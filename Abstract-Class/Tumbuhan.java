public class Tumbuhan extends MakhlukHidup {

    public Tumbuhan(String nama) {
        super(nama);
    }

    @Override
    public void bernafas() {
        System.out.println(this.nama + " bernafas menggunakan stomata (fotosintesis).");
    }

    @Override
    public void makan() {
        System.out.println(this.nama + " makan dengan menyerap nutrisi dari tanah.");
    }

    @Override
    public void bergerak() {
        System.out.println(this.nama + " bergerak secara pasif menuju arah cahaya.");
    }
}