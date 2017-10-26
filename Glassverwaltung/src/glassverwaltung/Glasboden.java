package glassverwaltung;

/**
 *
 * @author GYoffe
 */
public class Glasboden 
{
    // Eigenschaften
    private double radius;
    
    public Glasboden (double radius)
    {
        this.radius = radius;
    }
    
    public void verkleinern (double x)
    { // verkleinert den Radius des Glasboden-Objekts um x
        this.radius = radius - x;
    }
    
    public double flaeche ()
    { // liefert die Flaeche des Glasboden-Objekts
        return Math.PI * this.radius * this.radius;
    }
            
            
    public double umfang ()
    { // liefert die Umfang des Glasboden-Objekts
        return 2 * Math.PI * this.radius;
    }
    
    @Override
    public String toString()
    { // liefert die String-Darstellung des Glasboden-Objekts
        return "Boden(r=" + radius + ")";
    }
        
}
