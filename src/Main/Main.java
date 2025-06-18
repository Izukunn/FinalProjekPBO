package Main;

import gui.*;

import javax.swing.*;
import java.awt.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Main extends JFrame {

    public Main() {
        setTitle("Aplikasi Bangun Datar & Bangun Ruang");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabPane = new JTabbedPane();
        tabPane.addTab("Bangun Datar", new BangunDatarPanel());
        tabPane.addTab("Bangun Ruang", new BangunRuangPanel());

        add(tabPane);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Main().setVisible(true);
        });
    }
}

