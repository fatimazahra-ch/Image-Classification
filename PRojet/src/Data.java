import java.util.Arrays;
import java.util.Locale;

class Data implements  Cloneable
{
	/**nb of values in a data*/
	int length;
	String chemin="";
	/**the values*/
	private double[]values;
	/**cluster associated to the data*/
	Cluster cluster;
	double dist =0.00d;
	
	/**
	 * initialize the values, the length and the sum
	 * @param _length the nb of values*/
	public Data(int _length)
	{
		length = _length;
		values = new double[length];
		chemin="";
	}
	/**
	 * initialize the values, the length and the sum
	 * @param tab the list of values*/
	public Data(double ...tab)
	{
		this(tab.length);
		chemin="";
		values = Arrays.copyOf(tab, tab.length);
	}
	public Data(String _chemin,double ...tab)
	{
		this(tab);
		chemin=_chemin;
	}
	/**
	 * change a value, abd the sum
	 * @param i indice of the value to be changed
	 * @param x new value
	 * */
	public void setValue(int i, double x)
	{ values[i] = x; }
	public void setchemin(String _chemin)
	{ chemin=_chemin; }

	/**
	 * @return the ith value of he data
	 * */
	public double getValue(int i)
	{ return values[i]; }
	public String getchemin()
	{ return chemin; }


	/**compute the euclidian distance between the current value and another one
	 * @param o the Other value to be compared with
	 * @return the distance between the current data and the other*/
	public double distNorm(Data o)
	{
		double sum = 0;
		for(int i=0; i<length; i++)
			sum += Math.pow(values[i] - o.values[i], 2);
		dist = Math.sqrt(sum);
		return  dist;
	}

	/**
	 * @return a clone of the data*/
	protected Data clone()
	{
		Data copy = new Data(values);
		copy.setchemin(chemin);
		return copy;
	}
	
	/**
	 * @return the list of the values
	 * */
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder("(");
		String sep=", ";
		for(double v:values) sb.append(String.format(Locale.ENGLISH,"%.2f", v)).append(sep);
		sb.append(")");
		sb.append("\n"+chemin);
		sb.append("\n++ et la distance avec le centre est d="+String.format(Locale.ENGLISH,"%.2f", dist));
		return sb.toString();
	}

	
	public void setCluster(Cluster cluster) { this.cluster = cluster; }

	public Cluster getCluster() { return cluster; }
	



}