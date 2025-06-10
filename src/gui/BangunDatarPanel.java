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

        // ComboBox untuk memilih bangun datar
        String[] bangunDatar = {"Pilih Bangun", "Segitiga", "Persegi", "Persegi Panjang", "Jajaran Genjang", "Trapesium", "Belah Ketupat", "Layang-Layang", "Lingkaran", "Tembereng Lingkaran", "Juring Lingkaran"};
        bangunComboBox = new JComboBox<>(bangunDatar);
        bangunComboBox.setPreferredSize(new Dimension(150, 25));

        // Panel untuk input dinamis
        inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());
        inputPanel.setBorder(BorderFactory.createTitledBorder("Input Parameter"));

        // Panel untuk hasil
        hasilArea = new JTextArea(15, 25);
        hasilArea.setEditable(false);
        hasilArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        hasilArea.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        // Button hitung
        hitungButton = new JButton("Hitung");
        hitungButton.setEnabled(false);
        hitungButton.setPreferredSize(new Dimension(80, 25));

        // Panel atas untuk ComboBox
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.add(new JLabel("Pilih Bangun Datar:"));
        topPanel.add(bangunComboBox);

        // Panel kiri untuk input dan tombol
        JPanel leftPanel = new JPanel(new BorderLayout(5, 10));
        leftPanel.setPreferredSize(new Dimension(300, 0));
        leftPanel.add(topPanel, BorderLayout.NORTH);

        // Wrapper untuk input panel dengan ukuran tetap
        JPanel inputWrapper = new JPanel(new BorderLayout());
        inputWrapper.add(inputPanel, BorderLayout.NORTH);
        leftPanel.add(inputWrapper, BorderLayout.CENTER);

        // Panel untuk tombol di bagian bawah input
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.add(hitungButton);
        leftPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Panel kanan untuk hasil
        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBorder(BorderFactory.createTitledBorder("Hasil Perhitungan"));
        JScrollPane scrollPane = new JScrollPane(hasilArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        rightPanel.add(scrollPane, BorderLayout.CENTER);

        // Panel utama untuk membagi kiri dan kanan
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
        splitPane.setResizeWeight(0.4); // Panel kiri 40%, kanan 60%
        splitPane.setDividerLocation(350);
        splitPane.setDividerSize(5);

        add(splitPane, BorderLayout.CENTER);

        // Event listener
        bangunComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    updateInputFields();
                }
            }
        });

        hitungButton.addActionListener(e -> hitungBangunDatar());
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
                gbc.gridx = 0;
                gbc.gridy = row;
                inputPanel.add(new JLabel("Alas:"), gbc);
                gbc.gridx = 1;
                inputPanel.add(new JTextField(10), gbc);

                row++;
                gbc.gridx = 0;
                gbc.gridy = row;
                inputPanel.add(new JLabel("Tinggi:"), gbc);
                gbc.gridx = 1;
                inputPanel.add(new JTextField(10), gbc);
                hitungButton.setEnabled(true);
                break;

            case "Persegi":
                gbc.gridx = 0;
                gbc.gridy = row;
                inputPanel.add(new JLabel("Sisi:"), gbc);
                gbc.gridx = 1;
                JTextField sisiField = new JTextField(10);
                inputPanel.add(sisiField, gbc);
                hitungButton.setEnabled(true);
                break;

            case "Persegi Panjang":
                gbc.gridx = 0;
                gbc.gridy = row;
                inputPanel.add(new JLabel("Panjang:"), gbc);
                gbc.gridx = 1;
                inputPanel.add(new JTextField(10), gbc);

                row++;
                gbc.gridx = 0;
                gbc.gridy = row;
                inputPanel.add(new JLabel("Lebar:"), gbc);
                gbc.gridx = 1;
                inputPanel.add(new JTextField(10), gbc);
                hitungButton.setEnabled(true);
                break;

            case "Jajaran Genjang":
                gbc.gridx = 0;
                gbc.gridy = row;
                inputPanel.add(new JLabel("Alas:"), gbc);
                gbc.gridx = 1;
                inputPanel.add(new JTextField(10), gbc);

                row++;
                gbc.gridx = 0;
                gbc.gridy = row;
                inputPanel.add(new JLabel("Tinggi:"), gbc);
                gbc.gridx = 1;
                inputPanel.add(new JTextField(10), gbc);

                row++;
                gbc.gridx = 0;
                gbc.gridy = row;
                inputPanel.add(new JLabel("Sisi Miring:"), gbc);
                gbc.gridx = 1;
                inputPanel.add(new JTextField(10), gbc);
                hitungButton.setEnabled(true);
                break;

            case "Trapesium":
                break;

            case "Belah Ketupat":
                break;

            case "Layang-Layang":
                break;

            case "Lingkaran":
                gbc.gridx = 0;
                gbc.gridy = row;
                inputPanel.add(new JLabel("Radius(cm):"), gbc);
                gbc.gridx = 1;
                inputPanel.add(new JTextField(10), gbc);

                row++;
                gbc.gridx = 0;
                gbc.gridy = row;
                inputPanel.add(new JLabel("Custom pi(opsional):"), gbc);
                gbc.gridx = 1;
                inputPanel.add(new JTextField("0", 10), gbc);
                hitungButton.setEnabled(true);
                break;

            case "Tembereng Lingkaran":
                gbc.gridx = 0;
                gbc.gridy = row;
                inputPanel.add(new JLabel("Radius(cm):"), gbc);
                gbc.gridx = 1;
                inputPanel.add(new JTextField(10), gbc);

                row++;
                gbc.gridx = 0;
                gbc.gridy = row;
                inputPanel.add(new JLabel("Sudut:"), gbc);
                gbc.gridx = 1;
                inputPanel.add(new JTextField(10), gbc);

                row++;
                gbc.gridx = 0;
                gbc.gridy = row;
                inputPanel.add(new JLabel("Custom pi(opsional):"), gbc);
                gbc.gridx = 1;
                inputPanel.add(new JTextField("0", 10), gbc);
                hitungButton.setEnabled(true);
                break;

            case "Juring Lingkaran":
                gbc.gridx = 0;
                gbc.gridy = row;
                inputPanel.add(new JLabel("Radius(cm):"), gbc);
                gbc.gridx = 1;
                inputPanel.add(new JTextField(10), gbc);

                row++;
                gbc.gridx = 0;
                gbc.gridy = row;
                inputPanel.add(new JLabel("Sudut:"), gbc);
                gbc.gridx = 1;
                inputPanel.add(new JTextField(10), gbc);

                row++;
                gbc.gridx = 0;
                gbc.gridy = row;
                inputPanel.add(new JLabel("Custom pi(opsional):"), gbc);
                gbc.gridx = 1;
                inputPanel.add(new JTextField("0", 10), gbc);
                hitungButton.setEnabled(true);
                break;
        }

        inputPanel.revalidate();
        inputPanel.repaint();
    }

    private void hitungBangunDatar() {
        String selected = (String) bangunComboBox.getSelectedItem();
        StringBuilder result = new StringBuilder();

        try {
            Component[] components = inputPanel.getComponents();

            switch (selected) {
                case "Persegi":
                    double sisi = Double.parseDouble(((JTextField) components[1]).getText());
                    double luas = sisi * sisi;
                    double keliling = 4 * sisi;
                    result.append("=== PERSEGI ===\n");
                    result.append("Sisi: ").append(sisi).append(" unit\n");
                    result.append("Luas: ").append(String.format("%.2f", luas)).append(" unit²\n");
                    result.append("Keliling: ").append(String.format("%.2f", keliling)).append(" unit\n");
                    break;

                case "Segitiga":
                    double alas = Double.parseDouble(((JTextField) components[1]).getText());
                    double tinggi = Double.parseDouble(((JTextField) components[3]).getText());
                    double luasSegitiga = 0.5 * alas * tinggi;
                    result.append("=== SEGITIGA ===\n");
                    result.append("Alas: ").append(alas).append(" unit\n");
                    result.append("Tinggi: ").append(tinggi).append(" unit\n");
                    result.append("Luas: ").append(String.format("%.2f", luasSegitiga)).append(" unit²\n");
                    break;

                case "Persegi Panjang":
                    double panjang = Double.parseDouble(((JTextField) components[1]).getText());
                    double lebar = Double.parseDouble(((JTextField) components[3]).getText());
                    double luasPersegiPanjang = panjang * lebar;
                    double kelilingPersegiPanjang = 2 * (panjang + lebar);
                    result.append("=== PERSEGI PANJANG ===\n");
                    result.append("Panjang: ").append(panjang).append(" unit\n");
                    result.append("Lebar: ").append(lebar).append(" unit\n");
                    result.append("Luas: ").append(String.format("%.2f", luasPersegiPanjang)).append(" unit²\n");
                    result.append("Keliling: ").append(String.format("%.2f", kelilingPersegiPanjang)).append(" unit\n");
                    break;

                case "Jajaran Genjang":
                    double alasJajar = Double.parseDouble(((JTextField) components[1]).getText());
                    double tinggiJajar = Double.parseDouble(((JTextField) components[3]).getText());
                    double sisiMiring = Double.parseDouble(((JTextField) components[5]).getText());
                    double luasJajar = alasJajar * tinggiJajar;
                    double kelilingJajar = 2 * (alasJajar + sisiMiring);
                    result.append("=== JAJAR GENJANG ===\n");
                    result.append("Alas: ").append(alasJajar).append(" unit\n");
                    result.append("Tinggi: ").append(tinggiJajar).append(" unit\n");
                    result.append("Sisi Miring: ").append(sisiMiring).append(" unit\n");
                    result.append("Luas: ").append(String.format("%.2f", luasJajar)).append(" unit²\n");
                    result.append("Keliling: ").append(String.format("%.2f", kelilingJajar)).append(" unit\n");
                    break;

                case "Trapesium":
                    break;

                case "Belah Ketupat":
                    break;

                case "Layang-Layang":
                    break;

                case "Lingkaran":
                    double radiusLingkaran = Double.parseDouble(((JTextField) components[1]).getText());
                    double customPiLingkaran = Double.parseDouble(((JTextField) components[3]).getText());
                    try {
                        Lingkaran lingkaran;
                        if (customPiLingkaran == 0) {
                            lingkaran = new Lingkaran(radiusLingkaran);
                        } else {
                            lingkaran = new Lingkaran(radiusLingkaran, customPiLingkaran);
                        }
                        result.append(lingkaran.tampilkanInfo());
                    } catch (InvalidInputException ex) {
                        JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case "Tembereng Lingkaran":
                    double radiusTembereng = Double.parseDouble(((JTextField) components[1]).getText());
                    double sudutTembereng = Double.parseDouble(((JTextField) components[3]).getText());
                    double customPiTembereng = Double.parseDouble(((JTextField) components[5]).getText());
                    try {
                        Lingkaran temberengLingkaran;
                        if (customPiTembereng == 0) {
                            temberengLingkaran = new TemberengLingkaran(radiusTembereng, sudutTembereng);
                        } else {
                            temberengLingkaran = new TemberengLingkaran(radiusTembereng, sudutTembereng, customPiTembereng);
                        }
                        result.append(temberengLingkaran.tampilkanInfo());
                    } catch (InvalidInputException ex) {
                        JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                case "Juring Lingkaran":
                    double radiusJuring = Double.parseDouble(((JTextField) components[1]).getText());
                    double sudutJuring = Double.parseDouble(((JTextField) components[3]).getText());
                    double customPiJuring = Double.parseDouble(((JTextField) components[5]).getText());
                    try {
                        Lingkaran juringLingkaran;
                        if (customPiJuring == 0) {
                            juringLingkaran = new JuringLingkaran(radiusJuring, sudutJuring);
                        } else {
                            juringLingkaran = new JuringLingkaran(radiusJuring, sudutJuring, customPiJuring);
                        }
                        result.append(juringLingkaran.tampilkanInfo());
                    } catch (InvalidInputException ex) {
                        JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
            }

            hasilArea.setText(result.toString());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Input harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
