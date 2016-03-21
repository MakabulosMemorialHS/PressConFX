/* *************************************************************************************
 * PressConFX.java
 *
 * Main application for the Private Schools Press Conference
 * Management Software.
 *
 * (c) Robert Pascual 2016
 * rtonypascual@gmail.com
 * http://www.github.com/RobertPascualPH/
 *
 * Revision History:
 *
 * $Id$
 *
 * $Log$
 *
 * ***********************************************************************************/
import java.lang.*;
import java.util.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.geometry.*;

public class PressConFX extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override public void start(Stage primaryStage) {
        primaryStage.setTitle("Private Schools Press Conference");
        VBox topLayout = new VBox();
        Scene menuScene = new Scene(topLayout);
        menuScene.getStylesheets().add("default.css");
        topLayout.getStyleClass().add("grid");

        primaryStage.setScene(menuScene);
        Text bannerText = new Text("Private Schools\nPress Conference\nMain Menu\n");
        bannerText.getStyleClass().add("h1");
        topLayout.getChildren().add(bannerText);

        /* NOW ADD THE BUTTONS. Quiz: What is the equiv name in Qt? */ 

        Button penNamesButton         = new Button("Enter Pen Names");
        Button winnersButton          = new Button("Enter Winners");
        Button commitButton           = new Button("Commit");
        Button winnersReportButton    = new Button("Prepare Winners Report");
        Button schoolsReportButton    = new Button("Prepare Schools Report");
        Button rankingsButton         = new Button("Prepare Rankings");
        Button lastViewedButton       = new Button("Print Last Viewed Report");
        Button quitButton             = new Button("Quit");

        topLayout.getChildren().addAll(
           penNamesButton, winnersButton,
           commitButton, winnersReportButton,
           schoolsReportButton, rankingsButton,
           lastViewedButton, quitButton);


        /* THE EVENT HANDLERS FOR THE VARIOUS BUTTONS */

        quitButton.setOnAction(
            new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                Platform.exit();
                }
            }
        );


        primaryStage.show();
    }
}

