/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.services;

import javax.ejb.Local;

/**
 *
 * @author JordanLcq
 */
@Local
public interface TitreServiceLocal {
    
    public void MettreEnVente(String nom, String mnémonique, Double prixUnité) 
            throws Exception;
}
