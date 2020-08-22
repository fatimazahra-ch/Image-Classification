import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class AlgoKMeans
{
	
	private static  double samples[][];
	protected static ArrayList<Data> dataSet = new ArrayList<>();
	public static ArrayList<Cluster> clusters = new ArrayList<>();
    private static double error = 0;
    private static int nb=0;
    protected static ArrayList<Double> errors=new ArrayList<Double>();

	/**initialise de Data list, normalize them, and create the clusters
	 * @param _nbClusters nb of clusters
	 * @param _dim size of a data
	 *  */
	private static void initialize(int _nbClusters, int _dim,ArrayList<String> _chemins)
	{
		for(double[] data:samples) 
			dataSet.add(new Data(data));
	    for(int i=0;i<_chemins.size();i++) {
	    	dataSet.get(i).setchemin(_chemins.get(i));
	    }

		createClusters(_nbClusters);
	}

	/**create clusters well separated*/
	private static void createClusters(int _nbClusters) {
		Data centroid = dataSet.get((int)(dataSet.size()*Math.random()));
		Cluster firstCluster = new Cluster(centroid);
		clusters.add(firstCluster);
		int nbClusters = _nbClusters;
		for(int c = 1; c<nbClusters; c++) {
			Data farData = null;
			double maxDist = Double.NEGATIVE_INFINITY;
			for(Data data:dataSet) {
				double minDist = Double.POSITIVE_INFINITY;
				for(Cluster cluster:clusters) {
					double dist = data.distNorm(cluster.getCentroid());
					if(minDist>dist) minDist = dist;
				}
				if (maxDist<minDist) {
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
	private static void kMeanCluster()
	{
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
	public AlgoKMeans() throws IOException
	{
		String ligne="";
		int cpt_data;
		int dim=4*3;
		int nbSamples =1000;
		samples =new double[nbSamples][dim];
		int nbClusters = 10;
		ArrayList<String> chemins=new ArrayList<String>();
		FileReader fichier=new FileReader("C:/fatimazahra CHARJANE/S3/JAVA Dev/Classification images/K-means/image.txt");
		BufferedReader bufferR=new BufferedReader(fichier);
		
		
		FileWriter fichier_w=new FileWriter("C:/fatimazahra CHARJANE/S3/JAVA Dev/Classification images/K-means/image.txt");
		BufferedWriter bufferW=new BufferedWriter(fichier_w);
		for(int i=0;i<1000;i++) {
			bufferW.write("C:/fatimazahra CHARJANE/S3/JAVA Dev/Classification images/K-means/img/"+i+".jpg");
			bufferW.newLine();
		}
		bufferW.close();
		fichier_w.close();
		while((ligne=bufferR.readLine())!=null){
			chemins.add(ligne);
		}
		for(int i=0;i<chemins.size();i++) {
			cpt_data=0;
			double [] rgb=new double[dim];
			hist h=new hist(chemins.get(i));
			//bufferW.write(chemins.get(i));
			for(int j=0;j<4;j++){
				//bufferW.write(String.valueOf(h.rouge[j]));
				//bufferW.write("/");
				rgb[cpt_data]=h.rouge[j];
				cpt_data++;
				}
			//bufferW.write("-------");
			for(int j=0;j<4;j++) {
				//bufferW.write(String.valueOf(h.vert[j]));
				//bufferW.write("/");
				rgb[cpt_data]=h.vert[j];
				cpt_data++;
			}
			//bufferW.write("-------");
			for(int j=0;j<4;j++) {
				//bufferW.write(String.valueOf(h.bleu[j]));
				//bufferW.write("/");
				rgb[cpt_data]=h.bleu[j];
				cpt_data++;
			}
			samples[i]=Arrays.copyOf(rgb, dim);
			//bufferW.newLine();
		}
	    fichier.close();
		long start = System.currentTimeMillis();
		initialize(nbClusters, dim,chemins);
		kMeanCluster();
		long end = System.currentTimeMillis();
		System.out.println("after " + (end-start) + " ms ");
		clusters.forEach(c->c.computeStats());
		// Print out clustering results.
		for(Cluster cluster:clusters)
		{
			
			if (cluster.dataSet.size()>0)
			{
				nb++;
				error += cluster.moyDist;
				errors.add(cluster.error());
			}
        }
		error = error/(nb*dim);
	}
}