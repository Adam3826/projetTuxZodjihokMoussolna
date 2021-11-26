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
        dico.ajouteMotDico(1, "Fils");
        dico.ajouteMotDico(1, "toto");
        dico.ajouteMotDico(1, "riri");
        
        //niveau 2
        dico.ajouteMotDico(2, "zahaavh");
        dico.ajouteMotDico(2, "rururi");
        dico.ajouteMotDico(2, "fzbzvvb");
        
        //niveau 3
        dico.ajouteMotDico(3, "zfjubbv  ");
        dico.ajouteMotDico(3, "vzvzvvjv");
        dico.ajouteMotDico(3, "togbazi");
        
        //niveau 4
        
        dico.ajouteMotDico(4, "ZODJIHOUE");
        dico.ajouteMotDico(4, "ADEBOLILO");
        dico.ajouteMotDico(4, "ADAMMOUSS");
        //niveau 5
        dico.ajouteMotDico(5, "adam_hubert");
        dico.ajouteMotDico(5, "zodjihok_moussolna");
        dico.ajouteMotDico(5, "chaymae_barryma");
        
        System.out.println(dico.getMotDepuisListeNiveau(1));
        System.out.println(dico.getMotDepuisListeNiveau(2));
        System.out.println(dico.getMotDepuisListeNiveau(3));
        System.out.println(dico.getMotDepuisListeNiveau(4));
        System.out.println(dico.getMotDepuisListeNiveau(5));
        
    }
    
}
