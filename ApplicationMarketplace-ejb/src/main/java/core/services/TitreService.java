/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.services;

import core.controllers.TitreFacadeLocal;
import core.entities.Titre;
import core.mdb.MajTitresProducerLocal;
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
    
    @EJB
    private MajTitresProducerLocal majTitresProducer;
    
    @Override
    public void MettreEnVente(Titre nouveauTitre) 
            throws Exception {
        gestionTitre.ajouter(nouveauTitre);
        
        majTitresProducer.sendTitre(nouveauTitre, "ajout");
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    
}
