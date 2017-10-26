package geometrie;

/**
 * Klasse Parallelogramm beschreibt ein Parallelogramm-Objekt
 * Diese Klasse soll ein Syntax-Beispiel zum Aufbau
 * einer Klasse sein.
 *  
 * @author GYoffe
 */
public class Parallelogramm extends Rechteck
{
    // Eigenschaften Grundkante und Seitenkante werden vererbt
    private int hoehe; // Zusätliche Eigenschaften des Parallelogramms
    
    /**
     * Standard-Konstruktur-Methode 
     * mit Aufruf des Basis-Konstruktors
     */
    public Parallelogramm()
    {
        super(); // Aufruf des Basis-Konstruktors
        hoehe = 0;
    }
    
    /**
     * Überladene Konstruktur-Methode
     * @param gk ist grundkante von der Klasse Rechteck
     * @param sk ist seitenkante von der Klasse Rechteck
     * @param h ist die hoehe
     */
    public Parallelogramm(int gk, int sk, int h)
    {
        super(gk, sk); // Aufruf des Konstruktors der Klasse Rechteck
        hoehe = h;
    }
    
    /**
     * 
     * @param h ist die hoehe
     */
    public void setHoehe(int h)
    {
        hoehe  = h;
    }
    
    /**
     * 
     * @return Die hoehe
     */
    public int getHoehe()
    {
        return hoehe;
    }
    
    /**
     * 
     * @return Die Flaeche berechnung, mit ein überschreibende
     * berecheFlaeche() Methode aus Rechteck und Nutzung die getGrundkante() 
     * Methode aus Rechteck.
     */
    @Override // überschreibt berecheFlaeche() aus Rechteck
    public double berecheFlaeche()
    {
        return super.getGrundkante() * hoehe;
    }
    
    /**
     * 
     * @return Die Wort "Parallelogramm" und die Werte 
     * grundkante, seitenkante und hoehe.
     */
    @Override // überschreibt toString() aus Rechteck
    public String toString()
    {
        return "Parallelogramm (" + super.getGrundkante() + ", "
                + super.getSeitenkante() + ", " + hoehe +")";
    }
} // Ende der Klasse Parallelogramm
