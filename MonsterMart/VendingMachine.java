import java.util.*;

public class VendingMachine {
    Bahan stok;
    ArrayList<Transaksi> logTransaksi = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    ArrayList<Menu> menu = new ArrayList<>();

    public VendingMachine(Bahan stok) {
        this.stok = stok;
        menu.add(new Menu("Coca-Cola", 8000));
        menu.add(new Menu("Sprite", 8000));
        menu.add(new Menu("Fanta", 8000));
    }

    public void tampilkanMenu() {
        System.out.println("=== Menu Vending Machine ===");
        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i + 1) + ". " + menu.get(i));
        }
    }

    public void mulai() {
        while (true) {
            stok.status();
            tampilkanMenu();
            System.out.print("Pilih menu (0 untuk keluar, 99 untuk refill): ");
            int pilihan = sc.nextInt();
            sc.nextLine();

            if (pilihan == 0) break;
            
            if (pilihan == 99) {
                stok.refill(10);
                System.out.println("Stok berhasil di-refill!");
                continue;
            }

            if (pilihan < 1 || pilihan > menu.size()) {
                System.out.println("Pilihan tidak valid!");
                continue;
            }

            Menu minuman = menu.get(pilihan - 1);
            int totalHarga = minuman.harga;

            if (!stok.cekStok(minuman.nama)) {
                System.out.println("\nStok untuk " + minuman.nama + " habis! Silahkan refill.\n");
                continue;
            }

            System.out.println("Total harga: Rp" + totalHarga);
            System.out.print("Bayar: Rp");
            int bayar = sc.nextInt();
            sc.nextLine();

            if (bayar < totalHarga) {
                System.out.println("\nUang kurang, transaksi dibatalkan!\n");
                continue;
            }

            stok.kurangiStok(minuman.nama);
            System.out.println("\nTransaksi berhasil! Silahkan ambil " + minuman.nama);
            if (bayar > totalHarga) {
                System.out.println("Kembalian: Rp" + (bayar - totalHarga));
            }
            System.out.println();
            
            logTransaksi.add(new Transaksi(minuman.nama, totalHarga));
        }
        tampilkanLog();
    }

    public void tampilkanLog() {
        System.out.println("\n=== Log Transaksi ===");
        if (logTransaksi.isEmpty()){
            System.out.println("Tidak ada transaksi.");
        } else {
            for (Transaksi t : logTransaksi) {
                System.out.println(t);
            }
        }
    }
}
