/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core.mdb;

import core.entities.Titre;
import core.services.TitreServiceLocal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJB;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

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
        try {
           ObjectMessage om = (ObjectMessage) message;
           Titre nouveauTitre = (Titre) om.getObject();
            
            titreService.MettreEnVente(nouveauTitre);
        } catch (JMSException ex) {
            Logger.getLogger(IntegrationEnBourseListener.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(IntegrationEnBourseListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
