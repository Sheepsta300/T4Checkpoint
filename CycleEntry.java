package checkpoint2;

public class CycleEntry extends Entry{
	private String terrain;
	private String tempo;
	
	public CycleEntry(String n, int d, int m, int y, int h, int min,
			int s, float dist, String terrain, String tempo) {
		super(n, d, m, y, h, min, s, dist);
		this.tempo = tempo;
		this.terrain = terrain;
	}
	public String getEntry () {
		   String result = getName()+" cycled " + getDistance() + " km in "
		             +getHour()+":"+getMin()+":"+ getSec() + " on "
		             +getDay()+"/"+getMonth()+"/"+getYear()+ " on " +
		              getTerrain() + " terrain at a tempo of " + getTempo() + "\n";
		   return result;
		  }
	public String getTerrain() {
		return terrain;
	}
	public String getTempo() {
		return tempo;
	}
}