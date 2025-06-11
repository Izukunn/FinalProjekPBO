package gui;

import benda_geometri.*;
import benda_geometri.InvalidInputException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class BangunDatarPanel extends JPanel {

    private JComboBox<String> bangunComboBox;
    private JPanel inputPanel;
    private JButton hitungButton;
    private JTextArea hasilArea;

    public BangunDatarPanel() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String[] bangunDatar = {
            "Pilih Bangun", "Segitiga", "Persegi", "Persegi Panjang", "Jajaran Genjang",
            "Trapesium", "Belah Ketupat", "Layang-Layang", "Lingkaran",
            "Tembereng Lingkaran", "Juring Lingkaran"
        };
        bangunComboBox = new JComboBox<>(bangunDatar);

        inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());
        inputPanel.setBorder(BorderFactory.createTitledBorder("Input Parameter"));

        hasilArea = new JTextArea(15, 25);
        hasilArea.setEditable(false);
        hasilArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));

        hitungButton = new JButton("Hitung");
        hitungButton.setEnabled(false);

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.add(new JLabel("Pilih Bangun Datar:"));
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

        hitungButton.addActionListener(e -> hitungBangunDatar());
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
            case "Segitiga":
                addInputField(gbc, row++, "Alas:");
                addInputField(gbc, row++, "Tinggi:");
                hitungButton.setEnabled(true);
                break;
            case "Persegi":
                addInputField(gbc, row++, "Sisi:");
                hitungButton.setEnabled(true);
                break;
            case "Persegi Panjang":
                addInputField(gbc, row++, "Panjang:");
                addInputField(gbc, row++, "Lebar:");
                hitungButton.setEnabled(true);
                break;
            case "Jajaran Genjang":
                addInputField(gbc, row++, "Alas:");
                addInputField(gbc, row++, "Tinggi:");
                addInputField(gbc, row++, "Sisi Miring:");
                hitungButton.setEnabled(true);
                break;
            case "Trapesium":
                addInputField(gbc, row++, "Sisi Atas:");
                addInputField(gbc, row++, "Sisi Bawah:");
                addInputField(gbc, row++, "Tinggi:");
                addInputField(gbc, row++, "Sisi Miring Kiri:");
                addInputField(gbc, row++, "Sisi Miring Kanan:");
                hitungButton.setEnabled(true);
                break;
            case "Belah Ketupat":
                addInputField(gbc, row++, "Diagonal 1:");
                addInputField(gbc, row++, "Diagonal 2:");
                addInputField(gbc, row++, "Sisi:");
                hitungButton.setEnabled(true);
                break;
            case "Layang-Layang":
                addInputField(gbc, row++, "Diagonal 1:");
                addInputField(gbc, row++, "Diagonal 2:");
                addInputField(gbc, row++, "Sisi Pendek:");
                addInputField(gbc, row++, "Sisi Panjang:");
                hitungButton.setEnabled(true);
                break;
            case "Lingkaran":
                addInputField(gbc, row++, "Radius:");
                addInputField(gbc, row++, "Custom Pi (opsional):");
                hitungButton.setEnabled(true);
                break;
            case "Tembereng Lingkaran":
            case "Juring Lingkaran":
                addInputField(gbc, row++, "Radius:");
                addInputField(gbc, row++, "Sudut:");
                addInputField(gbc, row++, "Custom Pi (opsional):");
                hitungButton.setEnabled(true);
                break;
        }

        inputPanel.revalidate();
        inputPanel.repaint();
    }

    private void hitungBangunDatar() {
        String selected = (String) bangunComboBox.getSelectedItem();
        StringBuilder result = new StringBuilder();
        Component[] components = inputPanel.getComponents();

        try {
            switch (selected) {
                case "Segitiga":
                    double alas = Double.parseDouble(((JTextField) components[1]).getText());
                    double tinggi = Double.parseDouble(((JTextField) components[3]).getText());
                    result.append("Luas = ").append(0.5 * alas * tinggi);
                    break;
                case "Persegi":
                    double sisi = Double.parseDouble(((JTextField) components[1]).getText());
                    result.append("Luas = ").append(sisi * sisi);
                    break;
                case "Persegi Panjang":
                    double panjang = Double.parseDouble(((JTextField) components[1]).getText());
                    double lebar = Double.parseDouble(((JTextField) components[3]).getText());
                    result.append("Luas = ").append(panjang * lebar);
                    break;
                case "Jajaran Genjang":
                    double alasJG = Double.parseDouble(((JTextField) components[1]).getText());
                    double tinggiJG = Double.parseDouble(((JTextField) components[3]).getText());
                    result.append("Luas = ").append(alasJG * tinggiJG);
                    break;
                case "Trapesium":
                    double atas = Double.parseDouble(((JTextField) components[1]).getText());
                    double bawah = Double.parseDouble(((JTextField) components[3]).getText());
                    double tinggiTrap = Double.parseDouble(((JTextField) components[5]).getText());
                    result.append("Luas = ").append(0.5 * (atas + bawah) * tinggiTrap);
                    break;
                case "Belah Ketupat":
                    double d1 = Double.parseDouble(((JTextField) components[1]).getText());
                    double d2 = Double.parseDouble(((JTextField) components[3]).getText());
                    result.append("Luas = ").append(0.5 * d1 * d2);
                    break;
                case "Layang-Layang":
                    double d1LK = Double.parseDouble(((JTextField) components[1]).getText());
                    double d2LK = Double.parseDouble(((JTextField) components[3]).getText());
                    result.append("Luas = ").append(0.5 * d1LK * d2LK);
                    break;
                // Tambahkan Lingkaran, Tembereng, Juring sesuai instance class-nya bila sudah ada
            }

            hasilArea.setText(result.toString());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Input harus angka!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
