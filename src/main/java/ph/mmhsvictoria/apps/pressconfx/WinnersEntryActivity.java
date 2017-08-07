/* *****************************************************
 * WinnersEntryActivity.java
 *
 *
 * *****************************************************/
package ph.mmhsvictoria.apps.pressconfx;

import java.lang.*;
import java.util.*;
import javafx.application.Platform;

import javafx.event.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.Scene;
import javafx.scene.text.*;

import javafx.stage.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class WinnersEntryActivity {

    public static Scene winnersEntryScene;

    public static void initialize() {

        // Create the Scene graph and its parent node.

        VBox topLayout = new VBox();
            topLayout.setPrefWidth(PressConFX.stageWidth);
            topLayout.setPrefHeight(PressConFX.stageHeight);
            topLayout.setAlignment(Pos.BOTTOM_LEFT);
        winnersEntryScene = new Scene(topLayout);
            winnersEntryScene.getStylesheets().add("ph/mmhsvictoria/apps/pressconfx/default.css");
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
                    WinnersEntryActivity.exit();
                }
            }
        );

        // The Banner Title

        Text pnlabel = new Text("Winners Database Entry");
        pnlabel.getStyleClass().add("h1");
        topLayout.getChildren().add(pnlabel);

        // The CHOICE BOX FOR THE Contest Code

        HBox hba  = new HBox();

        VBox vba1 = new VBox();    hba.getChildren().add(vba1);

        Text contest_code_label = new Text("Contest Code");
        contest_code_label.setWrappingWidth(PenNameActivity.WRAPPING_WIDTH);
        contest_code_label.getStyleClass().add("lighttext");

        ChoiceBox<String> contestCodes = new ChoiceBox<String>();
        vba1.getChildren().addAll(contest_code_label, contestCodes);

        VBox vba2 = new VBox();    hba.getChildren().add(vba2);

        Text blabel = new Text("Place");
        blabel.setWrappingWidth(PenNameActivity.WRAPPING_WIDTH);
        blabel.getStyleClass().add("lighttext");

        ChoiceBox<String> placeCodes = new ChoiceBox<String>();
        vba2.getChildren().addAll(blabel, placeCodes);


        VBox vba3 = new VBox();    hba.getChildren().add(vba3);

        Text clabel = new Text("Points");
        clabel.setWrappingWidth(PenNameActivity.WRAPPING_WIDTH);
        clabel.getStyleClass().add("lighttext");

        ChoiceBox<String> pointsCode = new ChoiceBox<String>();
        vba3.getChildren().addAll(clabel, pointsCode);

        topLayout.getChildren().add(hba);

        // The student's PEN NAME or ID CODE.

        Button selButton = new Button("Student Name");
        TextField nameField = new TextField();
        nameField.setPrefWidth(300);
        nameField.setText("Select a name below and click button on left");
        HBox spnBox = new HBox();
        spnBox.getChildren().addAll(selButton, nameField);
        topLayout.getChildren().addAll(spnBox);

        TableView<CampusJournalist> cjTable = new TableView<CampusJournalist>();
        ScrollPane scrPane = new ScrollPane(cjTable);
        scrPane.setPrefHeight(300);
        topLayout.getChildren().add(scrPane);


        // Define the columns of the TableView<CampusJournalist>

        TableColumn pnameCol = new TableColumn("Pen Name");
        pnameCol.setMinWidth(200);
        pnameCol.setCellValueFactory(
            new PropertyValueFactory<CampusJournalist,String>("penName")
        );
        cjTable.getColumns().add(pnameCol);

        TableColumn lnameCol = new TableColumn("Family Name");
        lnameCol.setMinWidth(200);
        lnameCol.setCellValueFactory(
            new PropertyValueFactory<CampusJournalist,String>("lastName")
        );
        cjTable.getColumns().add(lnameCol);

        TableColumn fnameCol = new TableColumn("First Name");
        fnameCol.setMinWidth(200);
        fnameCol.setCellValueFactory(
            new PropertyValueFactory<CampusJournalist,String>("firstName")
        );
        cjTable.getColumns().add(fnameCol);

        TableColumn mnameCol = new TableColumn("Middle Name");
        mnameCol.setMinWidth(200);
        mnameCol.setCellValueFactory(
            new PropertyValueFactory<CampusJournalist,String>("middleName")
        );
        cjTable.getColumns().add(mnameCol);

        TableColumn snameCol = new TableColumn("School Name");
        snameCol.setMinWidth(200);
        snameCol.setCellValueFactory(
            new PropertyValueFactory<CampusJournalist,String>("schoolName")
        );
        cjTable.getColumns().add(snameCol);

    }


    public static void show(Stage stage) {
        stage.setScene(winnersEntryScene);
        stage.show();
    }


    public static void exit() {
        // WinnersEntryActivity.clearFields();
        PressConFX.rootStage.setScene(PressConFX.mainMenuScene);
    }
}

