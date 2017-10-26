package fahrzeugverwaltung;

/**
 * Abstrakte Klasse Fahrzeug enthält alle generellen
 * Eigenschaften der Fahrzeug. 
 * @author GYoffe
 *  ** Datei: Klassendiagramm_Fahrzeugverwaltung_Blatt_6_Seite_6-7.docx
 */
public abstract class Fahrzeug 
{
    private String kennzeichen;
    private double kmStand;
    private boolean vermitet = false;
    
    /**
     * Standardkonstruktur
     */
    public Fahrzeug()
    {}
//        kennzeichen = "";  // no need
//        kmStand = 0;
//        vermitet = false;
//    }
    
    /**
     * Abstakte Methode zur Berechnung des Mitpreises.
     * @param tage Anzahl der Vermietungstage.
     * @param km Länge der gefahrenen Kilometer
     * @return Nettopreis der Vermietung
     */
    public abstract double berechnenMietpreis(int tage, double km);

    /**
     * Methode gibt den Fahrzeug Kennzeichen zurück
     * @return String Kennzeichen
     */
    public String getKennzeichen() {
        return kennzeichen;
    }

    /**
     * Methode gibt den Kilometerstand zurück
     * @return Kilometerstand Kilometerstand
     */
    public double getKmStand() {
        return kmStand;
    }

    /**
     * Methode gibt den Vermietungsstatus zurück.
     * @return Vermietungsstatus
     */
    public boolean isVermitet() {
        return vermitet;
    }

    /**
     * Methode setzt den kennzeichen 
     * @param kennzeichen kennzeichen 
     */
    public void setKennzeichen(String kennzeichen) {
        this.kennzeichen = kennzeichen;
    }

     /**
     * Methode setzt den kmStand 
     * @param kmStand kmStand 
     */
    public void setKmStand(double kmStand) {
        this.kmStand = kmStand;
    }

    /**
     * Methode setzt den Vermietungsstand
     * @param vermitet Vermietungsstand
     */
    public void setVermitet(boolean vermitet) {
        this.vermitet = vermitet;
    }

    /**
     * Methode liefert eine Zeichenkette mit Infos zum Fahrzeug
     * @return String
     */
    @Override // überschreibt toString() aus java.lang.object
    public String toString()
    {
        String text;
        if (this.vermitet)
            text = "vermitet";
        else
            text = "verleihbar";
        return kennzeichen + ", " + kmStand + " km, " + text;
    }
    
    
}
