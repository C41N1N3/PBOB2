public class Hewan extends MakhlukHidup {

    public Hewan(String nama) {
        super(nama);
    }

    @Override
    public void bernafas() {
        System.out.println(this.nama + " bernafas (bisa pakai insang atau paru-paru).");
    }

    @Override
    public void makan() {
        System.out.println(this.nama + " makan (bisa daging atau tumbuhan).");
    }

    @Override
    public void bergerak() {
        System.out.println(this.nama + " bergerak (bisa berenang, terbang, atau berjalan).");
    }
}