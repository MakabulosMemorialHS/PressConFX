/* *******************************************************
 * Pen_Names.java
 *
 * Dialog for entry of new Pen Names.
 *
 * Robert Pascual
 *
 * *******************************************************/
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


public class Pen_Names {


    public static final double HBOX_SPACING   = 8.0;
    public static final double WRAPPING_WIDTH = 100.0;

    /* ************************************************************************
     * This method creates the entry screen for the Pen Names entry Stage.
     * When this method is entered, we place as a parameter the 
     * javafx.Stage.Window object which we want to own this pen names Stage.
     * ***********************************************************************/
    
    public static void Entry_Screen(Window owner) {
        Stage pen_names_stage = new Stage();
        pen_names_stage.setTitle("Enter Student Details");

        /* ************************************************************
         * Note the style that I am using.
         * For each window or main dialog, my standard names are
         *
         * (a) topLayout for the root of the scene graph attached to the stage.
         * (b) topScene for the scene set on the layout.
         * ************************************************************/
        
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

        Text pnlabel = new Text("Enter Student Details");
        pnlabel.getStyleClass().add("h1");
        topLayout.getChildren().add(pnlabel);

        // The CHOICE BOX FOR THE SCHOOL NAME

        HBox school_hbox = new HBox(Pen_Names.HBOX_SPACING);
        Text school_label = new Text("School");
        school_label.setWrappingWidth(Pen_Names.WRAPPING_WIDTH);
        school_label.setTextAlignment(TextAlignment.RIGHT);

        ChoiceBox<String> schools = new ChoiceBox<String>();

        school_hbox.getChildren().addAll(school_label, schools);
        topLayout.getChildren().add(school_hbox);


        // The student's PEN NAME or ID CODE.

        HBox pen_name_hbox = new HBox(Pen_Names.HBOX_SPACING);
        Text pen_name_label = new Text("Pen Name");
        pen_name_label.setWrappingWidth(Pen_Names.WRAPPING_WIDTH);
        pen_name_label.setTextAlignment(TextAlignment.RIGHT);

        TextField pen_name_field = new TextField("");

        pen_name_hbox.getChildren().addAll(pen_name_label, pen_name_field);
        topLayout.getChildren().add(pen_name_hbox);


        // Student's LAST NAME

        HBox last_name_hbox = new HBox(Pen_Names.HBOX_SPACING);
        Text last_name_label = new Text("Last Name");
        last_name_label.setWrappingWidth(Pen_Names.WRAPPING_WIDTH);
        last_name_label.setTextAlignment(TextAlignment.RIGHT);

        TextField last_name_field = new TextField();

        last_name_hbox.getChildren().addAll(last_name_label, last_name_field);
        topLayout.getChildren().add(last_name_hbox);


        // Student's FIRST NAME

        HBox first_name_hbox = new HBox(Pen_Names.HBOX_SPACING);
        Text first_name_label = new Text("First Name");
        first_name_label.setWrappingWidth(Pen_Names.WRAPPING_WIDTH);
        first_name_label.setTextAlignment(TextAlignment.RIGHT);

        TextField first_name_field = new TextField();

        first_name_hbox.getChildren().addAll(first_name_label, first_name_field);
        topLayout.getChildren().add(first_name_hbox);


        // Student's MIDDLE NAME

        HBox middle_name_hbox = new HBox(Pen_Names.HBOX_SPACING);
        Text middle_name_label = new Text("Middle Name");
        middle_name_label.setWrappingWidth(Pen_Names.WRAPPING_WIDTH);
        middle_name_label.setTextAlignment(TextAlignment.RIGHT);

        TextField middle_name_field = new TextField();

        middle_name_hbox.getChildren().addAll(middle_name_label, middle_name_field);
        topLayout.getChildren().add(middle_name_hbox);


        // The CANCEL and OK Button.

        Button cancel_button = new Button("Cancel");
        cancel_button.setCancelButton(true);

        Button ok_button = new Button("OK");
        ok_button.setDefaultButton(false);

        HBox cancel_ok_hbox = new HBox(Pen_Names.HBOX_SPACING);
        cancel_ok_hbox.setPrefWidth(300);

        cancel_ok_hbox.getChildren().addAll(cancel_button, ok_button);
        topLayout.getChildren().add(cancel_ok_hbox);



        pen_names_stage.setScene(topScene);
        pen_names_stage.initOwner(owner);
        pen_names_stage.show();
    }
}

