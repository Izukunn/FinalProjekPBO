package gui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private JTabbedPane tabbedPane;
    private BangunDatarPanel bangunDatarPanel;
    private BangunRuangPanel bangunRuangPanel;

    public MainFrame() {
        setTitle("Kalkulator Geometri");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        tabbedPane = new JTabbedPane();
        tabbedPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Tambahkan padding

        bangunDatarPanel = new BangunDatarPanel();
        bangunRuangPanel = new BangunRuangPanel();

        tabbedPane.addTab("Bangun Datar", bangunDatarPanel);
        tabbedPane.addTab("Bangun Ruang", bangunRuangPanel);

        add(tabbedPane);
    }
}