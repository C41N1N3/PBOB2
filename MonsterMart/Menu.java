public class Menu {
    String nama;
    int harga;
    int kopiReq;
    int gulaReq;
    int susuReq;
    int airReq;
    int coklatReq;
    int matchaReq;

    public Menu(String nama, int harga, int kopiReq, int gulaReq, int susuReq, int airReq, int coklatReq, int matchaReq) {
        this.nama = nama;
        this.harga = harga;
        this.kopiReq = kopiReq;
        this.gulaReq = gulaReq;
        this.susuReq = susuReq;
        this.airReq = airReq;
        this.coklatReq = coklatReq;
        this.matchaReq = matchaReq;
    }

    @Override
    public String toString() {
        return nama + " - Harga: Rp" + harga;
    }
}
