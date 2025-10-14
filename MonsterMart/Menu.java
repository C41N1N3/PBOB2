public class Menu {
    String nama;
    int harga;

    public Menu(String nama, int harga) {
        this.nama = nama;
        this.harga = harga;
    }

    @Override
    public String toString() {
        return nama + " - Harga: Rp" + harga;
    }
}
