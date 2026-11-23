package latihan_modul3;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.List;

class DemoProductTable {

    static class Product {
        private final Long kode;
        private final String judul;
        private final Integer jumlah;

        Product(Long kode, String judul, Integer jumlah) {
            this.kode = kode;
            this.judul = judul;
            this.jumlah = jumlah;
        }

        Long getKode() {
            return kode;
        }

        String getJudul() {
            return judul;
        }

        Integer getJumlah() {
            return jumlah;
        }
    }

    static class ProductModel extends AbstractTableModel {
        private  final String[] headers = {"kode", "judul", "jumlah"};

        private final List<Product> items;

        ProductModel(List<Product> items) {
            this.items = items;
        }

        Product getAt(int modelRow) {
            return items.get(modelRow);
        }

        @Override
        public int getRowCount() {
            return  items.size();
        }

        @Override
        public String getColumnName(int col) {
            return headers[col];
        }

        @Override
        public int getColumnCount() {
            return  headers.length;
        }

        @Override
        public boolean isCellEditable(int row, int col) {
            return false;
        }

        @Override
        public Class<?> getColumnClass(int col) {
            return switch (col) {
                case 0 -> Long.class;
                case 1 -> String.class;
                case 2 -> Integer.class;

                default -> Object.class;
            };

        }

        @Override
        public Object getValueAt(int row, int col) {
            Product p = items.get(row);

            return switch (col){
                case 0 -> p.getKode();
                case 1 -> p.getJudul();
                case 2 -> p.getJumlah();
                default ->  null;
            };
        }


    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            ProductModel model = new ProductModel(List.of(
                    new Product(11L, "Keyboard", 100),
                    new Product(12L, "Mouse", 20),
                    new Product(13L, "Monitor", 2)
            ));

            JTable table = new JTable(model);

            table.setAutoCreateRowSorter(true);

            JButton cekBtn = new JButton("Cek Kode");

            cekBtn.addActionListener(e -> {
                int viewRow = table.getSelectedRow();

                if (viewRow < 0 ) return;

                int modelRow = table.convertRowIndexToModel(viewRow);

                Product dipilih = model.getAt(modelRow);

                JOptionPane.showMessageDialog(null, "Kode dipilih: " + dipilih.getKode());
            });

            JFrame frame = new JFrame("Latihan Table");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new JScrollPane(table), BorderLayout.CENTER);
            frame.add(cekBtn, BorderLayout.SOUTH);
            frame.setSize(420, 260);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}