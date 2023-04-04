
public class SprintEntry extends Entry{
	private int repetitions;
	private int recovery;
	
	public SprintEntry(String n, int d, int m, int y, int h, int min,
			int s, float dist, int repetitions, int recovery) {
		super(n, d, m, y, h, min, s, dist);
		this.repetitions = repetitions;
		this.recovery = recovery;
	}
	public String getEntry () {
		   String result = getName()+" sprinted " + getDistance() + " km in "
		             +getHour()+":"+getMin()+":"+ getSec() + " on "
		             +getDay()+"/"+getMonth()+"/"+getYear()+ getRepetitions() + 
		             " times, with a " + recovery + " minute recovery time\n";
		   return result;
		  }
	public int getRepetitions() {
		return repetitions;
	}
	public int getRecovery() {
		return recovery;
	}
}
