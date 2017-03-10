import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Justus on 01.03.2017.
 */
public class Calculator {
    Scanner sc = new Scanner(System.in);
    Main main;
    ArrayList<Integer> index = new ArrayList<>();

    public Calculator(Main main) {
        this.main = main;
    }

    public void calcMenu() {
        System.out.println("Please select your calculation.");
        System.out.println("[1] Distance between two points");
        System.out.println("[2] Show relations between two points");
        System.out.println("[3] Check if Points are on one line.");
        switch (sc.nextInt()) {
            case 1:
                pointSelection(2);
                calcDistance(index);
                index.clear();
                break;
            case 2:
                pointSelection(2);
                showRelations(index);
                index.clear();
                break;
            case 3:
                System.out.println("How many points do you wanna check?");
                pointSelection(sc.nextInt());
                pointsOnALine(index);
                index.clear();
                break;
        }

    }

    public void pointsOnALine(ArrayList<Integer> points) {


    }

    public void showRelations(ArrayList<Integer> points) {

        System.out.println("\nDistance: " + calcDistance(points));

    }

    private ArrayList<Integer> pointSelection(int pointAmount) {
        main.listPoints(true);
        for (int i = 1; i < pointAmount + 1; i++) {
            if (main.points.size() >= i) {
                System.out.println("Please select your point number " + i + " now.");
                index.add(sc.nextInt());
            } else {
                System.out.println("\nYou need at least " + i + " points to calculate a distance.\n");
            }
        }
        return index;

    }

    public double calcDistance(ArrayList<Integer> points) {
        double distance = 0;
        distance = Math.sqrt(Math.pow((main.points.get(points.get(0)).getpX() - (main.points.get(points.get(1)).getpX())), 2) + Math.pow((main.points.get(points.get(0)).getpY() -
                (main.points.get(points.get(1)).getpY())), 2) + Math.pow((main.points.get(points.get(0)).getpZ() - (main.points.get(points.get(1)).getpZ())), 2));

        return distance;
    }
}
