public class Transaksi {
    String minuman;
    String ukuran;
    int totalHarga;

    public Transaksi(String minuman, String ukuran, int totalHarga) {
        this.minuman = minuman;
        this.ukuran = ukuran;
        this.totalHarga = totalHarga;
    }

    @Override
    public String toString() {
        return minuman + " (" + ukuran + ") - Total: Rp" + totalHarga;
    }
}
