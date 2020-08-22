import java.util.ArrayList;
import java.util.Locale;

class Cluster {
	 ArrayList<Data> dataSet; 
	 Data centroid; 
	 static int nb; 
	 int no; 
	 double minDist;
	 double maxDist;
	 double moyDist;

	public Cluster() {
		dataSet = new ArrayList<>();
		centroid = new Data(768); // 3*nbPixels
		no = nb++; // ??
	}

	public Cluster (Data _centroid) {
		this();
		centroid = _centroid;
	}

	public void add (Data data)	{
		dataSet.add(data);
		data.setCluster(this);
	}

	public void remove(Data data) {
		dataSet.remove(data);
		data.setCluster(null);
	}
	
	/**recompute the center of the cluster*/
	public void centralize() {
		int nbElt = dataSet.size(); // number of rows = number of photos in data ...
		if( nbElt > 0 ) {
			int dim = 768;
			int[] tabI = {0};
			for(int i=0 ; i < dim ; i++)	{
				tabI[0] = i;
				double sum = dataSet.stream().parallel().mapToDouble(d->d.getValue(tabI[0])).sum();
				int average = (int)sum/nbElt;
				if( centroid.getValue(i) != average ) { centroid.setValue(i, (int)sum/nbElt); }
			}    		
		}    	
	}
	
	/**compute the stats (minimal distance from a data to the centroid, maximal distance, average of the distances)*/
	public void computeStats() {
		double somDist = 0;
		minDist = Double.POSITIVE_INFINITY;
		maxDist = Double.NEGATIVE_INFINITY;
		for(Data data:dataSet)
		{
			double dist = data.distNorm(centroid);
			if(dist<minDist) minDist = dist;
			if(dist>maxDist) maxDist = dist;
			somDist += dist;
		}
		if(dataSet.size()>0) moyDist = somDist/dataSet.size();
	}
	
	/**@return the no of the clusters, its nb of data, the stats and the data*/
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("cluster " + no + ", nb elts =  " + dataSet.size() + "\n");
		sb.append("--> centroid = ").append(centroid).append("\n data = \n");
		if (dataSet.size() < 50) 
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

}