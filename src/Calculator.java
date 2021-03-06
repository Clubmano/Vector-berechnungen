import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Justus on 01.03.2017.
 */
class Calculator {
    private final Scanner sc = new Scanner(System.in);
    private final basic basic;
    private final ArrayList<Integer> index = new ArrayList<>();

    public Calculator(basic basic) {
        this.basic = basic;
    }

    // The menu, which shows up when the method calculations is called. The menu shows all the calculations, that can be done
    public void calcMenu() {
        System.out.println("Please select your calculation.");
        System.out.println("[1] Distance between two points");
        System.out.println("[2] Show relations between two points");
        System.out.println("[3] Check if points are on one line.");
        System.out.println("[4] Add or subtract points..");
        switch (sc.nextInt()) {
            case 1:
                pointSelection(2, 2);
                System.out.println("\nThe Distance is: " + calcDistance(index) + "\n");
                index.clear();
                break;
            case 2:
                pointSelection(2, 2);
                showRelations(index);
                index.clear();
                break;
            case 3:
                System.out.println("How many points do you wanna check?");
                pointSelection(sc.nextInt(), 3);
                pointsOnALine(index);
                index.clear();
                break;
            case 4:
                pointSelection(2,2);
                System.out.println("How many times would you like to add or subtract the point?");
                additionOfVector(index, sc.nextInt());
                index.clear();
                break;
        }

    }

    //Method to check whether 3 or more Points are on one line. It checks if the relative gradient between three points differs.
    private void pointsOnALine(ArrayList<Integer> points) {
        boolean onALine = true;
        //Checking for a difference in X gradient.
        int originRelativeGradientX = (int) ((basic.points.get(points.get(0)).getpX() - basic.points.get(points.get(1)).getpX())
                / (basic.points.get(points.get(0)).getpY() - basic.points.get(points.get(1)).getpY()));
        for (int i = 1; i < points.size() - 1; i++) {
            int comparisonRelativeGradientX = (int) ((basic.points.get(points.get(i)).getpX() - basic.points.get(points.get(i + 1)).getpX())
                    / (basic.points.get(points.get(i)).getpY() - basic.points.get(points.get(i + 1)).getpY()));
            System.out.println(originRelativeGradientX);
            System.out.println(comparisonRelativeGradientX);

            if (comparisonRelativeGradientX != originRelativeGradientX) {
                onALine = false;
                break;
            } else {

            }
        }
        //Checking for a difference in Y gradient.
        int originRelativeGradientY = (int) ((basic.points.get(points.get(0)).getpY() - basic.points.get(points.get(1)).getpY())
                / (basic.points.get(points.get(0)).getpZ() - basic.points.get(points.get(1)).getpZ()));
        for (int i = 1; i < points.size() - 1; i++) {
            int comparisonRelativeGradientY = (int) ((basic.points.get(points.get(i)).getpY() - basic.points.get(points.get(i + 1)).getpY())
                    / (basic.points.get(points.get(i)).getpZ() - basic.points.get(points.get(i + 1)).getpZ()));
            System.out.println(originRelativeGradientY);
            System.out.println(comparisonRelativeGradientY);
            if (comparisonRelativeGradientY != originRelativeGradientY) {
                onALine = false;
                break;
            }
        }
        if (onALine) {
            System.out.println("\nThe selected points are on one line.\n");
        } else {
            System.out.println("\nThe selected points are not one line.\n");
        }
    }

    // This method shows all relations between two points. Basically sums up all other calculation methods.
    private void showRelations(ArrayList<Integer> points) {

        System.out.println("\nDistance: " + calcDistance(points));

    }

    // The method, which is called when points have to be selected for any other calculation.
    private ArrayList<Integer> pointSelection(int pointAmount, int minimumAmount) {
        basic.listPoints(true);
        for (int i = 1; i < pointAmount + 1; i++) {
            if (minimumAmount >= pointAmount) {
                System.out.println("Please select your point number " + i + " now.");
                index.add(sc.nextInt());
            } else {
                System.out.println("\nYou need at least " + minimumAmount + " points to do the selected calculation.\n");
            }
        }
        return index;

    }

    //Method to calculate the distance between two points. It is done by the simple formal sqrt(Δx²+Δy²+Δz²).
    private double calcDistance(ArrayList<Integer> points) {
        double distance = Math.sqrt(Math.pow((basic.points.get(points.get(0)).getpX() - (basic.points.get(points.get(1)).getpX())), 2)
                + Math.pow((basic.points.get(points.get(0)).getpY() - (basic.points.get(points.get(1)).getpY())), 2)
                + Math.pow((basic.points.get(points.get(0)).getpZ() - (basic.points.get(points.get(1)).getpZ())), 2));

        return distance;
    }
    private void additionOfVector (ArrayList<Integer> points, int factor){
        basic.points.add(new Point((basic.points.get(points.get(0)).getpX() + (basic.points.get(points.get(1)).getpX()*factor)),
                    (basic.points.get(points.get(0)).getpY() + (basic.points.get(points.get(1)).getpY()*factor)),
                    (basic.points.get(points.get(0)).getpZ() + (basic.points.get(points.get(1)).getpZ()*factor)),
                basic.points.get(0).getName()+ " ("+factor+basic.points.get(1).getName()+")"));
    }
}
