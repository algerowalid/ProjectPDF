/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpdf;

/**
 *
 * @author Eurequat-Algerie
 */
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
public class LoadAndShow extends JPanel {    
    private static final long serialVersionUID = (long) 0.134243242342;
    private static final String PATH = "d:/test.tif";
    private BufferedImage image;
    public static  Dimension size = new Dimension();

    
    public LoadAndShow(BufferedImage image) {
        this.image = image;
        size.setSize(image.getWidth(), image.getHeight());
    }
    protected void paintComponent(Graphics g) {
        int x = (getWidth() - size.width) / 2;
        int y = (getHeight() - size.height) / 2;
        g.drawImage(image, x, y, this);
    }
    public Dimension getPreferredSize() {
        return size;
    }
    public static void main(String[] args) throws IOException {
        BufferedImage image = ImageIO.read(new File(PATH));
        LoadAndShow test = new LoadAndShow(image);
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new JScrollPane(test));
        
        int x = (image.getWidth() - size.width) / 2;
        int y = (image.getHeight() - size.height) / 2;
        
        System.out.println(image.getWidth()+"  "+image.getHeight());
        f.setSize(535,381);
        f.setLocation(200, 200);
        f.setVisible(true);
    }
}