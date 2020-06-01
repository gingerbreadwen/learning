/**
 *  Tests calcForceExertedBy
 */
public class TestBody {

    /**
     *  Tests TestBody.
     */
    public static void main(String[] args) {
        Body b1 = new Body(1.4960e+11,0.0000e+00,0.0000e+00,2.9800e+04,5.9740e+24,"earth.gif");
        Body b2 = new Body(2.2790e+11,0.0000e+00,0.0000e+00,2.4100e+04,6.4190e+23,"mars.gif");
        double p1 = b1.calcForceExertedBy(b2);
        double p2 = b2.calcForceExertedBy(b1);
        double p1x = b1.calcForceExertedByX(b2);
        double p2x = b2.calcForceExertedByX(b1);
        double p1y = b1.calcForceExertedByY(b2);
        double p2y = b2.calcForceExertedByY(b1);
        System.out.println("fmars:"+p1+" fxmars:"+p1x+" fymars:"+p1y);
        System.out.println("fearth:"+p2+" fxearth:"+p2x+" fyearth:"+p2y);


    }

}
