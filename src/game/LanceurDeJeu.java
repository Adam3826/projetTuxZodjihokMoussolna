/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author zodji
 */
public class LanceurDeJeu {
  public static void main(String args[]) throws SAXException, IOException, ParserConfigurationException {
      
        Jeu jeu;
        
        // Declare un Jeu
        //?!!?;
        //Instancie un nouveau jeu
        jeu =new JeuDevineLeMotOrdre();
        //Execute le jeu
        jeu.execute();
    }
}
