package mik.easj.skole.restjsonlist;



public class Passager {

    private int Id;
    private String Navn;
    private double BagageVaegt;
    private String Efternavn;
    private int BagageAntal;
    private int FlyNummer;


    public Passager()
    {}



    public Passager(int id, String navn, double bagageVaegt, String efternavn, int bagageAntal, int flyNummer) {
        this.Id = id;
        this.Navn = navn;
        this.BagageVaegt = bagageVaegt;
        this.Efternavn = efternavn;
        this.BagageAntal = bagageAntal;
        this.FlyNummer = flyNummer;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNavn() {
        return Navn;
    }

    public void setNavn(String navn) {
        Navn = navn;
    }

    public double getBagageVaegt() {
        return BagageVaegt;
    }

    public void setBagageVaegt(double bagageVaegt) {
        BagageVaegt = bagageVaegt;
    }

    public String getEfternavn() {
        return Efternavn;
    }

    public void setEfternavn(String efternavn) {
        Efternavn = efternavn;
    }

    public int getBagageAntal() {
        return BagageAntal;
    }

    public void setBagageAntal(int bagageAntal) {
        BagageAntal = bagageAntal;
    }

    public int getFlyNummer() {
        return FlyNummer;
    }

    public void setFlyNummer(int flyNummer) {
        FlyNummer = flyNummer;
    }

    @Override
    public String toString() {
        return Navn;
    }
}
