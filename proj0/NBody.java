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
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		String imageToDraw = "images/starfield.jpg";
		double Radius = NBody.readRadius(filename);
		Body[] body = NBody.readBodies(filename);

	


		/*int iz = 0;
		while(iz<body.length){
			body[iz].draw();
			System.out.println("body.xxPos"+body[iz].xxPos);
			System.out.println("body.yyPos"+body[iz].yyPos);
			iz++;

		}

		StdDraw.show();
		StdDraw.pause(2000);


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


		StdDraw.clear();

		StdDraw.picture(0, 0, imageToDraw);

		int k = 0;
		while(k<body.length){
			body[k].draw();
			k++;
		}

		


		StdDraw.show();


		

		*/


		double[] xForces = new double[body.length];
		double[] yForces = new double[body.length];

		double time = 0.0;
		int i1 = 0;
		
		while(time<=T){

			StdDraw.setXscale(-1000*Radius,1000*Radius);
        	StdDraw.setYscale(-1000*Radius,1000*Radius);

       		 StdDraw.enableDoubleBuffering();
			
			StdDraw.clear();
			StdDraw.picture(0, 0, imageToDraw);

			int k = 0;
			while(k<body.length){
				body[k].draw();
				k++;			
							
			}


			StdDraw.show();
			StdDraw.pause(10);

			int i=0;
			while(i<body.length){
				xForces[i] = body[i].calcNetForceExertedByX(body);
				yForces[i] = body[i].calcNetForceExertedByY(body);
				System.out.println("fx:"+xForces[i]+"			fy:"+yForces[i]);
				i++;
				
			}

			int j = 0;
			while(j<body.length){
				body[j].update(dt,xForces[j],yForces[j]);
				//System.out.println(body[j].imgFileName+" "+body[j].xxPos+" "+
					//body[j].yyPos+" "+body[j].xxVel+" "+body[j].yyVel+" "+body[j].mass);
				j++;
			}
					
			
	

			i1++;
			time = time + i1*dt;
			

		}
		
	}

}