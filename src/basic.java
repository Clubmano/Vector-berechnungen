import java.io.File;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

/**
 * Created by Justus on 01.03.2017.
 */
class basic {
    ArrayList<Point> points = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    public Scanner fileReader;
    private File objectsFilePath = new File("C:\\Users\\Justus\\Vector berechnungen\\Object Files\\Objects.txt");
    private File autoSaveFilePath = new File("C:\\Users\\Justus\\Vector berechnungen\\Object Files\\Autosave.txt");
    private Data dataHandler;
    private Calculator calcHandler;
    public Formatter file;

    public basic() {
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

    private void deletePoints() {
        System.out.println("Which points would you like to delete?");
        listPoints(true);
        while(sc.hasNextInt()) {
            System.out.println(sc.nextInt());
        }
        /*while (sc.hasNext()) {
            points.remove(sc.nextInt());
        }
        System.out.println("Points have been deleted.\n");*/
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
                deletePoints();
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
        System.out.println("[3] Delete Object");
        System.out.println("[4] Calculations");
        System.out.println("[5] Load or Save object file");
        System.out.println("[6] Exit");

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
                dataHandler.dataMenu();
                break;
            case 6:
                dataHandler.writeDataIntoFile(autoSaveFilePath);
                System.exit(0);
                break;


        }
    }


}
