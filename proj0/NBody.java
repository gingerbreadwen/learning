public class NBody{

	public static double readRadius(String file){
		/* Start reading in planets.txt */
		In in = new In(file);
		int numberofPlanets = in.readInt();
		double radiusoftheUniverse = in.readDouble();

		return radiusoftheUniverse;
	}

	public static Body[] readBodies(String file){
		/* Start reading in planets.txt */
		In in = new In(file);
		int numberofPlanets = in.readInt();
		double radiusoftheUniverse = in.readDouble();
		Body[] body = new Body[numberofPlanets];
		int i = 0;
		/* Keep looking until the file is empty. */
		while(!(i == numberofPlanets)){
			double xP = in.readDouble();			
			double yP = in.readDouble();
			double xV = in.readDouble();
			double yV = in.readDouble();
			double m = in.readDouble();
			String name = in.readString();
			body[i] = new Body(xP,yP,xV,yV,m,name);
			i++;

			
					
		}
		return body;
	}

	public static String imageToDraw = "images/starfield.jpg";

	/* Draws three copies of the image in a rectangular pattern. */
	public static void drawStarfield(double r) {
	/** Enables double buffering.
	 * A animation technique where all drawing takes place on the offscreen canvas.
	 * Only when you call show() does your drawing get copied from the
	 * offscreen canvas to the onscreen canvas, where it is displayed
	 * in the standard drawing window. */
		StdDraw.enableDoubleBuffering();

	/** Sets up the universe so it goes from
	  * -100, -100 up to 100, 100 */
		StdDraw.setScale(-2*r,2*r);

	/* Clears the drawing window. */
		StdDraw.clear();

	
	
		StdDraw.picture(0, 0, imageToDraw);
	

	/* Shows the drawing to the screen, and waits 2000 milliseconds. */
		StdDraw.show();
		
	}

	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double Radius = NBody.readRadius(filename);
		Body[] body = NBody.readBodies(filename);
		NBody.drawStarfield(Radius);
		int iz = 0;
		while(iz<body.length){
			body[iz].draw();
			System.out.println("body.xxPos"+body[iz].xxPos);
			System.out.println("body.yyPos"+body[iz].yyPos);
			iz++;

		}

		StdDraw.enableDoubleBuffering();
		StdDraw.show();
		StdDraw.pause(2000);
		StdDraw.clear();

		double[] xForces = new double[body.length];
		double[] yForces = new double[body.length];

		int i=0;
		while(i<body.length){
			xForces[i] = body[i].calcNetForceExertedByX(body);
			yForces[i] = body[i].calcNetForceExertedByY(body);
			System.out.println("xForces"+xForces[i]);

			i++;
		}

		int j = 0;
		while(j<body.length){
			body[j].update(dt,xForces[j],yForces[j]);
			System.out.println("body.xxPos"+body[j].xxPos);
			System.out.println("body.yyPos"+body[j].yyPos);
			j++;
		}

		NBody.drawStarfield(Radius);
		int k = 0;
		while(k<body.length){
			body[k].draw();
			k++;
		}
		StdDraw.enableDoubleBuffering();
		StdDraw.show();


		

		/*


		double[] xForces = new double[body.length];
		double[] yForces = new double[body.length];

		double time = 0.0;
		int i1 = 0;
		
		while(time<=T){
			int i=0;
			while(i<body.length){
				xForces[i] = body[i].calcNetForceExertedByX(body);
				yForces[i] = body[i].calcNetForceExertedByY(body);
				System.out.println("xForces"+i);
				i++;
			}

			int j = 0;
			while(j<body.length){
				body[j].update(dt,xForces[j],yForces[j]);
				System.out.println("body.xxPos"+j);
				j++;
			}
					
			NBody.drawStarfield();
			int k = 0;
			while(k<body.length){
				body[k].draw();
				System.out.println("body.draw"+k);
				k++;
				
							
			}
			StdDraw.enableDoubleBuffering();
			StdDraw.show();

			
			
			
			

			

			i1++;
			time = time + i1*dt;
			

		}*/
		
	}

}