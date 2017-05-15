import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Justus on 11.05.2017.
 */
public class Frame extends JFrame  implements ActionListener {
    public JButton objects, calculations, saveOrLoad, exit, addObjects, delObjects, back;
    public JPanel menuPanel, standardMenuPanel, objectMenuPanel;

    public Frame(basic basic) {
        this.setTitle("Vector berechnungen");
        this.setSize(400, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuPanel = new JPanel(new GridBagLayout());
        this.add(menuPanel);
        printMenu();


    }
    public void printMenu() {
        standardMenuPanel = new JPanel();

        objects = new JButton("Objects");
        objects.addActionListener(this);
        objects.setBounds(0,-500, 100,100);

        calculations = new JButton("Calculations");
        calculations.addActionListener(this);
        calculations.setBounds(100,-500, 100,100);

        saveOrLoad = new JButton("Save & Load");
        saveOrLoad.addActionListener(this);
        saveOrLoad.setBounds(200,-500, 100,100);

        exit = new JButton("Exit");
        exit.addActionListener(this);
        exit.setBounds(300,-500, 100,100);

        standardMenuPanel.add(objects);
        standardMenuPanel.add(calculations);
        standardMenuPanel.add(saveOrLoad);
        standardMenuPanel.add(exit);

        menuPanel.add(standardMenuPanel);



    }
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == this.objects) {
                menuPanel.remove(standardMenuPanel);
                this.repaint();
                objectMenu();

            } else if (e.getSource() == this.calculations) {

            } else if (e.getSource() == this.saveOrLoad) {

            } else if (e.getSource() == this.exit) {
                System.exit(0);

            }

            if (e.getSource() == this.addObjects) {

            } else if (e.getSource() == this.delObjects) {

            } else if (e.getSource() == this.back) {
                menuPanel.remove(objectMenuPanel);
                this.repaint();
                printMenu();
            }



    }
    public void objectMenu() {
        objectMenuPanel = new JPanel();

        addObjects = new JButton("addObjects");
        addObjects.addActionListener(this);

        delObjects = new JButton("delObjects");
        delObjects.addActionListener(this);

        back = new JButton("back");
        back.addActionListener(this);

        objectMenuPanel.add(addObjects);
        objectMenuPanel.add(delObjects);
        objectMenuPanel.add(back);

        menuPanel.add(objectMenuPanel);


    }
}
