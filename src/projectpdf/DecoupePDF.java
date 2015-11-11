/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpdf;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfCopy;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;
import java.io.FileOutputStream;
/**
 *
 * @author Eurequat-Algerie
 */
public class DecoupePDF {
    
    
    public void decoupe(String link, String sortie){
    
       try {

//            String inFile = args[0].toLowerCase();
            System.out.println ("Reading " + link);
            PdfReader reader = new PdfReader(link);
            int n = reader.getNumberOfPages();
            System.out.println ("Number of pages : " + n);
            int i = 0;        
         
                    
            while ( i < n ) {
                String outFile = sortie+"/page_" + String.format("%04d", i + 1) + ".pdf"; 
                System.out.println ("Writing " + outFile);
                Document document = new Document(reader.getPageSizeWithRotation(1));
                PdfCopy writer = new PdfCopy(document, new FileOutputStream(outFile));
                document.open();
                PdfImportedPage page = writer.getImportedPage(reader, ++i);
                writer.addPage(page);
                document.close();
                writer.close();
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
        }

    }
    
      public static void main(String[] args) {

     

    }
}
