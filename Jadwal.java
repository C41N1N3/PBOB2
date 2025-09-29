import java.util.ArrayList;

public class Jadwal {
    private ArrayList<MataKuliah> daftarMataKuliah;
    private int maksSKS;
    private int totalSKS;

    public Jadwal(int maksSKS) {
        this.maksSKS = maksSKS;
        this.totalSKS = 0;
        this.daftarMataKuliah = new ArrayList<>();
    }

    public boolean tambahMataKuliah(MataKuliah mk) {
        if ((totalSKS + mk.getSKS()) <= maksSKS) {
            daftarMataKuliah.add(mk);
            totalSKS += mk.getSKS();
            return true;
        } else {
            return false;
        }
    }

    public boolean hapusMataKuliah(String kodeMK) {
        for (int i = 0; i < daftarMataKuliah.size(); i++) {
            MataKuliah mk = daftarMataKuliah.get(i);
            if (mk.getKodeMK().equals(kodeMK)) {
                totalSKS -= mk.getSKS();
                daftarMataKuliah.remove(i);
                return true;
            }
        }
        return false;
    }

    public void tampilkanJadwal() {
        System.out.println("--- Daftar Mata Kuliah yang Diambil ---");
        if (daftarMataKuliah.isEmpty()) {
            System.out.println("Belum ada mata kuliah yang dipilih.");
        } else {
            for (MataKuliah mk : daftarMataKuliah) {
                System.out.println(mk.getInfo());
            }
        }
        System.out.println("Total SKS: " + totalSKS + " / " + maksSKS);
        System.out.println("---------------------------------------");
    }
}