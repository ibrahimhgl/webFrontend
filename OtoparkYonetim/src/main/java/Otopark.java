import java.util.ArrayList;
import java.util.List;

public class Otopark {
    private List<ParkYeri> parkYerleri;

    public Otopark(int kapasite) {
        parkYerleri = new ArrayList<>();
        for (int i = 1; i <= kapasite; i++) {
            parkYerleri.add(new ParkYeri(i));
        }
    }

    public void aracGirisi(Arac arac) {
        for (ParkYeri parkYeri : parkYerleri) {
            if (!parkYeri.isDoluMu()) {
                parkYeri.parkEt(arac);
                System.out.println("Araç başarıyla park edildi: " + arac.getPlaka());
                return;
            }
        }
        System.out.println("Maalesef otopark dolu.");
    }

    public void aracCikisi(String plaka) {
        for (ParkYeri parkYeri : parkYerleri) {
            if (parkYeri.isDoluMu() && parkYeri.getArac().getPlaka().equals(plaka)) {
                parkYeri.parkCikisi();
                System.out.println("Araç otoparktan çıkarıldı: " + plaka);
                return;
            }
        }
        System.out.println("Belirtilen plakada bir araç bulunamadı.");
    }

    public void parkDurumu() {
        for (ParkYeri parkYeri : parkYerleri) {
            if (parkYeri.isDoluMu()) {
                System.out.println("Park Yeri " + parkYeri.getParkYeriNo() + " - DOLU - " +
                        parkYeri.getArac().getPlaka());
            } else {
                System.out.println("Park Yeri " + parkYeri.getParkYeriNo() + " - BOŞ");
            }
        }
    }
}
