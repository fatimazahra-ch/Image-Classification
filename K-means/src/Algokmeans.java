import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Random;

import javax.imageio.ImageIO;

public class Algokmeans {
	
	private static  int samples[][];
	private static ArrayList<Data> dataSet = new ArrayList<>();
	private static ArrayList<Cluster> clusters = new ArrayList<>();
	
    
    private Algokmeans(Data[] data) {
    	samples =new int[data.length][768];
    	for( int i = 0 ; i < data.length ; i++ ) {
    		Data d = new Data(data[i].image);
    		for( int j = 0 ; j < 768 ; j++ ) {
    			samples[i][j] = d.getValue(j);
    		}
    	}
    	
    }
    
     /**create some randomize data
	 * @param _nb nb of data to generate
	 * @param _dim diemnsion of the data */
	private static void createSamples (int _nb, int _dim) {
		samples =new int[_nb][_dim];
		
		
//		Random r = new Random();
//		for ( int i = 0 ; i < _nb ; i++ ) {
//			for ( int j = 0 ; j < _dim ; j++ ) {
//				samples[i][j] = r.nextInt(255);
//			}
//		}	
	}

	/**initialise de Data list, normalize them, and create the clusters
	 * @param _nbClusters nb of clusters
	 * @param _dim size of a data
	 *  */
	
	private static void initialize(int _nbClusters) {
		for(int[] data:samples) {
			dataSet.add(new Data(data));
		}
		createClusters(_nbClusters);
	}

	/** create clusters well separated*/
	private static void createClusters(int _nbClusters) {
		Data centroid = dataSet.get( (int)(dataSet.size()*Math.random()) );
		Cluster firstCluster = new Cluster(centroid);
		clusters.add(firstCluster);
		int nbClusters = _nbClusters;
		for( int c = 1 ; c < nbClusters ; c++ ) {
			Data farData = null;
			Double maxDist = Double.NEGATIVE_INFINITY;
			for( Data data:dataSet ) {
				double minDist = Double.POSITIVE_INFINITY;
				for(Cluster cluster:clusters) {
					double dist = data.distNorm(cluster.getCentroid());
					if( minDist > dist ) minDist = dist;
				}
				if ( maxDist < minDist ) {
					maxDist  = minDist; 
					farData = data;
				}
			}
			Cluster cluster = new Cluster(farData.clone());
			clusters.add(cluster);
		}
		System.out.println("Initially, centroids are:");
		clusters.forEach(c->System.out.println(c.centroid.toString()));
	}
	
	/**algorithm of Kmeans :<br>
	 * set each data in th best cluster and do a loop: <br>
	 * -compute the new clusters centers; -moving  of data in best clusters if necessary
	 * */
	
	private static void kMeanCluster() {
		dataSet.forEach(data -> searchCluster(data).add(data));
		boolean moving = true;
		while(moving)
		{
			moving = false;
			clusters.forEach(c -> c.centralize());
			for(Data data:dataSet)
			{
				Cluster bestCluster = searchCluster(data);
				if(data.getCluster() != bestCluster){
					moving = true;
					data.getCluster().remove(data);
					bestCluster.add(data);
				}
			}
		}
	}



	/**search the best cluster for a data
	 * @param data the data to place in a cluster
	 * @return the cluster whose the centroid is the closest from the data*/
	private static Cluster searchCluster(Data data) {
		Cluster bestCluster = null;
		double minimum = Double.POSITIVE_INFINITY;
		double distance=0;
		for(Cluster cluster:clusters)
		{
			distance = data.distNorm(cluster.getCentroid());
			if(distance < minimum){ minimum = distance; bestCluster = cluster; }
		}
		return bestCluster;
	}

	/**main program
	 * @throws IOException */
	public static void main(String[] args) throws IOException	{
//		int dim=768;
//		int nbSamples = 10000;
//		createSamples(nbSamples, dim);
//		for( int i = 0 ; i < 10000 ; i++ ) {
//			for( int j = 0 ; j < 255 ; j++ )
//				System.out.print(samples[i][j]);
//			System.out.println();
//		} 
		
		Data[] data = new Data[5];
		data[0] = new Data(ImageIO.read(new File("1.jpg")));
		data[1] = new Data(ImageIO.read(new File("2.jpg")));
    	data[2] = new Data(ImageIO.read(new File("3.jpg")));
    	data[3]	= new Data(ImageIO.read(new File("4.jpg")));
    	data[4]	= new Data(ImageIO.read(new File("5.jpg")));
				
    	Algokmeans a = new Algokmeans(data);
    	
		int nbClusters = 3;
		System.out.println("classification of " + " samples of dimension " + 768 + " into " + nbClusters + " clusters.");
		long start = System.currentTimeMillis();
		initialize(nbClusters);
		//For(clusters).......
		
//		System.out.println("\n *********************  Clusters are : *****************");
//		for( int i = 0 ; i < 15 ; i++ ) {
//			System.out.println(clusters.get(i).toString());
//		}
		
		
		kMeanCluster();
		long end = System.currentTimeMillis();
		System.out.println("after " + (end-start) + " ms ");
		clusters.forEach(c->c.computeStats());
		// Print out clustering results.
		double error = 0;
		int nb=0;
		for(Cluster cluster:clusters)	{
			if (cluster.dataSet.size()>0)	{
				System.out.println(cluster);
				nb++;
				error += cluster.moyDist;
			}
		}
		error = error/(nb*768);
		System.out.println("gobal error= " + String.format(Locale.ENGLISH, "%.2f", (error*100)) + " % ");
	}
}