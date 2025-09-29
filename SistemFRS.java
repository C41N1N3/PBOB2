public class SistemFRS {
    public static void main(String[] args) {
        // 1. Buat beberapa objek Dosen
        Dosen dosenPBO = new Dosen("111", "Dr. Amar Sabir");
        Dosen dosenWeb = new Dosen("222", "Prof. Adzim");
        Dosen dosenStatistika = new Dosen("333", "Bu Rini, M.Sc.");
        Dosen dosenKalkulus = new Dosen("444", "Pak Muqbil, Ph.D.");

        // 2. Buat beberapa objek MataKuliah
        MataKuliah pbo = new MataKuliah("IF101", "Pemrograman Berorientasi Objek", 4, dosenPBO);
        MataKuliah pweb = new MataKuliah("IF102", "Pemrograman Web", 3, dosenWeb);
        MataKuliah statprob = new MataKuliah("MA101", "Statistika & Probabilitas", 3, dosenStatistika);
        MataKuliah kalkulus = new MataKuliah("MA102", "Kalkulus Lanjut", 4, dosenKalkulus);

        // 3. Buat objek Mahasiswa (menggunakan constructor dengan SKS custom 10)
        System.out.println("Membuat mahasiswa Muhammad Akhdan Alwaafy dengan maks SKS 24.");
        Mahasiswa mhs = new Mahasiswa("Muhammad Akhdan Alwaafy", "5025241223", 24);
        
        // 4. Mahasiswa mulai memilih mata kuliah
        mhs.pilihMataKuliah(pbo);
        mhs.pilihMataKuliah(pweb);
        mhs.pilihMataKuliah(statprob);
        mhs.pilihMataKuliah(kalkulus);
        
        // 5. Lihat jadwal setelah pemilihan
        System.out.println("\n--- JADWAL SETELAH PEMILIHAN AWAL ---");
        mhs.lihatJadwal();
        
        System.out.println("\n--- PROSES HAPUS MATA KULIAH ---");
        mhs.hapusMataKuliah("IF102");
        mhs.hapusMataKuliah("XX999");
        
        System.out.println("\n--- JADWAL AKHIR ---");
        mhs.lihatJadwal();
    }
}