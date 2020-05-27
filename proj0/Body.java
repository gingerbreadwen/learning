public class Body{
	double xxPos; 
	double yyPos;
	double xxVel;
	double yyVel;
	double mass;
	String imgFileName;
	static final double G = 6.67e-11;
	public Body(double xP, double yP, double xV,
              double yV, double m, String img){
		this.xxPos = xP;
		this.yyPos = yP;
		this.xxVel = xV;
		this.yyVel = yV;
		this.mass = m;
		this.imgFileName = img;
	}
	public Body(Body b){
		this.xxPos = b.xxPos;
		this.yyPos = b.yyPos;
		this.xxVel = b.xxVel;
		this.yyVel = b.yyVel;
		this.mass = b.mass;
		this.imgFileName = b.imgFileName;

	}

	public double calcDistance(Body b){
		double dx = this.xxPos - b.xxPos;
		double dy = this.yyPos - b.yyPos;
		return Math.sqrt(dx*dx + dy*dy);			
	}
	public double calcForceExertedBy(Body b){
		double f = G * this.mass * b.mass/
			(this.calcDistance(b)*this.calcDistance(b));
		return f;
	}

}
