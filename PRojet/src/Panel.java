import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panel extends JPanel {
    private static final long serialVersionUID = -9129537057351390955L;

    private Image[] img = new Image[500];
    private int len ;
    private JLabel pimage = new JLabel();
    
	private static int x=0;
     
    public Panel(Image[] img, int len) {
		super();
		this.img = img;
		this.len = len;
	}
    
	public Panel(ArrayList<String> sameimages) {
		// TODO Auto-generated constructor stub
    	len = sameimages.size();
    	 for(int i = 0;i<sameimages.size();i++)
         {
         	ImageIcon imageicon = new ImageIcon(sameimages.get(i));
         	img[i] = imageicon.getImage();
         }
    	
	}
	
	public void paintComponent(Graphics g) {
        //tu peux changer la taille ici
		x = 0;
    	for(int i=0;i<len;i++)
    	{
    		 g.drawImage(img[i], x, 0, 50, 50, this);
    	     x = x+50;
    	}

    }
}