/* *****************************************************************
 * DialogScenes.java
 *
 * For each Dialog in the Application, we create a new scene. The methods
 * in this class all return references to a javafx.scene.Scene object.
 * It is up to the calling function (or method) to decide what to do with
 * the Scene object.
 *
 * Robert Pascual 2016
 *
 *
 * *****************************************************************/
package ph.mmhsvictoria.apps.pressconfx;

import java.lang.*;
import java.util.*;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.Scene;
import javafx.stage.Window;
import javafx.scene.text.Text;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.text.TextAlignment;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Spinner;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.BorderPane;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class DialogScenes {

    public static final double HBOX_SPACING   = 8.0;
    public static final double VBOX_SPACING   = 8.0;
    public static final double WRAPPING_WIDTH = 100.0;

    /* ************************************************************************
     * This method creates the entry screen for the Pen Names entry Stage.
     * When this method is entered, we place as a parameter the 
     * javafx.Stage.Window object which we want to own this pen names Stage.
     * ***********************************************************************/
    
    public static void Pen_Names_Entry(Stage dialogStage) {

        // The root of our scene graph shall be a VBox layout

        VBox topLayout = new VBox();
        BorderPane sp = new BorderPane();
        Scene pnscene = new Scene(topLayout);
        sp.setCenter(topLayout);

        // The style for the scene graph is indicated in a CSS file.
        // We load the CSS file and apply a rule from that CSS to
        // the scene graph we have here.

        topLayout.getStyleClass().add("grid2");

        /* *****************************************************************
         * Now successively add elements to the Dialog.
         * ****************************************************************/

        // The Banner Title

        Text pnlabel = new Text("Enter Student Details");
        pnlabel.getStyleClass().add("h1");
        sp.setTop(pnlabel);

        // The CHOICE BOX FOR THE SCHOOL NAME

        HBox school_hbox = new HBox(Pen_Names.HBOX_SPACING);
        Text school_label = new Text("School");
        school_label.setWrappingWidth(Pen_Names.WRAPPING_WIDTH);
        school_label.setTextAlignment(TextAlignment.LEFT);

        ChoiceBox<String> schools = new ChoiceBox<String>();

        topLayout.getChildren().addAll(school_label, schools);


        // The student's PEN NAME or ID CODE.

        Text pen_name_label = new Text("Pen Name");
        pen_name_label.setWrappingWidth(Pen_Names.WRAPPING_WIDTH);
        pen_name_label.setTextAlignment(TextAlignment.LEFT);

        TextField pen_name_field = new TextField("");

        topLayout.getChildren().addAll(pen_name_label, pen_name_field);

        // Student's LAST NAME

        Text last_name_label = new Text("Last Name");
        last_name_label.setWrappingWidth(Pen_Names.WRAPPING_WIDTH);
        last_name_label.setTextAlignment(TextAlignment.LEFT);

        TextField last_name_field = new TextField();

        topLayout.getChildren().addAll(last_name_label, last_name_field);


        // Student's FIRST NAME

        Text first_name_label = new Text("First Name");
        first_name_label.setWrappingWidth(Pen_Names.WRAPPING_WIDTH);
        first_name_label.setTextAlignment(TextAlignment.LEFT);

        TextField first_name_field = new TextField();

        topLayout.getChildren().addAll(first_name_label, first_name_field);


        // Student's MIDDLE NAME

        Text middle_name_label = new Text("Middle Name");
        middle_name_label.setWrappingWidth(Pen_Names.WRAPPING_WIDTH);
        middle_name_label.setTextAlignment(TextAlignment.LEFT);

        TextField middle_name_field = new TextField();

        topLayout.getChildren().addAll(middle_name_label, middle_name_field);


        // The CANCEL and OK Button.

        Button cancel_button = new Button("Cancel");
        cancel_button.setCancelButton(true);

        Button ok_button = new Button("OK");
        ok_button.setDefaultButton(false);

        HBox cancel_ok_hbox = new HBox(Pen_Names.HBOX_SPACING);
        cancel_ok_hbox.setPrefWidth(300);

        cancel_ok_hbox.getChildren().addAll(cancel_button, ok_button);
        topLayout.getChildren().add(cancel_ok_hbox);

        cancel_button.setOnAction(
            new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                ;
                }
            }
        );

        // pen_names_stage.setScene(topScene);
        // pen_names_stage.initOwner(owner);
        // pen_names_stage.show();

        dialogStage.showAndWait();
    }


    /* *****************************************************************
     * This Dialog presents a way to enter the winners of a particular
     * contest.
     * ****************************************************************/

    public static void Winners_Entry(StackPane sp) {

        // First we prep the Stage.

        // Stage winners_stage = new Stage();
        // winners_stage.setTitle("Enter Contest Winners");

        /* ************************************************************
         * Note the style that I am using.
         * For each window or main dialog, my standard names are
         *
         * (a) topLayout for the root of the scene graph attached to the stage.
         * (b) topScene for the scene set on the layout.
         * ************************************************************/
        
        // Then we prep a Scene Graph.
        // The root of our scene graph shall be a VBox layout

        VBox topLayout = new VBox();
        sp.getChildren().add(topLayout);

        // Scene topScene = new Scene(topLayout);


        // The style for the scene graph is indicated in a CSS file.
        // We load the CSS file and apply a rule from that CSS to
        // the scene graph we have here.

        // topScene.getStylesheets().add("css/default.css");
        // topLayout.getStyleClass().add("grid2");

        /* *****************************************************************
         * Now successively add elements to the Dialog.
         * ****************************************************************/

        // The Banner Title

        Text pnlabel = new Text("Enter Contest Winners");
        pnlabel.getStyleClass().add("h1");
        topLayout.getChildren().add(pnlabel);

        // The Button and TextField for the CONTEST CODE.

        HBox category_hbox = new HBox(Winners.HBOX_SPACING);
        ChoiceBox<String> contest_names = new ChoiceBox<String>();
        TextField contest_code = new TextField("");

        category_hbox.getChildren().addAll(contest_names, contest_code);
        topLayout.getChildren().add(category_hbox);

        /*
        Text school_label = new Text("School");
        school_label.setWrappingWidth(Winners.WRAPPING_WIDTH);
        school_label.setTextAlignment(TextAlignment.RIGHT);
        System.out.println("Styles associated with Text: " + school_label.getStyle());

        ChoiceBox<String> schools = new ChoiceBox<String>();

        school_hbox.getChildren().addAll(school_label, schools);
        topLayout.getChildren().add(school_hbox);
        */

        // The RANK of the Winner: Or Which Place did this person get?

        HBox hbox02 = new HBox(Winners.HBOX_SPACING);
        Text text02 = new Text("Place or Rank");
        Spinner rank_spinner = new Spinner(1, 10, 1);
        rank_spinner.setEditable(true);
        hbox02.getChildren().addAll(text02, rank_spinner);
        topLayout.getChildren().add(hbox02);


        // How many points for this Winner?

        HBox hbox03 = new HBox(Winners.HBOX_SPACING);
        Text text03 = new Text("Points");
        Spinner point_spinner = new Spinner(1, 10, 10);
        point_spinner.setEditable(true);
        hbox03.getChildren().addAll(text03, point_spinner);
        topLayout.getChildren().add(hbox03);


        // The LIST OF STUDENT NAMES

        ListView listview01 = new ListView();
        ScrollPane namelv = new ScrollPane(listview01);
        topLayout.getChildren().add(namelv);


        // The CANCEL and OK Button.

        Button cancel_button = new Button("Cancel");
        cancel_button.setCancelButton(true);

        Button ok_button = new Button("OK");
        ok_button.setDefaultButton(false);

        HBox cancel_ok_hbox = new HBox(Winners.HBOX_SPACING);
        cancel_ok_hbox.setPrefWidth(300);

        cancel_ok_hbox.getChildren().addAll(cancel_button, ok_button);
        topLayout.getChildren().add(cancel_ok_hbox);



        // winners_stage.setScene(topScene);
        // winners_stage.initOwner(owner);
        // winners_stage.show();
    }


    /* =============================================================
       Prepare the Winners Report
       ============================================================= */

    public static void Winners_Report(StackPane sp) {

        // Stage report_stage = new Stage();
        // report_stage.setTitle("Contest Winners Report\n");
        VBox topLayout = new VBox();
        sp.getChildren().add(topLayout);
        // Scene topScene = new Scene(topLayout);

        // topScene.getStylesheets().add("css/default.css");
        // topLayout.getStyleClass().add("grid2");

        /* *****************************************************************
         * Now successively add elements to the Dialog.
         * ****************************************************************/

        // The Banner Title

        Text pnlabel = new Text("Contest Winners Report");
        pnlabel.getStyleClass().add("h1");
        topLayout.getChildren().add(pnlabel);

        // The CHOICE BOX FOR THE OOL NAME

        HBox ccode_hbox = new HBox(Winners.HBOX_SPACING);
        Text ccode_label = new Text("Contest Name");
        ccode_label.setWrappingWidth(Winners.WRAPPING_WIDTH);
        ccode_label.setTextAlignment(TextAlignment.RIGHT);

        ChoiceBox<String> contest_codes = new ChoiceBox<String>();

        ccode_hbox.getChildren().addAll(ccode_label, contest_codes);
        topLayout.getChildren().add(ccode_hbox);

        // Create Radio Buttons for determining what kind of
        // output we want.

        VBox rbvbox = new VBox(Winners.VBOX_SPACING);
        final ToggleGroup group = new ToggleGroup();
        RadioButton rb1 = new RadioButton("LaTeX");
        rb1.setToggleGroup(group);
        rb1.setSelected(true);
        RadioButton rb2 = new RadioButton("Simple Text");
        rb2.setToggleGroup(group);
        rbvbox.getChildren().addAll(rb1, rb2);
        topLayout.getChildren().add(rbvbox);
      
        // The CANCEL and OK Button.

        Button cancel_button = new Button("Cancel");
        cancel_button.setCancelButton(true);

        Button ok_button = new Button("OK");
        ok_button.setDefaultButton(false);

        HBox cancel_ok_hbox = new HBox(Winners.HBOX_SPACING);
        cancel_ok_hbox.setPrefWidth(300);

        cancel_ok_hbox.getChildren().addAll(cancel_button, ok_button);
        topLayout.getChildren().add(cancel_ok_hbox);

        // report_stage.setScene(topScene);
        // report_stage.initOwner(owner);
        // report_stage.show();
    }

    /* =============================================================
       Prepare the Report Listing The Winners of A Particular School
       ============================================================= */

    public static void School_Winners_Report(StackPane sp) {

        // Stage report_stage = new Stage();
        // report_stage.setTitle("School Winners Report\n");
        VBox topLayout = new VBox();
        sp.getChildren().add(topLayout);
        // Scene topScene = new Scene(topLayout);

        // topScene.getStylesheets().add("css/default.css");
        // topLayout.getStyleClass().add("grid2");

        /* *****************************************************************
         * Now successively add elements to the Dialog.
         * ****************************************************************/

        // The Banner Title

        Text pnlabel = new Text("School Winners Report");
        pnlabel.getStyleClass().add("h1");
        topLayout.getChildren().add(pnlabel);

        // The CHOICE BOX FOR THE OOL NAME

        HBox ccode_hbox = new HBox(Winners.HBOX_SPACING);
        Text ccode_label = new Text("School");
        ccode_label.setWrappingWidth(Winners.WRAPPING_WIDTH);
        ccode_label.setTextAlignment(TextAlignment.RIGHT);

        ChoiceBox<String> contest_codes = new ChoiceBox<String>();

        ccode_hbox.getChildren().addAll(ccode_label, contest_codes);
        topLayout.getChildren().add(ccode_hbox);

        // Create Radio Buttons for determining what kind of
        // output we want.

        VBox rbvbox = new VBox(Winners.VBOX_SPACING);
        final ToggleGroup group = new ToggleGroup();
        RadioButton rb1 = new RadioButton("LaTeX");
        rb1.setToggleGroup(group);
        rb1.setSelected(true);
        RadioButton rb2 = new RadioButton("Simple Text");
        rb2.setToggleGroup(group);
        rbvbox.getChildren().addAll(rb1, rb2);
        topLayout.getChildren().add(rbvbox);
      
        // The CANCEL and OK Button.

        Button cancel_button = new Button("Cancel");
        cancel_button.setCancelButton(true);

        Button ok_button = new Button("OK");
        ok_button.setDefaultButton(false);

        HBox cancel_ok_hbox = new HBox(Winners.HBOX_SPACING);
        cancel_ok_hbox.setPrefWidth(300);

        cancel_ok_hbox.getChildren().addAll(cancel_button, ok_button);
        topLayout.getChildren().add(cancel_ok_hbox);

        // report_stage.setScene(topScene);
        // report_stage.initOwner(owner);
        // report_stage.show();
    }



    /* =============================================================
       Prepare the Ranks List. This report lists the schools who have
       won contests ranked by points earned.
       ============================================================= */

    public static void Rankings_Report(StackPane sp) {

        // Stage report_stage = new Stage();
        // report_stage.setTitle("Report of Schools By Rank\n");
        VBox topLayout = new VBox();
        sp.getChildren().add(topLayout);
        // Scene topScene = new Scene(topLayout);

        // topScene.getStylesheets().add("css/default.css");
        // topLayout.getStyleClass().add("grid2");

        /* *****************************************************************
         * Now successively add elements to the Dialog.
         * ****************************************************************/

        // The Banner Title

        Text pnlabel = new Text("Report of Schools By Rank");
        pnlabel.getStyleClass().add("h1");
        topLayout.getChildren().add(pnlabel);

        // The CHOICE BOX FOR THE OOL NAME

        /* **
        HBox ccode_hbox = new HBox(Winners.HBOX_SPACING);
        Text ccode_label = new Text("School");
        ccode_label.setWrappingWidth(Winners.WRAPPING_WIDTH);
        ccode_label.setTextAlignment(TextAlignment.RIGHT);

        ChoiceBox<String> contest_codes = new ChoiceBox<String>();

        ccode_hbox.getChildren().addAll(ccode_label, contest_codes);
        topLayout.getChildren().add(ccode_hbox);
        ** */
      
        // Create Radio Buttons for determining what kind of
        // output we want.

        Text prompt1 = new Text("Select Division");
        topLayout.getChildren().add(prompt1);
        

        VBox rbvbox = new VBox(Winners.VBOX_SPACING);
        final ToggleGroup group = new ToggleGroup();
        RadioButton rb1 = new RadioButton("Elementary");
        rb1.setToggleGroup(group);
        rb1.setSelected(true);
        RadioButton rb2 = new RadioButton("Secondary");
        rb2.setToggleGroup(group);
        rbvbox.getChildren().addAll(rb1, rb2);
        topLayout.getChildren().add(rbvbox);
      
        // The CANCEL and OK Button.

        Button cancel_button = new Button("Cancel");
        cancel_button.setCancelButton(true);

        Button ok_button = new Button("OK");
        ok_button.setDefaultButton(false);

        HBox cancel_ok_hbox = new HBox(Winners.HBOX_SPACING);
        cancel_ok_hbox.setPrefWidth(300);

        cancel_ok_hbox.getChildren().addAll(cancel_button, ok_button);
        topLayout.getChildren().add(cancel_ok_hbox);

        // report_stage.setScene(topScene);
        // report_stage.initOwner(owner);
        // report_stage.show();
    }



}

