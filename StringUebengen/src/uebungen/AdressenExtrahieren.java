package uebungen;

/**
 *
 * @author GYoffe
 */
public class AdressenExtrahieren 
{
    public static void main(String[] args) 
    {   // gegeben
        String[] kunden = 
        {
            "Antonius;Müller;10315;Berlin;Kurze Str.;13",
            "Axel;Schweiß;12489;Berlin;Lange Gurke;27",
            "Maria;Schmidt;04158;Leipzig;Messe-Alle;4",
            "Heike;Lehmann;04178;Leipzig;Leipziger Str.;7"
        };
        
        // Definition 2-dim Array
        String[][] tab = new String[kunden.length][6];
        // 1-dim Array in 2-dim Array überführen
        for (int i = 0; i < kunden.length; i++)
        {   // Aufsplitten einer Zeichenkette
            String[] eineZeile = kunden[i].split(";");
            for (int e = 0; e < eineZeile.length; e++)
            {    
                tab[i][e] = eineZeile[e];
            }
        }
        
        // Anzeige des 2-dim Arrays
        for (int z = 0; z < tab.length; z++) 
        {
            for (int e = 0; e < tab[z].length; e++) 
            {
                System.out.print(tab[z][e] + "\t| ");
            }
            System.out.println(""); // neue Zeile
        } // ende for zur Anzeige
    } // ende main
} // ende class AdressenExtrahieren



//            String vorname = zeile1[0];
//            String nachname = zeile1[1];
//            String plz = zeile1[2];
//            String ort = zeile1[3];
//            String str = zeile1[4];
//            String hnr = zeile1[5];
//            tab[i][0] = vorname;
//            tab[i][1] = nachname;
//            tab[i][2] = plz;
//            tab[i][3] = ort;
//            tab[i][4] = str;
//            tab[i][5] = hnr;
//or
//                tab[0][0] = zeile[0];
//                tab[0][1] = zeile[1];
//                tab[0][2] = zeile[2];
//                tab[0][3] = zeile[3];
//                tab[0][4] = zeile[4];
//                tab[0][5] = zeile[5];
