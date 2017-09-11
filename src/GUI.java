/**
 * Created by Moritz on 11.09.2017.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

import static javafx.application.Application.launch;

/**
 * Created by Moritz on 11.09.2017.
 */
public class GUI extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("GUIKL.fxml"));
        Scene scene = new Scene(root);

        Text txt = (Text) scene.lookup("#txt1");
        RadioButton rdone = (RadioButton) scene.lookup("#rdc");
        RadioButton rdtwo = (RadioButton) scene.lookup("#rdv");
        RadioButton rdtree = (RadioButton) scene.lookup("#rdr");
        Button btn = (Button)scene.lookup("#btn1");

        btn.setOnAction(event -> onClick());

        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    void onClick(){
        JOptionPane.showMessageDialog(null,"CLICK!");
    }
}


/**import com.sun.org.apache.xml.internal.dtm.ref.DTMDefaultBaseIterators;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
/** import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.function.DoubleToIntFunction;


public class GUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        /**Pane root = null;
        root = new VBox();


        Button akt = new Button("Auswählen");
        akt.setOnAction((event -> a()));
        akt.setMaxWidth(125);

        Label empty = new Label("");
        empty.setMaxWidth(9999);

        Label opening = new Label("Bitte wählen sie ein Verfahren aus");
        opening.setMaxWidth(9999);

        RadioButton btnc = new RadioButton("Cäsar Chiffre");
        btnc.setMaxWidth(9999);

        RadioButton btnv = new RadioButton("Vigenerre Chiffre");
        btnv.setMaxWidth(9999);

        RadioButton btnr = new RadioButton("RSA Verschlüsselung");
        btnr.setMaxWidth(9999);

        root.getChildren().addAll(opening,empty,btnc,btnv,btnr,akt);


        primaryStage.setTitle("Test");
        Scene scene = new Scene(root,300,300);
        primaryStage.setScene(scene);
        primaryStage.show();



    }

    private void a(){
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        System.exit(0);
           }
}
**/