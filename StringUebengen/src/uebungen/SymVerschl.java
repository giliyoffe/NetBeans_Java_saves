package uebungen;

/**
 * Caesar-Verschlüsselung (Verschiebung um 3 Stellen)
 * @author GYoffe
 */
public class SymVerschl 
{ // main-Methode
  public static void main(String[] args)
  {
    String text = "ABC Heut ist ein zu regnerischer Tag! XYZ";
    System.out.println( caesarVerschl(text) );
    System.out.println( caesarVerschl2(text) );
  }
  // ***** Caesar-Verschlüsselung (Variante 1)
  // (Verschiebung um 3 Buchstaben)
  public static String caesarVerschl(String text)
  {
    // Ergebnisarray
    char[] verschlText = new char[text.length()];
    for (int index = 0; index < text.length(); index++)
    { // Buchstaben holen
      char buchstabe = text.charAt(index);
      if ( (buchstabe >= 'a' && buchstabe <= 'z')
         ||(buchstabe >= 'A' && buchstabe <= 'Z') )
      {
        if ( (buchstabe >= 'x' && buchstabe <= 'z')
           || (buchstabe >= 'X' && buchstabe <= 'Z') )
        {
          verschlText[index] = (char) (buchstabe - 26 + 3);
        } else
        {
          verschlText[index] = (char) (buchstabe + 3);
        }
      } else
      {
        verschlText[index] = text.charAt(index);
      }
    }
    return new String(verschlText);
  }
  
  // ***** Caesar-Verschlüsselung (Variante 2)
  public static String caesarVerschl2(String text)
  {
    // Ergebnisarray
    char[] verschlText = new char[text.length()];
    for (int index = 0; index < text.length(); index++)
    { // einen Buchstaben holen
      char buchstabe = text.charAt(index);
      if (buchstabe >= 'a' && buchstabe <= 'z')
      {
        verschlText[index] = (char) ((buchstabe - 'a' + 3) % 26 + 'a');
      } else if (buchstabe >= 'A' && buchstabe <= 'Z')
      {
        verschlText[index] = (char) ((buchstabe - 'A' + 3) % 26 + 'A');
      } else
      {
        verschlText[index] = buchstabe;
      }
    } // ende for
    return new String(verschlText);
  } // ende Methode caesarVerschl2
} // ende class

//          
//// me zurück:
//        char[] unverschlText = new char[text.length()];
//        for (int index = 0; index < text.length(); index++) 
//        {
//            unverschlText[index] = (char)(text.charAt(index) - 3);
//        }
//      
//        return new String(unverschlText) ;