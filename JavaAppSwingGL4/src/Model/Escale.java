package Model;

public class Escale {
    private int id;
    private String heureArrivee;  // Format HH:mm:ss
    private String heureDepart;   // Format HH:mm:ss
    private Vol vol;  // Référence vers l'objet Vol associé

    public Escale(String heureArrivee, String heureDepart, Vol vol) {
        this.heureArrivee = heureArrivee;
        this.heureDepart = heureDepart;
        this.vol = vol;
    }

    // Ajoutez des getters et setters si nécessaire

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeureArrivee() {
        return heureArrivee;
    }

    public void setHeureArrivee(String heureArrivee) {
        this.heureArrivee = heureArrivee;
    }

    public String getHeureDepart() {
        return heureDepart;
    }

    public void setHeureDepart(String heureDepart) {
        this.heureDepart = heureDepart;
    }

    public Vol getVol() {
        return vol;
    }

    public void setVol(Vol vol) {
        this.vol = vol;
    }

    // Ajoutez d'autres méthodes si nécessaire
}
