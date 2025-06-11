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

    private void addInputFieldCustomPi(GridBagConstraints gbc, int row, String label) {
        gbc.gridx = 0;
        gbc.gridy = row;
        inputPanel.add(new JLabel(label), gbc);

        gbc.gridx = 1;
        inputPanel.add(new JTextField("0", 10), gbc);
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
                addInputField(gbc, row++, "Sisi Kiri:");
                addInputField(gbc, row++, "Sisi Kanan:");
                addInputField(gbc, row++, "Tinggi:");
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
                addInputFieldCustomPi(gbc, row++, "Custom Pi (opsional):");
                hitungButton.setEnabled(true);
                break;
            case "Tembereng Lingkaran":
                addInputField(gbc, row++, "Radius:");
                addInputField(gbc, row++, "Sudut:");
                addInputFieldCustomPi(gbc, row++, "Custom Pi (opsional):");
                hitungButton.setEnabled(true);
                break;
            case "Juring Lingkaran":
                addInputField(gbc, row++, "Radius:");
                addInputField(gbc, row++, "Sudut:");
                addInputFieldCustomPi(gbc, row++, "Custom Pi (opsional):");
                hitungButton.setEnabled(true);
                break;
        }

        inputPanel.revalidate();
        inputPanel.repaint();
    }

    private void hitungBangunDatar() {
        String selected = (String) bangunComboBox.getSelectedItem();
        hitungButton.setEnabled(false);
        hasilArea.setText("Menghitung...");

        new Thread(() -> {
            try {
                StringBuilder result = new StringBuilder();
                Component[] components = inputPanel.getComponents();

                switch (selected) {
                    case "Segitiga":
                        double alas = Double.parseDouble(((JTextField) components[1]).getText());
                        double tinggi = Double.parseDouble(((JTextField) components[3]).getText());
                        result.append("Luas = ").append(0.5 * alas * tinggi);
                        break;
                    case "Persegi":
                        double sisiPersegi = Double.parseDouble(((JTextField) components[1]).getText());
                        try {
                            Persegi persegi = new Persegi(sisiPersegi);
                            Thread persegiThread = new Thread(persegi);
                            persegiThread.start();
                            persegiThread.join();
                            result.append(persegi.tampilkanInfo());
                        } catch (InvalidInputException | InterruptedException ex) {
                            SwingUtilities.invokeLater(()
                                    -> JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE)
                            );
                        }
                        break;
                    case "Persegi Panjang":
                        double panjangPP = Double.parseDouble(((JTextField) components[1]).getText());
                        double lebarPP = Double.parseDouble(((JTextField) components[3]).getText());
                        try {
                            PersegiPanjang persegiPanjang = new PersegiPanjang(panjangPP, lebarPP);
                            Thread ppThread = new Thread(persegiPanjang);
                            ppThread.start();
                            ppThread.join();
                            result.append(persegiPanjang.tampilkanInfo());
                        } catch (InvalidInputException | InterruptedException ex) {
                            SwingUtilities.invokeLater(()
                                    -> JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE)
                            );
                        }
                        break;
                    case "Jajaran Genjang":
                        double alasJG = Double.parseDouble(((JTextField) components[1]).getText());
                        double tinggiJG = Double.parseDouble(((JTextField) components[3]).getText());
                        result.append("Luas = ").append(alasJG * tinggiJG);
                        break;
                    case "Trapesium":
                        double sisiAtas = Double.parseDouble(((JTextField) components[1]).getText());
                        double sisiBawah = Double.parseDouble(((JTextField) components[3]).getText());
                        double sisiKiri = Double.parseDouble(((JTextField) components[5]).getText());
                        double sisiKanan = Double.parseDouble(((JTextField) components[7]).getText());
                        double tinggi = Double.parseDouble(((JTextField) components[9]).getText());
                        try {
                            Trapesium trapesium = new Trapesium(sisiAtas, sisiBawah, sisiKiri, sisiKanan, tinggi);
                            Thread trapesiumThread = new Thread(trapesium);
                            trapesiumThread.start();
                            trapesiumThread.join();
                            result.append(trapesium.tampilkanInfo());
                        } catch (InvalidInputException | InterruptedException ex) {
                            SwingUtilities.invokeLater(()
                                    -> JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE)
                            );
                        }
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
                            Thread lingkaranThread = new Thread(lingkaran);
                            lingkaranThread.start();
                            lingkaranThread.join();
                            result.append(lingkaran.tampilkanInfo());
                        } catch (InvalidInputException | InterruptedException ex) {
                            SwingUtilities.invokeLater(()
                                    -> JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE));
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
                            Thread temberengLingkaranThread = new Thread(temberengLingkaran);
                            temberengLingkaranThread.start();
                            temberengLingkaranThread.join();
                            result.append(temberengLingkaran.tampilkanInfo());
                        } catch (InvalidInputException | InterruptedException ex) {
                            SwingUtilities.invokeLater(()
                                    -> JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE));
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
                            Thread juringLingkaranThread = new Thread(juringLingkaran);
                            juringLingkaranThread.start();
                            juringLingkaranThread.join();
                            result.append(juringLingkaran.tampilkanInfo());
                        } catch (InvalidInputException | InterruptedException ex) {
                            SwingUtilities.invokeLater(()
                                    -> JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE));
                        }
                        break;
                }
                SwingUtilities.invokeLater(() -> {
                    hasilArea.setText(result.toString());
                    hitungButton.setEnabled(true);
                });
            } catch (NumberFormatException ex) {
                SwingUtilities.invokeLater(() -> {
                    JOptionPane.showMessageDialog(this, "Input harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
                    hitungButton.setEnabled(true);
                });
            } catch (Exception ex) {
                SwingUtilities.invokeLater(() -> {
                    JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    hitungButton.setEnabled(true);
                });
            }
        }
        ).start();

    }
}
