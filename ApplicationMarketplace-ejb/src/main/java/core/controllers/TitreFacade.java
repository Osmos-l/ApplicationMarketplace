/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.controllers;

import core.entities.Titre;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author JordanLcq
 */
@Stateless
public class TitreFacade implements TitreFacadeLocal {
    
    private List<Titre> titres;

    public TitreFacade() {
    }
    
    public List<Titre> getTitres() {
        return this.titres;
    }

    @Override
    public List<Titre> ajouter(Titre aAjouter) throws Exception {
        if (this.titres.contains(aAjouter)) {
            throw new Exception("Le titre est déjà dans la liste");
        }
        this.titres.add(aAjouter);
        
        return getTitres();
    }

    @Override
    public List<Titre> supprimer(Titre aSupprimer) throws Exception {
        if (!this.titres.contains(aSupprimer)) {
            throw new Exception("Le titre n'est pas dans la liste");
        }
        
        this.titres.remove(aSupprimer);
        
        return getTitres();
    }

    @Override
    public List<Titre> modifier(Titre ancienTitre, Titre nouveauTitre) throws Exception {
        if (!this.titres.contains(ancienTitre)) {
            throw new Exception("L'ancien titre n'est pas dans la liste");
        }
        
         if (this.titres.contains(nouveauTitre)) {
            throw new Exception("Le nouveau titre est déjà dans la liste");
        }
        
        this.titres.remove(ancienTitre);
        this.titres.add(nouveauTitre);
        
        return getTitres();
    }

    @Override
    public Titre trouverParMnemonique(String mnemonique) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Titre> rechercheMnemonique(String mnemonique) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
      
}
