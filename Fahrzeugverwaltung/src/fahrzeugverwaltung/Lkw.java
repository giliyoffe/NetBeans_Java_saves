package fahrzeugverwaltung;

/**
 * Klasse Lkw enthält die
 * Eigenschaften für ein LKW Fahrzeug. 
 * @author GYoffe
 */
public class Lkw extends Fahrzeug
{
    private double nutzlast;
    
    /**
     * Standardkonstruktur
     */
    public Lkw()
    {}
//        super(); // no need
//    }
    
    /**
     * Methode zur Berechnung des Mitpreises.
     * @param tage Anzahl der Vermietungstage.
     * @param km Länge der gefahrenen Kilometer
     * @return Nettopreis der Vermietung
     */
    @Override
    public double berechnenMietpreis(int tage, double km)
    {
        // addieren den gefahren km zum kmStand
        this.setKmStand(this.getKmStand() + km); 
        
        if (nutzlast > 1800)
        {
           return 80 * tage + km * 0.2;
        }
        else
        {
           return 50 * tage + km * 0.2;
        }
    }

    /**
     * Methode gibt den Nutzlast zurück
     * @return nutzlast Nutzlast
     */
    public double getNutzlast() {
        return nutzlast;
    }

    /**
     * Methode setzt den Nutzlast 
     * @param nutzlast Nutzlast 
     */
    public void setNutzlast(double nutzlast) {
        this.nutzlast = nutzlast;
    }
    
    /**
     * Methode liefert eine Zeichenkette mit Infos zum LKW
     * @return String
     */
    @Override
    public String toString() 
    {
            return "LKW{" + super.toString() + ", Nutzlast: " + nutzlast +" kg }";
    }

//    @Override // überschreibt toString() aus java.lang.object
//    public String toString()
//    {
//       return "Fahrzeug: " + super.getKennzeichen() + ", Rechnungsbetrag: " ;
//        
//    }
    
}
