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
package ph.mmhsvictoria.apps.pressconfx;

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
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.MenuItem;




public class PressConFX extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override public void start(Stage primaryStage) {
        primaryStage.setTitle("Private Schools Press Conference");
        BorderPane sceneroot = new BorderPane();
        Scene menuScene = new Scene(sceneroot);

        menuScene.getStylesheets().add("css/default.css");

        VBox topLayout = new VBox();
        sceneroot.setCenter(topLayout);
        topLayout.getStyleClass().add("grid");


        /* Create a MenuBar and populate with Menus
           ----------------------------------------------- */

        Menu menu1 = new Menu("File");

        Menu menu2 = new Menu("Database");
            MenuItem menu21 = new MenuItem("Initialize");
            MenuItem menu22 = new MenuItem("Edit/Add Data");
            menu2.getItems().addAll(menu21, menu22);

        Menu menu3 = new Menu("Settings");

        MenuBar menubar = new MenuBar();
        menubar.getMenus().addAll(menu1, menu2, menu3);
        menubar.setVisible(true);
        sceneroot.setTop(menubar);

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


        /* THE EVENT HANDLERS FOR THE VARIOUS BUTTONS
           ------------------------------------------
           Note that setOnAction() requires an EventHandler be passed
           as a parameter. In the following cases, the Eventhandler object
           is an anonymous class. The class is defined in the body of
           the parameter passed to setOnAction. */


        /* For the Pen Names.
           ------------------------------------------*/

        penNamesButton.setOnAction(
            new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                PCDialogs.Pen_Names_Entry(primaryStage);
                }
            }
        );


        /* For the winners.
           ------------------------------------------*/

        winnersButton.setOnAction(
            new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                PCDialogs.Winners_Entry(primaryStage);
                }
            }
        );


        /* For the winners report.
           ------------------------------------------*/

        winnersReportButton.setOnAction(
            new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                PCDialogs.Winners_Report(primaryStage);
                }
            }
        );



        /* For the school winners report.
           ------------------------------------------*/

        schoolsReportButton.setOnAction(
            new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                PCDialogs.School_Winners_Report(primaryStage);
                }
            }
        );


        /* Prepare the Rankings
           ------------------------------------------*/

        rankingsButton.setOnAction(
            new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                PCDialogs.Rankings_Report(primaryStage);
                }
            }
        );




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

