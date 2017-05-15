import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Justus on 11.05.2017.
 */
public class Frame extends JFrame implements ActionListener {
    private final GridBagConstraints c;
    public JButton objects, calculations, saveOrLoad, exit, addObjects, delObjects, back;
    public JPanel menuPanel, standardMenuPanel, objectMenuPanel;

    public Frame(basic basic) {
        this.setTitle("Vector berechnungen");
        this.setSize(400, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menuPanel = new JPanel(new GridBagLayout());

        c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.ipadx = WIDTH / 16;
        c.ipady = HEIGHT / 20;

        this.add(menuPanel);
        menuPanel.setBounds(0, 100, WIDTH, 100);
        menuInitialising();


    }

    public void menuInitialising() {
        standardMenu();
        objectMenu();
        menuPanel.add(standardMenuPanel);

    }

    public void standardMenu() {
        standardMenuPanel = new JPanel();

        objects = new JButton("Objects");
        objects.addActionListener(this);

        calculations = new JButton("Calculations");
        calculations.addActionListener(this);

        saveOrLoad = new JButton("Save & Load");
        saveOrLoad.addActionListener(this);

        exit = new JButton("Exit");
        exit.addActionListener(this);

        standardMenuPanel.add(objects);
        standardMenuPanel.add(calculations);
        standardMenuPanel.add(saveOrLoad);
        standardMenuPanel.add(exit);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.objects) {
            menuPanel.remove(standardMenuPanel);
            this.repaint();
            menuPanel.add(objectMenuPanel);

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
            menuPanel.add(standardMenuPanel);
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

    }
}
