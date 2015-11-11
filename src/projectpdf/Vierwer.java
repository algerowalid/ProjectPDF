/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpdf;

import com.java4less.ocr.tess3.OCRFacade;
import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import java.awt.BorderLayout;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import org.icepdf.core.views.DocumentViewController;
import org.icepdf.ri.common.ComponentKeyBinding;
import org.icepdf.ri.common.SwingController;
import org.icepdf.ri.common.SwingViewBuilder;
import org.icepdf.ri.common.views.DocumentViewControllerImpl;

public class Vierwer extends JFrame{ 
    
    static JFrame applicationFrame = new JFrame("Neo-Data Test");
    static JPanel m = new panel2();
    static JPanel viewerComponentPanel;
    static SwingViewBuilder factory;
    static SwingController controller=new SwingController();
    
    static String link, linkimg, linkpage,linkxml;
    static String titre, info;
    

    
    int flag=0;
    int NPage;
   
    
    public void ajout(JPanel a){
    
        applicationFrame.add(a);
        applicationFrame.revalidate();
   
    }
    // les liens des fichier setter and getter 
    public void setLink(String a ){
    link=a;
    }
    public String getLink(){
    String a = link;
    return a;
    }  
    public void setLinkpage(String a ){
    linkpage=a;
    }
    public String getLinkpage(){
    String a = linkpage;
    return a;
    }
    public void setLinkimage(String a ){
    this.linkimg=a;
    }
    public String getLinkimage(){
    return linkimg;
    }
    
    
    // les infos utiles 
    
    public void setTitre(String a){
    this.titre=a;
    }
    public String getTitre(){
    return titre;
    }
 
    public void setNpage(int a){
        this.NPage=a;
    }
    public int getNpage(){
        return NPage;
    }

    
    public void setInfo(String a){
    this.info=a;
    }
    public String getInfo(){
    return info ;
    }
 
    
    
    
    public static void main(String[] args) {
        
        // build a component controller 
        factory = new SwingViewBuilder(controller);
        controller.setIsEmbeddedComponent(true);
        
        // set the viewController embeddable flag. 
        DocumentViewController viewController = controller.getDocumentViewController();
        viewerComponentPanel = factory.buildViewerPanel();
        
      
        
        // add copy keyboard command 
        ComponentKeyBinding.install(controller, viewerComponentPanel); 
        // add interactive mouse link annotation support via callback 
        controller.getDocumentViewController().setAnnotationCallback( new org.icepdf.ri.common.MyAnnotationCallback(controller.getDocumentViewController()));
        // build a containing JFrame for display 
        
       
        applicationFrame.getContentPane().setLayout(new BorderLayout());
        applicationFrame.add(m, BorderLayout.WEST);
        applicationFrame.getContentPane().add(viewerComponentPanel, BorderLayout.CENTER);
        applicationFrame.getContentPane().add(factory.buildCompleteMenuBar(), BorderLayout.NORTH);
        // Now that the GUI is all in place, we can try opening a PDF 
        // hard set the page view to single page which effectively give a single
        // page view. This should be done after openDocument as it has code that
        // can change the view mode if specified by the file. 
        controller.setPageViewMode( DocumentViewControllerImpl.ONE_PAGE_VIEW, false); 
        
        // show the component 
        applicationFrame.pack();
        

        
    
     java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                applicationFrame.setVisible(true);
               
                JFrame.setDefaultLookAndFeelDecorated(true);
                 applicationFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        applicationFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
              }
        });
    
   
    }
 
    
    
   public void launcher(){
   String[] arguments = new String[] {"123"};
   this.main(arguments);
     java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                applicationFrame.setVisible(true);
               
                JFrame.setDefaultLookAndFeelDecorated(true);
                 applicationFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        applicationFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
              }
        });
   }
    
    
   public void opendoc(String link){
   
       controller.openDocument(link);
   
   }

public void getRectangle(int x, int y , int w , int h) throws AWTException, IOException{
   
      BufferedImage screencapture = new Robot().createScreenCapture(new Rectangle( x, y, w, h));
     // Save as JPEG
     File file = new File("text.tif");
     ImageIO.write(screencapture, "tiff", file);
      
     OCRFacade facade=new OCRFacade();
     String text=facade.recognizeFile("text.tif", "eng");
        
        
        this.setInfo(text);
        
        System.out.println("Finish  "+text);
   }
   
    public void getRectangleImage(int x, int y , int w , int h) throws AWTException, IOException{
   
      BufferedImage screencapture = new Robot().createScreenCapture(new Rectangle( x, y, w, h));
     
      String lien = this.getLinkimage();
      
      int Nfichier = new File(lien).list().length;
     
      
       lien= lien+"/images_" + String.format("%04d",NPage)+"_"+ String.format("%04d", Nfichier+1) + ".jpg";
      
    //  String link = view.get
      
      // Save as JPEG
     File file = new File(lien);
     ImageIO.write(screencapture, "jpeg", file);
     
     JPanel pan = new panel2();
     
        
    
    }
    
    
class ScreenCapture {
    
  
   int Npage;
   Vierwer view = new Vierwer();
   
   public void setterNpage(int a){
this.Npage=a;
}
   
   
   
   

}
}