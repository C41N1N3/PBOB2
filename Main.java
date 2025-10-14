public class Main {
    public static void main(String[] args) {
        Bahan stokAwal = new Bahan(10, 10, 10, 10, 10, 10);
        VendingMachine vm = new VendingMachine(stokAwal);
        vm.mulai();
    }
}