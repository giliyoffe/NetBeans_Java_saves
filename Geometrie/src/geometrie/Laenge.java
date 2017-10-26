package geometrie;

/**
 * Klasse Laenge dienst zum Längenmaß berechnung 
 * von verschiedene arten von Maßeinheiten.
 *
 * @author GYoffe
 */
public class Laenge 
{
    // Eigenschaften
    private double value;
    private char unit;

    // überladene Konstruktur-Methode 
    public Laenge(double Value, char Unit) 
    {
        value = Value;
        unit = Unit;
    }

    // Berechnungsmethoden
    double tmp;

    public double getMeter() 
    {
        // 39.37007874015748 = 1 (inch) / 0.0254 (meter)
        tmp = value * 39.37007874015748;
        return tmp;
    }

    public double getInch() 
    {
        tmp = value * 0.0254;
        return tmp;
    }

    public double getFoot() 
    {
        tmp = value * 0.3048;
        return tmp;
    }

    public double getYard() 
    {
        tmp = value * 0.9144;
        return tmp;
    }
    
    /**
     *     
     * toString override mit switch um die verschiedenen Maßeinheiten
     * Möglichkeiten zu handhaben.
     * @return Des Anzeige der umrechnung von Inch, Foot und Yard nach Meter
     * und von Meter nach Inch. 
     */
    @Override
    public String toString() 
    {
        double x = 0.0;
        String einheit = "meter";
        switch (unit) {
            case 'm':
                x = getMeter();
                einheit = "inch";
                break;
            case 'i':
                x = getInch();
                break;
            case 'f':
                x = getFoot();
                break;
            case 'y':
                x = getYard();
                break;
            default:
                System.out.println("falsche Eingabe! falsche Umrechnung! "
                        + "\nNutzen Sie: m, i, f oder y");
        }

        return x + " " + einheit;
    }
}
