/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.controllers;

import core.entities.Titre;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author JordanLcq
 */
@Local
public interface TitreFacadeLocal {
    
    List<Titre> ajouter(Titre aAjouter) throws Exception;
        
    List<Titre> supprimer(Titre aSupprimer) throws Exception;
    
    List<Titre> modifier(Titre ancienTitre, Titre nouveauTitre) throws Exception;
    
    Titre trouverParMnemonique(String mnemonique) throws Exception;
    
    List<Titre> rechercheMnemonique(String mnemonique) throws Exception;
}
