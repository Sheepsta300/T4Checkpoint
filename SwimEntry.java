package checkpoint2;

public class SwimEntry extends Entry {
	
	private String where;
	
	public SwimEntry(String n, int d, int m, int y, int h, int min, int s, float dist, String where) {
		super(n, d, m, y, h, min, s, dist);
		this.where = where;
	}	
	public String getEntry () {
		   String result = getName()+" swam " + getDistance() + " km in "
		             +getHour()+":"+getMin()+":"+ getSec() + " on "
		             +getDay()+"/"+getMonth()+"/"+getYear()+ " " + getWhere() + "\n";
		   return result;
		  }
	public String getWhere() {
		return where;
	}
}
