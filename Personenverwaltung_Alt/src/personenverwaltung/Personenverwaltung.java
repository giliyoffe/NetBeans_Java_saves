package personenverwaltung;

import java.io.File;
import java.io.IOException;
import java.util.Optional;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author GYoffe
 */
public class Personenverwaltung extends Application
{
   //Objektvariablen der Klasse Personenverwaltung
    // sie dienen zum Aufbau der Verbindung zwischen den Klassen
    private Personenliste liste;        // Komposition
    private GuiController controller;   // Aggregation
    private Stage fenster;
    private boolean geaendert = false;
    
    /**
     * Methode setzt ein Flag, aus dem zu erkennen ist, ob an den Daten
     * Änderungen vorgenommen wurden.
     * @param geaendert true, wenn Daten geändert wurden
     */
    public void setGeaendert(boolean geaendert)
    {
        this.geaendert = geaendert;
    }
    /**
     * Konstruktormethode de Personenverwaltung definiert eine neue
     * Personenliste, welche verwaltet werden soll.
     */
    public Personenverwaltung()
    {
        liste = new Personenliste();
    }

    /**
     * Methode wird bei Start der Applikation aufgerufen.
     * Die Methode enthält alle Anweisungen zum Aufbau des Fensters der
     * Benutzeroberfläche.
     * @param fenster Referenz auf das Fenster von Typ Stage.
     */
    @Override
    public void start( Stage fenster ) throws IOException
    {
        // Objekt zum Übersetzen der FXML-Datei erstellen
        FXMLLoader loader = new FXMLLoader();
        // Pfad zur FXML-Datei übergeben
        loader.setLocation(getClass().getResource("Gui.fxml"));
        // FXML beschreibt ein Objekt von Typ AnchorPane
        // Pane-Objekt der Benutzeroberfläche (Wurzel mit untergeordneten Elementen)
        AnchorPane root = (AnchorPane)loader.load();
        // Verbindung zum Controller aufbauen
        controller = loader.getController();
        // Übergabe der Referenzen an den Controller
        controller.setVerwaltung(this); //Verwaltung
        // Verbinden des Fensters mit Scene und AnchorPane
        fenster.setScene(new Scene(root));
        fenster.setResizable(false);
        fenster.setTitle("Personenverwaltung");
        fenster.show();        
        // Einlesen der Daten aus der Datei
        File file = getDatei(true);
        if (file != null)
        {
            liste.einlesenListeAusDatei(file);
        }
        // Listenreferenz dem Controller mitteilen
        controller.setListe(liste); //  Liste
        // Anfangszustand der Anwendung setzen
        if (! liste.getListe().isEmpty() )
        {
            controller.setZustand(Konstanten.BASIS);
        }
        else
        {
            controller.setZustand(Konstanten.LEER);
        }
    } // Ende start-Methode
   
    @Override
    public void stop() 
    {
      //  if ( ! this.geaendert) System.exit(0);
        try {
                File file = getDatei(false);
                if ( file != null)
                {
                    liste.speichernListeInDatei(file);
                    dialogAnzeige(liste.getListe().size() + " Datensätze gespeichert.");
                }
            }catch (IOException ioe)
            {
                dialogAnzeige("Änderungen konnten nicht gespeichert werden");
            }finally
            {
                System.exit(0); // Anwendung beenden
            }
    }
    
    /**
    * Hauptmethode ist der Starpunkt der gesamten Anwendung
    * Personenverwaltung
    * @param args Programmparameter
    */
    public static void main(String[] args) throws IOException
    {
        Application.launch(); //  Erstellen der Gui - Aufruf der Start()
    }
    
    // Methode
    /**
     * Methode erzeugt eine Dialogfenster zur Auswahl einer Datei.
     * Soll es ein Öffnen Dialog sein, dann Parameter true setzen.
     * 
     * @param oeffnen true - wenn Öffnen-Dialog
     * @return ausgewählte Datei und Datenpfad - File
     */
    private File getDatei( boolean oeffnen )
    {
        // Dialog zur Dateiauswahl
        FileChooser fc = new FileChooser();
        // Anfangsverzeichnis
        String userVZ = System.getProperty("user.dir");
        fc.setInitialDirectory(new File(userVZ));
        File file;
        if ( oeffnen )
        {
            file = fc.showOpenDialog(fenster);
            if ( file == null ) // wenn Abbrechen oder Schließen X
            { // **** später  Dialog
                System.out.println("Keine Datei ausgewählt!");
            }
        } 
        else
        {
            return fc.showSaveDialog(fenster);
        }
        
        return file;
    }
    
    public void dialogAnzeige(String text)
    {   
	Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Hinweis");
        alert.initOwner(fenster);
        alert.setHeaderText(text);
        alert.showAndWait();
    }
    /**
     * Methode zuegt einen Frage-Dialog (CONFIRM) an.
     * 
     * @param title Titel das Dialog
     * @param frage  Anzuzeigen Frage
     * @return true, wenn Yes geklickt
     */
    public boolean frage(String title, String frage)
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.initOwner(fenster);
        alert.setHeaderText(frage);
        alert.getButtonTypes().setAll(ButtonType.YES, ButtonType.NO);
        Optional antw = alert.showAndWait();
        return antw.get() == ButtonType.YES;
    }
    
} // Ende der Klasse Personenverwaltung
