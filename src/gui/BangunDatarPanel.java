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
                        try {
                            Segitiga segitiga = new Segitiga(alas, tinggi);
                            Thread segitigaThread = new Thread(segitiga);
                            segitigaThread.start();
                            segitigaThread.join();
                            result.append(segitiga.tampilkanInfo());
                        } catch (InvalidInputException | InterruptedException ex) {
                            SwingUtilities.invokeLater(()
                                    -> JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE)
                            );
                        }
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
                        double sisiMJG = Double.parseDouble(((JTextField) components[5]).getText());
                        try {
                            JajaranGenjang jg = new JajaranGenjang(alasJG, tinggiJG, sisiMJG);
                            Thread jgThread = new Thread(jg);
                            jgThread.start();
                            jgThread.join();
                            result.append(jg.tampilkanInfo());
                        } catch (InvalidInputException | InterruptedException ex) {
                            SwingUtilities.invokeLater(()
                                    -> JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE)
                            );
                        }
                        break;

                    case "Trapesium":
                        double sisiAtasT = Double.parseDouble(((JTextField) components[1]).getText());
                        double sisiBawahT = Double.parseDouble(((JTextField) components[3]).getText());
                        double sisiKiriT = Double.parseDouble(((JTextField) components[5]).getText());
                        double sisiKananT = Double.parseDouble(((JTextField) components[7]).getText());
                        double tinggiT = Double.parseDouble(((JTextField) components[9]).getText());
                        try {
                            Trapesium trapesium = new Trapesium(sisiAtasT, sisiBawahT, sisiKiriT, sisiKananT, tinggiT);
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
                        double diagonal1BelahKetupat = Double.parseDouble(((JTextField) components[1]).getText());
                        double diagonal2BelahKetupat = Double.parseDouble(((JTextField) components[3]).getText());
                        double sisiBelahKetupat = Double.parseDouble(((JTextField) components[5]).getText());
                        try {
                            BelahKetupat belahKetupat = new BelahKetupat(diagonal1BelahKetupat, diagonal2BelahKetupat, sisiBelahKetupat);
                            Thread belahKetupatThread = new Thread(belahKetupat);
                            belahKetupatThread.start();
                            belahKetupatThread.join();
                            result.append(belahKetupat.tampilkanInfo());
                        } catch (InvalidInputException | InterruptedException ex) {
                            SwingUtilities.invokeLater(()
                                    -> JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE));
                        }
                        break;

                    case "Layang-Layang":
                        double diagonal1LayangLayang = Double.parseDouble(((JTextField) components[1]).getText());
                        double diagonal2LayangLayang = Double.parseDouble(((JTextField) components[3]).getText());
                        double sisiPendekLayangLayang = Double.parseDouble(((JTextField) components[5]).getText());
                        double sisiPanjangLayangLayang = Double.parseDouble(((JTextField) components[7]).getText());
                        try {
                            LayangLayang layangLayang = new LayangLayang(
                                    diagonal1LayangLayang,
                                    diagonal2LayangLayang,
                                    sisiPendekLayangLayang,
                                    sisiPanjangLayangLayang
                            );
                            Thread layangLayangThread = new Thread(layangLayang);
                            layangLayangThread.start();
                            layangLayangThread.join();
                            result.append(layangLayang.tampilkanInfo());
                        } catch (InvalidInputException | InterruptedException ex) {
                            SwingUtilities.invokeLater(()
                                    -> JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE));
                        }
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
                            if (lingkaran.getErrorMessage() != null) {
                                JOptionPane.showMessageDialog(null, lingkaran.getErrorMessage());
                            }
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
                            if (temberengLingkaran.getErrorMessage() != null) {
                                JOptionPane.showMessageDialog(null, temberengLingkaran.getErrorMessage());
                            }
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
                            if (juringLingkaran.getErrorMessage() != null) {
                                JOptionPane.showMessageDialog(null, juringLingkaran.getErrorMessage());
                            }
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
            }
            catch (NumberFormatException ex) {
                SwingUtilities.invokeLater(() -> {
                    JOptionPane.showMessageDialog(this, "Input harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
                    hitungButton.setEnabled(true);
                });
            }
            catch (Exception ex) {
                SwingUtilities.invokeLater(() -> {
                    JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    hitungButton.setEnabled(true);
                });
            }
        }
        ).start();

    }
}
