package gui;

import benda_geometri.*;
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
        
        String[] bangunRuang = {"Pilih Bangun", "Kubus", "Balok", "Tabung", "Kerucut", "Bola"};
        bangunComboBox = new JComboBox<>(bangunRuang);
        bangunComboBox.setPreferredSize(new Dimension(150, 25));
        
        inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());
        inputPanel.setBorder(BorderFactory.createTitledBorder("Input Parameter"));
        
        hasilArea = new JTextArea(15, 25);
        hasilArea.setEditable(false);
        hasilArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        hasilArea.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        
        hitungButton = new JButton("Hitung");
        hitungButton.setEnabled(false);
        hitungButton.setPreferredSize(new Dimension(80, 25));
        
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.add(new JLabel("Pilih Bangun Ruang:"));
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
        
        bangunComboBox.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                updateInputFields();
            }
        });
        
        hitungButton.addActionListener(e -> hitungBangunRuang());
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
                gbc.gridx = 0; gbc.gridy = row;
                inputPanel.add(new JLabel("Sisi:"), gbc);
                gbc.gridx = 1;
                inputPanel.add(new JTextField(10), gbc);
                hitungButton.setEnabled(true);
                break;
                
            case "Balok":
                gbc.gridx = 0; gbc.gridy = row;
                inputPanel.add(new JLabel("Panjang:"), gbc);
                gbc.gridx = 1;
                inputPanel.add(new JTextField(10), gbc);
                
                row++;
                gbc.gridx = 0; gbc.gridy = row;
                inputPanel.add(new JLabel("Lebar:"), gbc);
                gbc.gridx = 1;
                inputPanel.add(new JTextField(10), gbc);
                
                row++;
                gbc.gridx = 0; gbc.gridy = row;
                inputPanel.add(new JLabel("Tinggi:"), gbc);
                gbc.gridx = 1;
                inputPanel.add(new JTextField(10), gbc);
                hitungButton.setEnabled(true);
                break;
                
            case "Tabung":
                gbc.gridx = 0; gbc.gridy = row;
                inputPanel.add(new JLabel("Radius:"), gbc);
                gbc.gridx = 1;
                inputPanel.add(new JTextField(10), gbc);
                
                row++;
                gbc.gridx = 0; gbc.gridy = row;
                inputPanel.add(new JLabel("Tinggi:"), gbc);
                gbc.gridx = 1;
                inputPanel.add(new JTextField(10), gbc);
                hitungButton.setEnabled(true);
                break;
                
            case "Kerucut":
                gbc.gridx = 0; gbc.gridy = row;
                inputPanel.add(new JLabel("Radius:"), gbc);
                gbc.gridx = 1;
                inputPanel.add(new JTextField(10), gbc);
                
                row++;
                gbc.gridx = 0; gbc.gridy = row;
                inputPanel.add(new JLabel("Tinggi:"), gbc);
                gbc.gridx = 1;
                inputPanel.add(new JTextField(10), gbc);
                
                row++;
                gbc.gridx = 0; gbc.gridy = row;
                inputPanel.add(new JLabel("Garis Pelukis:"), gbc);
                gbc.gridx = 1;
                inputPanel.add(new JTextField(10), gbc);
                hitungButton.setEnabled(true);
                break;
                
            case "Bola":
                gbc.gridx = 0; gbc.gridy = row;
                inputPanel.add(new JLabel("Radius:"), gbc);
                gbc.gridx = 1;
                inputPanel.add(new JTextField(10), gbc);
                hitungButton.setEnabled(true);
                break;
        }
        
        inputPanel.revalidate();
        inputPanel.repaint();
    }
    
    private void hitungBangunRuang() {
        String selected = (String) bangunComboBox.getSelectedItem();
        StringBuilder result = new StringBuilder();
        
        try {
            Component[] components = inputPanel.getComponents();
            
            switch (selected) {
                case "Kubus":
                    double sisi = Double.parseDouble(((JTextField)components[1]).getText());
                    double volume = sisi * sisi * sisi;
                    double luasPermukaan = 6 * sisi * sisi;
                    result.append("=== KUBUS ===\n");
                    result.append("Sisi: ").append(sisi).append(" unit\n");
                    result.append("Volume: ").append(String.format("%.2f", volume)).append(" unit³\n");
                    result.append("Luas Permukaan: ").append(String.format("%.2f", luasPermukaan)).append(" unit²\n");
                    break;
                    
                case "Balok":
                    double panjang = Double.parseDouble(((JTextField)components[1]).getText());
                    double lebar = Double.parseDouble(((JTextField)components[3]).getText());
                    double tinggi = Double.parseDouble(((JTextField)components[5]).getText());
                    double volumeBalok = panjang * lebar * tinggi;
                    double luasPermukaanBalok = 2 * (panjang * lebar + panjang * tinggi + lebar * tinggi);
                    result.append("=== BALOK ===\n");
                    result.append("Panjang: ").append(panjang).append(" unit\n");
                    result.append("Lebar: ").append(lebar).append(" unit\n");
                    result.append("Tinggi: ").append(tinggi).append(" unit\n");
                    result.append("Volume: ").append(String.format("%.2f", volumeBalok)).append(" unit³\n");
                    result.append("Luas Permukaan: ").append(String.format("%.2f", luasPermukaanBalok)).append(" unit²\n");
                    break;
                    
                case "Tabung":
                    double radius = Double.parseDouble(((JTextField)components[1]).getText());
                    double tinggiTabung = Double.parseDouble(((JTextField)components[3]).getText());
                    double volumeTabung = Math.PI * radius * radius * tinggiTabung;
                    double luasPermukaan = 2 * Math.PI * radius * (radius + tinggiTabung);
                    result.append("=== TABUNG ===\n");
                    result.append("Radius: ").append(radius).append(" unit\n");
                    result.append("Tinggi: ").append(tinggiTabung).append(" unit\n");
                    result.append("Volume: ").append(String.format("%.2f", volumeTabung)).append(" unit³\n");
                    result.append("Luas Permukaan: ").append(String.format("%.2f", luasPermukaan)).append(" unit²\n");
                    break;
                    
                case "Kerucut":
                    double radiusKerucut = Double.parseDouble(((JTextField)components[1]).getText());
                    double tinggiKerucut = Double.parseDouble(((JTextField)components[3]).getText());
                    double garisPelukis = Double.parseDouble(((JTextField)components[5]).getText());
                    double volumeKerucut = (1.0/3.0) * Math.PI * radiusKerucut * radiusKerucut * tinggiKerucut;
                    double luasPermukaanKerucut = Math.PI * radiusKerucut * (radiusKerucut + garisPelukis);
                    result.append("=== KERUCUT ===\n");
                    result.append("Radius: ").append(radiusKerucut).append(" unit\n");
                    result.append("Tinggi: ").append(tinggiKerucut).append(" unit\n");
                    result.append("Garis Pelukis: ").append(garisPelukis).append(" unit\n");
                    result.append("Volume: ").append(String.format("%.2f", volumeKerucut)).append(" unit³\n");
                    result.append("Luas Permukaan: ").append(String.format("%.2f", luasPermukaanKerucut)).append(" unit²\n");
                    break;
                    
                case "Bola":
                    double radiusBola = Double.parseDouble(((JTextField)components[1]).getText());
                    double volumeBola = (4.0/3.0) * Math.PI * radiusBola * radiusBola * radiusBola;
                    double luasPermukaanBola = 4 * Math.PI * radiusBola * radiusBola;
                    result.append("=== BOLA ===\n");
                    result.append("Radius: ").append(radiusBola).append(" unit\n");
                    result.append("Volume: ").append(String.format("%.2f", volumeBola)).append(" unit³\n");
                    result.append("Luas Permukaan: ").append(String.format("%.2f", luasPermukaanBola)).append(" unit²\n");
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