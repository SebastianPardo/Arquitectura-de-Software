/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Facade;

/**
 *
 * @author arqsoft2017i
 */
public interface DataBaseMediator {
    
    public DataAccess.Entity.Usuario searchByMail(String mail);
    
}
