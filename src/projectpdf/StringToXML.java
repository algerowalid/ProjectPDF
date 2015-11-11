/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpdf;
import java.io.File;
import java.io.StringReader;


 
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
 
public class StringToXML {
   
    public static void saveXML(String XmlString, int page) {
        
     Vierwer view = new Vierwer();
   String lien = view.getLink()+"/articles";
  
  
    File file = new File(lien);
     int Nfichier =0;
   
     if(file.getTotalSpace()>0.0){
       Nfichier = new File(lien).list().length;
     }
    String fina= lien+"/article_" + String.format("%04d",page)+"_"+ String.format("%04d", Nfichier+1) + ".xml";
        
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
 
        DocumentBuilder builder;
        try
        {
            builder = factory.newDocumentBuilder();
 
            // Use String reader
            Document document = builder.parse( new InputSource(
                    new StringReader( XmlString)));
 
            TransformerFactory tranFactory = TransformerFactory.newInstance();
            Transformer aTransformer = tranFactory.newTransformer();
            Source src = new DOMSource( document );
            Result dest = new StreamResult( new File( fina ) );
            aTransformer.transform( src, dest );
        } catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}