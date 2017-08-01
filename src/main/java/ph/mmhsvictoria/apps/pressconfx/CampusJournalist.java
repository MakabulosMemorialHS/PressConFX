/* ***************************************************************
 * CampusJournalist.java
 *
 * ***************************************************************/
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

import javafx.beans.property.*;

public class CampusJournalist {

    private StringProperty lastName;
    private StringProperty firstName;
    private StringProperty middleName;
    private StringProperty penName;
    private StringProperty schoolName;



   public CampusJournalist() {
        lastName   = new SimpleStringProperty(this, "lastName", "");
        firstName  = new SimpleStringProperty(this, "firstName", "");
        middleName = new SimpleStringProperty(this, "middleName", "");
        penName    = new SimpleStringProperty(this, "penName", "");
        schoolName = new SimpleStringProperty(this, "schoolName", "");
   }


    public CampusJournalist(String pN, String lN, String fN, String mN, String schN) {
        lastName   = new SimpleStringProperty(this, "lastName", lN);
        firstName  = new SimpleStringProperty(this, "firstName", fN);
        middleName = new SimpleStringProperty(this, "middleName", mN);
        penName    = new SimpleStringProperty(this, "penName", pN);
        schoolName = new SimpleStringProperty(this, "schoolName", schN);

   }

    public final String getLastName() {
        return lastName.get();
    }

   public final String getFirstName() {
        return firstName.get();
    }


    public final String getMiddleName() {
        return middleName.get();
    }


    public final String getPenName() {
        return penName.get();
    }


    public final String getSchoolName() {
        return schoolName.get();
    }


    /* **************************
       SETTERS
       **************************/

    public final void setLastName(String aparam) {
        lastName.set(aparam);
    }


    public final void setFirstName(String aparam) {
        firstName.set(aparam);
    }


    public final void setMiddleName(String aparam) {
        middleName.set(aparam);
    }


    public final void setPenName(String aparam) {
        penName.set(aparam);    
    }


    public final void setSchoolName(String aparam) {
        schoolName.set(aparam);
    }

}

