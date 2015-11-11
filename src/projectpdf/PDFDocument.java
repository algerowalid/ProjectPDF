/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpdf;

import com.adobe.acrobat.Viewer;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.util.*;
import java.util.List;

/**
 * Class to display a PDF document in a JFrame
 */
public class PDFDocument extends JPanel
{
  private Viewer viewer;

  public PDFDocument( String filename )
  {
    // Set the layout for this panel
    this.setLayout( new BorderLayout() );

    // Create the viewer
    try
    {
      viewer = new Viewer();
      FileInputStream fis = new FileInputStream( filename );
      viewer.setDocumentInputStream( fis );
      this.add( viewer, BorderLayout.CENTER );
      viewer.activate();

      String page1 = viewer.getTextForPage( 0 );
      System.out.println( "page1: \n" + page1 );
    }
    catch( Exception e )
    {
      e.printStackTrace();
    }
  }

  public static void main( String[] args )
  {
  

    String filename = "d:/test-001.pdf";
    PDFDocument pdf = new PDFDocument(filename);

    // Create our frame
    JFrame frame = new JFrame( "PDF Viewer" );
    frame.setSize( 1024,768 );
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    frame.setLocation( d.width/2 - 512, d.height/2 - 384 );
    frame.getContentPane().add( pdf );
    frame.setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
    frame.setVisible( true );
  }
}