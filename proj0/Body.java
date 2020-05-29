public class Body{
	double xxPos; 
	double yyPos;
	double xxVel;
	double yyVel;
	double mass;
	String imgFileName;
	static final double G = 6.67e-11;
	/**
	* @param  xP - 星体x坐标.
	* @param  yP - 星体y坐标.
	* @param  xV - 星体x方向速度.
	* @param  yV - 星体y方向速度.
	* @param  m - 星体质量.
	* @param  img - 图片名称.
	*/
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

	public double calcNetForceExertedByX(Body[] s){	
		double netForceX = 0;
		for (Body k : s) {
			if (this.equals(k)) {
			continue;	
			}else{
				double dx = k.xxPos - this.xxPos;
				double fx = this.calcForceExertedBy(k) * dx 
				/ Math.sqrt(this.calcDistance(k));	
				netForceX = fx + netForceX;					
			}	
			
		}
		return netForceX;
	}

	public double calcNetForceExertedByY(Body[] s){	
		double netForceY = 0;
		for (Body k : s) {
			if (this.equals(k)) {
			continue;	
			}else{
				double dy = k.yyPos - this.yyPos;
				double fy = this.calcForceExertedBy(k) * dy 
				/ Math.sqrt(this.calcDistance(k));	
				netForceY = fy + netForceY;					
			}	
			
		}
		return netForceY;
	}

	public void update(double dt,double fX,double fY){
		double aNetX = fX / this.mass;
		double aNetY = fY / this.mass;
		this.xxVel = this.xxVel + dt*aNetX;
		this.yyVel = this.yyVel + dt*aNetY;
		this.xxPos = this.xxPos + dt*this.xxVel;
		this.yyPos = this.yyPos + dt*this.yyVel;

	}

	public void draw(){
		String a = "images/";
		String b = this.imgFileName;
		String imageToDraw =a.concat(b);
		StdDraw.enableDoubleBuffering();

	/** Sets up the universe so it goes from
	  * -100, -100 up to 100, 100 */
		StdDraw.setScale(-2.50e+11,2.50e+11);

	/* Clears the drawing window. */
		

	/* Stamps copies of pic. */
		StdDraw.picture(this.xxPos, 
			this.yyPos,imageToDraw);
		
		
	

	/* Shows the drawing to the screen, and waits 2000 milliseconds. */
		StdDraw.show();
		StdDraw.pause(2000);
	}

}
