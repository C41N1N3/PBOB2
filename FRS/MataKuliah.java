public class MataKuliah {
    private String kodeMK;
    private String namaMK;
    private int sks;
    private Dosen dosen;

    public MataKuliah(String kodeMK, String namaMK, int sks, Dosen dosen) {
        this.kodeMK = kodeMK;
        this.namaMK = namaMK;
        this.sks = sks;
        this.dosen = dosen;
    }

    /**
     * Mengembalikan kode mata kuliah.
     */
    public String getKodeMK() {
        return kodeMK;
    }

    public int getSKS() {
        return sks;
    }

    public String getInfo() {
        return "Kode: " + kodeMK + "\n" +
               "Nama: " + namaMK + "\n" +
               "SKS: " + sks + "\n" +
               dosen.getInfo() + "\n";
    }
}
