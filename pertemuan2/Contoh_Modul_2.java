import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;

public class Contoh_Modul_2 {
    private final int limit_stok = 1000;
    private final JFrame frame = new JFrame("Contoh Modul 2");
    private final JTextField NamaField = new JTextField(20);
    private final JTextField StokField = new JTextField(20);

    public Contoh_Modul_2() {
        tampilan();
    }

    private void tampilan() {
        JPanel fieldPanel = new JPanel(new GridLayout(0, 2, 5, 5));
        fieldPanel.add(new JLabel("Nama Barang:"));
        fieldPanel.add(NamaField);
        fieldPanel.add(new JLabel("Stok Barang:"));
        fieldPanel.add(StokField);

        JButton tombol = new JButton("Simpan");
        tombol.addActionListener(event -> {
            if (!periksaInput()) {
                return;
            }

            String namaBarang = NamaField.getText().trim();
            int stokBarang;
            try {
                stokBarang = Integer.parseInt(StokField.getText().trim());
            } catch (NumberFormatException e) {
                tampilkanPesan("Stok harus berupa angka. Silakan masukkan angka yang valid.", StokField);
                return;
            }

            if (stokBarang < 0) {
                tampilkanPesan("Stok tidak boleh bernilai negatif.", StokField);
            } else if (stokBarang > limit_stok) {
                tampilkanPesan("Stok melebihi batas maksimum: " + limit_stok, StokField);
            } else {
                JOptionPane.showMessageDialog(frame,
                        "Data berhasil disimpan:\nNama Barang: " + namaBarang + "\nStok Barang: " + stokBarang);
            }
        });
        fieldPanel.add(new JLabel());
        fieldPanel.add(tombol);

        frame.getContentPane().add(fieldPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private boolean periksaInput() {
        if (NamaField.getText().trim().isEmpty()) {
            tampilkanPesan("Nama dan Stok tidak boleh kosong. Silakan isi semua field.", NamaField);
            return false;
        }
        if (StokField.getText().trim().isEmpty()) {
            tampilkanPesan("Nama dan Stok tidak boleh kosong. Silakan isi semua field.", StokField);
            return false;
        }
        return true;
    }

    private void tampilkanPesan(String pesan, JTextField field) {
        JOptionPane.showMessageDialog(frame, pesan);
        field.requestFocus();
        field.selectAll();
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(Contoh_Modul_2::new);
    }
}
