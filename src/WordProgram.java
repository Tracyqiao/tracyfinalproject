import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;

public class WordProgram extends JFrame {
    private JTextPane textPane;
    private JComboBox<String> fontComboBox;
    private JComboBox<Integer> sizeComboBox;

    private JComboBox<String> ColorBox;
    private JButton boldButton;
    private JButton italicButton;
    private JButton underlineButton;
    private JButton bulletButton;

    private JButton LeftAlign;

    private JButton RightAlign;

    private JButton MidAlign;

    public WordProgram() {
        setTitle("Word Processor");
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JToolBar buttons1 = new JToolBar();
        add(buttons1, BorderLayout.NORTH);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fonts = ge.getAvailableFontFamilyNames();
        fontComboBox = new JComboBox<>(fonts);
        fontComboBox.addActionListener(new FontComboBoxListener());
        buttons1.add(fontComboBox);

        Integer[] sizes = {8, 10, 12, 14, 16, 18, 20, 24, 28, 32, 36, 40, 48, 56, 64, 72};
        sizeComboBox = new JComboBox<>(sizes);
        sizeComboBox.addActionListener(new SizeComboBoxListener());
        buttons1.add(sizeComboBox);

        // Bold button
        boldButton = new JButton(new StyledEditorKit.BoldAction());
        boldButton.setText("Bold");
        buttons1.add(boldButton);

        // Italic button
        italicButton = new JButton(new StyledEditorKit.ItalicAction());
        italicButton.setText("Italicize");
        buttons1.add(italicButton);

        // Underline button
        underlineButton = new JButton(new StyledEditorKit.UnderlineAction());
        underlineButton.setText("Underline");
        buttons1.add(underlineButton);

        // Bullet button
        bulletButton = new JButton(new BulletAction());
        bulletButton.setText("AddBullets");
        buttons1.add(bulletButton);

        // Text pane
        textPane = new JTextPane();
        JScrollPane scrollPane = new JScrollPane(textPane);
        add(scrollPane, BorderLayout.CENTER);

        JToolBar buttons2 = new JToolBar();
        add(buttons2, BorderLayout.WEST);

        buttons2.setLayout(new GridLayout(20,3));

        LeftAlign = new JButton(new StyledEditorKit.AlignmentAction("Left Align", StyleConstants.ALIGN_LEFT));
        LeftAlign.setText("Left");
        buttons2.add(LeftAlign);

        RightAlign = new JButton(new StyledEditorKit.AlignmentAction("Right Align", StyleConstants.ALIGN_RIGHT));
        RightAlign.setText("Right");
        buttons2.add(RightAlign);

        MidAlign = new JButton(new StyledEditorKit.AlignmentAction("Right Align", StyleConstants.ALIGN_CENTER));
        MidAlign.setText("Center");
        buttons2.add(MidAlign);

        String[] colors = {"black","green","blue","yellow","pink","red"};
        ColorBox = new JComboBox<>(colors);
        ColorBox.addActionListener(new ColorBoxListener());
        buttons2.add(ColorBox);


    }
    private class BulletAction extends StyledEditorKit.StyledTextAction {

        public BulletAction() {
            super("bullet");
        }

        public void actionPerformed(ActionEvent e) {
            JEditorPane editor = (JEditorPane) e.getSource();
            StyledDocument doc = getStyledDocument(editor);

            int start = editor.getSelectionStart();
            int end = editor.getSelectionEnd();

            try {
                doc.insertString(start, "\u2022 ", doc.getStyle(StyleContext.DEFAULT_STYLE));
            } catch (BadLocationException ex) {
                ex.printStackTrace();
            }
        }
    }

    private class FontComboBoxListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String selectedFont = (String) fontComboBox.getSelectedItem();
            MutableAttributeSet attr = new SimpleAttributeSet();
            StyleConstants.setFontFamily(attr, selectedFont);
            textPane.setCharacterAttributes(attr, false);
        }
    }

    private class ColorBoxListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String selectedColor = (String) ColorBox.getSelectedItem();
            MutableAttributeSet colors = new SimpleAttributeSet();
            if(selectedColor.equals("black")){
                StyleConstants.setForeground(colors, Color.black);
            }
            else if (selectedColor.equals("green")){
                StyleConstants.setForeground(colors, Color.green);
            }
            else if (selectedColor.equals("red")){
                StyleConstants.setForeground(colors, Color.red);
            }
            else if (selectedColor.equals("blue")){
                StyleConstants.setForeground(colors, Color.blue);
            }
            else if (selectedColor.equals("yellow")){
                StyleConstants.setForeground(colors, Color.yellow);
            }
            else if (selectedColor.equals("pink")){
                StyleConstants.setForeground(colors, Color.pink);
            }


            textPane.setCharacterAttributes(colors, false);
        }
    }

    private class SizeComboBoxListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            int selectedSize = (int) sizeComboBox.getSelectedItem();
            MutableAttributeSet attr = new SimpleAttributeSet();
            StyleConstants.setFontSize(attr, selectedSize);
            textPane.setCharacterAttributes(attr, false);
        }
    }

    public static void main(String[] args) {
        WordProgram wordProcessor = new WordProgram();
        wordProcessor.setVisible(true);
    }
}