package personenverwaltung;

import java.time.format.DateTimeFormatter;

/**
 * Das Interface enthält verschiedene Konstanten zur
 * Steuerung der Zustände in der Benutzeroberfläche.
 * @author GYoffe
 */
public interface Konstanten
{
    final int BASIS = 1;
    final int NEU   = 2;
    final int AENDERN = 3;
    final int LEER = 4;
    
    final DateTimeFormatter DTF = 
            DateTimeFormatter.ofPattern("dd.MM.yyyy");
}
