import java.util.Map;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class TechSupport {
    private Map<String, String> responses;
    private Random random;

    public TechSupport() {
        responses = new HashMap<>();
        random = new Random();

        // beberapa pasangan kata kunci → respons
        responses.put("error", "Apakah Anda menerima pesan kesalahan? Coba restart sistem.");
        responses.put("help", "Apa yang bisa saya bantu?");
        responses.put("crash", "Kapan crash terjadi? Apakah ada pesan spesifik?");
        responses.put("slow", "Sudahkah Anda memeriksa penggunaan CPU dan RAM?");
        responses.put("update", "Pastikan sistem operasi dan driver Anda diperbarui.");
        responses.put("internet", "Apakah koneksi internet Anda stabil? Coba restart router.");
        responses.put("password", "Jika Anda lupa password, gunakan fitur 'Lupa Kata Sandi'.");
        responses.put("printer", "Apakah printer sudah dinyalakan dan terhubung ke komputer?");
        responses.put("virus", "Coba jalankan pemindaian antivirus penuh.");
        responses.put("sound", "Periksa apakah volume dan perangkat output audio sudah benar.");
    }

    public String getResponse(String userInput) {
        String[] words = userInput.toLowerCase().split("\\s+");
        for (String w : words) {
            if (responses.containsKey(w)) {
                return responses.get(w);
            }
        }

        // kalau tidak ada kata kunci cocok, jawaban acak generik
        String[] generic = {
            "Coba jelaskan lebih rinci.",
            "Saya belum mengerti, bisa ulangi?",
            "Bisakah Anda memberi detail lebih lanjut?"
        };
        return generic[random.nextInt(generic.length)];
    }

    public static void main(String[] args) {
        TechSupport ts = new TechSupport();
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Sistem Bantuan Teknis ===");
        System.out.println("Ketik pertanyaan Anda (atau ketik 'exit' untuk keluar)");

        while (true) {
            System.out.print("\nAnda: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("TechSupport: Terima kasih telah menggunakan layanan kami!");
                break;
            }

            System.out.println("TechSupport: " + ts.getResponse(input));
        }

        scanner.close();
    }
}
