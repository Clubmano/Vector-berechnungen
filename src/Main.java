import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

/**
 * Created by Justus on 01.03.2017.
 */
class Main {
    ArrayList<Point> points = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    public Scanner fileReader;
    private File objectsFilePath = new File("C:\\Users\\Justus\\Vector berechnungen\\Objects.txt");
    private File autoSaveFilePath = new File("C:\\Users\\Justus\\Vector berechnungen\\Autosave.txt");
    private Data dataHandler;
    private Calculator calcHandler;
    public Formatter file;

    public Main() {
        dataHandler = new Data(this);
        calcHandler = new Calculator(this);
        dataHandler.readDataFromFile(autoSaveFilePath, false);
        start();
    }

    private void start() {
        while (true) {
            printMenu();

        }
    }

    private void deleteAPoint() {
        System.out.println("Which Point would you like to delete?");
        listPoints(true);
        points.remove(sc.nextInt());
        System.out.println();
    }
    private void deleteAllPoints() {
        points.clear();
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
    private void deleteMenu() {
        System.out.println("\n[1] Delete one point.");
        System.out.println("\n[2] Delete all points.");
        switch (sc.nextInt()){
            case 1:
                deleteAPoint();
                break;
            case 2:
                deleteAllPoints();
                break;
        }

    }
    public ArrayList<Point> getPoints() {
        return points;
    }

    private void printMenu() {
        System.out.println("[1] Data Something");
        System.out.println("[2] List everything");
        System.out.println("[3] Delete");
        System.out.println("[4] Calculations");
        System.out.println("[5] Load Objects");
        System.out.println("[6] Save Objects");
        System.out.println("[7] Exit");

        switch (sc.nextInt()) {
            case 1:
                dataHandler.inputData();
                break;
            case 2:
                listPoints(false);
                break;

            case 3:
                deleteMenu();
                break;
            case 4:
                calcHandler.calcMenu();
                break;
            case 5:
                dataHandler.readDataFromFile(objectsFilePath, true);
                break;
            case 6:
                dataHandler.writeDataIntoFile(objectsFilePath);
                break;
            case 7:
                dataHandler.writeDataIntoFile(autoSaveFilePath);
                System.exit(0);
                break;


        }
    }


}
