/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpdf;

/**
 *
 * @author Eurequat-Algerie
 */
import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.geom.Area;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MySnipTool extends JFrame {
    JTextField text;

     JFrame frame = new JFrame("Testing");
  
    public static void main(String[] args) {
        new MySnipTool();
    }

    public MySnipTool() {
       
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                
                frame.setUndecorated(true);
                frame.setBackground(new Color(0, 0, 0, 0));
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new CapturePane());
                Rectangle bounds = getVirtualBounds();
                frame.setLocation(bounds.getLocation());
                frame.setSize(bounds.getSize());
                frame.setAlwaysOnTop(true);
                frame.setVisible(true);
            }
        });
    }

    public class CapturePane extends JPanel {

        private Rectangle selectionBounds;
        private Point clickPoint;

        public CapturePane() {
            setOpaque(false);

       MouseAdapter mouseHandler = new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 2) {
                        frame.dispose();
                    }
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    clickPoint = e.getPoint();
                    selectionBounds = null;
                    
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    clickPoint = null;
                     String ah = null;
              
                     if(selectionBounds!=null){    
                   int w = selectionBounds.width;
                   int h = selectionBounds.height;
                   
                   int x = selectionBounds.x;
                   int y = selectionBounds.y;
                    
                   frame.dispose();
                  
                 // ScreenCapture  p = new ScreenCapture();
                   Vierwer v = new Vierwer(); 
                   try {
                        v.getRectangle(x, y, w, h);
                       
                    } catch (AWTException ex) {
                        Logger.getLogger(MySnipTool.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(MySnipTool.class.getName()).log(Level.SEVERE, null, ex);
                    }
                 
                }  
                    
                }

                @Override
                public void mouseDragged(MouseEvent e) {
                    Point dragPoint = e.getPoint();
                    int x = Math.min(clickPoint.x, dragPoint.x);
                    int y = Math.min(clickPoint.y, dragPoint.y);
                    int width = Math.max(clickPoint.x - dragPoint.x, dragPoint.x - clickPoint.x);
                    int height = Math.max(clickPoint.y - dragPoint.y, dragPoint.y - clickPoint.y);
                    selectionBounds = new Rectangle(x, y, width, height);
                    repaint();
                }
            };

            addMouseListener(mouseHandler);
            addMouseMotionListener(mouseHandler);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(new Color(255, 255, 255, 128));

            Area fill = new Area(new Rectangle(new Point(0, 0), getSize()));
            if (selectionBounds != null) {
                fill.subtract(new Area(selectionBounds));
            }
            g2d.fill(fill);
            if (selectionBounds != null) {
                g2d.setColor(Color.BLACK);
                g2d.draw(selectionBounds);
            }
            g2d.dispose();
        }
    }

    public static Rectangle getVirtualBounds() {
        Rectangle bounds = new Rectangle(0, 0, 0, 0);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice lstGDs[] = ge.getScreenDevices();
        for (GraphicsDevice gd : lstGDs) {
            bounds.add(gd.getDefaultConfiguration().getBounds());
        }
        return bounds;
    }
    
    
    private void close() {
WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);

    }
}