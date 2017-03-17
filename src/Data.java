import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

/**
 * Created by Justus on 01.03.2017.
 */
class Data {

    private Scanner sc = new Scanner(System.in);
    boolean inputFinished = false;
    private basic basic;
    private String directory = "C:\\Users\\Justus\\Vector berechnungen\\Object Files";

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

    public void dataMenu() {
        System.out.println("What would you like to do?\n");
        System.out.println("[1] Save Data");
        System.out.println("[2] Load Data");
        System.out.println("[3] Delete Save file");
        switch (sc.nextInt()) {
            case 1:
                System.out.println("As what would you like to save your file?");
                File saveFile = new File("C:\\Users\\Justus\\Vector berechnungen\\Object Files\\" + sc.next() + ".txt");
                writeDataIntoFile(saveFile);
                break;
            case 2:
                findFiles(directory, ".text");
                System.out.println("What file would you like to load?");
                File loadFile = new File("C:\\Users\\Justus\\Vector berechnungen\\Object Files\\" + sc.next() + ".txt");
                readDataFromFile(loadFile, true);
                break;
            case 3:
                findFiles(directory, ".text");
                System.out.println("What file would you like to delete?");
                File deleteFile = new File("C:\\Users\\Justus\\Vector berechnungen\\Object Files\\" + sc.next() + ".txt");
                if (deleteFile.delete()){
                    System.out.println("The selected file has been deleted.\n");
                }else {
                    System.out.println("The selected file couldn't be deleted.\n");
                }
                break;
        }
    }
    public void findFiles( String dirName, String type){
        File dir = new File(dirName);
        ArrayList<String>fileNames = new ArrayList<>();
        for (File file : dir.listFiles()) {
            if (file.getName().endsWith((".txt"))) {
                fileNames.add(file.getName());
            }
        }
        for (String a : fileNames){
            System.out.println(a);
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
                    Double.parseDouble(basic.fileReader.next()), Double.parseDouble(basic.fileReader.next()), basic.fileReader.next()));
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
