import javax.swing.*;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;

import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;

public class WordProgram extends JFrame {
    private JTextPane textPane;
    private JComboBox<String> fontComboBox;
    private JComboBox<Integer> sizeComboBox;
    private JComboBox<String> colorBox;
    private JButton boldButton;
    private JButton italicButton;
    private JButton underlineButton;
    private JButton leftAlignButton;
    private JButton rightAlignButton;
    private JButton centerAlignButton;
    private JLabel wordCountLabel;

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

        // Word count label
        wordCountLabel = new JLabel("Word count: 0");
        buttons1.add(wordCountLabel);

        // Text pane
        textPane = new JTextPane();
        textPane.getDocument().addDocumentListener(new WordCountDocumentListener());
        JScrollPane scrollPane = new JScrollPane(textPane);
        add(scrollPane, BorderLayout.CENTER);

        JToolBar buttons2 = new JToolBar();
        add(buttons2, BorderLayout.WEST);

        buttons2.setLayout(new GridLayout(20, 1));

        leftAlignButton = new JButton(new StyledEditorKit.AlignmentAction("Left Align", StyleConstants.ALIGN_LEFT));
        leftAlignButton.setText("Left");
        buttons2.add(leftAlignButton);

        rightAlignButton = new JButton(new StyledEditorKit.AlignmentAction("Right Align", StyleConstants.ALIGN_RIGHT));
        rightAlignButton.setText("Right");
        buttons2.add(rightAlignButton);

        centerAlignButton = new JButton(new StyledEditorKit.AlignmentAction("Center Align", StyleConstants.ALIGN_CENTER));
        centerAlignButton.setText("Center");
        buttons2.add(centerAlignButton);

        String[] colors = {"black", "green","blue", "yellow","pink","red"};
        colorBox = new JComboBox<>(colors);
        colorBox.addActionListener(new ColorBoxListener());
        buttons2.add(colorBox);
    }

    private class FontComboBoxListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String selectedFont = (String) fontComboBox.getSelectedItem();
            MutableAttributeSet attr = new SimpleAttributeSet();
            StyleConstants.setFontFamily(attr, selectedFont);
            textPane.setCharacterAttributes(attr, false);
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

    private class ColorBoxListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String selectedColor = (String) colorBox.getSelectedItem();
            MutableAttributeSet colors = new SimpleAttributeSet();
            if (selectedColor.equals("black")) {
                StyleConstants.setForeground(colors, Color.black);
            } else if (selectedColor.equals("green")) {
                StyleConstants.setForeground(colors, Color.green);
            } else if (selectedColor.equals("red")) {
                StyleConstants.setForeground(colors, Color.red);
            } else if (selectedColor.equals("blue")) {
                StyleConstants.setForeground(colors, Color.blue);
            } else if (selectedColor.equals("yellow")) {
                StyleConstants.setForeground(colors, Color.yellow);
            } else if (selectedColor.equals("pink")) {
                StyleConstants.setForeground(colors, Color.pink);
            }
            textPane.setCharacterAttributes(colors, false);
        }
    }

    private class WordCountDocumentListener implements DocumentListener {
        @Override
        public void insertUpdate(DocumentEvent e) {
            updateWordCount();
        }

        @Override
        public void removeUpdate(DocumentEvent e) {
            updateWordCount();
        }

        @Override
        public void changedUpdate(DocumentEvent e) {
            updateWordCount();
        }

        private void updateWordCount() {
            String text = textPane.getText();
            String[] words = text.split("\\s+");

            int count = 0;
            for (String word : words) {
                if (!word.isEmpty()) {
                    count++;
                }
            }
            wordCountLabel.setText("Word count: " + count);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            WordProgram wordProgram = new WordProgram();
            wordProgram.setVisible(true);
        });
    }
}
