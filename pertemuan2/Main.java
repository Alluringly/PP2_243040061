import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.*;

public class Main {

    private static final String FORM = "FORM";
    private static final String RINGKASAN = "RINGKASAN";
    private static final int BATAS_STOK = 1000000;

    private JFrame frame;
    private CardLayout navigasi;
    private JPanel kartu;

    private JTextField namaField;
    private JTextField stokField;
    private JTextArea ringkasanArea;

    public Main() {

        frame = new JFrame("Aplikasi Data Barang");

        navigasi = new CardLayout();
        kartu = new JPanel(navigasi);

        namaField = new JTextField(20);
        stokField = new JTextField(20);

        kartu.add(buatPanelForm(), FORM);
        kartu.add(buatPanelRingkasan(), RINGKASAN);

        frame.setContentPane(kartu);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 300);
        frame.setLocationRelativeTo(null);
    }

    private JPanel buatPanelForm() {

        JPanel panel = new JPanel(new BorderLayout(10, 10));

        JLabel judul = new JLabel(
                "FORM DATA BARANG",
                SwingConstants.CENTER);

        JPanel fieldPanel = new JPanel(
                new GridLayout(2, 2, 10, 10));

        fieldPanel.add(new JLabel("Nama Barang:"));
        fieldPanel.add(namaField);

        fieldPanel.add(new JLabel("Stok Awal:"));
        fieldPanel.add(stokField);

        JButton tinjauButton = new JButton("Tinjau");
        JButton bersihkanButton = new JButton("Bersihkan");

        tinjauButton.addActionListener(e -> tampilkanRingkasan());
        bersihkanButton.addActionListener(e -> bersihkanForm());

        JPanel tombolPanel = new JPanel();
        tombolPanel.add(tinjauButton);
        tombolPanel.add(bersihkanButton);

        panel.setBorder(
                BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(judul, BorderLayout.NORTH);
        panel.add(fieldPanel, BorderLayout.CENTER);
        panel.add(tombolPanel, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel buatPanelRingkasan() {

        JPanel panel = new JPanel(new BorderLayout(10, 10));

        JLabel judul = new JLabel(
                "RINGKASAN DATA BARANG",
                SwingConstants.CENTER);

        ringkasanArea = new JTextArea(8, 30);
        ringkasanArea.setEditable(false);

        JButton kembaliButton = new JButton("Kembali");

        kembaliButton.addActionListener(e -> {
            navigasi.show(kartu, FORM);
            namaField.requestFocusInWindow();
        });

        panel.setBorder(
                BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(judul, BorderLayout.NORTH);
        panel.add(new JScrollPane(ringkasanArea), BorderLayout.CENTER);
        panel.add(kembaliButton, BorderLayout.SOUTH);

        return panel;
    }

    private void tampilkanRingkasan() {

        String nama = namaField.getText().trim();
        String teksStok = stokField.getText().trim();

        if (nama.isEmpty()) {
            JOptionPane.showMessageDialog(
                    frame, "Nama barang wajib diisi!");
            namaField.requestFocusInWindow();
            return;
        }

        if (teksStok.isEmpty()) {
            JOptionPane.showMessageDialog(
                    frame, "Stok wajib diisi!");
            stokField.requestFocusInWindow();
            return;
        }

        int stok;

        try {
            stok = Integer.parseInt(teksStok);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    frame, "Stok harus berupa bilangan bulat!");
            stokField.requestFocusInWindow();
            stokField.selectAll();
            return;
        }

        if (stok < 0 || stok > BATAS_STOK) {
            JOptionPane.showMessageDialog(
                    frame, "Stok harus antara 0 sampai 1000000!");
            stokField.requestFocusInWindow();
            stokField.selectAll();
            return;
        }

        String hasil = "Nama Barang : " + nama +
                "\nStok Awal   : " + stok +
                "\n\nData berhasil ditampilkan.";

        ringkasanArea.setText(hasil);

        navigasi.show(kartu, RINGKASAN);
    }

    private void bersihkanForm() {
        namaField.setText("");
        stokField.setText("");
        namaField.requestFocusInWindow();
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            Main aplikasi = new Main();
            aplikasi.frame.setVisible(true);
        });
    }
}
