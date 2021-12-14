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



import java.io.File;
import java.io.IOException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class Profil {
    Profil(){}

    private String nom;
    private String avatar;
    private String dateNaissance;
    private ArrayList<Partie> parties;
    private boolean existe = false;
    
    public Document _doc;
   
    
     //Cree un DOM à partir d'un fichier XML
    public Profil(String nomFichier) throws SAXException, IOException, ParserConfigurationException {
        File xmlFile = new File("src/xml/"+nomFichier+".xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;

        dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(xmlFile);

        Element nomElt = (Element) doc.getElementsByTagName("ns1:nom").item(0);
        nom = nomElt.getTextContent();

        Element avatarElt = (Element) doc.getElementsByTagName("ns1:avatar").item(0);
        avatar = avatarElt.getTextContent();

        Element annivElt = (Element) doc.getElementsByTagName("ns1:anniversaire").item(0);
        dateNaissance = annivElt.getTextContent();
        
        parties= new ArrayList<Partie>();
        
        NodeList nodeList = doc.getElementsByTagName("ns1:partie");

        for (int i = 0; i < nodeList.getLength(); i++) {
            Element partieElt = (Element) nodeList.item(i);
            
            Partie partie = new Partie(partieElt);
            parties.add(partie);
        }
    }
  
    public Profil(String nom, String dateNaissance) {
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        avatar = nom+".png";
        parties = new ArrayList<Partie>();
        existe = true;
        //toXML("src/xml/"+nom+".xml");
    }

    
    public void ajouterPartie(Partie p) {
        parties.add(p);
    }
    
    public int getDernierNiveau() {
        int niv = 0;
        return niv;
    }
    
    public String toString() {
        return parties.size() + " parties pour ce profil";
    }
    
    public void sauvegarder(String nomFichier) throws ParserConfigurationException, SAXException, IOException, TransformerConfigurationException, TransformerException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder parser = dbFactory.newDocumentBuilder();
        
        // on crer la racine profil
        Document doc = parser.newDocument() ;
        Element profil = doc.createElement("profil");
        doc.appendChild(profil);

        // on ajoute a la racine 
        //le nom nom
        Element nom = doc.createElement("nom");
        nom.appendChild(doc.createTextNode(this.nom));
        profil.appendChild(nom);

        // pareille pour avatar
        Element avatar = doc.createElement("avatar");
        avatar.appendChild(doc.createTextNode(this.avatar));
        profil.appendChild(avatar);
        
        //     date de naissance
        Element anniv = doc.createElement("anniversaire");
        anniv.appendChild(doc.createTextNode(this.dateNaissance));
        profil.appendChild(anniv);

        // creation du noeud partie suivi de partie dans le for-each
        Element listeParties = doc.createElement("parties");
        profil.appendChild(listeParties);

        for (Partie t : parties) {
            Element partie = doc.createElement("partie");
            //on dit au noeud parties de prendre pour noeud partie
            listeParties.appendChild(partie);

            // creation de l'attribut  date 
            Attr date = doc.createAttribute("date");
            date.setValue(t.getDate());
            partie.setAttributeNode(date);

            String trouvé= "";
            trouvé += t.getTrouve();
            // attribut trouvé
            Attr att= doc.createAttribute("trouvé");
            att.setValue(trouvé);
            partie.setAttributeNode(att);
           
            String temp;
            temp = "";
            temp+= t.getTemps();
            // element temps
            Element temps = doc.createElement("temps");
            temps.appendChild(doc.createTextNode(temp));
            partie.appendChild(temps);

            // mot
            Element mot = doc.createElement("mot");
            mot.appendChild(doc.createTextNode(t.getMot()));
            partie.appendChild(mot);

            // attribut niveau
            Attr at = doc.createAttribute("niveau");
            
            String niv;
            niv = "";
            
            //on affect a niv la valeur de niveau
            niv += t.getNiveau();
            at.setValue(niv);//on met ajour l'attribut niveau genre le dernier niveau
            mot.setAttributeNode(at); 
        }

        DOMSource src= new DOMSource(doc);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        StreamResult result = new StreamResult(nomFichier);
        transformer.transform(src, result);
        System.out.println("Le fichier " + nomFichier + " à été créé");
    }
    
    public String getNom() {
        return nom;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public String getAvatar() {
        return avatar;
    }
    
    public Boolean charge(String nom) {
        return existe;
    }
}
   

