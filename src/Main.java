import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

/**
 * Created by Justus on 01.03.2017.
 */
public class Main {
    ArrayList<Point> points = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    Scanner fileReader;
    Input inputHandler;
    Calculator calcHandler;
    private Formatter file;

    public Main() {
        inputHandler = new Input(this);
        calcHandler = new Calculator(this);
        start();
    }

    private void start() {
        while (true) {
            printMenu();

        }
    }

    public void deletePoint() {
        System.out.println("Which Point would you like to delete?");
        listPoints(true);
        points.remove(sc.nextInt());
        System.out.println();
    }

    public void listPoints(boolean showIndex) {
        System.out.println("");
        for (int i = 0; i < points.size(); i++) {
            if (showIndex == true) {
                System.out.println("[" + i + "]" + "Point " + points.get(i).name + " (" +
                        points.get(i).getpX() + "|" + points.get(i).getpY() + "|" + points.get(i).getpZ() + ")");
            } else {
                System.out.println("Point " + points.get(i).name + " (" +
                        points.get(i).getpX() + "|" + points.get(i).getpY() + "|" + points.get(i).getpZ() + ")");
            }
        }
        System.out.println("\n");
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    private void readDataFromFile() {
        points.clear();
        try {
            fileReader = new Scanner("Objects.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
        while (fileReader.hasNext()) {
            for (int i = 0; i < points.size(); i++) {
                points.get(i).setName(fileReader.nextLine());
                System.out.println(points.get(i).getName());
                points.get(i).setpX(fileReader.nextDouble());
                points.get(i).setpY(fileReader.nextDouble());
                points.get(i).setpZ(fileReader.nextDouble());
            }
        }
    }

    private void writeDataIntoFile() {
        try {
            file = new Formatter("Objects.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < points.size(); i++) {
            String pX = Double.toString(points.get(i).getpX());
            String pY = Double.toString(points.get(i).getpY());
            String pZ = Double.toString(points.get(i).getpZ());
            file.format("%s%s%s%s%s%s%s%s", points.get(i).getName(), " ", pX, " ", pY, " ", pZ, "\n");
        }
        file.close();
        System.out.println("Objects have been saved.");

    }

    private void printMenu() {
        System.out.println("[1] Input Something");
        System.out.println("[2] List everything");
        System.out.println("[3] Delete");
        System.out.println("[4] Calculations");
        System.out.println("[5] Load Objects");
        System.out.println("[6] Save Objects");
        System.out.println("[7] Exit");

        switch (sc.nextInt()) {
            case 1:
                inputHandler.inputData();
                break;
            case 2:
                listPoints(false);
                break;

            case 3:
                deletePoint();
                break;
            case 4:
                calcHandler.calcMenu();
                break;
            case 5:
                readDataFromFile();
                break;
            case 6:
                writeDataIntoFile();
                break;
            case 7:
                System.exit(0);
                break;


        }
    }
}
