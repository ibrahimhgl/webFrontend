import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Otopark otopark = new Otopark(5); // 5 park yeri kapasiteli bir otopark
        Scanner scanner = new Scanner(System.in);

        try {
            // DatabaseHelper nesnesi oluşturuluyor
            DatabaseHelper dbHelper = new DatabaseHelper();

            while (true) {
                System.out.println("\n1. Araç Girişi");
                System.out.println("2. Araç Çıkışı");
                System.out.println("3. Park Durumu");
                System.out.println("4. Çıkış");
                System.out.print("Seçiminiz: ");
                int secim = scanner.nextInt();
                scanner.nextLine(); // satır sonu karakterini temizle

                switch (secim) {
                    case 1: // Araç Girişi
                        System.out.print("Plaka: ");
                        String plaka = scanner.nextLine();
                        System.out.print("Marka: ");
                        String marka = scanner.nextLine();
                        System.out.print("Model: ");
                        String model = scanner.nextLine();
                        System.out.print("Renk: ");
                        String renk = scanner.nextLine();

                        Arac arac = new Arac(plaka, marka, model, renk);
                        otopark.aracGirisi(arac);

                        // Veritabanına ekleme
                        dbHelper.aracEkle(plaka, marka, model, renk);
                        System.out.println("Araç başarıyla kaydedildi ve park edildi.");
                        break;

                    case 2: // Araç Çıkışı
                        System.out.print("Çıkış yapacak aracın plakası: ");
                        String cikisPlaka = scanner.nextLine();
                        otopark.aracCikisi(cikisPlaka);

                        // Veritabanından çıkış işlemi yapılabilir (Opsiyonel)
                        dbHelper.aracCikisi(cikisPlaka);
                        break;

                    case 3: // Park Durumu
                        otopark.parkDurumu();

                        // Veritabanından park durumu görüntüle
                        dbHelper.parkDurumu();
                        break;

                    case 4: // Çıkış
                        System.out.println("Çıkış yapılıyor...");
                        return;

                    default:
                        System.out.println("Geçersiz seçim. Tekrar deneyin.");
                }
            }
        } catch (SQLException e) {
            System.err.println("Veritabanı hatası: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Bir hata oluştu: " + e.getMessage());
        } finally {
            scanner.close(); // Scanner'ı kapat
        }
    }
}
