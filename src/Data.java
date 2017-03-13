import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

/**
 * Created by Justus on 01.03.2017.
 */
class Data {

    private Scanner sc = new Scanner(System.in);
    boolean inputFinished = false;
    private Main main;

    public Data(Main main) {
        this.main = main;
    }

    public void inputData() {
        System.out.println("Please choose what you'd like to add.\n");
        System.out.println("[1] Point");
        System.out.println("[2] Line");
        System.out.println("[3] Plane");
        switch (sc.nextInt()) {
            case 1:
                main.getPoints().add(new Point());
                break;
            case 2:

                break;
            case 3:

                break;
        }

    }
    public void readDataFromFile(File mfile, boolean showText) {
        main.points.clear();
        try {
            main.fileReader = new Scanner(mfile);
        } catch (Exception e) {
            System.out.println("File does not exist.");
        }
        int i = 0;
        while (main.fileReader.hasNext()) {
            main.points.add(i, new Point(Double.parseDouble(main.fileReader.next()),
                    Double.parseDouble(main.fileReader.next()),Double.parseDouble(main.fileReader.next()),main.fileReader.next()));
            i++;
        }
        if (showText) {
            System.out.println("\nThese objects have been loaded.");
            main.listPoints(false);
        }
    }
    public void writeDataIntoFile(File mfile) {
        try {
            main.file = new Formatter(mfile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < main.points.size(); i++) {
            String pX = Double.toString(main.points.get(i).getpX());
            String pY = Double.toString(main.points.get(i).getpY());
            String pZ = Double.toString(main.points.get(i).getpZ());
            main.file.format("%s%s%s%s%s%s%s%s", pX, " ", pY, " ", pZ, " ", main.points.get(i).getName(), "\n");
        }
        main.file.close();
        System.out.println("Objects have been saved.");

    }

}
