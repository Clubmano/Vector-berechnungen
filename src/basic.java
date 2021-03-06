import java.io.File;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

/**
 * Created by Justus on 01.03.2017.
 */
class basic{
    private final Frame frame;
    public Scanner fileReader;
    public Formatter file;
    ArrayList<Point> points = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private File autoSaveFilePath = new File("C:\\Users\\Justus\\Vector berechnungen\\Object Files\\Autosave.txt");
    private Data dataHandler;
    private Calculator calcHandler;

    public basic() {
        dataHandler = new Data(this);
        calcHandler = new Calculator(this);

        frame = new Frame(this);
        frame.setVisible(true);

        dataHandler.readDataFromFile(autoSaveFilePath, false);
        //start();
    }

    /*private void start() {
        while (true) {
            standardMenu();

        }
    }*/

    private void deletePoints() {
        System.out.println("Which points would you like to delete?");
        listPoints(true);
        while (sc.hasNextInt()) {
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
            if (showIndex) {
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
        switch (sc.nextInt()) {
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

   /* public void standardMenu() {
        *//*System.out.println("[1] Data Something");
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


        }*//*
        objects = new JButton("Objects");
        objects.addActionListener(this);

        calculations = new JButton("Calculations");
        calculations.addActionListener(this);

        saveOrLoad = new JButton("Save & Load");
        saveOrLoad.addActionListener(this);

        exit = new JButton("Exit");
        exit.addActionListener(this);

        frame.add(objects);
        frame.add(calculations);
        frame.add(saveOrLoad);
        frame.add(exit);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.objects) {

        } else if (e.getSource() == this.calculations) {

        } else if (e.getSource() == this.saveOrLoad) {

        } else if (e.getSource() == this.exit) {

        }
    }*/
}
