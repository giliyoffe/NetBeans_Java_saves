package fahrzeugverwaltung;

/**
 * Klasse Pkw enthält die
 * Eigenschaften für ein PKW Fahrzeug. 
 * @author GYoffe
 */
public class Pkw extends Fahrzeug
{
    /**
     * Standardkonstruktur
     */
    public Pkw()
    {}
//        super();  //no need
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
        
        return tage + km * 0.2;
    }

    /**
     * Methode liefert eine Zeichenkette mit Infos zum PKW
     * @return String
     */
    @Override
    public String toString() 
    {
            return "PKW{" + super.toString() + "}";
    }
    
    
}
