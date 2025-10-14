public class Transaksi {
    String minuman;
    int totalHarga;

    public Transaksi(String minuman, int totalHarga) {
        this.minuman = minuman;
        this.totalHarga = totalHarga;
    }

    @Override
    public String toString() {
        return minuman + " (Botolan) - Total: Rp" + totalHarga;
    }
}
