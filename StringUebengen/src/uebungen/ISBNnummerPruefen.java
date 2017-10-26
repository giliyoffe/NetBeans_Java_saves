package uebungen;

/**
 * ISBNnummer und Prüfziffer nach Luhn berechnen und prüfen 
 * @author GYoffe
 */
public class ISBNnummerPruefen 
{
    
    static public void main(String[] args)
    {
        String[] isbnNr    =
        {
            "978-3-446-42663-4", "978-3-8266-7504-1",
            "978 - 3 - 8272 - 6665 - 1",
            "978-3-8266-3333-3", // (nicht korrekt)
            "9783815588970"
        };
        for (int i = 0; i < isbnNr.length; i++) 
        {
            System.out.print(isbnNr[i] + "  ");
            if ( isISBN(isbnNr[i]) )
                System.out.println(" ist gültig");
            else
                System.out.println(" ist NICHT gültig");
        }
    } // end main
    
    public static boolean isISBN(String nummer) 
    {
        // Leerzeichen und bindestrich entfernen
        nummer = nummer.replace(" ", "").replace("-", "");
        // Prüfen, ob nur 13 Ziffern enthalten sind
        if ( ! nummer.matches("[0-9]{13}"))
            return false;
        // Prüfziffer holen
        int pz = nummer.charAt(nummer.length()-1) - '0'; //minus the 0 in ascii code the result is the int number of that ziffer
        // Prüfziffer nach Luhn berechnen
        int summe = 0;
        for (int i = nummer.length() - 2; i >= 0; i-=2 ) 
        {   // char-Ziffer holen und umwandeln in int
            int zahl = nummer.charAt(i) - '0'; // zahl = 3 (its place [11] in 1st zahl. i = place 11 is 3
               summe += zahl * 3;  
          //  if (i > 0) // no need cuz the number is ungerade/uneven zahl (13)
               summe += nummer.charAt(i - 1) - '0'; // is like * 1

        }
        int berechnetePz = 10 - summe % 10;
        if( berechnetePz == 10 ) berechnetePz = 0;

        return pz == berechnetePz; // 
    }
} // end class
