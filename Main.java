public class Main {
    public static void main(String[] args) {
        MakhlukHidup budi = new Manusia("Budi");
        MakhlukHidup kucing = new Hewan("Kucing");
        MakhlukHidup mawar = new Tumbuhan("Mawar");
        System.out.println("--- Demo Manusia ---");
        budi.makan();
        budi.bergerak();
        budi.bernafas();
        budi.tumbuh();
        System.out.println("\n--- Demo Hewan ---");
        kucing.makan();
        kucing.bergerak();
        kucing.bernafas();
        kucing.tumbuh();
        System.out.println("\n--- Demo Tumbuhan ---");
        mawar.makan();
        mawar.bergerak();
        mawar.bernafas();
        mawar.tumbuh();
    }
}