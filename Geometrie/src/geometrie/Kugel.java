package geometrie;

/**
 * Klasse Kugel beschreibt ein Kugel-Objekt
 * Diese Klasse soll ein Syntax-Beispiel zum Aufbau
 * einer Klasse sein.
 *  
 * @author GYoffe
 */
public class Kugel extends Kreis
{
    /**
     * Standard-Konstruktur-Methode 
     * mit Aufruf des Basis-Konstruktors
     */
    public Kugel()
    {
        super();
    }

    /**
     * Überladene Konstruktur-Methode
     * @param r ist radius von Klasse Kreis
     */
    public Kugel(double r)
    {
        super(r);
    } 
     
    // Berechnungsmethoden
    /**
     * 
     * @return Die Flaeche berechnung, mit ein überschreibende
     * berecheFlaeche() Methode aus Kreis und Nutzung die getRadius() 
     * Methode aus Kreis.
     */
    @Override  // überschreibt berechnenFlaeche() aus Kreis
    public double berecheFlaeche()
    {
        return  4 * Math.PI * super.getRadius() * super.getRadius();
    }
    
    /**
     * 
     * @return Die Berechnung des Volumen
     * mit Nutzung die getRadius() Methode aus Kreis.
     */
    public double berechneVolumen()
    {
        return Math.PI * 4.0/3 * Math.pow(this.getRadius(), 3);
    }
    
    /**
     * 
     * @return Die Wort "Kugel" und des Radius Wert und 
     *         die Wort "Kugelvolumen" und des Volumen Wert und 
     *         die Wort "Kugelumfang" und des umfang Wert und 
     *         die Wort "Kugelfläche" und des fläche Wert. 
     */
    @Override
    public String toString()
    {
      return "Kugel(" + this.getRadius() + ")" + 
             "\nKugelvolumen: " + this.berechneVolumen() +
             "\n Kugelumfang: " + this.berecheUmfang() +
             "\n Kugelfläche: " + this.berecheFlaeche();
    }
} // Ende der Klasse Kugel
