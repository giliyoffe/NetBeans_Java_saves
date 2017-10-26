package geometrie;

/**
 * Klasse Kreis beschreibt ein Kreis-Objekt
 * Diese Klasse soll ein Syntax-Beispiel zum Aufbau
 * einer Klasse sein.
 *   
 * @author GYoffe
 */
public class Kreis extends Figur
{ 
    // Eigenschaften (Attribute, Objektvariablen) 
    private double radius;
    
    /**
     * Standard-Konstruktur-Methode 
     */
    public Kreis()
    {
        radius = 0;
    } 
    
    /**
     * Überladene Konstruktur-Methode 
     * @param r ist radius
     */
    public Kreis(double r)
    {
        radius = r;
    } 
    
    // Berechnungsmethoden
    /**
     * 
     * @return Die Berechnung den Fläche
     */
    @Override
    public double berecheFlaeche()
    {
        return  Math.PI * radius * radius;
    }
    
    /**
     * 
     * @return Die Berechnung den Umfang
     */
    @Override
    public double berecheUmfang()
    {
        return  2 * Math.PI * radius;
    }
    
    /**
     * 
     * @return Der Radius
     */
    public double getRadius()
    {
        return radius;
    }
    
    /**
     * 
     * @param r ist radius 
     */
    public void setRadius(double r)
    {
        radius = r;
    }
    
    /**
     * 
     * @return Die Wort "Kreis" und die radius Wert
     */
    // toString-Methode in Klasse Kreis
    @Override
    public String toString()
    {
        return "Kreis (" + radius + ")";
    }
} // Ende der Klasse Kreis
