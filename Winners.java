/* *****************************************************************
 * Winners.java
 *
 * Dialog for entry of new winners in the various categories..
 *
 * Robert Pascual
 *
 * *****************************************************************/
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
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Spinner;

public class Winners {


    public static final double HBOX_SPACING   = 8.0;
    public static final double WRAPPING_WIDTH = 100.0;

    /* ************************************************************************
     * This method creates the entry screen for the Pen Names entry Stage.
     * When this method is entered, we place as a parameter the 
     * javafx.Stage.Window object which we want to own this pen names Stage.
     * ***********************************************************************/
    
    public static void Winners_Entry(Window owner) {

        // First we prep the Stage.

        Stage winners_stage = new Stage();
        winners_stage.setTitle("Enter Contest Winners");

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
        Scene topScene = new Scene(topLayout);


        // The style for the scene graph is indicated in a CSS file.
        // We load the CSS file and apply a rule from that CSS to
        // the scene graph we have here.

        topScene.getStylesheets().add("default.css");
        topLayout.getStyleClass().add("grid2");

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



        winners_stage.setScene(topScene);
        winners_stage.initOwner(owner);
        winners_stage.show();
    }
}

