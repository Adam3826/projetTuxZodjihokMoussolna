/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
/**
 *
 * @author zodji
 */
public class testDico {
   public static void main(String[] args) {
        Dico dico = new Dico(null);
        
        //niveau 1
        dico.ajouteMotADico(1, "Fils");
        dico.ajouteMotADico(1, "toto");
        dico.ajouteMotADico(1, "riri");
        
        //niveau 2
        dico.ajouteMotADico(2, "zahaavh");
        dico.ajouteMotADico(2, "rururi");
        dico.ajouteMotADico(2, "fzbzvvb");
        
        //niveau 3
        dico.ajouteMotADico(3, "zfjubbv  ");
        dico.ajouteMotADico(3, "vzvzvvjv");
        dico.ajouteMotADico(3, "togbazi");
        
        //niveau 4
        
        dico.ajouteMotADico(4, "ZODJIHOUE");
        dico.ajouteMotADico(4, "ADEBOLILO");
        dico.ajouteMotADico(4, "ADAMMOUSS");
        //niveau 5
        dico.ajouteMotADico(5, "adam_hubert");
        dico.ajouteMotADico(5, "zodjihok_moussolna");
        dico.ajouteMotADico(5, "chaymae_barryma");
        
        System.out.println(dico.getMotDepuisListeNiveau(1));
        System.out.println(dico.getMotDepuisListeNiveau(2));
        System.out.println(dico.getMotDepuisListeNiveau(3));
        System.out.println(dico.getMotDepuisListeNiveau(4));
        System.out.println(dico.getMotDepuisListeNiveau(5));
        
    }
    
}
