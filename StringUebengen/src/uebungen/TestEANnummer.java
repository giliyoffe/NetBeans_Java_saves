package uebungen;

/**
 *
 * @author GYoffe
 */
public class TestEANnummer 
{
    public static void main(String[] args) throws Exception
    {
        
        /** from IBANPruefen klass
//test
String iban = "DE";
 //take first 2 letters for land and convert to numbers
        int landChar1 = iban.charAt(0) -64; // A = 65
        int landChar2 = iban.charAt(1) -64;
        // add 9 to each new number from the letters
        landChar1 += 9;
        landChar2 += 9;
        // place the numbers side by side to create a new number/String
        String landNr = landChar1+""+landChar2;
        System.out.println(landNr);
        
        **/
      
        
        
        long[] eanLong = {4012994952055L, 29005109, 20153250, 5705831105065L, 
            4305615043685L, -12345678, 29049805};
        EANNummer[] ean = new EANNummer[eanLong.length];
        for ( int i = 0; i < ean.length; i++ )
        {
            try
            {
            ean[i] = new EANNummer(eanLong[i]);
            System.out.println(ean[i]);
            } catch (Exception e)
            {
                System.out.println(eanLong[i] + " " + e.getMessage());
            }
        }
    }
}
