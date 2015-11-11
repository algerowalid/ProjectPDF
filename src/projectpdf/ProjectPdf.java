/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpdf;

import java.io.*;  
import com.itextpdf.text.Document;  
import com.itextpdf.text.Paragraph;  
import com.itextpdf.text.pdf.PdfReader;  
import com.itextpdf.text.pdf.PdfWriter;  
import com.itextpdf.text.pdf.parser.PdfTextExtractor;


 

/**
 *
 * @author Eurequat-Algerie
 */
public class ProjectPdf {

    /**
     * @param args the command line arguments
     */
    public static void main(String arg[]) throws IOException
      {  
        
          Vierwer view = new Vierwer();
          view.launcher();
          
}
}