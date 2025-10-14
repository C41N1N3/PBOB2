public class Bahan {
    int cocaCola;
    int sprite;
    int fanta;

    public Bahan(int cocaCola, int sprite, int fanta) {
        this.cocaCola = cocaCola;
        this.sprite = sprite;
        this.fanta = fanta;
    }

    public boolean cekStok(String namaMinuman) {
        switch (namaMinuman) {
            case "Coca-Cola":
                return cocaCola > 0;
            case "Sprite":
                return sprite > 0;
            case "Fanta":
                return fanta > 0;
            default:
                return false;
        }
    }

    public void kurangiStok(String namaMinuman) {
        switch (namaMinuman) {
            case "Coca-Cola":
                cocaCola--;
                break;
            case "Sprite":
                sprite--;
                break;
            case "Fanta":
                fanta--;
                break;
        }
    }

    public void refill(int jumlah) {
        cocaCola += jumlah;
        sprite += jumlah;
        fanta += jumlah;
    }

    public void status() {
        System.out.println("Stok Coca-Cola: " + cocaCola + ", Sprite: " + sprite + ", Fanta: " + fanta);
    }
}
