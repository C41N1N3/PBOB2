public class Bahan {
    int kopi;
    int gula;
    int susu;
    int air;
    int coklat;
    int matcha;
    int cocaCola;
    int sprite;
    int fanta;

    public Bahan(int kopi, int gula, int susu, int air, int coklat, int matcha, int cocaCola, int sprite, int fanta) {
        this.kopi = kopi;
        this.gula = gula;
        this.susu = susu;
        this.air = air;
        this.coklat = coklat;
        this.matcha = matcha;
        this.cocaCola = cocaCola;
        this.sprite = sprite;
        this.fanta = fanta;
    }

    public boolean cekStok(int kopiReq, int gulaReq, int susuReq, int airReq, int coklatReq, int matchaReq) {
        return kopi >= kopiReq && gula >= gulaReq && susu >= susuReq && air >= airReq && coklat >= coklatReq && matcha >= matchaReq;
    }

    public boolean cekStok(int cocaColaReq, int spriteReq, int fantaReq) {
        return cocaCola >= cocaColaReq && sprite >= spriteReq && fanta >= fantaReq;
    }

    public void kurangiStok(int kopiReq, int gulaReq, int susuReq, int airReq, int coklatReq, int matchaReq) {
        kopi -= kopiReq;
        gula -= gulaReq;
        susu -= susuReq;
        air -= airReq;
        coklat -= coklatReq;
        matcha -= matchaReq;
    }
    
    public void kurangiStok(int cocaColaReq, int spriteReq, int fantaReq) {
        cocaCola -= cocaColaReq;
        sprite -= spriteReq;
        fanta -= fantaReq;
    }

    public void refill(int kopiAdd, int gulaAdd, int susuAdd, int airAdd, int coklatAdd, int matchaAdd, int sodaAdd) {
        kopi += kopiAdd;
        gula += gulaAdd;
        susu += susuAdd;
        air += airAdd;
        coklat += coklatAdd;
        matcha += matchaAdd;
        cocaCola += sodaAdd;
        sprite += sodaAdd;
        fanta += sodaAdd;
    }

    public void status() {
        System.out.println("Stok Kopi: " + kopi + ", Gula: " + gula + ", Susu: " + susu + ", Air: " + air + ", Coklat: " + coklat + ", Matcha: " + matcha);
        System.out.println("Stok Coca-Cola: " + cocaCola + ", Sprite: " + sprite + ", Fanta: " + fanta);
    }
}
