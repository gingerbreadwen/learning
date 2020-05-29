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
	public static void drawStarfield() {
				/** Enables double buffering.
		  * A animation technique where all drawing takes place on the offscreen canvas.
		  * Only when you call show() does your drawing get copied from the
		  * offscreen canvas to the onscreen canvas, where it is displayed
		  * in the standard drawing window. */
		StdDraw.enableDoubleBuffering();

		/** Sets up the universe so it goes from
		  * -100, -100 up to 100, 100 */
		StdDraw.setScale(-512,512);

		/* Clears the drawing window. */
		StdDraw.clear();

		/* Stamps three copies of advice.png in a triangular pattern. */
	
		StdDraw.picture(0, 0, imageToDraw);
	

		/* Shows the drawing to the screen, and waits 2000 milliseconds. */
		StdDraw.show();
		StdDraw.pause(2000);
	}

	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double Radius = NBody.readRadius(filename);
		Body[] b = NBody.readBodies(filename);
		NBody.drawStarfield();
	}

}