import javax.swing.*;
import java.awt.*;

public class FormPendaftaran extends JFrame {
    public FormPendaftaran() {
        setTitle("Formulir Pendaftaran Kegiatan");
        setSize(550, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout(10, 10));

        JLabel lblTitle = new JLabel("FORMULIR PENDAFTARAN KEGIATAN", JLabel.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitle.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(lblTitle, BorderLayout.NORTH);

        JPanel panelContent = new JPanel();
        panelContent.setLayout(new BoxLayout(panelContent, BoxLayout.Y_AXIS));
        panelContent.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel panelIdentitas = new JPanel(new GridLayout(4, 2, 5, 10));
        panelIdentitas.setBorder(BorderFactory.createTitledBorder("Identitas Peserta"));

        panelIdentitas.add(new JLabel("Nama Lengkap:"));
        JTextField txtNama = new JTextField();
        panelIdentitas.add(txtNama);

        panelIdentitas.add(new JLabel("Email:"));
        JTextField txtEmail = new JTextField();
        panelIdentitas.add(txtEmail);

        panelIdentitas.add(new JLabel("Jenis Kelamin:"));
        JPanel panelGender = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        JRadioButton rbMale = new JRadioButton("Laki-laki");
        JRadioButton rbFemale = new JRadioButton("Perempuan");
        ButtonGroup bgGender = new ButtonGroup();
        bgGender.add(rbMale);
        bgGender.add(rbFemale);
        panelGender.add(rbMale);
        panelGender.add(rbFemale);
        panelIdentitas.add(panelGender);

        panelIdentitas.add(new JLabel("Nomor Telepon:"));
        JTextField txtTelp = new JTextField();
        panelIdentitas.add(txtTelp);

        panelContent.add(panelIdentitas);
        panelContent.add(Box.createRigidArea(new Dimension(0, 10)));

        JPanel panelKegiatan = new JPanel(new GridLayout(2, 1, 5, 5));
        panelKegiatan.setBorder(BorderFactory.createTitledBorder("Pilihan Kegiatan & Fasilitas"));

        JPanel panelSesi = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        panelSesi.add(new JLabel("Pilih Sesi:"));
        String[] sesiOptions = { "Sesi 1: Workshop UI/UX", "Sesi 2: Backend Development", "Sesi 3: Cloud Computing" };
        JComboBox<String> cbSesi = new JComboBox<>(sesiOptions);
        panelSesi.add(cbSesi);
        panelKegiatan.add(panelSesi);

        JPanel panelFasilitas = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
        panelFasilitas.add(new JLabel("Fasilitas: "));
        JCheckBox chkSertifikat = new JCheckBox("Sertifikat");
        JCheckBox chkKonsumsi = new JCheckBox("Konsumsi");
        panelFasilitas.add(chkSertifikat);
        panelFasilitas.add(chkKonsumsi);
        panelKegiatan.add(panelFasilitas);

        panelContent.add(panelKegiatan);
        panelContent.add(Box.createRigidArea(new Dimension(0, 10)));

        JPanel panelCatatan = new JPanel(new BorderLayout(5, 5));
        panelCatatan.setBorder(BorderFactory.createTitledBorder("Catatan / Alasan Mengikuti"));
        JTextArea txtCatatan = new JTextArea(4, 20);
        JScrollPane scrollCatatan = new JScrollPane(txtCatatan);
        panelCatatan.add(scrollCatatan, BorderLayout.CENTER);

        panelContent.add(panelCatatan);

        JScrollPane mainScroll = new JScrollPane(panelContent);
        add(mainScroll, BorderLayout.CENTER);

        JPanel panelButton = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        JButton btnSimpan = new JButton("Daftar");
        JButton btnBatal = new JButton("Batal");
        panelButton.add(btnSimpan);
        panelButton.add(btnBatal);
        add(panelButton, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new FormPendaftaran().setVisible(true);
        });
    }
}
