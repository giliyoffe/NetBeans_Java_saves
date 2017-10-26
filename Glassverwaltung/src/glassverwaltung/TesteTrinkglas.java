package glassverwaltung;

/**
 *
 * @author GYoffe
 */
public class TesteTrinkglas 
{
    public static void main(String[] args) 
    {
        Trinkglas t1 = new Trinkglas (100, 50);
        System.out.println(t1.toString());
        
        while ( t1.flaeche() < t1.volumen() / 8 )
        {
            t1.verkleinern(5);
            System.out.println(t1.toString());
        }
    }
}
