package my.note;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class NoteTakingApp extends JFrame {
    JTextArea textArea;
    private JButton saveButton;
    private JButton loadButton;

    public NoteTakingApp() {
        setTitle("Note Taking App");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);

        saveButton = new JButton("Save Note");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filePath = new String();
                saveNote();
            }
        });

        loadButton = new JButton("Load Note");
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filePath = new String();
                loadNote();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(saveButton);
        buttonPanel.add(loadButton);

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    void saveNote() {
        String note = textArea.getText();
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            try {

                String filePath = fileChooser.getSelectedFile().getAbsolutePath();
                BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));


                writer.write(note);


                writer.close();

                JOptionPane.showMessageDialog(this, "Note saved successfully!", "Save Note", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error saving note: " + ex.getMessage(), "Save Note Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    void loadNote() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            try {
                String filePath = fileChooser.getSelectedFile().getAbsolutePath();
                BufferedReader reader = new BufferedReader(new FileReader(filePath));
                StringBuilder noteContent = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    noteContent.append(line).append("\n");
                }
                reader.close();

                textArea.setText(noteContent.toString());

            } catch (FileNotFoundException e) {
                throw new RuntimeException("File not found: " + e.getMessage());
            } catch (IOException e) {
                throw new RuntimeException("Error reading the file: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new NoteTakingApp().setVisible(true);
            }
        });
    }
}