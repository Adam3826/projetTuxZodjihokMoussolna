/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author zodji
 */

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import game.Profil;

import java.io.IOException;
import java.util.ArrayList;
import java.lang.Object;
import java.util.Random;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class Partie {
    private String date;
    private String mot;
    private int trouvé;
    private int temps;
    boolean finPartie;
    private int niveau;
     //Partie(){}
    
    public Partie(String date, String mot, int niveau) {
        this.date = date;
        this.mot = mot;
        this.niveau = niveau;
        this.finPartie = false;
    }
    
    
    
    
  
    public Partie(Element partieElt) {
        this.date = partieElt.getAttribute("ns1 :date");  //reaffectation de la date
        this.mot = partieElt.getElementsByTagName("ns1:mot").item(0).getTextContent();//pareil pour mot
        Element t = (Element)partieElt.getElementsByTagName("ns1:mot").item(0);
        this.niveau = Integer.parseInt(t.getAttribute("ns1:niveau")) ;//on recuperela valeur de l'attribut entier
        
        // au caas ou on a un attribut trouvé dans notre xml
        if (partieElt.hasAttribute("trouvé")) {
            trouvé = Integer.parseInt(partieElt.getAttribute("trouvé").replace("%", ""));
        }
        // sinon on met trouvé a zero
        else 
            trouvé = 0;
        System.out.println("Trouvé: " + trouvé);
        
        //si le nom du premier noeud est temps on recupere la valeur du premier element  du noeud temps et on l'affecte a temps si non on lui affecte 0
        if (partieElt.getFirstChild().getNodeName().equals("ns1:temps"))
            temps = Integer.parseInt(partieElt.getElementsByTagName("ns1:temps").item(0).getTextContent());
        else
            temps = 0;

    }
    
   
    
    public void setTrouve(int nbLettresRestantes) {
        trouvé= ((this.mot.length()-nbLettresRestantes)*100)/this.mot.length();
    }

    public void setTemps(int temps) {
        this.temps = temps;
    }  
    
    public int getTrouve(){
        return trouvé;
    }
    
    public int getNiveau() {
        return niveau;
    }
    
    public String getMot() {
        return mot;
    }
    
    public String getTemps() {
        return Integer.toString(temps);
    }
     
    public String getDate(){
        return date;
    }
    
    @Override
    public String toString() {
        String s = "";
        s+= "Date: " + getDate() + "\nMot à trouver: " + getMot()+"\nNiveau du mot: "+getNiveau()+
        "\nTemps de la partie: "+getTemps()+" secondes\nPourcentage de lettre trouvé: "+getTrouve()+"%.";
        
        return s;
    }
    
}

    

