import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.*;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Objects;

public class GUI extends Application{

    @Override
    public void start(Stage stage) throws Exception {

        // Algorithmen Bibliothek wird initalisiert
        Algorithmen alg = new Algorithmen();

        byte[] zwischen;

        Parent root = FXMLLoader.load(getClass().getResource("guikl.fxml")); // Design der GUI wird geladen
        stage.setResizable(false);  // Das Fenster kann nicht durch den Benutzer in der Größe verändert werden
        stage.setTitle("Verschlüsselungverfahren"); // Titel wird gesetzt
        Scene scene = new Scene(root); // Scene wird initalisiert


        // Eingabefelder und Knöpfe werden initalisiert und Einstellungen werden getroffen
        TextArea txt_c = (TextArea) root.lookup("#ct1");
        TextArea txt2_c = (TextArea) root.lookup("#ct3");
        txt2_c.setEditable(false);  // das Ausgabefeld kann nich bearbeitet werden
        TextField key_c = (TextField) root.lookup("#ct2");
        Button btnv = (Button) root.lookup("#btnv");
        Button btne = (Button) root.lookup("#btne");

        // Eingabefelder und Knöpfe werden initalisiert und Einstellungen werden getroffen
        TextArea txt_v = (TextArea) root.lookup("#vt1");
        TextArea txt2_v = (TextArea) root.lookup("#vt3");
        txt2_v.setEditable(false);  // das Ausgabefeld kann nich bearbeitet werden
        TextField key_v = (TextField) root.lookup("#vt2");
        Button btnv2 = (Button) root.lookup("#btnv2");
        Button btne2 = (Button) root.lookup("#btne2");


        // Eingabefelder und Knöpfe werden initalisiert und Einstellungen werden getroffen
        TextArea txt_r = (TextArea) root.lookup("#rt1");
        TextArea txt2_r = (TextArea) root.lookup("#rt4");
        txt2_r.setEditable(false); // das Ausgabefeld kann nich bearbeitet werden
        TextField key_r = (TextField) root.lookup("#rt2");
        TextField key2_r = (TextField) root.lookup("#rt3");
        Button btnv3 = (Button) root.lookup("#btnv3");
        Button btne3 = (Button) root.lookup("#btne3");

        //Aktion des Verschlüsselungsknopfes der Cäsar-Chiffre wird mittels Lamda Befehl definiert
        btnv.setOnAction(e -> {
            Integer key = Integer.parseInt(key_c.getText());
            if(key <= 0 || key > 25){ //Prüfung ob sich der "key" zwischen 0 und 25 befindet
                JOptionPane.showMessageDialog(null,"Bitte geben sie eine Zahl zwischen 1 und 25 ein");
                //Gegebenenfalls wird eine Fehlermeldung ausgegeben
            }
            else{
                txt2_c.setText( // Der Text des Ausgabefeldes wird gesetzt
                        alg.Caesar_encrypt( // Die entsprechende Methode wird aufgerufen
                                txt_c.getText().toLowerCase(),key)); // die benötigten Parameter werden übergeben
            }
        });

        //Aktion des Entschlüsselungsknopfes der Cäsar-Chiffre wird mittels Lamda Befehl definiert
        btne.setOnAction(e -> {
            Integer key = Integer.parseInt(key_c.getText());
            if((key <= 0 || key > 25) && Objects.equals(txt_c.getText(), "")){ //Prüfung ob sich der "key"
                                                                 // zwischen 0 und 25 befindet und ob das Feld leer ist
                JOptionPane.showMessageDialog(null,"Bitte geben sie eine Zahl zwischen 1 und 25 ein");
                //Gegebenenfalls wird eine Fehlermeldung ausgegeben
            }
            else{
                txt2_c.setText( // Der Text des Ausgabefeldes wird gesetzt
                        alg.Caesar_decrypt( // Die entsprechende Methode wird aufgerufen
                                txt_c.getText().toLowerCase(),key)); // die benötigten Parameter werden übergeben
            }
        });


        //Aktion des Verschlüsselungsknopfes der Vigenerre-Chiffre wird mittels Lamda Befehl definiert
        btnv2.setOnAction(e -> {
            // Es wird geprüft ob das Eingabefeld des Schlüssels leer ist
            if(!txt_v.getText().isEmpty()) {
                txt2_v.setText(alg.Vigenere_encrypt( // Die entsprechende Methode wird aufgerufen
                        txt_v.getText().toLowerCase(), key_v.getText())); // die benötigten Parameter werden übergeben
            }
        });


        //Aktion des Entschlüsselungsknopfes der Vigenerre-Chiffre wird mittels Lamda Befehl definiert
        btne2.setOnAction(e -> {
            if(!txt_v.getText().isEmpty()) { // Es wird geprüft ob das Eingabefeld des Schlüssels leer ist
                txt2_v.setText(alg.Vigenere_decrypt(    // Die entsprechende Methode wird aufgerufen
                        txt_v.getText().toLowerCase(), key_v.getText())); // die benötigten Parameter werden übergeben
            }
        });


       btnv3.setOnAction( e -> {
           txt2_r.setText(alg.RSA_encrypt(txt_r.getText(),new RSAKey(23,143)));
       });



       btne3.setOnAction(e -> {
           txt2_r.setText(alg.RSA_decrypt(txt_r.getText(),new RSAKey(47,143)));

       });



        // Das Fenster wird "fertig" gemacht und erscheint
        stage.setScene(scene);
        stage.show();
    }

    private String b2s(byte[] bytes) {
       String ret = "";

        for (byte a: bytes
             ) {
            ret += (char) a;
        }

        return ret;
    }


    /**
     * @param args the command line arguments
     */

    // Das Programm wird ausgeführt
    public static void main(String[] args) {
        launch(args);
    }
}
