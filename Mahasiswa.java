public class Mahasiswa {
    private String nama;
    private String nrp;
    private Jadwal jadwal;

    public Mahasiswa(String nama, String nrp, int maksSKS) {
        this.nama = nama;
        this.nrp = nrp;
        this.jadwal = new Jadwal(maksSKS);
    }
    
    public void pilihMataKuliah(MataKuliah mk) {
        System.out.println(nama + " mencoba memilih mata kuliah: " + mk.getInfo().split("\n")[1]);
        boolean berhasil = jadwal.tambahMataKuliah(mk);
        if (berhasil) {
            System.out.println(">> Berhasil ditambahkan!\n");
        } else {
            System.out.println(">> GAGAL! Batas SKS akan terlampaui.\n");
        }
    }

    public void hapusMataKuliah(String kodeMK) {
        System.out.println(nama + " mencoba menghapus mata kuliah dengan kode: " + kodeMK);
        boolean berhasil = jadwal.hapusMataKuliah(kodeMK);
        if (berhasil) {
            System.out.println(">> Berhasil dihapus!\n");
        } else {
            System.out.println(">> GAGAL! Mata kuliah dengan kode tersebut tidak ditemukan di jadwal.\n");
        }
    }
    // --------------------
    
    public void lihatJadwal() {
        System.out.println("Jadwal untuk " + nama + " (NRP: " + nrp + ")");
        jadwal.tampilkanJadwal();
    }
}