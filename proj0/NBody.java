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

	public static void main(String[] args) {
		double T = Double(args[0]);
		double dt = Double(args[1]);
		String filename = args[2];
		double Radius = NBody.readRadius(filename);
		NBody.readBodies(filename);
	}

}