import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

class Data implements  Cloneable  {
	
	    BufferedImage image;
	    private final int[] rouge = new int[256];
		private final int[] vert = new int[256];
	    private final int[] bleu = new int[256];
	    private int[] values;
		private Cluster cluster;

		public Data(int _length) { // _length = 3*nbrPixels.
			  values = new int[_length];
	    }
		 
	    public Data(int[] tab) {
			  this(tab.length);
			  values = Arrays.copyOf(tab, tab.length);
		 }
		
		public Data(BufferedImage monImage) {
			  image = monImage;
			  récupérerRVB();
		}
		
	    public int[] toArray(int argb) {	   
			   int[] array = new int[3];
			   for(int i=0; i<3; i++) {
				   array[i] = (argb >> (2-i)*8 ) & 0xff;
		       }
			   return array;
		} 
	    
	    private void récupérerRVB () { 
	    	  Raster trame = image.getRaster();
		      int[] rgb = new int[3];
		      for ( int y=0 ; y<image.getHeight(); y++)
		         for (int x=0; x<image.getWidth(); x++) {
		            trame.getPixel(x, y, rgb);
		            rouge[rgb[0]]++;  
		            vert[rgb[1]]++;
		            bleu[rgb[2]]++;
		         } 
		   
		      values = new int[768];
		      int j = 0;   
		      for( int i = 0 ; i < 256 ; i++ , j++ ) { values[j] = rouge[i]; }
		      for( int i = 0 ; i < 256 ; i++ , j++ ) { values[j] = vert[i]; }
		      for( int i = 0 ; i < 256 ; i++ , j++ ) { values[j] = bleu[i]; }
		 }
	    
		public double distNorm(Data o) {
			double dist, sum = 0;
			for( int i = 0 ; i < 768 ; i++ )
				sum +=  Math.pow(values[i] - o.values[i], 2);
			dist =  Math.sqrt(sum);
			return  dist;
		}
		
		protected Data clone(){
			//Data copy = new Data(image);
			Data copy = new Data(values);
			return copy;
		}
		
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder("(");
			String sep=", ";
			for(double v:values) sb.append(String.format(Locale.ENGLISH,"%.2f", v)).append(sep);
			sb.append(")");
			return sb.toString();
		} 
			
		public int getValue(int i) { return values[i]; }

		public int[] getValues() { return values; }

		public void setValues(int[] values) { this.values = values; }

		public void setValue(int i, int x) { values[i] = x; }

		public void setCluster(Cluster cluster) { this.cluster = cluster; }
	
		public Cluster getCluster() { return cluster; }

}
