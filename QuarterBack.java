
public class QuarterBack {
	private double completions = 0;
	private double attempts = 0;
	private double yards = 0;
	private double touchdowns = 0;
	private double interceptions = 0;
	private String name = "";
	
	public QuarterBack(){
		completions = 0;
		attempts = 0;
		yards = 0;
		touchdowns = 0;
		interceptions = 0;
		name = "";
	}
	
	public QuarterBack(String name){
		completions = 0;
		attempts = 0;
		yards = 0;
		touchdowns = 0;
		interceptions = 0;
		this.name = name;
	}
	
	public double getCompletions() {
		return completions;
	}
	
	public double getAttempts() {
		return attempts;
	}
	
	public double getYards() {
		return yards;
	}
	
	public double getTouchdowns() {
		return touchdowns;
	}
	
	public double getInterceptions() {
		return interceptions;
	}
	
	public String getName(){
		return name;
	}
	
	public void setCompletions(double completions) {
		this.completions = completions;
	}
	
	public void setAttempts(double attempts){
		this.attempts = attempts;
	}
	
	public void setYards (double yards){
		this.yards = yards;
	}
	
	public void setTouchdowns (double touchdowns){
		this.touchdowns = touchdowns;
	}
	
	public void setInterceptions (double interceptions){
		this.interceptions = interceptions;
	}
	
	public void setName (String name){
		this.name = name;
	}
	
	public double QBR() {
		try {
			double a = (((completions/attempts) * 100) -30) / 20;
			a = cap(a);
			double b = ((touchdowns/attempts) * 100) / 5;
			b = cap(b);
			double c = (9.5 - ((interceptions/attempts) * 100)) / 4;
			c = cap(c);
			double d = ((yards/attempts) - 3) / 4;
			d = cap(d);
			return ((a+b+c+d)/6)*100;
		}
		catch (ArithmeticException e){
			return 0;
		}
	}
	
	private static double cap(double a){
		if (a < 0)
			a = 0;
		if (a > 2.375)
			a = 2.375;
		return a;
	}
}
