package Menus.WorldSelectorMenu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.plaf.metal.MetalScrollBarUI;

import GraphicsController.Graphics;

public class CreateScrollMenu {
	
	public CreateScrollMenu(Graphics graphics){
		graphics.panelParent = new JPanel(new BorderLayout());

		graphics.panel = new JPanel();
		graphics.panel.setLayout(new BoxLayout(graphics.panel, BoxLayout.PAGE_AXIS));
        
        
		graphics.panel.setSize(300, 300);
		graphics.panel.setBackground(Color.black);
        JScrollPane scroller = new JScrollPane(graphics.panel, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        
        graphics.panelParent.setSize(300, 300);
        graphics.panelParent.setLocation(253, 160);
        graphics.panelParent.setBorder(BorderFactory.createEmptyBorder(-1, -1, -2, -1));

        
        scroller.getVerticalScrollBar().setUI(new MyScrollbarUI());
        scroller.getHorizontalScrollBar().setUI(new MyScrollbarUI());
        
        graphics.panelParent.add(scroller, BorderLayout.CENTER);
        graphics.add(graphics.panelParent);
        graphics.panelParent.setVisible(false);
	}
	
static class MyScrollbarUI extends MetalScrollBarUI {
    	
    	final int buttonSize = 25;
        final int sizeY = 300 - buttonSize;
        final Color newColor = Color.lightGray;
    	
        public Image imageThumb, imageTrack;

        MyScrollbarUI() {
            imageThumb = FauxImage.create(32, 32, Color.DARK_GRAY);
            imageTrack = FauxImage.create(32, 32, Color.lightGray);
        }

        protected void paintThumb(java.awt.Graphics g, JComponent c, Rectangle r) {
            g.setColor(Color.blue);
            ((Graphics2D) g).drawImage(imageThumb,
                r.x, r.y, r.width, r.height, null);
        }

        protected void paintTrack(java.awt.Graphics g, JComponent c, Rectangle r) {
        	//g.setColor(Color.red);
            ((Graphics2D) g).drawImage(imageTrack,
                r.x, r.y, r.width, r.height, null);
        }

        @Override
        protected JButton createDecreaseButton(int orientation) {
        	JButton button = super.createDecreaseButton(orientation);
    	    button.setSize(buttonSize, buttonSize);
    	    button.setBackground(newColor);
    	    return button;
        }

        @Override
        protected JButton createIncreaseButton(int orientation) {
        	JButton button = super.createIncreaseButton(orientation);
            button.setSize(buttonSize, buttonSize);
            button.setLocation(0, sizeY);
            button.setBackground(newColor);
            return button;
        }
    }
    
    public static class FauxImage {

        static public Image create(int w, int h, Color c) {
            BufferedImage bi = new BufferedImage(
                w, h, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = bi.createGraphics();
            g2d.setPaint(c);
            g2d.fillRect(0, 0, w, h);
            g2d.dispose();
            return bi;
        }
    }

}
