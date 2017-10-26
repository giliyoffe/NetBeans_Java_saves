
package geometrie;

/**
 * Abstrakte Klasse Figur legt fest, 
 * dass für jede geometrische Figur
 * Flächeninhalt und Umfang zu berechnen sind.
 * @author GYoffe
 */
public abstract class Figur 
{
    
    /**
     * Methode zur berechnung des Flächeninhaltes
     * von geometrischen Figuren.
     * @return Flächeninhaltes
     */
    public abstract double berecheFlaeche();
    /**
     * Methode zur berechnung des Umfangs
     * von geometrischen Figuren.
     * @return Umfang
     */
    public abstract double berecheUmfang();
    
}
