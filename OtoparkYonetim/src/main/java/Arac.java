import java.time.LocalDateTime;

public class Arac {
    private String plaka;
    private String marka;
    private String model;
    private String renk;
    private LocalDateTime girisZamani;

    // Constructor
    public Arac(String plaka, String marka, String model, String renk) {
        this.plaka = plaka;
        this.marka = marka;
        this.model = model;
        this.renk = renk;
        this.girisZamani = LocalDateTime.now();
    }

    // Getters and Setters
    // toString() metodu
}
