package latihan_modul3;

public class product {
    private final long kode;
    private final String judul;
    private final int jumlah;

    public product(long kode, String judul, int jumlah) {
        this.kode = kode;
        this.judul = judul;
        this.jumlah = jumlah;
    }

    public long getKode() {
        return kode;
    }

    public String getJudul() {
        return judul;
    }

    public int getJumlah() {
        return jumlah;
    }
}
