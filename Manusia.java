public class Manusia extends MakhlukHidup {

    public Manusia(String nama) {
        super(nama);
    }

    @Override
    public void bernafas() {
        System.out.println(this.nama + " bernafas menggunakan paru-paru.");
    }

    @Override
    public void makan() {
        System.out.println(this.nama + " makan nasi dan lauk pauk.");
    }

    @Override
    public void bergerak() {
        System.out.println(this.nama + " bergerak dengan berjalan menggunakan dua kaki.");
    }
}