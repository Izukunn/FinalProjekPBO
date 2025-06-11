package gui;

import benda_geometri.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;

public class BangunRuangPanel extends JPanel {

    private JComboBox<String> bangunComboBox;
    private JPanel inputPanel;
    private JButton hitungButton;
    private JTextArea hasilArea;

    public BangunRuangPanel() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String[] bangunRuang = {
            "Pilih Bangun", "Kubus", "Balok", "Tabung", "Bola", "Kerucut",
            "Limas Segitiga", "Limas Segiempat", "Prisma Segitiga"
        };
        bangunComboBox = new JComboBox<>(bangunRuang);

        inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());
        inputPanel.setBorder(BorderFactory.createTitledBorder("Input Parameter"));

        hasilArea = new JTextArea(15, 25);
        hasilArea.setEditable(false);
        hasilArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));

        hitungButton = new JButton("Hitung");
        hitungButton.setEnabled(false);

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.add(new JLabel("Pilih Bangun Ruang:"));
        topPanel.add(bangunComboBox);

        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.add(topPanel, BorderLayout.NORTH);
        leftPanel.add(inputPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.add(hitungButton);
        leftPanel.add(buttonPanel, BorderLayout.SOUTH);

        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBorder(BorderFactory.createTitledBorder("Hasil Perhitungan"));
        JScrollPane scrollPane = new JScrollPane(hasilArea);
        rightPanel.add(scrollPane, BorderLayout.CENTER);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
        splitPane.setResizeWeight(0.4);
        splitPane.setDividerLocation(350);
        splitPane.setDividerSize(5);

        add(splitPane, BorderLayout.CENTER);

        // Event
        bangunComboBox.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                updateInputFields();
            }
        });

        hitungButton.addActionListener(e -> hitungBangunRuang());
    }

    private void addInputField(GridBagConstraints gbc, int row, String label) {
        gbc.gridx = 0;
        gbc.gridy = row;
        inputPanel.add(new JLabel(label), gbc);

        gbc.gridx = 1;
        inputPanel.add(new JTextField(10), gbc);
    }

    private void updateInputFields() {
        inputPanel.removeAll();
        hitungButton.setEnabled(false);
        String selected = (String) bangunComboBox.getSelectedItem();

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        int row = 0;

        switch (selected) {
            case "Kubus":
                addInputField(gbc, row++, "Sisi:");
                hitungButton.setEnabled(true);
                break;
            case "Balok":
                addInputField(gbc, row++, "Panjang:");
                addInputField(gbc, row++, "Lebar:");
                addInputField(gbc, row++, "Tinggi:");
                hitungButton.setEnabled(true);
                break;
            case "Tabung":
                addInputField(gbc, row++, "Jari-jari:");
                addInputField(gbc, row++, "Tinggi:");
                hitungButton.setEnabled(true);
                break;
            case "Bola":
                addInputField(gbc, row++, "Jari-jari:");
                hitungButton.setEnabled(true);
                break;
            case "Kerucut":
                addInputField(gbc, row++, "Jari-jari:");
                addInputField(gbc, row++, "Tinggi:");
                hitungButton.setEnabled(true);
                break;
            case "Limas Segitiga":
                addInputField(gbc, row++, "Alas Segitiga:");
                addInputField(gbc, row++, "Tinggi Segitiga:");
                addInputField(gbc, row++, "Tinggi Limas:");
                hitungButton.setEnabled(true);
                break;
            case "Limas Segiempat":
                addInputField(gbc, row++, "Sisi Alas:");
                addInputField(gbc, row++, "Tinggi Limas:");
                hitungButton.setEnabled(true);
                break;
            case "Prisma Segitiga":
                addInputField(gbc, row++, "Alas Segitiga:");
                addInputField(gbc, row++, "Tinggi Segitiga:");
                addInputField(gbc, row++, "Tinggi Prisma:");
                hitungButton.setEnabled(true);
                break;
        }

        inputPanel.revalidate();
        inputPanel.repaint();
    }

    private void hitungBangunRuang() {
        String selected = (String) bangunComboBox.getSelectedItem();
        StringBuilder result = new StringBuilder();
        Component[] components = inputPanel.getComponents();

        try {
            switch (selected) {
                case "Kubus":
                    double sisi = Double.parseDouble(((JTextField) components[1]).getText());
                    result.append("Volume = ").append(Math.pow(sisi, 3));
                    break;
                case "Balok":
                    double panjang = Double.parseDouble(((JTextField) components[1]).getText());
                    double lebar = Double.parseDouble(((JTextField) components[3]).getText());
                    double tinggi = Double.parseDouble(((JTextField) components[5]).getText());
                    result.append("Volume = ").append(panjang * lebar * tinggi);
                    break;
                case "Tabung":
                    double rTab = Double.parseDouble(((JTextField) components[1]).getText());
                    double tTab = Double.parseDouble(((JTextField) components[3]).getText());
                    result.append("Volume = ").append(Math.PI * rTab * rTab * tTab);
                    break;
                case "Bola":
                    double rBola = Double.parseDouble(((JTextField) components[1]).getText());
                    result.append("Volume = ").append((4.0/3.0) * Math.PI * Math.pow(rBola, 3));
                    break;
                case "Kerucut":
                    double rKer = Double.parseDouble(((JTextField) components[1]).getText());
                    double tKer = Double.parseDouble(((JTextField) components[3]).getText());
                    result.append("Volume = ").append((1.0/3.0) * Math.PI * rKer * rKer * tKer);
                    break;
                case "Limas Segitiga":
                    double alas = Double.parseDouble(((JTextField) components[1]).getText());
                    double tinggiSegi = Double.parseDouble(((JTextField) components[3]).getText());
                    double tinggiLimas = Double.parseDouble(((JTextField) components[5]).getText());
                    double luasAlas = 0.5 * alas * tinggiSegi;
                    result.append("Volume = ").append((1.0/3.0) * luasAlas * tinggiLimas);
                    break;
                case "Limas Segiempat":
                    double sisiAlas = Double.parseDouble(((JTextField) components[1]).getText());
                    double tinggiLS = Double.parseDouble(((JTextField) components[3]).getText());
                    result.append("Volume = ").append((1.0/3.0) * sisiAlas * sisiAlas * tinggiLS);
                    break;
                case "Prisma Segitiga":
                    double alasP = Double.parseDouble(((JTextField) components[1]).getText());
                    double tinggiSegitiga = Double.parseDouble(((JTextField) components[3]).getText());
                    double tinggiPrisma = Double.parseDouble(((JTextField) components[5]).getText());
                    double luasAlasPrisma = 0.5 * alasP * tinggiSegitiga;
                    result.append("Volume = ").append(luasAlasPrisma * tinggiPrisma);
                    break;
            }

            hasilArea.setText(result.toString());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Input harus angka!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
