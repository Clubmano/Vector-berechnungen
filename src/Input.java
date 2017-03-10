import java.util.Scanner;

/**
 * Created by Justus on 01.03.2017.
 */
class Input {

    private Scanner sc = new Scanner(System.in);
    boolean inputFinished = false;
    private Main main;

    public Input(Main main) {
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

}
