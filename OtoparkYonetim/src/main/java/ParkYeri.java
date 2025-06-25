public class ParkYeri {
    private int parkYeriNo;
    private boolean doluMu;
    private Arac arac;

    // Constructor
    public ParkYeri(int parkYeriNo) {
        this.parkYeriNo = parkYeriNo;
        this.doluMu = false;
    }

    // Park alanını araca ayır
    public void parkEt(Arac arac) {
        this.arac = arac;
        this.doluMu = true;
    }

    // Park alanını boşalt
    public void parkCikisi() {
        this.arac = null;
        this.doluMu = false;
    }

    // Getters and Setters
}
