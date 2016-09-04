/* *************************************************************************************
 * PressConFX.java
 *
 * Main application for the Private Schools Press Conference
 * Management Software. This application was modified so that it is
 * compatible with use on a tablet or smartphone.
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
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;



public class PressConFX extends Application {

    /* Properties of this Application. */

    double stageHeight;
    double stageWidth;

    public static void main(String[] args) {
        Application.launch(args);
    }


    /* ************************************************************************
     * The start() method creates the main screen. We design this program so
     * that it looks like a mobile application. Then, it would be easy to
     * port it to android.
     * ************************************************************************/
     
    @Override public void start(Stage primaryStage) {

        /* Determine size of the screen. Could be tablet, smartphone, or
           LCD monitor. */

        Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
        stageHeight = bounds.getHeight();
        stageWidth = bounds.getWidth();


        /* Create the Node for the scene. And style it. */

        StackPane pane0 = new StackPane();
        Scene scene = new Scene(pane0, stageWidth, stageHeight);
        scene.getStylesheets().add("css/default.css");


        /* Set scene on stage. */

        primaryStage.setScene(scene);
        primaryStage.setTitle("Private Schools Press Conference");


        /* Great! Now we put things on the scene. */
        
        BorderPane bp1 = new BorderPane();
        pane0.getChildren().add(bp1);
        bp1.getStyleClass().add("main-screen");

        VBox topLayout = new VBox();
        bp1.setCenter(topLayout);
        topLayout.getStyleClass().add("main-screen");
        topLayout.setFillWidth(true);

        Text bannerText = new Text("Private Schools\nPress Conference\nMain Menu\n");
        bannerText.getStyleClass().add("h1");

        VBox vbt = new VBox();
        vbt.getStyleClass().add("top-bottom-panels");
        vbt.getChildren().add(bannerText);
        bp1.setTop(vbt);


        /* NOW ADD THE BUTTONS. Quiz: What is the equiv name in Qt? */ 

        Button penNamesButton         = new Button("Enter Pen Names");
        Button winnersButton          = new Button("Enter Winners");
        Button commitButton           = new Button("Commit");
        Button winnersReportButton    = new Button("Prepare Winners Report");
        Button schoolsReportButton    = new Button("Prepare Schools Report");
        Button rankingsButton         = new Button("Prepare Rankings");
        Button lastViewedButton       = new Button("Print Last Viewed Report");
        Button quitButton             = new Button("Quit");

        /* Set the MaxWidth of the Buttons so that they will be
           resized by the containing VBox.
           If the Buttons appear not to have the same size then
           check if the containing VBox has setFillWidth = true.
           ie: VBox.setFillWidth(true) */
        
        penNamesButton.setMaxWidth(300);
        winnersButton.setMaxWidth(300);
        commitButton.setMaxWidth(300);
        winnersReportButton.setMaxWidth(300);
        schoolsReportButton.setMaxWidth(300);
        rankingsButton.setMaxWidth(300);
        lastViewedButton.setMaxWidth(300);
        quitButton.setMaxWidth(300);

        quitButton.setCancelButton(true);

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
           ---------------------------------*/

        penNamesButton.setOnAction(
            new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    PenNameActivity.show(primaryStage);
                }
            }
        );


        /* For the winners.
           ------------------------------------------*/

        winnersButton.setOnAction(
            new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                PCDialogs.Winners_Entry(pane0);
                }
            }
        );


        /* For the winners report.
           ------------------------------------------*/

        winnersReportButton.setOnAction(
            new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                PCDialogs.Winners_Report(pane0);
                }
            }
        );



        /* For the school winners report.
           ------------------------------------------*/

        schoolsReportButton.setOnAction(
            new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                PCDialogs.School_Winners_Report(pane0);
                }
            }
        );


        /* Prepare the Rankings
           ------------------------------------------*/

        rankingsButton.setOnAction(
            new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                PCDialogs.Rankings_Report(pane0);
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

