import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class WordProgram implements ActionListener {
    JFrame frame;
    TextPanel dPanel;

    JPanel buttonPanel;

    private JLabel label;

    public WordProgram(){
        frame = new JFrame("Word Document Program");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        dPanel = new TextPanel();
        frame.add(dPanel);

        buttonPanel = new JPanel();
        frame.add(buttonPanel, BorderLayout.EAST);

        label = new JLabel("Text Size");
        buttonPanel.add(label);

        label = new JLabel("Text Font");
        buttonPanel.add(label);



    }

    }
　
