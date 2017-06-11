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

    /* Properties of this Application. */

    double stageHeight;
    double stageWidth;
    Scene mainMenuScene;
    Scene winnersEntryScene;
    Stage rootStage;

    public static void main(String[] args) {
        Application.launch(args);
    }


    private void initMainMenu() {
        /* Create the Node for the mainMenuScene. And style it. */

        StackPane pane0 = new StackPane();
        mainMenuScene = new Scene(pane0, stageWidth, stageHeight);
        mainMenuScene.getStylesheets().add("ph/mmhsvictoria/apps/pressconfx/default.css");

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
                    PenNameActivity.show(rootStage);    // Change the implementation of this function.
                }
            }
        );


        /* For the winners.
           ------------------------------------------*/

        winnersButton.setOnAction(
            new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                rootStage.setScene(winnersEntryScene);
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


    }



    private void initWinnersEntry() {
        /* ************************************************************
         * Note the style that I am using.
         * For each window or main dialog, my standard names are
         *
         * (a) topLayout for the root of the scene graph attached to the stage.
         * (b) topScene for the scene set on the layout.
         * ************************************************************/
        
        // We prep a Scene Graph.
        // The root of our scene graph shall be a VBox layout

        BorderPane bp = new BorderPane();
        winnersEntryScene = new Scene(bp,stageWidth,stageHeight);


        // The style for the scene graph is indicated in a CSS file.
        // We load the CSS file and apply a rule from that CSS to
        // the scene graph we have here.

        //  winnersEntryScene.getStylesheets().add("ph/mmhsvictoria/apps/pressconfx/default.css");
        // topLayout.getStyleClass().add("grid2");

        /* *****************************************************************
         * Now successively add elements to the Dialog.
         * ****************************************************************/

        // The Banner Title goes to the Top Panel of BorderPane bp

        VBox topLayout = new VBox();
        bp.setTop(topLayout);

        Text pnlabel = new Text("Enter Contest Winners");
        // pnlabel.getStyleClass().add("h1");
        topLayout.getChildren().add(pnlabel);

        GridPane topGp = new GridPane();
        topLayout.getChildren().add(topGp);
       
        // The Button and TextField for the CONTEST CODE.

        // HBox category_hbox = new HBox(Winners.HBOX_SPACING);
        ChoiceBox<String> contest_names = new ChoiceBox<String>();
        TextField contest_code = new TextField("");

        // category_hbox.getChildren().addAll(contest_names, contest_code);
       
        topGp.add(contest_code,0,0);
        topGp.add(contest_names,1,0);

        /*
        Text school_label = new Text("School");
        // school_label.setWrappingWidth(Winners.WRAPPING_WIDTH);
        // school_label.setTextAlignment(TextAlignment.RIGHT);
        // System.out.println("Styles associated with Text: " + school_label.getStyle());

        ChoiceBox<String> schools = new ChoiceBox<String>();

        school_hbox.getChildren().addAll(school_label, schools);
        topLayout.getChildren().add(school_hbox);
        */

        // The RANK of the Winner: Or Which Place did this person get?

        Text text02 = new Text("Place or Rank");
        Spinner rank_spinner = new Spinner(1, 10, 1);
        rank_spinner.setEditable(true);
        topGp.add(text02, 0, 1);
        topGp.add(rank_spinner,1,1);


        // How many points for this Winner?

        Text text03 = new Text("Points");
        Spinner point_spinner = new Spinner(1, 10, 10);
        point_spinner.setEditable(true);
        topGp.add(text03,0,2);
        topGp.add(point_spinner,1,2);


        // The LIST OF STUDENT NAMES

        ListView listview01 = new ListView();
        ScrollPane namelv = new ScrollPane(listview01);
        bp.setCenter(namelv);


        // The CANCEL and OK Button.

        HBox bottomLayout = new HBox();
        bp.setBottom(bottomLayout);

        Button cancel_button = new Button("Cancel");
        cancel_button.setCancelButton(true);

        cancel_button.setOnAction(
            new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    rootStage.setScene(mainMenuScene);
                }
            }
        );

        Button ok_button = new Button("OK");
        ok_button.setDefaultButton(false);
        bottomLayout.getChildren().add(cancel_button);
        bottomLayout.getChildren().add(ok_button);
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

        rootStage = primaryStage;

        /* Initialize the various Scenes. These Scenes will be switched onto the
           rootStage if their task is called. */

        initMainMenu();    // Initialize the Main Menu.
        initWinnersEntry();   // Initialize winnersEntryScene

        /* Set mainMenuScene on the rootStage. */

        // rootStage.setScene(mainMenuScene);
        rootStage.setScene(winnersEntryScene);
        rootStage.setTitle("Private Schools Press Conference");

        rootStage.show();
    }
}

