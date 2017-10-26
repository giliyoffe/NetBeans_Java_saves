package geometrie;

/**
 * Klasse Rechteck beschreibt ein Rechteck-Objekt
 * Diese Klasse soll ein Syntax-Beispiel zum Aufbau
 * einer Klasse sein.
 * 
 * @author GYoffe
 */
public class Rechteck extends Figur implements Comparable<Rechteck>
{
    // Eigenschaften (Attribute, Objektvariablen) 
    private int grundkante;
    private int seitenkante;
    
    /**
     * Standard-Konstruktur-Methode 
     */
    public Rechteck()
    {
        grundkante  = 0;
        seitenkante = 0;
    }
    
    /**
     * Überladene Konstruktur-Methode 
     * @param gk ist grundkante
     * @param sk ist seitenkante
     */
    public Rechteck(int gk, int sk)
    {
        grundkante = gk;
        seitenkante = sk;
        
    }
    
    /**
     * 
     * @param gk ist grundkante
     */
    // Zugriffsmethoden realisiern den Zugriff auf die Eigenschaften
    // Prinzip der Daten der Datenkapselung
    public void setGrundkante(int gk)
    {
        grundkante = gk;
    }
    
    /**
     * 
     * @param sk ist seitenkante
     */
    public void setSeitenkante(int sk)
    {
        seitenkante = sk;
    }
    
    /**
     * 
     * @return Grundkante
     */
    public int getGrundkante()
    {
        return grundkante;
    }
    
    /**
     * 
     * @return Seitenkante
     */
    public int getSeitenkante()
    {
        return seitenkante;
    }
    
    // Berechnungsmethoden
    /**
     * 
     * @return Umfang (nach berechnung)
     */
    @Override
    public double berecheUmfang()
    {
        return 2 * (grundkante + seitenkante);
    }
    
    /**
     * 
     * @return Flaeche (nach berechnung)
     */
    @Override
    public double berecheFlaeche()
    {
        return grundkante * seitenkante;
    }
    
    /**
     * Methode gibt eine Zeichenkette mit folgender Aussage zurück:
     * {@code Rechteck (grundkante, seitenkante)}
     * @return Die Wort "Rechteck" und die Werte grundkante und seitenkante
     */
    // toString-Methode in Klasse Rechteck 
    @Override // überschreibt toString() aus java.lang.object
    public String toString()
    {
        return "Rechteck (" + grundkante + ", " + seitenkante + ")";
    }
    
    //30.09.2016 - Blatt 6 / Seite 2 - Gleichenkeit von Objekten
    @Override
    public boolean equals(Object object)
    {
        // falls die object-Referenz null ist oder auf ein
        // Objekt von Typ einer anderen Klasse zeigt.
        if ( object == null || object.getClass() != this.getClass() )
        {
            return false; // Objekte sind nicht gleich
        }
        // Object-Referenz wird als Referenz auf ein  Rechteck gekennzeichnet,
        // um den Aufruf der Rechteck-Methode zu ermöglichen.
        Rechteck objRechteck = (Rechteck)object;
        return
        ( this.getGrundkante() == objRechteck.getGrundkante() &&
          this.getSeitenkante() == objRechteck.getSeitenkante() ) ||
        ( this.getGrundkante() == objRechteck.getSeitenkante() &&
          this.getSeitenkante() == objRechteck.getGrundkante() ) ;
    }
    /**
     * Methode veergleicht zwei Objekte.<br>
     * Sind die Objekte gleich wird ein Wert 0 zurückgegeben.
     * Ist dieses Objekt im Sinne der "natürlichen Ordnung" größer,
     * wird eine positive Zahl zurückgegeben; ist es kleiner,
     * wird eine negative Zahl zurückgegeben.<br>
     * Rechtecke können nach der Größe (d.h. nach dem Flächeninhalt)
     * sortieren werden.
     * @param rechteck ein Rechteck-Objekt
     * @return int-Wert gibt die Reihenfolge an
     * @throws NullPointerException falls Rechteck nicht vorhanden.
     */
    @Override
    public int compareTo(Rechteck rechteck) throws NullPointerException //throws NullPointerException - can be deleted.
    {
        if (rechteck == null)
        {    
            throw new NullPointerException ("Rechteckobjekt ist nicht vorhanden");
        }
      return (int)(this.berecheFlaeche() - rechteck.berecheFlaeche());
    }
    
} // Ende der Klasse Rechteck
