import java.util.ArrayList;
import java.util.Locale;

class Cluster
{
	double erreur;
	/**data associated to the cluster*/
	 ArrayList<Data> dataSet;
	/**computed data that represent the center of the cluster*/
	Data centroid;
	/**nb of clusters*/
	private static int nb;
	/**no of the cluster*/
	int no;
	/**minimal distance between one of the data and the centroid
	 * */
	double minDist;
	/**maximal distance between one of the data and the centroid
	 * */
	double maxDist;
	/**average of the distances between the data and the centroid
	 * */
	double moyDist;

	public Cluster()
	{
		dataSet = new ArrayList<>();
		centroid = new Data();
		no = nb++;
	}

	/**initialise the data with a centroid*/
	public Cluster(Data _centroid)
	{
		this();
		centroid = _centroid;
	}

	/**add a data to the cluster (and tell to the data that it is associated to this cluster)*/
	public void add(Data data)
	{
		dataSet.add(data);
		data.setCluster(this);
	}

	/**remove a data to from the cluster 
	 * (and tell to the data that it is no more associated to this cluster)*/
	public void remove(Data data)
	{
		dataSet.remove(data);
		data.setCluster(null);
	}
	
	/**recompute the center of the cluster*/
	public void centralize()
	{ 
		ArrayList<Double> average=new ArrayList<Double>();
		double[] dt;
		int nbElt = dataSet.size();
		if(nbElt>0)
		{
			int dim = dataSet.get(0).length;
			dt=new double[dim];
			int[] tabI = {0};
			for(int i=0; i<dim;i++)
			{
				tabI[0] = i;
				double sum = dataSet.stream().parallel().mapToDouble(d->d.getValue(tabI[0])).sum();
				average.add(sum/(double)nbElt);
			}
			for(int i=0; i<centroid.length;i++)
			{
				if(centroid.getValue(i)!=average.get(i))
					dt[i]=average.get(i);
				else
					dt[i]=centroid.getValue(i);
			}
			centroid=new Data("",dt);
		}    	
	}
	
	/**compute the stats (minimal distance from a data to the centroid, maximal distance, average of the distances)*/
	public void computeStats()
	{
		double somDist=0;
		minDist=Double.POSITIVE_INFINITY;
		maxDist=Double.NEGATIVE_INFINITY;
		for(Data data:dataSet)
		{
			double dist = data.distNorm(centroid);
			if(dist<minDist) minDist=dist;
			if(dist>maxDist) maxDist=dist;
			somDist+=dist;
		}
		if(dataSet.size()>0) moyDist = somDist/dataSet.size();
	}
	
	/**@return the no of the clusters, its nb of data, the stats and the data*/
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder("cluster " + no + ", nb elts =  " + dataSet.size() + "\n");
		sb.append("--> centroid = ").append(centroid).append("\n data = \n");
		if (dataSet.size()<50) 
			for(Data data:dataSet) sb.append(data.toString()).append("\n");
		sb.append("--> dist min=").append(String.format(Locale.ENGLISH,"%.2f", minDist));
		sb.append("; dist max=").append(String.format(Locale.ENGLISH,"%.2f", maxDist));
		sb.append("; average dist=").append(String.format(Locale.ENGLISH,"%.2f", moyDist));
		sb.append("	\n---- ");
		return sb.toString();
	}

	
	void setCentroid(Data _centroid) { centroid = _centroid; }

	Data getCentroid() { return centroid; }

	int getNo() {return no;}
	public double error() {
		erreur=moyDist/dataSet.size()*(dataSet.get(0).length);
		return erreur;
	}

}
