import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class WordProgram implements ActionListener {
    JFrame frame;

    TextPanel dPanel;

    JPanel buttonPanel;

    JPanel buttonPanel2;

    JButton addBulletButton, removeBulletButton,boldButton, italicizeButton,underlineButton;

    private JLabel label;
    private JTextField textField1, textField2,textField3,textField4,textField5;

    public WordProgram(){
        frame = new JFrame("Word Document Program");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        dPanel = new TextPanel();
        frame.add(dPanel);


        buttonPanel = new JPanel();
        frame.add(buttonPanel, BorderLayout.NORTH);

        label = new JLabel("Text Size");
        buttonPanel.add(label);

        textField1 = new JTextField(5);
        buttonPanel.add(textField1);

        label = new JLabel("Text Font");
        buttonPanel.add(label);

        textField2 = new JTextField(5);
        buttonPanel.add(textField2);

        label = new JLabel("Alignment");
        buttonPanel.add(label);

        textField3 = new JTextField(5);
        buttonPanel.add(textField3);

        label = new JLabel("Color");
        buttonPanel.add(label);

        textField4 = new JTextField(5);
        buttonPanel.add(textField4);

        label = new JLabel("Highlighter");
        buttonPanel.add(label);

        textField5 = new JTextField(5);
        buttonPanel.add(textField5);

        //Buttons:
        buttonPanel2 = new JPanel();
        frame.add(buttonPanel2, BorderLayout.EAST);

        addBulletButton = new JButton("Add Bullets");
        addBulletButton.addActionListener(this);
        buttonPanel2.add(addBulletButton);

        removeBulletButton = new JButton("Remove Bullets");
        removeBulletButton.addActionListener(this);
        buttonPanel2.add(removeBulletButton);

        boldButton = new JButton("Bold");
        boldButton.addActionListener(this);
        buttonPanel2.add(boldButton);

        italicizeButton = new JButton("Italicize");
        italicizeButton.addActionListener(this);
        buttonPanel2.add(italicizeButton);

        underlineButton = new JButton("Underline");
        underlineButton.addActionListener(this);
        buttonPanel2.add(underlineButton);




    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        WordProgram x = new WordProgram();
    }
    class TextPanel extends JPanel{

        private String mode;
        public TextPanel(){
            setBackground(Color.WHITE);

    }


    }

}

