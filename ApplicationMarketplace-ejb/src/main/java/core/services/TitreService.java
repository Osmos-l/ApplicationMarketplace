/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.services;

import core.controllers.TitreFacadeLocal;
import core.entities.Titre;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author JordanLcq
 */
@Stateless
public class TitreService implements TitreServiceLocal {

    @EJB
    private TitreFacadeLocal gestionTitre;
    
    @Override
    public void MettreEnVente(String nom, String mnemonique, Double prixUni) 
            throws Exception {
        Titre nouveauTitre = new Titre();
        nouveauTitre.setNomEntreprise(nom);
        nouveauTitre.setMnemonique(mnemonique);
        nouveauTitre.setPrix(prixUni);
        
        try {
            gestionTitre.ajouter(nouveauTitre);
        } catch (Exception e) {
            throw e;
        }
        
        // notifierBrokers()
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    
}
