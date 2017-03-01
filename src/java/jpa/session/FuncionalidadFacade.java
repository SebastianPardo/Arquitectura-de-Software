/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.Funcionalidad;

/**
 *
 * @author arqsoft2017i
 */
@Stateless
public class FuncionalidadFacade extends AbstractFacade<Funcionalidad> {

    @PersistenceContext(unitName = "RedAppPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FuncionalidadFacade() {
        super(Funcionalidad.class);
    }
    
}