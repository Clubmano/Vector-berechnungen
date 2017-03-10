import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

/**
 * Created by Justus on 01.03.2017.
 */
public class Point {
    Scanner sc = new Scanner(System.in);
    protected double pX, pY, pZ;
    protected String name;

    public Point() {
        setOrigin();
    }

    public Point(double pX, double pY, double pZ, String name) {
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

    public Scanner getSc() {
        return sc;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
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

    public void setName(String name) {
        this.name = name;
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
