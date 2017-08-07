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
import javafx.event.*;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.geometry.*;
import javafx.stage.Screen;



public class PressConFX extends Application {

    public static double stageHeight;
    public static double stageWidth;

    public static Scene mainMenuScene;
    public static Stage rootStage;

    Scene winnersEntryScene;

    public static void main(String[] args) {
        Application.launch(args);
    }


    private void initMainMenu() {
        /* Create the Node for the mainMenuScene. And style it. */

        BorderPane bp1 = new BorderPane();
        VBox topLayout = new VBox();
            bp1.setCenter(topLayout);
            bp1.setPrefWidth(PressConFX.stageWidth);
            bp1.setPrefHeight(PressConFX.stageHeight);
        mainMenuScene = new Scene(bp1);
        mainMenuScene.getStylesheets().add("ph/mmhsvictoria/apps/pressconfx/default.css");

        /* Great! Now we put things on the scene. */
        
        // bp1.getStyleClass().add("main-screen");

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
                    PenNameActivity.show(rootStage);
                }
            }
        );


        /* For the winners.
           ------------------------------------------*/

        winnersButton.setOnAction(
            new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    WinnersEntryActivity.show(rootStage);
                }
            }
        );


        /* For the winners report.
           ------------------------------------------*/

        winnersReportButton.setOnAction(
            new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                // PCDialogs.Winners_Report(bp1);
                }
            }
        );


        /* For the school winners report.
           ------------------------------------------*/

        schoolsReportButton.setOnAction(
            new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                // PCDialogs.School_Winners_Report(bp1);
                }
            }
        );


        /* Prepare the Rankings
           ------------------------------------------*/

        rankingsButton.setOnAction(
            new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                // PCDialogs.Rankings_Report(bp1);
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

    }


    /* ************************************************************************
     * The start() method creates the main screen. We design this program so
     * that it looks like a mobile application. Then, it would be easy to
     * port it to android.
     * ************************************************************************/
     
    @Override public void start(Stage primaryStage) {

        /*  
            Determine size of the screen. Could be tablet, smartphone, or
            LCD monitor.  

            Update 1: I have removed this capability. It does more harm than good.
            Update 2: I have returned this capability into force. I don't know why I am doing this. It could be a terrible mistake.
        */

	Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
	PressConFX.stageHeight = bounds.getHeight();
	PressConFX.stageWidth  = bounds.getWidth();

	// System.out.println("stageHeight = " + stageHeight);
	// System.out.println("stageWidth = " + stageWidth);

        primaryStage.setTitle("Private Schools Press Conference");
        rootStage = primaryStage;

        /* Initialize the various Scenes. These Scenes will be switched onto the
           rootStage if their task is called. */

        initMainMenu();    // Initialize the Main Menu

        PenNameActivity.initialize();  // For the pen names.
        WinnersEntryActivity.initialize();


        // Now show main menu.

        primaryStage.setScene(mainMenuScene);
        primaryStage.show();
    }
}

