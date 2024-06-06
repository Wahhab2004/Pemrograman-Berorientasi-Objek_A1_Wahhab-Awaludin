import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;


public class HRISGUI extends JFrame {
    private JFrame frame;
    private JComboBox<String> departementComboBox;
    private JTextField nameField, tglField, posisiField;
    private JButton addEmployeeButton;
    private JTextArea displayArea;
    private JTextField findIdField;
    private JButton addButton;
    private JButton showAllButton;
    private ArrayList<Employee> employees;

    public HRISGUI() {
        employees = new ArrayList<>();
        frame = new JFrame("HRIS");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        showMainPanel();
        frame.add(showMainPanel(), BorderLayout.CENTER);
        frame.pack();
        frame.setSize(600, 400);
        frame.setVisible(true);
    }

    private JPanel showMainPanel() {
        addButton = new JButton("Add Data");
        showAllButton = new JButton("Show Data");

        JPanel buttonPanel = new JPanel(new GridLayout(2, 1));
        buttonPanel.add(addButton);
        buttonPanel.add(showAllButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaintPanel(showInputPanel());
            }
        });

        showAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaintPanel(showAllDataPanel());
            }
        });

        return buttonPanel;
    }

    private JPanel showAllDataPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel topPanel = new JPanel(new GridLayout(1, 1));

        findIdField = new JTextField(15);
        topPanel.add(findIdField);

        JButton cancelButton = new JButton("Cancel");
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(cancelButton);

        displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        StringBuilder strBuilder = new StringBuilder();
        for (Employee emp : employees) {
            strBuilder.append(emp.getDetails()).append("\n");
        }
        displayArea.setText(strBuilder.toString());

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaintPanel(showMainPanel());
            }
        });

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.CENTER);
        panel.add(scrollPane, BorderLayout.SOUTH);
        return panel;
    }

    private void repaintPanel(JPanel newPanel) {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(newPanel);
        frame.revalidate();
        frame.repaint();
    }

    private JPanel showInputPanel() {
        JPanel inputPanel = new JPanel(new GridLayout(5, 2));

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(15);

        JLabel tglLahir = new JLabel("Tanggal lahir (DDMMYYYY):");
        tglField = new JTextField(15);

        JLabel posisi = new JLabel("Posisi:");
        posisiField = new JTextField(15);

        JLabel departementLabel = new JLabel("Departement:");
        String[] departments = Employee.getDepartments();
        departementComboBox = new JComboBox<>(departments);

        addEmployeeButton = new JButton("Add Data");

        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(tglLahir);
        inputPanel.add(tglField);
        inputPanel.add(posisi);
        inputPanel.add(posisiField);
        inputPanel.add(departementLabel);
        inputPanel.add(departementComboBox);
        inputPanel.add(addEmployeeButton);

        addEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String tgllahir = tglField.getText();
                String posisi = posisiField.getText();
                String department = departementComboBox.getSelectedItem().toString();

                Employee newEmployee;
                switch (posisi.toLowerCase()) {
                    case "manager":
                        newEmployee = new Manager(name, tgllahir, posisi, department);
                        break;
                    case "developer":
                        newEmployee = new Developer(name, tgllahir, posisi, department);
                        break;
                    case "hr staff":
                        newEmployee = new HRStaff(name, tgllahir, posisi, department);
                        break;
                    default:
                        JOptionPane.showMessageDialog(HRISGUI.this, "Invalid position!");
                        return;
                }

                employees.add(newEmployee);
                JOptionPane.showMessageDialog(HRISGUI.this, "Employee added: " + newEmployee.getDetails());
                repaintPanel(showMainPanel());
            }
        });

        return inputPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HRISGUI();
            }
        });
    }
}
