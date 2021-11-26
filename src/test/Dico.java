/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;

/**
 *
 * @author zodji
 */
public class Dico {
    private String cheminFichierDico;
    private ArrayList<String>[] listNiveaudeMot;
    private int niveau;
    
    
    
    public Dico(String cheminFichierDico){
        this.cheminFichierDico="../../dico/dico.xml";
        this.listeDeNiveauDeMot();
        //this.parseDico();
    }
    
    //creation de la liste de niveau des mots en d'autre terme pour chaque niveau de 1 à 5 il y a une liste de mot
    
    public void listeDeNiveauDeMot(){
        this.listNiveaudeMot = new ArrayList[5];
        for (int i = 0; i < 5; i++) 
            this.listNiveaudeMot[i] = new ArrayList<String>();
    }
    
    
    public String getChemeinFichierDico(){
        return cheminFichierDico;
    }
    
    
    public  String getMotDepuisListeNiveau(int niveau){
           //si la taile du tableau de la liste des  mots du meme Niveau est egale a zero on retourne un mot par defaut
           String s;
           vérifierNiveau(niveau);
           int taille=niveau-1;
           //if(listNiveaudeMot[taille].size()==0)
           if (listNiveaudeMot[taille].isEmpty()) {
            s="FDD_XML";
           }
           //sinon retourne de maniere aléatoires un mot dans la listes des mots du niveau assé en paramettre
           //niveau -1 car on compte dans un tableau de 0 à n-1
           else{
               s=listNiveaudeMot[taille].get((int)Math.floor(Math.random() * listNiveaudeMot[taille].size()));
           }
        return s;
    
    }
    
    //ici je decide de recuperer les mots d'une liste et de les retourné
    //mots est l'ensemble des mot de la liste d'un niveau donné et mot 
    //est la liste
    private String getMotDepuisListe(ArrayList<String> liste){
        String mots="";
        for (int i=0; i<5;i++){
            for(String unmot:listNiveaudeMot[i]){
                mots+=unmot;
            }
        }
    return mots;
    }
    
    
    
    private int vérifierNiveau(int niveau){
        int niv=0;
        //on verifie le niveau etant donné que dans notre cas le niveau est compri entre 1 et 5 alors 
        //si e niveau n'est pas dns cet interval on retourne un niveau 1 par defaut
        if(niveau <1 && niveau >5){
          niv=1;
        }
        else{
        niv = niveau;}
        
        return niv;
    }
    
    
    public void ajouteMotDico(int niveau, String mot){
        listNiveaudeMot[niveau].add(mot);
    }
    
    
    
    //initialiser le parseur dans le constructeur
    /*private void parseDico() {
      try {
            // Parse the document
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder p   = dbFactory.newDocumentBuilder();
            Document doc        = p.parse(this.pathToDicoFile);
            
            NodeList lesMots   = doc.getElementsByTagName("mot");
            
            for (int i = 0; i < lesMots.getLength(); i++ ) {
                int level   = Integer.parseInt(lesMots.item(i).getAttributes().item(0).getTextContent());
                String mot  = lesMots.item(i).getChildNodes().item(1).getTextContent();
                this.addWordToDico(level, mot);
            }

            
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Dico.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(Dico.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Dico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    
    
}
