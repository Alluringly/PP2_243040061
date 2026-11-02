import javax.swing.*;
import java.awt.*;

public class Contoh_Modul_1 {

    private int JumlahKlik = 0;

    private void tampilan() {
        JFrame frame = new JFrame("Contoh Modul 1");
        JLabel pesan = new JLabel("Tekan tombol ini.");
        JButton tombol = new JButton("Klik saya:");

        tombol.addActionListener(event -> {
            JumlahKlik++;
            pesan.setText("Saya sudah mengetik sebanyak:" + JumlahKlik);
        });

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(pesan, BorderLayout.CENTER);
        panel.add(tombol, BorderLayout.SOUTH);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Contoh_Modul_1()::tampilan);
    }
}