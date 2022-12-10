/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.mdb;

import core.services.TitreServiceLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author JordanLcq
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "IntegrationEnBourse")
    ,
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class IntegrationEnBourseListener implements MessageListener {
    
    @EJB
    private TitreServiceLocal titreService;
    
    public IntegrationEnBourseListener() {
    }
    
    @Override
    public void onMessage(Message message) {
        TextMessage text = (TextMessage) message;
        try {
            System.out.println("IntegrationEnBourseListener - New incoming message:");
            System.out.println(text.getText());
        } catch (JMSException ex) {
            Logger.getLogger(IntegrationEnBourseListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
