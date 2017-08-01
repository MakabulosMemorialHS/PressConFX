/* *****************************************************************
 * PenNameActivity.java
 *
 * Robert Pascual 2016
 *
 *
 * *****************************************************************/
package ph.mmhsvictoria.apps.pressconfx;

import java.lang.*;
import java.util.*;
import javafx.application.Platform;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.geometry.Pos;

import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.Scene;
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

import javafx.stage.Stage;
import javafx.stage.Window;

public class PenNameActivity {

    public static final double HBOX_SPACING   = 8.0;
    public static final double VBOX_SPACING   = 8.0;
    public static final double WRAPPING_WIDTH = 150.0;
    public static Scene penNameScene;

    private static TextField pen_name_field;
    private static TextField last_name_field;
    private static TextField first_name_field;
    private static TextField middle_name_field;

    /* ************************************************************************
     * This method creates the entry screen for the Pen Names entry Stage.
     * When this method is entered, we place as a parameter the 
     * javafx.Stage.Window object which we want to own this pen names Stage.
     * ***********************************************************************/
    
    public static void initialize() {

        // Create the Scene graph and its parent node.

        VBox topLayout = new VBox();
        topLayout.setAlignment(Pos.BOTTOM_LEFT);
        penNameScene = new Scene(topLayout);
        penNameScene.getStylesheets().add("ph/mmhsvictoria/apps/pressconfx/default.css");
        topLayout.getStyleClass().add("activity-windows");


        /* *****************************************************************
         * Now successively add elements to the Dialog.
         * ****************************************************************/

        // The CANCEL and OK Button.
        // Following the standard in mobile devices, the cancel and
        // OK buttons go to the top of the stage.

        Button cancel_button = new Button("<< Menu");
        cancel_button.setCancelButton(true);

        Button ok_button = new Button("Accept");
        ok_button.setDefaultButton(false);

        HBox cancel_ok_hbox = new HBox(PenNameActivity.HBOX_SPACING);
        // cancel_ok_hbox.setPrefWidth(300);

        cancel_ok_hbox.getChildren().addAll(cancel_button, ok_button);
        topLayout.getChildren().add(cancel_ok_hbox);

        cancel_button.setOnAction(
            new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    PenNameActivity.exit();
                }
            }
        );

        // The Banner Title

        Text pnlabel = new Text("Enter Student Details");
        pnlabel.getStyleClass().add("h1");
        topLayout.getChildren().add(pnlabel);

        // The CHOICE BOX FOR THE SCHOOL NAME

        Text school_label = new Text("School");
        school_label.setWrappingWidth(PenNameActivity.WRAPPING_WIDTH);
        school_label.getStyleClass().add("lighttext");

        ChoiceBox<String> schools = new ChoiceBox<String>();

        topLayout.getChildren().addAll(school_label, schools);


        // The student's PEN NAME or ID CODE.

        Text pen_name_label = new Text("Pen Name");
        pen_name_label.setWrappingWidth(PenNameActivity.WRAPPING_WIDTH);
        pen_name_label.getStyleClass().add("lighttext");

        pen_name_field = new TextField("");

        topLayout.getChildren().addAll(pen_name_label, pen_name_field);

        // Student's LAST NAME

        Text last_name_label = new Text("Last Name");
        last_name_label.setWrappingWidth(PenNameActivity.WRAPPING_WIDTH);
        last_name_label.getStyleClass().add("lighttext");

        last_name_field = new TextField();

        topLayout.getChildren().addAll(last_name_label, last_name_field);


        // Student's FIRST NAME

        Text first_name_label = new Text("First Name");
        first_name_label.setWrappingWidth(PenNameActivity.WRAPPING_WIDTH);
        first_name_label.getStyleClass().add("lighttext");

        first_name_field = new TextField();

        topLayout.getChildren().addAll(first_name_label, first_name_field);


        // Student's MIDDLE NAME

        Text middle_name_label = new Text("Middle Name");
        middle_name_label.getStyleClass().add("lighttext");

        middle_name_field = new TextField();

        topLayout.getChildren().addAll(middle_name_label, middle_name_field);



        // pen_names_stage.setScene(topScene);
        // pen_names_stage.initOwner(owner);
        // pen_names_stage.show();

        // stage.showAndWait();
    }

    public static void show(Stage stage) {
        stage.setScene(penNameScene);
        stage.show();
    }

    public static void clearFields() {
        pen_name_field.setText("");
        last_name_field.setText("");
        first_name_field.setText("");
        middle_name_field.setText("");
    }


    public static void exit() {
        PenNameActivity.clearFields();
        PressConFX.rootStage.setScene(PressConFX.mainMenuScene);
    }

}

