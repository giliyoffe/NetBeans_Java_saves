package glassverwaltung;

/**
 * Klasse Trinkglas
 * @author GYoffe
 */
public class Trinkglas 
{
    // Eigenschaften
    private Glasboden boden;
    private double hoehe;
    
    // Konstruktor
    public Trinkglas (double radius, double hoehe)
    {
        this.hoehe = hoehe;
        boden = new Glasboden (radius);
    }
    
    public void verkleinern (double x)
    { // verkleinert den Radius und des Hoehe des Trinkglas-Objekts um x
        hoehe -= x;
        boden.verkleinern(x);
    }
    
    public double flaeche()
    {
        return boden.flaeche() + hoehe * boden.umfang();
    }
    // Methode berechnet das Volumen des Glases
    public double volumen()
    {
        return boden.flaeche() * hoehe;
    }

    // Methode erzeugt eine Zeichenkette mit Trinkglas -Infos
    @Override
    public String toString()
    { // liefert die String-Darstellung des Glasboden-Objekts
        return "Glas(" + boden + ", Hoehe=" + hoehe + ")";
    }
    
}
