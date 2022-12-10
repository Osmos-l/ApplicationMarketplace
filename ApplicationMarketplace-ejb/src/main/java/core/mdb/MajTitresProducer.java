/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.mdb;

import core.entities.Titre;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.ObjectMessage;
import javax.jms.Topic;

/**
 *
 * @author JordanLcq
 */
@Singleton
public class MajTitresProducer implements MajTitresProducerLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
     /**
     * Nom du Topic recherché.
     */
    @Resource(mappedName = "MajTitres")
    private Topic majTitresTopic;
    /**
     * contexte JMS. Injection auto par serveur d'appli.
     */
    @Inject
    @JMSConnectionFactory("ConnectionFactory")
    private JMSContext context;

    @Override
    public void sendTitre(Titre titre, String jmsType) {
        // jmsTYPE: Ajout, Edit
        try {
            JMSProducer producer = context.createProducer();

            ObjectMessage mess = context.createObjectMessage();
            mess.setJMSType(jmsType);
            mess.setObject(titre);
            context.createProducer().send(majTitresTopic, mess);

        } catch (Exception ex) {
            Logger.getLogger(MajTitresProducer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
