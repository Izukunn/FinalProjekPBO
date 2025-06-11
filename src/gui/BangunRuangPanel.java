package gui;

import benda_geometri.*;
import benda_geometri.InvalidInputException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class BangunRuangPanel extends JPanel {

    private JComboBox<String> bangunComboBox;
    private JPanel inputPanel;
    private JButton hitungButton;
    private JTextArea hasilArea;

    public BangunRuangPanel() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        String[] bangunRuang = {
            "Pilih Bangun", "Prisma Segitiga", "Limas Segitiga", "Prisma Persegi", "Limas Persegi",
            "Prisma Persegi Panjang", "Limas Persegi Panjang", "Prisma Jajaran Genjang", "Limas Jajaran Genjang", "Prisma Trapesium",
            "Limas Trapesium", "Prisma Belah Ketupat", "Limas Belah Ketupat", "Prisma Layang-Layang", "Limas Layang-Layang",
            "Tabung", "Kerucut", "Kerucut Terpancung", "Bola", "Tembereng Bola", "Juring Bola", "Cincin Bola"
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
            case "Prisma Persegi":
                addInputField(gbc, row++, "Sisi Alas:");
                addInputField(gbc, row++, "Tinggi:");
                hitungButton.setEnabled(true);
                break;
            case "Limas Persegi":
                addInputField(gbc, row++, "Sisi Alas:");
                addInputField(gbc, row++, "Tinggi:");
                hitungButton.setEnabled(true);
                break;
            case "Prisma Persegi Panjang":
                addInputField(gbc, row++, "Panjang Alas:");
                addInputField(gbc, row++, "Lebar Alas:");
                addInputField(gbc, row++, "Tinggi:");
                hitungButton.setEnabled(true);
                break;
            case "Limas Persegi Panjang":
                addInputField(gbc, row++, "Panjang Alas:");
                addInputField(gbc, row++, "Lebar Alas:");
                addInputField(gbc, row++, "Tinggi:");
                hitungButton.setEnabled(true);
                break;
            case "Prisma Trapesium":
                addInputField(gbc, row++, "Sisi Atas:");
                addInputField(gbc, row++, "Sisi Bawah:");
                addInputField(gbc, row++, "Sisi Kiri:");
                addInputField(gbc, row++, "Sisi Kanan:");
                addInputField(gbc, row++, "Tinggi Alas:");
                addInputField(gbc, row++, "Tinggi Prisma:");
                hitungButton.setEnabled(true);
                break;
            case "Limas Trapesium":
                addInputField(gbc, row++, "Sisi Atas:");
                addInputField(gbc, row++, "Sisi Bawah:");
                addInputField(gbc, row++, "Sisi Kiri:");
                addInputField(gbc, row++, "Sisi Kanan:");
                addInputField(gbc, row++, "Tinggi Alas:");
                addInputField(gbc, row++, "Tinggi Limas:");
                hitungButton.setEnabled(true);
                break;
            case "Prisma Belah Ketupat":
                addInputField(gbc, row++, "Diagonal 1:");
                addInputField(gbc, row++, "Diagonal 2:");
                addInputField(gbc, row++, "Sisi:");
                addInputField(gbc, row++, "Tinggi Prisma:");
                hitungButton.setEnabled(true);
                break;
            case "Limas Belah Ketupat":
                addInputField(gbc, row++, "Diagonal 1:");
                addInputField(gbc, row++, "Diagonal 2:");
                addInputField(gbc, row++, "Sisi:");
                addInputField(gbc, row++, "Tinggi Prisma:");
                hitungButton.setEnabled(true);
                break;
            case "Prisma Layang-Layang":
                addInputField(gbc, row++, "Diagonal 1:");
                addInputField(gbc, row++, "Diagonal 2:");
                addInputField(gbc, row++, "Sisi Pendek:");
                addInputField(gbc, row++, "Sisi Panjang:");
                addInputField(gbc, row++, "Tinggi Prisma:");
                hitungButton.setEnabled(true);
                break;
            case "Limas Layang-Layang":
                addInputField(gbc, row++, "Diagonal 1:");
                addInputField(gbc, row++, "Diagonal 2:");
                addInputField(gbc, row++, "Sisi Pendek:");
                addInputField(gbc, row++, "Sisi Panjang:");
                addInputField(gbc, row++, "Tinggi Prisma:");
                hitungButton.setEnabled(true);
                break;
            case "Tabung":
                addInputField(gbc, row++, "Radius:");
                addInputField(gbc, row++, "Tinggi:");
                addInputFieldCustomPi(gbc, row++, "Custom Pi(Opsional):");
                hitungButton.setEnabled(true);
                break;
            case "Kerucut":
                addInputField(gbc, row++, "Radius:");
                addInputField(gbc, row++, "Tinggi:");
                addInputFieldCustomPi(gbc, row++, "Custom Pi(Opsional):");
                hitungButton.setEnabled(true);
                break;
            case "Kerucut Terpancung":
                addInputField(gbc, row++, "Radius Bawah:");
                addInputField(gbc, row++, "Radius Bawah:");
                addInputField(gbc, row++, "Tinggi:");
                addInputFieldCustomPi(gbc, row++, "Custom Pi(Opsional):");
                hitungButton.setEnabled(true);
                break;
            case "Bola":
                addInputField(gbc, row++, "Radius:");
                addInputFieldCustomPi(gbc, row++, "Custom Pi(Opsional):");
                hitungButton.setEnabled(true);
                break;
            case "Tembereng Bola":
                addInputField(gbc, row++, "Radius Bola:");
                addInputField(gbc, row++, "Tinggi Tembereng:");
                addInputFieldCustomPi(gbc, row++, "Custom Pi(Opsional):");
                hitungButton.setEnabled(true);
                break;
            case "Juring Bola":
                addInputField(gbc, row++, "Radius Bola:");
                addInputField(gbc, row++, "Tinggi Juring:");
                addInputFieldCustomPi(gbc, row++, "Custom Pi(Opsional):");
                hitungButton.setEnabled(true);
                break;
            case "Cincin Bola":
                addInputField(gbc, row++, "Radius Luar:");
                addInputField(gbc, row++, "Radius Dalam:");
                addInputFieldCustomPi(gbc, row++, "Custom Pi(Opsional):");
                hitungButton.setEnabled(true);
                break;
        }

        inputPanel.revalidate();
        inputPanel.repaint();
    }

    private void hitungBangunRuang() {
        String selected = (String) bangunComboBox.getSelectedItem();
        hitungButton.setEnabled(false);
        hasilArea.setText("Menghitung...");

        new Thread(() -> {
            try {
                StringBuilder result = new StringBuilder();
                Component[] components = inputPanel.getComponents();
                switch (selected) {
                    case "Prisma Persegi":
                        double sisiPrismaP = Double.parseDouble(((JTextField) components[1]).getText());
                        double tinggiPrismaP = Double.parseDouble(((JTextField) components[3]).getText());
                        try {
                            PrismaPersegi prismaPersegi = new PrismaPersegi(sisiPrismaP, tinggiPrismaP);
                            Thread prismaThread = new Thread(prismaPersegi);
                            prismaThread.start();
                            prismaThread.join();
                            result.append(prismaPersegi.tampilkanInfo());
                        } catch (InvalidInputException | InterruptedException ex) {
                            SwingUtilities.invokeLater(()
                                    -> JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE)
                            );
                        }
                        break;

                    case "Limas Persegi":
                        double sisiLimasP = Double.parseDouble(((JTextField) components[1]).getText());
                        double tinggiLimasP = Double.parseDouble(((JTextField) components[3]).getText());
                        try {
                            LimasPersegi limas = new LimasPersegi(sisiLimasP, tinggiLimasP);
                            Thread limasThread = new Thread(limas);
                            limasThread.start();
                            limasThread.join();
                            result.append(limas.tampilkanInfo());
                        } catch (InvalidInputException | InterruptedException ex) {
                            SwingUtilities.invokeLater(()
                                    -> JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE)
                            );
                        }
                        break;

                    case "Prisma Persegi Panjang":
                        double panjangPrismaPP = Double.parseDouble(((JTextField) components[1]).getText());
                        double lebarPrismaPP = Double.parseDouble(((JTextField) components[3]).getText());
                        double tinggiPrismaPP = Double.parseDouble(((JTextField) components[5]).getText());
                        try {
                            PrismaPersegiPanjang prismaPP = new PrismaPersegiPanjang(panjangPrismaPP, lebarPrismaPP, tinggiPrismaPP);
                            Thread prismaPPThread = new Thread(prismaPP);
                            prismaPPThread.start();
                            prismaPPThread.join();
                            result.append(prismaPP.tampilkanInfo());
                        } catch (InvalidInputException | InterruptedException ex) {
                            SwingUtilities.invokeLater(()
                                    -> JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE)
                            );
                        }
                        break;

                    case "Limas Persegi Panjang":
                        double panjangLimasPP = Double.parseDouble(((JTextField) components[1]).getText());
                        double lebarLimasPP = Double.parseDouble(((JTextField) components[3]).getText());
                        double tinggiLimasPP = Double.parseDouble(((JTextField) components[5]).getText());
                        try {
                            LimasPersegiPanjang limasPP = new LimasPersegiPanjang(panjangLimasPP, lebarLimasPP, tinggiLimasPP);
                            Thread limasPPThread = new Thread(limasPP);
                            limasPPThread.start();
                            limasPPThread.join();
                            result.append(limasPP.tampilkanInfo());
                        } catch (InvalidInputException | InterruptedException ex) {
                            SwingUtilities.invokeLater(()
                                    -> JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE)
                            );
                        }
                        break;

                    case "Prisma Trapesium":
                        double sisiAtasTp = Double.parseDouble(((JTextField) components[1]).getText());
                        double sisiBawahTp = Double.parseDouble(((JTextField) components[3]).getText());
                        double sisiKiriTp = Double.parseDouble(((JTextField) components[5]).getText());
                        double sisiKananTp = Double.parseDouble(((JTextField) components[7]).getText());
                        double tinggiAlasTp = Double.parseDouble(((JTextField) components[9]).getText());
                        double tinggiPrismaTp = Double.parseDouble(((JTextField) components[11]).getText());
                        try {
                            PrismaTrapesium prismaTrapesium = new PrismaTrapesium(sisiAtasTp, sisiBawahTp, sisiKiriTp, sisiKananTp, tinggiAlasTp, tinggiPrismaTp);
                            Thread prismaTrapesiumThread = new Thread(prismaTrapesium);
                            prismaTrapesiumThread.start();
                            prismaTrapesiumThread.join();
                            result.append(prismaTrapesium.tampilkanInfo());
                        } catch (InvalidInputException | InterruptedException ex) {
                            SwingUtilities.invokeLater(()
                                    -> JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE)
                            );
                        }
                        break;

                    case "Limas Trapesium":
                        double sisiAtasTr = Double.parseDouble(((JTextField) components[1]).getText());
                        double sisiBawahTr = Double.parseDouble(((JTextField) components[3]).getText());
                        double sisiKiriTr = Double.parseDouble(((JTextField) components[5]).getText());
                        double sisiKananTr = Double.parseDouble(((JTextField) components[7]).getText());
                        double tinggiAlasTr = Double.parseDouble(((JTextField) components[9]).getText());
                        double tinggiLimasTr = Double.parseDouble(((JTextField) components[11]).getText());
                        try {
                            LimasTrapesium limasTrapesium = new LimasTrapesium(sisiAtasTr, sisiBawahTr, sisiKiriTr, sisiKananTr, tinggiAlasTr, tinggiLimasTr);
                            Thread limasTrapesiumThread = new Thread(limasTrapesium);
                            limasTrapesiumThread.start();
                            limasTrapesiumThread.join();
                            result.append(limasTrapesium.tampilkanInfo());
                        } catch (InvalidInputException | InterruptedException ex) {
                            SwingUtilities.invokeLater(()
                                    -> JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE)
                            );
                        }
                        break;

                    case "Prisma Belah Ketupat":
                        double diagonal1PrismaBelahKetupat = Double.parseDouble(((JTextField) components[1]).getText());
                        double diagonal2PrismaBelahKetupat = Double.parseDouble(((JTextField) components[3]).getText());
                        double sisiPrismaBelahKetupat = Double.parseDouble(((JTextField) components[5]).getText());
                        double tinggiPrismaBelahKetupat = Double.parseDouble(((JTextField) components[7]).getText());

                        try {
                            PrismaBelahKetupat prismaBelahKetupat = new PrismaBelahKetupat(
                                    diagonal1PrismaBelahKetupat,
                                    diagonal2PrismaBelahKetupat,
                                    sisiPrismaBelahKetupat,
                                    tinggiPrismaBelahKetupat
                            );

                            Thread prismaBelahKetupatThread = new Thread(prismaBelahKetupat);
                            prismaBelahKetupatThread.start();
                            prismaBelahKetupatThread.join();

                            result.append(prismaBelahKetupat.tampilkanInfo());
                        } catch (InvalidInputException | InterruptedException ex) {
                            SwingUtilities.invokeLater(()
                                    -> JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE));
                        }
                        break;

                    case "Limas Belah Ketupat":
                        double diagonal1LimasBelahKetupat = Double.parseDouble(((JTextField) components[1]).getText());
                        double diagonal2LimasBelahKetupat = Double.parseDouble(((JTextField) components[3]).getText());
                        double sisiLimasBelahKetupat = Double.parseDouble(((JTextField) components[5]).getText());
                        double tinggiPrismaLimasBelahKetupat = Double.parseDouble(((JTextField) components[7]).getText());
                        try {
                            LimasBelahKetupat limasBelahKetupat = new LimasBelahKetupat(
                                    diagonal1LimasBelahKetupat,
                                    diagonal2LimasBelahKetupat,
                                    sisiLimasBelahKetupat,
                                    tinggiPrismaLimasBelahKetupat
                            );
                            Thread limasBelahKetupatThread = new Thread(limasBelahKetupat);
                            limasBelahKetupatThread.start();
                            limasBelahKetupatThread.join();
                            result.append(limasBelahKetupat.tampilkanInfo());
                        } catch (InvalidInputException | InterruptedException ex) {
                            SwingUtilities.invokeLater(()
                                    -> JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE));
                        }
                        break;

                    case "Prisma Layang-Layang":
                        double diagonal1PrismaLayangLayang = Double.parseDouble(((JTextField) components[1]).getText());
                        double diagonal2PrismaLayangLayang = Double.parseDouble(((JTextField) components[3]).getText());
                        double sisiPendekPrismaLayangLayang = Double.parseDouble(((JTextField) components[5]).getText());
                        double sisiPanjangPrismaLayangLayang = Double.parseDouble(((JTextField) components[7]).getText());
                        double tinggiPrismaLayangLayang = Double.parseDouble(((JTextField) components[9]).getText());

                        try {
                            PrismaLayangLayang prismaLayangLayang = new PrismaLayangLayang(
                                    diagonal1PrismaLayangLayang,
                                    diagonal2PrismaLayangLayang,
                                    sisiPendekPrismaLayangLayang,
                                    sisiPanjangPrismaLayangLayang,
                                    tinggiPrismaLayangLayang
                            );

                            Thread prismaLayangLayangThread = new Thread(prismaLayangLayang);
                            prismaLayangLayangThread.start();
                            prismaLayangLayangThread.join();

                            result.append(prismaLayangLayang.tampilkanInfo());
                        } catch (InvalidInputException | InterruptedException ex) {
                            SwingUtilities.invokeLater(()
                                    -> JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE));
                        }
                        break;

                    case "Limas Layang-Layang":
                        double diagonal1LimasLayangLayang = Double.parseDouble(((JTextField) components[1]).getText());
                        double diagonal2LimasLayangLayang = Double.parseDouble(((JTextField) components[3]).getText());
                        double sisiPendekLimasLayangLayang = Double.parseDouble(((JTextField) components[5]).getText());
                        double sisiPanjangLimasLayangLayang = Double.parseDouble(((JTextField) components[7]).getText());
                        double tinggiLimasLayangLayang = Double.parseDouble(((JTextField) components[9]).getText());

                        try {
                            LimasLayangLayang limasLayangLayang = new LimasLayangLayang(
                                    diagonal1LimasLayangLayang,
                                    diagonal2LimasLayangLayang,
                                    sisiPendekLimasLayangLayang,
                                    sisiPanjangLimasLayangLayang,
                                    tinggiLimasLayangLayang
                            );

                            Thread limasLayangLayangThread = new Thread(limasLayangLayang);
                            limasLayangLayangThread.start();
                            limasLayangLayangThread.join();

                            result.append(limasLayangLayang.tampilkanInfo());
                        } catch (InvalidInputException | InterruptedException ex) {
                            SwingUtilities.invokeLater(()
                                    -> JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE));
                        }
                        break;

                    case "Tabung":
                        double radiusTabung = Double.parseDouble(((JTextField) components[1]).getText());
                        double tinggiTabung = Double.parseDouble(((JTextField) components[3]).getText());
                        double customPiTabung = Double.parseDouble(((JTextField) components[5]).getText());
                        try {
                            Lingkaran tabung;
                            if (customPiTabung == 0) {
                                tabung = new Tabung(radiusTabung, tinggiTabung);
                            } else {
                                tabung = new Tabung(radiusTabung, tinggiTabung, customPiTabung);
                            }
                            Thread tabungThread = new Thread(tabung);
                            tabungThread.start();
                            tabungThread.join();
                            result.append(tabung.tampilkanInfo());
                        } catch (InvalidInputException | InterruptedException ex) {
                            SwingUtilities.invokeLater(()
                                    -> JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE));
                        }
                        break;

                    case "Kerucut":
                        double radiusKerucut = Double.parseDouble(((JTextField) components[1]).getText());
                        double tinggiKerucut = Double.parseDouble(((JTextField) components[3]).getText());
                        double customPiKerucut = Double.parseDouble(((JTextField) components[5]).getText());
                        try {
                            Lingkaran kerucut;
                            if (customPiKerucut == 0) {
                                kerucut = new Kerucut(radiusKerucut, tinggiKerucut);
                            } else {
                                kerucut = new Kerucut(radiusKerucut, tinggiKerucut, customPiKerucut);
                            }
                            Thread kerucutThread = new Thread(kerucut);
                            kerucutThread.start();
                            kerucutThread.join();
                            result.append(kerucut.tampilkanInfo());
                        } catch (InvalidInputException | InterruptedException ex) {
                            SwingUtilities.invokeLater(()
                                    -> JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE));
                        }
                        break;

                    case "Kerucut Terpancung":
                        double radiusBawahKerucutT = Double.parseDouble(((JTextField) components[1]).getText());
                        double radiusAtasKerucutT = Double.parseDouble(((JTextField) components[3]).getText());
                        double tinggiKerucutT = Double.parseDouble(((JTextField) components[5]).getText());
                        double customPiKerucutT = Double.parseDouble(((JTextField) components[7]).getText());
                        try {
                            KerucutTerpancung kerucutT;
                            if (customPiKerucutT == 0) {
                                kerucutT = new KerucutTerpancung(radiusBawahKerucutT, radiusAtasKerucutT, tinggiKerucutT);
                            } else {
                                kerucutT = new KerucutTerpancung(radiusBawahKerucutT, radiusAtasKerucutT, tinggiKerucutT, customPiKerucutT);
                            }
                            Thread kerucutTThread = new Thread(kerucutT);
                            kerucutTThread.start();
                            kerucutTThread.join();
                            result.append(kerucutT.tampilkanInfo());
                        } catch (InvalidInputException | InterruptedException ex) {
                            SwingUtilities.invokeLater(()
                                    -> JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE));
                        }
                        break;

                    case "Bola":
                        double radiusBola = Double.parseDouble(((JTextField) components[1]).getText());
                        double customPiBola = Double.parseDouble(((JTextField) components[3]).getText());
                        try {
                            Lingkaran bola;
                            if (customPiBola == 0) {
                                bola = new Bola(radiusBola);
                            } else {
                                bola = new Bola(radiusBola, customPiBola);
                            }
                            Thread bolaThread = new Thread(bola);
                            bolaThread.start();
                            bolaThread.join();
                            result.append(bola.tampilkanInfo());
                        } catch (InvalidInputException | InterruptedException ex) {
                            SwingUtilities.invokeLater(()
                                    -> JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE));
                        }
                        break;

                    case "Tembereng Bola":
                        double radiusBolaTembereng = Double.parseDouble(((JTextField) components[1]).getText());
                        double tinggiTembereng = Double.parseDouble(((JTextField) components[3]).getText());
                        double customPiTembereng = Double.parseDouble(((JTextField) components[5]).getText());
                        try {
                            TemberengBola temberengBola;
                            if (customPiTembereng == 0) {
                                temberengBola = new TemberengBola(radiusBolaTembereng, tinggiTembereng);
                            } else {
                                temberengBola = new TemberengBola(radiusBolaTembereng, tinggiTembereng, customPiTembereng);
                            }
                            Thread temberengBolaThread = new Thread(temberengBola);
                            temberengBolaThread.start();
                            temberengBolaThread.join();
                            result.append(temberengBola.tampilkanInfo());
                        } catch (InvalidInputException | InterruptedException ex) {
                            SwingUtilities.invokeLater(()
                                    -> JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE));
                        }
                        break;

                    case "Juring Bola":
                        double radiusBolaJuring = Double.parseDouble(((JTextField) components[1]).getText());
                        double tinggiJuring = Double.parseDouble(((JTextField) components[3]).getText());
                        double customPiJuring = Double.parseDouble(((JTextField) components[5]).getText());
                        try {
                            JuringBola juringBola;
                            if (customPiJuring == 0) {
                                juringBola = new JuringBola(radiusBolaJuring, tinggiJuring);
                            } else {
                                juringBola = new JuringBola(radiusBolaJuring, tinggiJuring, customPiJuring);
                            }
                            Thread juringBolaThread = new Thread(juringBola);
                            juringBolaThread.start();
                            juringBolaThread.join();
                            result.append(juringBola.tampilkanInfo());
                        } catch (InvalidInputException | InterruptedException ex) {
                            SwingUtilities.invokeLater(()
                                    -> JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE));
                        }
                        break;

                    case "Cincin Bola":
                        double radiusLuarCincin = Double.parseDouble(((JTextField) components[1]).getText());
                        double radiusDalamCincin = Double.parseDouble(((JTextField) components[3]).getText());
                        double customPiCincin = Double.parseDouble(((JTextField) components[5]).getText());
                        try {
                            Lingkaran cincinBola;
                            if (customPiCincin == 0) {
                                cincinBola = new CincinBola(radiusLuarCincin, radiusDalamCincin);
                            } else {
                                cincinBola = new CincinBola(radiusLuarCincin, radiusDalamCincin, customPiCincin);
                            }
                            Thread cincinBolaThread = new Thread(cincinBola);
                            cincinBolaThread.start();
                            cincinBolaThread.join();
                            result.append(cincinBola.tampilkanInfo());
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
        }).start();

    }
}
