public class Bahan {
    int kopi;
    int gula;
    int susu;
    int air;
    int coklat;
    int matcha;

    public Bahan(int kopi, int gula, int susu, int air, int coklat, int matcha) {
        this.kopi = kopi;
        this.gula = gula;
        this.susu = susu;
        this.air = air;
        this.coklat = coklat;
        this.matcha = matcha;
    }

    public boolean cekStok(int kopiReq, int gulaReq, int susuReq, int airReq, int coklatReq, int matchaReq) {
        return kopi >= kopiReq && gula >= gulaReq && susu >= susuReq && air >= airReq && coklat >= coklatReq && matcha >= matchaReq;
    }

    public void kurangiStok(int kopiReq, int gulaReq, int susuReq, int airReq, int coklatReq, int matchaReq) {
        kopi -= kopiReq;
        gula -= gulaReq;
        susu -= susuReq;
        air -= airReq;
        coklat -= coklatReq;
        matcha -= matchaReq;
    }

    public void refill(int kopiAdd, int gulaAdd, int susuAdd, int airAdd, int coklatAdd, int matchaAdd) {
        kopi += kopiAdd;
        gula += gulaAdd;
        susu += susuAdd;
        air += airAdd;
        coklat += coklatAdd;
        matcha += matchaAdd;
    }

    public void status() {
        System.out.println("Stok Kopi: " + kopi + ", Gula: " + gula + ", Susu: " + susu + ", Air: " + air + ", Coklat: " + coklat + ", Matcha: " + matcha);
    }
}