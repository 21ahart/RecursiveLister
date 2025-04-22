import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecursiveListerGUI extends JFrame {
    private JTextArea textArea;

    public RecursiveListerGUI() {
        setTitle("Recursive File Lister");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        JLabel dirLabel = new JLabel("Files and Directories:");

        
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        

        JButton selectDirButton = new JButton("Select Directory");
        selectDirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

                int result = fileChooser.showOpenDialog(RecursiveListerGUI.this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    String selectedPath = fileChooser.getSelectedFile().getAbsolutePath();
                    RecursiveLister lister = new RecursiveLister(selectedPath);
                    lister.listFiles();
                    textArea.setText(lister.listFilesRecursively(selectedPath));
                }
            }
        });
        setLayout(new BorderLayout());
        add(selectDirButton, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }
}