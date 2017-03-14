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
    private basic basic;

    public Data(basic basic) {
        this.basic = basic;
    }

    public void inputData() {
        System.out.println("Please choose what you'd like to add.\n");
        System.out.println("[1] Point");
        System.out.println("[2] Line");
        System.out.println("[3] Plane");
        switch (sc.nextInt()) {
            case 1:
                basic.getPoints().add(new Point());
                break;
            case 2:

                break;
            case 3:

                break;
        }

    }
    public void readDataFromFile(File mfile, boolean showText) {
        basic.points.clear();
        try {
            basic.fileReader = new Scanner(mfile);
        } catch (Exception e) {
            System.out.println("File does not exist.");
        }
        int i = 0;
        while (basic.fileReader.hasNext()) {
            basic.points.add(i, new Point(Double.parseDouble(basic.fileReader.next()),
                    Double.parseDouble(basic.fileReader.next()),Double.parseDouble(basic.fileReader.next()), basic.fileReader.next()));
            i++;
        }
        if (showText) {
            System.out.println("\nThese objects have been loaded.");
            basic.listPoints(false);
        }
    }
    public void writeDataIntoFile(File mfile) {
        try {
            basic.file = new Formatter(mfile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < basic.points.size(); i++) {
            String pX = Double.toString(basic.points.get(i).getpX());
            String pY = Double.toString(basic.points.get(i).getpY());
            String pZ = Double.toString(basic.points.get(i).getpZ());
            basic.file.format("%s%s%s%s%s%s%s%s", pX, " ", pY, " ", pZ, " ", basic.points.get(i).getName(), "\n");
        }
        basic.file.close();
        System.out.println("Objects have been saved.");

    }

}
