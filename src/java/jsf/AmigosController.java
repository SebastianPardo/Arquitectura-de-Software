package jsf;

import jpa.entities.Amigos;
import jsf.util.JsfUtil;
import jsf.util.PaginationHelper;
import jpa.session.AmigosFacade;

import java.io.Serializable;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;


@Named("amigosController")
@SessionScoped
public class AmigosController implements Serializable {


    private Amigos current;
    private DataModel items = null;
    @EJB private jpa.session.AmigosFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public AmigosController() {
    }

    public Amigos getSelected() {
        if (current == null) {
            current = new Amigos();
            current.setAmigosPK(new jpa.entities.AmigosPK());
            selectedItemIndex = -1;
        }
        return current;
    }

    private AmigosFacade getFacade() {
        return ejbFacade;
    }
    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem()+getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (Amigos)getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new Amigos();
        current.setAmigosPK(new jpa.entities.AmigosPK());
        selectedItemIndex = -1;
        return "Create";
    }

    public String create() {
        try {
            current.getAmigosPK().setUsuIdUsuario(current.getUsuario1().getIdUsuario());
            current.getAmigosPK().setIdUsuario(current.getUsuario().getIdUsuario());
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("AmigosCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (Amigos)getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            current.getAmigosPK().setUsuIdUsuario(current.getUsuario1().getIdUsuario());
            current.getAmigosPK().setIdUsuario(current.getUsuario().getIdUsuario());
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("AmigosUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (Amigos)getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("AmigosDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count-1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex+1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public Amigos getAmigos(jpa.entities.AmigosPK id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass=Amigos.class)
    public static class AmigosControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            AmigosController controller = (AmigosController)facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "amigosController");
            return controller.getAmigos(getKey(value));
        }

        jpa.entities.AmigosPK getKey(String value) {
            jpa.entities.AmigosPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new jpa.entities.AmigosPK();
            key.setUsuIdUsuario(values[0]);
            key.setIdUsuario(values[1]);
            return key;
        }

        String getStringKey(jpa.entities.AmigosPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getUsuIdUsuario());
            sb.append(SEPARATOR);
            sb.append(value.getIdUsuario());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Amigos) {
                Amigos o = (Amigos) object;
                return getStringKey(o.getAmigosPK());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: "+Amigos.class.getName());
            }
        }

    }

}