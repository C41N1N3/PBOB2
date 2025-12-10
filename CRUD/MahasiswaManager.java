import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class MahasiswaManager{
    public void tampilkanData() {
        Connection conn = KoneksiDB.getConnection();
        try {
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM mahasiswa";
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("\n=== DATA MAHASISWA ===");
            while(rs.next()) {
                System.out.println("NIM: " + rs.getString("nim"));
                System.out.println("Nama: " + rs.getString("nama"));
                System.out.println("Jurusan: " + rs.getString("jurusan"));
                System.out.println("-------------------------");
            }
            conn.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void tambahData(String nim, String nama, String jurusan) {
        Connection conn = KoneksiDB.getConnection();
        try {
            String sql = "INSERT INTO mahasiswa (nim, nama, jurusan) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, nim);
            pstmt.setString(2, nama);
            pstmt.setString(3, jurusan);
            int rows = pstmt.executeUpdate();
            if (rows > 0) System.out.println("Data berhasil disimpan!");
            conn.close();
        } catch (Exception e) {
            System.out.println("Gagal menyimpan: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        MahasiswaManager app = new MahasiswaManager();
        Scanner scan = new Scanner(System.in);
        System.out.println("1. Tampilkan Data");
        System.out.println("2. Tambah Data");
        System.out.print("Pilih menu: ");
        int menu = scan.nextInt();
        scan.nextLine();
        if (menu == 1) {
            app.tampilkanData();
        } else if (menu == 2) {
            System.out.print("Masukkan NIM: ");
            String nim = scan.nextLine();
            System.out.print("Masukkan Nama: ");
            String nama = scan.nextLine();
            System.out.print("Masukkan Jurusan: ");
            String jr = scan.nextLine();
            app.tambahData(nim, nama, jr);
        }
    }
}