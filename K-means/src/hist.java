import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;



public class hist{
	   private BufferedImage image;
	   private String chemin;
	   protected final int[] rouge = {0,0,0,0};
	   protected final int[] vert = {0,0,0,0};
	   protected final int[] bleu = {0,0,0,0};
	   
	   public hist(String monchemin) throws IOException{
		      chemin=monchemin;
		      image   = ImageIO.read(new File(chemin));
		      recupererRVB();
		   }
	   
		 
	   private void recupererRVB() {
		      Raster trame = image.getRaster();
		      int[] rgb = new int[3];
		      for (int y=0; y<image.getHeight(); y++) {
		         for (int x=0; x<image.getWidth(); x++) {
		            trame.getPixel(x, y, rgb);
		            if(rgb[0]<=63 &&  rgb[1]<=63 && rgb[2]<=63) {
		            	rouge[0]++;
		            	vert[0]++;
		            	bleu[0]++;
		            }
		            if((63<rgb[0] && rgb[0]<=127) &&  (63<rgb[1] && rgb[1]<=127) && (63<rgb[2] && rgb[2]<=127)) {
		            	rouge[1]++;
		            	vert[1]++;
		            	bleu[1]++;
		            }
		            if((127<rgb[0] && rgb[0]<=191) &&  (127<rgb[1] && rgb[1]<=191) && (127<rgb[2] && rgb[2]<=191)) {
		            	rouge[2]++;
		            	vert[2]++;
		            	bleu[2]++;
		            }
		            if((191<rgb[0] && rgb[0]<=255) &&  (191<rgb[1] && rgb[1]<=255) && (191<rgb[2] && rgb[2]<=255)) {
		            	rouge[3]++;
		            	vert[3]++;
		            	bleu[3]++;
		            }
		         }
		      }
      }
}

