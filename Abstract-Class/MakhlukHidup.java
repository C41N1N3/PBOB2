public abstract class MakhlukHidup {
    protected String nama;
    public MakhlukHidup(String nama) {
        this.nama = nama;
    }

    public abstract void bernafas();
    public abstract void makan();
    public abstract void bergerak();
    public void tumbuh() {
        System.out.println(this.nama + " sedang tumbuh.");
    }

    public String getNama() {
        return this.nama;
    }
}