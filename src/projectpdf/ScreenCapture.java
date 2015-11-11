/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpdf;
import com.java4less.ocr.tess3.OCRFacade;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JTextField;

class ScreenCapture {
    
   static  String info= null;
   int Npage;
   Vierwer view = new Vierwer();
   
   public void setterNpage(int a){
this.Npage=a;
}
   
   public void getRectangle(int x, int y , int w , int h) throws AWTException, IOException{
   
      BufferedImage screencapture = new Robot().createScreenCapture(new Rectangle( x, y, w, h));
     // Save as JPEG
     File file = new File("text.tif");
     ImageIO.write(screencapture, "tiff", file);
      
     OCRFacade facade=new OCRFacade();
     String text=facade.recognizeFile("text.tif", "eng");
        
        
        view.setInfo("walid");
        
        System.out.println("Finish  "+text);
   }
   
    public void getRectangleImage(int x, int y , int w , int h) throws AWTException, IOException{
   
      BufferedImage screencapture = new Robot().createScreenCapture(new Rectangle( x, y, w, h));
     
      String lien = view.getLinkimage();
      
      int Nfichier = new File(lien).list().length;
     
      
       lien= lien+"/images_" + String.format("%04d",Npage)+"_"+ String.format("%04d", Nfichier+1) + ".jpg";
      
    //  String link = view.get
      
      // Save as JPEG
     File file = new File(lien);
     ImageIO.write(screencapture, "jpeg", file);
     
     JPanel pan = new panel2();
     
        
    
    }
   
   
  public static void main(String args[]) throws
           AWTException, IOException {
     // capture the whole screen
   /*  BufferedImage screencapture = new Robot().createScreenCapture(
           new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()) );
*/
  /*    BufferedImage screencapture = new Robot().createScreenCapture(new Rectangle( 5, 100, 500, 1024));

      
     // Save as JPEG
     File file = new File("d:/les images/screencapturebmp.bmp");
     ImageIO.write(screencapture, "bmp", file);

     // Save as PNG
     // File file = new File("screencapture.png");
     // ImageIO.write(screencapture, "png", file);*/
  }
}