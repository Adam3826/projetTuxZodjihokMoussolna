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

    private ArrayList<String> listeNiveau1;
    private ArrayList<String> listeNiveau2;
    private ArrayList<String> listeNiveau3;
    private ArrayList<String> listeNiveau4;
    private ArrayList<String> listeNiveau5;
    private String cheminFichierDico;

    //private int niveau;
    public Dico(String cheminFichierDico) {
        
        this.listeNiveau1=new ArrayList<String>();
        this.listeNiveau1=new ArrayList<String>();
        this.listeNiveau2=new ArrayList<String>();
        this.listeNiveau3=new ArrayList<String>();
        this.listeNiveau4=new ArrayList<String>();
        this.listeNiveau5=new ArrayList<String>();
        this.cheminFichierDico = cheminFichierDico;
    }

    //selectionne une liste selon un niveau fourni en parametre
    public String getMotDepuisListeNiveau(int niveau) {
        //si la taile du tableau de la liste des  mots du meme Niveau est egale a zero on retourne un mot par defaut
        String s = "";
        switch (vérifierNiveau(niveau)) {

            case 5:
                s = getMotDepuisListe(listeNiveau5);
            case 4:
                s = getMotDepuisListe(listeNiveau4);
            case 3:
                s = getMotDepuisListe(listeNiveau3);
            case 2:
                s = getMotDepuisListe(listeNiveau2);
            case 1:
                s = getMotDepuisListe(listeNiveau1);
            default:
                break;

        }
        return s;

    }

    public void ajouteMotADico(int niveau, String mot) {
        switch (vérifierNiveau(niveau)) {

            case 5:
                listeNiveau5.add(mot);
            case 4:
                listeNiveau4.add(mot);
            case 3:
                listeNiveau3.add(mot);
            case 2:
                listeNiveau2.add(mot);
            case 1:
                listeNiveau1.add(mot);
            default:
                break;

        }
    }

    public String getChemeinFichierDico() {
        return cheminFichierDico;
    }

    private int vérifierNiveau(int niveau) {
        int niv = 0;
        //on verifie le niveau etant donné que dans notre cas le niveau est compri entre 1 et 5 alors 
        //si e niveau n'est pas dns cet interval on retourne un niveau 5 par defaut
        if (niveau < 1 || niveau > 5) {
            niv = 5;
        } else {
            niv = niveau;
        }

        return niv;
    }

    //creation de la liste de niveau des mots en d'autre terme pour chaque niveau de 1 à 5 il y a une liste de mot
    /* public void listeDeNiveauDeMot() {
        this.listNiveaudeMot = new ArrayList[5];
        for (int i = 0; i < 5; i++) {
            this.listNiveaudeMot[i] = new ArrayList<String>();
        }
    }*/
    //extrait un mot au hasard d'une liste donnée
    private String getMotDepuisListe(ArrayList<String> list) {
        String mots;
        int index;  //indice du mot choisi
        double randomDouble = java.lang.Math.random();
        randomDouble = list.size() * randomDouble; //proportion entre la taille du double et la taille de l'arraylist
        index = (int) randomDouble;
        mots = list.get(index);

        return mots;
    }

    //ici je decide de recuperer les mots d'une liste et de les retourné
    //mots est l'ensemble des mot de la liste d'un niveau donné et mot 
    //est la liste
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
