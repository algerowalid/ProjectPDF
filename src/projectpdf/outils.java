/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpdf;
import java.awt.Component;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import org.icepdf.core.exceptions.PDFException;
import org.icepdf.core.exceptions.PDFSecurityException;
import org.icepdf.core.pobjects.Document;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextField;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.xml.sax.InputSource;

/**
 *
 * @author Eurequat-Algerie
 */
public class outils {
 
    
    public int NombrePage(String a) throws IOException{
        int b = 0 ;
        Document document = new Document();
        try {
            document.setFile(a);
            b = document.getNumberOfPages();
            
        } catch (PDFException ex) {
            Logger.getLogger(loadPdf.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PDFSecurityException ex) {
            Logger.getLogger(loadPdf.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(loadPdf.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return b;}
    
    public void setterText(JTextField a , String text){
     
        MySnipTool p = new MySnipTool();
        
        a.setText(text);
    }
    public  File lastFileModified(String dir) {
    File fl = new File(dir);
    File[] files = fl.listFiles(new FileFilter() {          
        public boolean accept(File file) {
            return file.isFile();
        }
    });
    long lastMod = Long.MIN_VALUE;
    File choice = null;
    for (File file : files) {
        if (file.lastModified() > lastMod) {
            choice = file;
            lastMod = file.lastModified();
        }
    }
    return choice;
}
    
    public void writeFile(String yourXML, int page) throws IOException{
        
        
       /*  Vierwer view = new Vierwer();
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
            org.w3c.dom.Document document = builder.parse( new InputSource(
                    new StringReader( yourXML)));
 
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
        */
    Vierwer view = new Vierwer();
   String lien = view.getLink()+"/articles";
  
  
    File file = new File(lien);
     int Nfichier =0;
   
     if(file.getTotalSpace()>0.0){
       Nfichier = new File(lien).list().length;
     }
    String fina= lien+"/article_" + String.format("%04d",page)+"_"+ String.format("%04d", Nfichier+1) + ".xml";
   
    BufferedWriter out = new BufferedWriter(new FileWriter(fina));
    
    try { 
        out.write(yourXML);
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        out.close();
    }
    
}
    
}
