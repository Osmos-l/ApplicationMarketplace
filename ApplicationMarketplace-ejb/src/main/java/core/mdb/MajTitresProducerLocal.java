/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.mdb;

import core.entities.Titre;
import javax.ejb.Local;

/**
 *
 * @author JordanLcq
 */
@Local

public interface MajTitresProducerLocal {
            
    public void sendTitre(Titre titre, MajTitresProducer.JMSTypeMessage typeMessage);
}
