package uebungen;

/**
 * * http://angelika-lorenz.de/pages/ueb/pages/0405pruefalgo.php
 * Klasse beschreibt ein EANNummer zum eingabeprüfen
 * zu prüfen.
 * @author GYoffe
 */
public class EANNummer 
{
    private long nummer;
    // Privater Konstruktor 
    private EANNummer()
    {}
    /**
     * Methode gibt den EANNummer zurück.
     * @return long-Zahl
     */
    public long getNummer() {
        return nummer;
    }
    /**
     *Methode setzt die EAN. Es wird
     * geprüft, ob die long-Zahl einer EAN-Nummer entspricht.
     * @param long-Zahl
     * @exception Exception wenn <i>nummer</i> keine EAN-Nummer ist.
     */
    public void setNummer(long nummer) throws Exception
    {
        this.nummer = preufenNummer(nummer);
    }
    
    /**
     * Konstruktor erzeugt ein EAN-Nummer-Objekt. Es wird
     * geprüft, ob die long-Zahl einer EAN-Nummer ist.
     * @param nummer long-Zahl
     * @exception Exception wenn nummer keine EAN-Nummer ist.
     */
    public EANNummer(long nummer) throws Exception
    {
        this.nummer = preufenNummer(nummer);
    }
    
    
    
    /**
     * Methode erzeugt eine Zeichenkette mit der EAN-Nummer.
     * @return String
     */
    @Override
    public String toString()
    {
        return "EAN " + nummer;
    }
   /**
    * Methode prüft <i>nummer</i> ob diese eine gültige
    * 8-stellige oder 13-stellige EAN-Nummer ist
    * @param nummer long - EAN-Nummer
    * @return geprüfte EAN-Nummer
    * @throws Exception wenn EAN nicht OK.
    */
    public static long preufenNummer(long nummer) 
                                            throws Exception
    {   
//        if ((nummer >= 1000_0000 && nummer <= 9999_9999) 
//            ||( nummer >= 1000_0000_0000_0L && 
//                nummer <= 9999_9999_9999_9L ) )
        
        // Prüfung, ob 8 oder 13 Stellen
        String strEan = Long.toString(nummer);
        if ( ! (strEan.length() == 8 || strEan.length() == 13 ) )
            throw new NumberFormatException("EAN nicht 8 oder 13 Stellig.");
            
        // Prüfziffer holen
        long pz = nummer % 10;
        // Algorithmus zur Berechnung Prüfziffer
        int summe = 0;
        // 
        while (nummer > 0)
        {
            nummer = nummer / 10; // letzte Ziffer entfernen
            summe += (nummer % 10) * 3;
            nummer = nummer / 10; // letzte Ziffer entfernen
            summe += nummer % 10; 
        }
        long berechnetePz = 10 - (summe % 10); // no need for Klama
        if( berechnetePz == 10 ) berechnetePz = 0;
        if( pz != berechnetePz )
            throw new Exception("EAN ungültig!");
        return Long.parseLong(strEan); // Rückgabe der EAN
    } // Ende preufenNummer
} // Ende class
