import java.util.*;

public class VendingMachine {
    Bahan stok;
    ArrayList<Transaksi> logTransaksi = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    ArrayList<Menu> menu = new ArrayList<>();

    public VendingMachine(Bahan stok) {
        this.stok = stok;
        menu.add(new Menu("Espresso", 10000, 1, 1, 0, 1, 0, 0));
        menu.add(new Menu("Cappuccino", 15000, 1, 1, 1, 1, 0, 0));
        menu.add(new Menu("Latte", 20000, 1, 1, 2, 1, 0, 0));
        menu.add(new Menu("Susu Coklat", 18000, 0, 1, 2, 1, 1, 0));
        menu.add(new Menu("Dark Coklat", 17000, 0, 1, 0, 1, 2, 0));
        menu.add(new Menu("Matcha", 16000, 0, 1, 0, 1, 0, 2));
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
                stok.refill(10, 10, 10, 10, 10, 10);
                System.out.println("Stok berhasil di-refill!");
                continue;
            }

            if (pilihan < 1 || pilihan > menu.size()) {
                System.out.println("Pilihan tidak valid!");
                continue;
            }

            Menu minuman = menu.get(pilihan - 1);

            System.out.print("Pilih ukuran (S/M/L): ");
            String ukuran = sc.nextLine().toUpperCase();
            
            int multiplier = 1;
            switch (ukuran) {
                case "S": multiplier = 1; break;
                case "M": multiplier = 2; break;
                case "L": multiplier = 3; break;
                default:
                    System.out.println("Ukuran tidak valid, menggunakan ukuran S.");
                    ukuran = "S";
                    multiplier = 1;
            }

            System.out.print("Tambahkan gula? + Rp2000 (Y/N): ");
            String tambahGula = sc.nextLine().toUpperCase();

            int extraGula = 0;
            int extraSusu = 0;
            int hargaGula = 0;
            int hargaSusu = 0;

            if (tambahGula.equals("Y")) {
                extraGula = 1;
                hargaGula = 2000;
            }
            
            boolean bolehTambahSusu = !(minuman.nama.equals("Dark Coklat") || minuman.nama.equals("Matcha"));

            if (bolehTambahSusu) {
                System.out.print("Tambahkan susu? + Rp3000 (Y/N): ");
                String tambahSusu = sc.nextLine().toUpperCase();
                if (tambahSusu.equals("Y")) {
                    extraSusu = 1;
                    hargaSusu = 3000;
                }
            }
            
            int kopiReq = minuman.kopiReq * multiplier;
            int gulaReq = (minuman.gulaReq * multiplier) + extraGula;
            int susuReq = (minuman.susuReq * multiplier) + extraSusu;
            int airReq = minuman.airReq * multiplier;
            int coklatReq = minuman.coklatReq * multiplier;
            int matchaReq = minuman.matchaReq * multiplier;

            int totalHarga = (minuman.harga * multiplier) + hargaGula + hargaSusu;

            System.out.println("Total harga: Rp" + totalHarga);
            System.out.print("Bayar: Rp");
            int bayar = sc.nextInt();
            sc.nextLine();

            if (bayar < totalHarga) {
                System.out.println("\nUang kurang, transaksi dibatalkan!\n");
                continue;
            }

            if (!stok.cekStok(kopiReq, gulaReq, susuReq, airReq, coklatReq, matchaReq)) {
                System.out.println("\nStok tidak cukup! Silahkan refill.\n");
                continue;
            }

            stok.kurangiStok(kopiReq, gulaReq, susuReq, airReq, coklatReq, matchaReq);
            System.out.println("\nMembuat minuman... Selesai! Silahkan ambil " + minuman.nama + " ukuran " + ukuran);
            if (bayar > totalHarga) {
                System.out.println("Kembalian: Rp" + (bayar - totalHarga));
            }
            
            System.out.println();
            logTransaksi.add(new Transaksi(minuman.nama, ukuran, totalHarga));
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
