import java.util.Scanner;

/**
 * Created by Justus on 01.03.2017.
 */
class Point {
    Scanner sc = new Scanner(System.in);
    private double pX;
    private double pY;
    private double pZ;
    String name;

    public Point() {
        setOrigin();
    }

    Point(double pX, double pY, double pZ, String name) {
        this.pX = pX;
        this.pY = pY;
        this.pZ = pZ;
        this.name = name;
    }
    private void setOrigin() {
        System.out.println("Please name your Object.");
        name = sc.next();
        System.out.println("Please assign your origin coordinates.");
        System.out.println("X-value: ");
        pX = sc.nextFloat();
        System.out.println("Y-value: ");
        pY = sc.nextFloat();

        System.out.println("Z-value: ");
        pZ = sc.nextFloat();
    }
    public void setpX(double pX) {
        this.pX = pX;
    }

    public void setpY(double pY) {
        this.pY = pY;
    }

    public void setpZ(double pZ) {
        this.pZ = pZ;
    }

    public String getName() {
        return name;
    }

    public double getpX() {
        return pX;
    }

    public double getpY() {
        return pY;
    }

    public double getpZ() {
        return pZ;
    }
}
