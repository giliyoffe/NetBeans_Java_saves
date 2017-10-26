package geometrie;

/**
 * Klasse Dreieck beschreiben ein Dreieck. 
 * Das Dreieck wird durch seine drei Seiten beschrieben.
 * Die Werte der drei Seiten müssen der Dreiecksungleichung.
 * @author GYoffe
 */
public class Dreieck extends Figur implements Comparable<Dreieck>
{ 
    // Eigenschaften: drei Seiten des Dreieck
    private int seiteA;
    private int seiteB;
    private int seiteC;
    
    /**
     * Konstruktor initialisiert die Eigenschaften des Dreiecks.
     * Die drei Seiten müssen der Dreiecksungleichung entsprechen.
     * Eine Dreiecksseite höchstens so lang wie die Summe der beiden
     * anderen Seiten ist.
     * @param seiteA Seitenkante A
     * @param seiteB Seitenkante B
     * @param seiteC Seitenkante C
     * @exception IllegalArgumentException wenn die drei 
     * Seiten nicht der Dreiecksungleichung
     * entsprechen.
     */
    public Dreieck(int seiteA, int seiteB, int seiteC)
    {
        if ( isDreieck(seiteA, seiteB, seiteC))
        {
            this.seiteA = seiteA;    
            this.seiteB = seiteB;
            this.seiteC = seiteC;
        }
        else
        { // werfen eine Exception
            throw new IllegalArgumentException
        ("Werte entsprechen keine Dreieck.");
        }
           
             
    }
    /**
     * Methode prüft, ob drei int-Werte ein Dreieck representieren.
     * Die drei Werte müssen größer 0 sein und der
     * Dreiecksungleichung entsprechen.
     * @param a int-Wert
     * @param b int-Wert
     * @param c int-Wert
     * @return true, wenn Werte einem Dreieck entsprechen.
     */
    public static boolean isDreieck(int a, int b, int c)
    {
        return (a > 0 && b > 0 && c > 0) &&
               (a > b && a > c && a < b + c ) ||
               ( b > a && b > c && b < c + a) ||
               ( c > a && c > b && c < a + b)  ;
    }
    
    /**
     * Standartkonstruktor initialisert das Dreieck mit
     * den Seitenkanten 3 und 4 und 5.
     */
    public Dreieck() 
    {
       seiteA = 3;
       seiteB = 4;
       seiteC = 5; 
    }   
    
    /**
     * Methode liefert den Wert der Seite A.
     * @return Wert der Seite A
     */
    public int getSeiteA() {
        return seiteA;
    }

    /**
     * Methode liefert den Wert der Seite B.
     * @return Wert der Seite B
     */
    public int getSeiteB() {
        return seiteB;
    }

    /**
     * Methode liefert den Wert der Seite C.
     * @return Wert der Seite C
     */
    public int getSeiteC() {
        return seiteC;
    }
    
    /**
     * Methode setzt den Wert der Seite A. Es wird geprüft, ob
     * dieser Seite die Dreieckungleichung weiterhin gilt. 
     * @param seiteA Seitenkante A
     */
    public void setSeiteA(int seiteA) 
    {
        if ( isDreieck(seiteA, this.seiteB, this.seiteC))
        {
            this.seiteA = seiteA;    
        }
        else
        {
            throw new IllegalArgumentException
                  ("Werte entsprechen keine Dreieck.");
        }
    }
    
    /**
     * Methode setzt den Wert der Seite B. Es wird geprüft, ob
     * dieser Seite die Dreieckungleichung weiterhin gilt. 
     * @param seiteB Seitenkante B
     */
    public void setSeiteB(int seiteB) 
    {
        if ( isDreieck(this.seiteA, seiteB, this.seiteC))
        {
            this.seiteB = seiteB;    
        }
        else
        {
            throw new IllegalArgumentException
                  ("Werte entsprechen keine Dreieck.");
        }
    }

    /**
     * Methode setzt den Wert der Seite C. Es wird geprüft, ob
     * dieser Seite die Dreieckungleichung weiterhin gilt. 
     * @param seiteC Seitenkante C
     */
    public void setSeiteC(int seiteC) 
    {
        if ( isDreieck(this.seiteA, this.seiteB, seiteC))
        {
            this.seiteC = seiteC;    
        }
        else
        {
            throw new IllegalArgumentException
                  ("Werte entsprechen keine Dreieck.");
        }
    }
    
    /**
     * Methode liefert eine Zeichenkette mit den 
     * Seitenkanten des Dreieck.
     * @return Zeichenkette
     */
    @Override // überschreibt toString() aus java.lang.object
    public String toString()
    {
        return "Dreieck ( " + seiteA + "," + seiteB + "," + seiteC + ")" ;
    }
    
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
        Dreieck objDreieck = (Dreieck)object;
        return
        ( this.getSeiteA() == objDreieck.getSeiteA() &&
          this.getSeiteB() == objDreieck.getSeiteB() &&
          this.getSeiteC() == objDreieck.getSeiteC()  ) ;
    }
    
    /**
     * Methode vergleich zwei Dreieckobjekte.
     * Mit der Methode können Dreiecke nach der Flächengröße
     * sortieren werden. Ist dieses Dreieck größer als das
     * Dreieck-Objekt, so wird ein positver Wert zurückgegeben.
     * @param dreieck Objekt
     * @return int-Wert
     */
    @Override
    public int compareTo(Dreieck dreieck)
    {
        if ( dreieck == null)
            throw new NullPointerException("Dreieck nicht vorhanden.");
        return (int)(this.berecheFlaeche() - dreieck.berecheFlaeche());
    }
    
    /**
     * Methode berechnet die Fläche des Dreiecks nach der
     * Heronsche Flächenformel: <br>
     * A² = s * (s-a) * (s-b) * (s-c), s = u/2
     * @return Dreiecksfläche
     */
    @Override
    public double berecheFlaeche()
    {
        double s = this.berecheUmfang() / 2;
        return Math.sqrt(s * (s-seiteA) * (s-seiteB) * (s-seiteC));
    }

    /**
     * Methode berechnet die Umfang des Dreiecks   //???
     * @return Umfang des Dreiecks                 //???
     */
   @Override
   public double berecheUmfang()
   {
       return seiteA + seiteB + seiteC;
   }
            
} // Ende class Dreieck

