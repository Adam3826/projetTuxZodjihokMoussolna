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
     Partie(){}}
    /*
    public Partie(String date, String mot, int niveau) {
        this.date = date;
        this.mot = mot;
        this.niveau = niveau;
        this.finPartie = false;
    }
    
  
    public Partie(Element partieElt) {
        this.date = partieElt.getAttribute("ns1:date");
        this.mot = partieElt.getElementsByTagName("ns1:mot").item(0).getTextContent();
        Element m = (Element)partieElt.getElementsByTagName("ns1mot").item(0);
        this.niveau = Integer.parseInt(m.getAttribute("ns1:niveau")) ;
        
        if (partieElt.hasAttribute("trouvé")) {
            this.trouvé = Integer.parseInt(partieElt.getAttribute("trouvé").replace("%", ""));
        }
        else 
            trouvé = 0;
        System.out.println("Trouvé: " + trouvé);
        if (partieElt.getFirstChild().getNodeName().equals("ns1:temps"))
            this.temps = Integer.parseInt(partieElt.getElementsByTagName("ns1:temps").item(0).getTextContent());
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
        String str = "";
        str += "Date: " + getDate() + "\nMot à trouver: " + getMot()+"\nNiveau du mot: "+getNiveau();
        str += "\nTemps de la partie: "+getTemps()+" secondes\nPourcentage de lettre trouvé: "+getTrouve()+"%.";
        
        return str;
    }
    
}

    
*/
