/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Facade;

import DataAccess.Entity.*;
import DataAccess.DAO.*;

/**
 *
 * @author arqsoft2017i
 */
public class DataBaseController implements DataBaseMediator{

    @Override
    public Usuario searchByMail(String mail) {
        UserDAO usrD = new UserDAO();
        AuthenticationDAO authD = new AuthenticationDAO();
        
        Usuario value = usrD.searchById(authD.searhByMail(mail).getIdUsuario());
        
        return value;
    }
    
}
