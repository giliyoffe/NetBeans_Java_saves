/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uebungen;

import java.math.BigInteger;

/**
 *
 * @author GYoffe
 */


public class IBANPruefen 
{
    public static void main(String[] args) 
    {

        String[] ibans = { 
                            "DE 08 7009 0100 1234 5678 90",
                            "DE79 1001 0010 0012 3456 78",
                            "DE49 5001 0010 0012 3456 78",
                            "DE60 1234 5678 0012 3456 78",
                            "DE60 1254 5678 0012 3456 78*",
                            "XE60 1234 5678 0012 3456 78*",
                            "AT161234500012345678",
                            "CH6612345000012345678",
                            "BE64123012345678"
                        };
        
        for (int i = 0; i < ibans.length; i++) 
        {
            System.out.print(ibans[i] + "  ");
            if ( isIBAN(ibans[i]) )
                System.out.println(" ist gültig");
            else
                System.out.println(" ist NICHT gültig");
        }
    }

//lorenz
 
    public static boolean isIBAN(String strIban)
    {

////lorenz --- --               not finished!!!!

        // Leerzeichen entfernen
        strIban = strIban.replace(" ", "");
        
        // Länderkennung prüfen und berechnen
        String land = strIban.substring(0, 2).toUpperCase();
        
        if (! land.matches("[A-Z]{2}")) // nur Buchstaben erlaubt
            return false;
        land = berechnenLaenderzahl(land);

        // Prufziffer ermitteln
        String strPruefziffer = strIban.substring(2,4);
        if ( ! strPruefziffer.matches("[0-9]{2}"))
            return false;
        int pruefziffer = Integer.parseInt(strPruefziffer);
        //BBAN ermitteln
        String strBban = strIban.substring(4);
        if ( ! strBban.matches("[0-9]+") )
            return false;
        // Länder erkennung un "00" an BBAN anhängen
        String strZahl = strBban + land + "00";
        // Grße Zahl erstellen und Pruefziffer berechnen
        BigInteger zahl = new BigInteger(strZahl);
        BigInteger rest = zahl.mod(BigInteger.valueOf(97L));
        int berechnetePruefziffer = 98 - rest.intValue();
        return berechnetePruefziffer == pruefziffer; 
        
    }
    
    private static String berechnenLaenderzahl(String land)
    {
        // A entspricht 65 --> -64+9 ergibt -55
        int buchstabenzahl = land.charAt(0) - 55;
        String rueckgabe = Integer.toString(buchstabenzahl);
        // zweiten Buchstaben berechnen
        buchstabenzahl = land.charAt(1) - 55;
        // Rückgabe beides zusammen
        return rueckgabe + Integer.toString(buchstabenzahl);
    }
}

// lorenz




  /**
   * me
   * // Leerzeichen und Sternchen entfernen
        iban = iban.replace(" ", "")//.replace("*", ""); //DE08700901001234567890
        // Prüft, ob 22 Stellige 
        if ( ! iban.matches("[A-Z]{2}[0-9]{20}"))
          return false;


        //take first 2 letters for land and convert to numbers
        int landChar1 = iban.charAt(0) -64; // A = 65
        int landChar2 = iban.charAt(1) -64;
        // add 9 to each new number from the letters        //or can in last step -55(cuz its 64-9)
        landChar1 += 9;
        landChar2 += 9;
        // place the numbers side by side to create a new number/String
        String landNr = landChar1+""+landChar2;
        BigInteger landBI = new BigInteger(landNr);  // need?
        // add the new number to the end of the rest of the number
        //BigInteger ibanBI = new BigInteger(iban); // iban with DE
        
        // save the first 2 digits as pz and the rest of the number as a diffrent number
        String pz = iban.substring(2,3);
//        int pz1 = iban.charAt(2);
//        int pz2 = iban.charAt(3);
//        String pz = pz1+""+pz2;
        String rest = iban.substring(4,19);
        // add the land number 
        String restUndLand = rest+""+landNr;
        // and 2 zeros to the end of the number(the long one)
        BigInteger ibanbefore2zeroes = new BigInteger(restUndLand);
        ibanbefore2zeroes = ibanbefore2zeroes.multiply(ibanbefore2zeroes 100);
        // BigInteger ibanBIfinished = new BigInteger(ibanbefore2zeroes * 100);
        // the number modulo 97
        
        // 98 minus the result of the modulo
        
        // result from last step ewuals to pz
        
        
                // String nummer = BigInteger(ibans[i]);

       // BigInteger ibanBI = new BigInteger;
//        BigInteger(String val)
//          Translates the decimal String representation of a BigInteger into a BigInteger.
    
**/
//    }
//
//
//}
