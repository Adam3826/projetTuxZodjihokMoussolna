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
    public boolean charge(String nom) {
    boolean existe = false;
        return existe;
    }

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
        
        parties= new ArrayList<>(); //<Partie>
        
        NodeList nodeList = doc.getElementsByTagName("ns1:partie");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element partieElt = (Element) nodeList.item(i);
            
            Partie partie = new Partie(partieElt);
            parties.add(partie);
        }
    }
}
  /*
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
        
        // element racine
        Document doc = parser.newDocument() ;
        Element profil = doc.createElement("profil");
        doc.appendChild(profil);
        // nom
        Element nom = doc.createElement("nom");
        nom.appendChild(doc.createTextNode(this.nom));
        profil.appendChild(nom);
        // avatar
        Element avatar = doc.createElement("avatar");
        avatar.appendChild(doc.createTextNode(this.avatar));
        profil.appendChild(avatar);
        
        // date de naissance
        Element anniv = doc.createElement("anniversaire");
        anniv.appendChild(doc.createTextNode(this.dateNaissance));
        profil.appendChild(anniv);
        // parties
        Element listeParties = doc.createElement("parties");
        profil.appendChild(listeParties);
        for (Partie e : parties) {
            Element partie = doc.createElement("partie");
            listeParties.appendChild(partie);
            // attribut date
            Attr a = doc.createAttribute("date");
            a.setValue(e.getDate());
            partie.setAttributeNode(a);
            String trouv = "";
            trouv += e.getTrouve();
            // attribut trouvé
            Attr a1 = doc.createAttribute("trouvé");
            a1.setValue(trouv);
            partie.setAttributeNode(a1);
           
            String tmp;
            tmp = "";
            tmp += e.getTemps();
            // temps
            Element temps = doc.createElement("temps");
            temps.appendChild(doc.createTextNode(tmp));
            partie.appendChild(temps);
            // mot
            Element mot = doc.createElement("mot");
            mot.appendChild(doc.createTextNode(e.getMot()));
            partie.appendChild(mot);
            // attribut niveau
            Attr a2 = doc.createAttribute("niveau");
            
            String nv;
            nv = "";
            nv += e.getNiveau();
            a2.setValue(nv);
            mot.setAttributeNode(a2); 
        }
        DOMSource source = new DOMSource(doc);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        StreamResult result = new StreamResult(nomFichier);
        transformer.transform(source, result);
        System.out.println("Le fichier " + nomFichier + " a été créé");
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
   
    
}
   
*/