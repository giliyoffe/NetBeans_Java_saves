package uebungen;

/**
 * Kreditkartenummer und Prüfziffer nach Luhn berechnen und prüfen
 * @author GYoffe
 */
public class pruefZifferberechnungKreditkartePruefen 
{
    public static void main(String[] args) 
    {
        String[] kknr =
        {
            "2718 2818 2845 8567", "5646 8716 8784 8467",
            "1234 5678 9012 3452", "8454 5166 4164 5453",
            "4754 8719 9826 7870"
        };
        for (int i = 0; i < kknr.length; i++) 
        {
            System.out.println(kknr[i] + "  ");
            if ( isKKNummer(kknr[i]) )
                System.out.println(" ist gültig");
            else
                System.out.println(" ist NICHT gültig");
        }
    } // end main
    
    public static boolean isKKNummer(String nummer)
    {
        // Leerzeichen entfernen
        nummer = nummer.replace(" ", "");
        // Prüfen, ob nur 16 Ziffern enthalten sind
        if ( ! nummer.matches("[0-9]{16}"))
            return false;
        // Prüfziffer holen
        int pz = nummer.charAt(nummer.length()-1) - '0'; //minus the 0 in ascii code the result is the int number of that ziffer
        // Prüfziffer nach Luhn berechnen
        int summe = 0;
        for (int i = nummer.length() - 2; i >= 0; i-=2 ) 
        {   // char-Ziffer holen und umwandeln in int
            int zahl = nummer.charAt(i) - '0';
            if( zahl * 2 > 9 ) // falls zahl * 2 zweistellig (doule number (größer als 9))
               summe += zahl * 2 - 9; // "Quersumme für zahlen zwischen 10 und 19"
            else
               summe += zahl * 2;  
            if (i > 0)
               summe += nummer.charAt(i - 1) - '0'; // is like * 1

        }
        int berechnetePz = 10 - summe % 10;
        if( berechnetePz == 10 ) berechnetePz = 0;

        return pz == berechnetePz; // 
    }
} // end class
