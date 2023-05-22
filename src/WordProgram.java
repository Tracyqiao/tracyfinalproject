import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class WordProgram implements ActionListener {
    JFrame frame;

    JTextArea textArea = new JTextArea(1000,900);
    private int width = 1280, height = 980;
    private JScrollPane scrollbar = new JScrollPane(textArea);
    private int textHeight = 12;
    private Font currentFont = new Font(Font.SANS_SERIF, 2, textHeight);

    JPanel buttonPanel;

    JPanel buttonPanel2;


    JComboBox dropBox1,dropBox2,dropBox3,dropBox4,dropBox5;

    JButton addBulletButton, removeBulletButton,boldButton, italicizeButton,underlineButton;

    private JLabel label;

    public WordProgram(){
        frame = new JFrame("Word Document Program");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        buttonPanel = new JPanel();
        frame.add(buttonPanel, BorderLayout.NORTH);


        String l1[]={"10","12","18"};
        label = new JLabel("Text Size");
        buttonPanel.add(label);

        dropBox1 = new JComboBox(l1);
        buttonPanel.add(dropBox1);

        String l2[]={"Arial","Century Gothic","AmerType","Times New Roman"};
        label = new JLabel("Text Font");
        buttonPanel.add(label);

        dropBox2 = new JComboBox(l2);
        buttonPanel.add(dropBox2);

        String l3[]={"Right","middle","left"};
        label = new JLabel("Alignment");
        buttonPanel.add(label);

        dropBox3 = new JComboBox(l3);
        buttonPanel.add(dropBox3);


        String l4[]={"Black","Red","Yellow","Blue","Green","Orange","Pink","Purple"};
        label = new JLabel("Color");
        buttonPanel.add(label);

        dropBox4 = new JComboBox(l4);
        buttonPanel.add(dropBox4);

        String l5[]={"Black","Red","Yellow","Blue","Green","Orange","Pink","Purple"};
        label = new JLabel("Highlighter");
        buttonPanel.add(label);

        dropBox5 = new JComboBox(l5);
        buttonPanel.add(dropBox5);

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
    class textArea extends JPanel{

        private String mode;

        public textArea(){
            setBackground(Color.WHITE);

    }
        public void setMode(String mode) {
            this.mode = mode;
        }
        public void mousePressed(MouseEvent e){
            if(mode.equals("Add Bullets")){

            }
            if(mode.equals("Remove Bullets")){

            }
            if(mode.equals("Bold")){

            }
            if(mode.equals("Italicize")){

            }
            if(mode.equals("Underline")){

            }
        }


    }

}

