/**
 * Created by Justus on 01.03.2017.
 */
public class Line extends Point {

    protected double dX, dY, dZ;

    public Line() {
        super();
        setDirection();
    }

    public Line(double pX, double pY, double pZ, double dX, double dY, double dZ, String name) {
        super(pX, pY, pZ, name);
        this.dX = dX;
        this.dY = dY;
        this.dZ = dZ;
    }

    private void setDirection() {
        System.out.println("Please assign your first direction coordinates.");
        System.out.println("X-value: ");
        dX = sc.nextFloat();
        System.out.println("Y-value: ");
        dY = sc.nextFloat();
        System.out.println("Z-value: ");
        dZ = sc.nextFloat();
    }

    public double getdX() {
        return dX;
    }

    public double getdY() {
        return dY;
    }

    public double getdZ() {
        return dZ;
    }
}
