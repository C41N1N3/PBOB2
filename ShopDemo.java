public class ShopDemo {

    public static void main(String[] args) {
        SalesItem laptop = new SalesItem("Laptop Super", 20000000);
        System.out.println("Menambahkan komentar...");
        laptop.addComment("Andi", "Luar biasa, sangat cepat!", 5);
        laptop.addComment("Beni", "Baterainya agak boros.", 3);
        boolean statusGagal = laptop.addComment("Citra", "Tidak bisa memberi rating 0", 0);
        System.out.println("\nMenampilkan info produk:");
        laptop.showInfo();
        System.out.println("\nMenghapus komentar kedua (index 1)...");
        laptop.removeComment(1);
        System.out.println("\nMenampilkan info produk setelah dihapus:");
        laptop.showInfo();
        System.out.println("\nMencoba menghapus index 99...");
        laptop.removeComment(99);
        
        System.out.println("Program selesai.");
    }
}