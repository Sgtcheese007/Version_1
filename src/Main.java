package Controller;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.io.File;
import java.util.Optional;

import static java.awt.SystemColor.desktop;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        BorderPane mainborderpane = new BorderPane();

        Scene mainscene = new Scene(mainborderpane);
        mainscene.getStylesheets().add("stylesheet.css");
        stage.setScene(mainscene);
        stage.setMinHeight(800);
        stage.setMinWidth(800);

        //making the main menu title
        Label title = new Label("QuizNow");
        title.getStyleClass().add("label_text_title");
        mainborderpane.setTop(title);

        //make vbox
        VBox leftVBox = new VBox();
        leftVBox.setPadding(new Insets(10, 10, 10, 10));

        //play button
        Button playbutton = new Button("Play!");
        BorderPane.setAlignment(playbutton, Pos.CENTER_LEFT);
        playbutton.getStyleClass().add("button_layout_1");
        leftVBox.getChildren().add(playbutton);

        //help button
        Button helpbutton = new Button("Help");
        BorderPane.setAlignment(helpbutton, Pos.BOTTOM_LEFT);
        helpbutton.getStyleClass().add("button_layout_1");
        leftVBox.getChildren().add(helpbutton);

        mainborderpane.setLeft(leftVBox);

        //combobox
        ObservableList options = FXCollections.observableArrayList("Option 1", "Option 2", "Option 3");
        ComboBox quizselectbox = new ComboBox(options);
        quizselectbox.getSelectionModel().select(0);
        quizselectbox.getStyleClass().add("combobox_layout");
        mainborderpane.setCenter(quizselectbox);

        // close button
        Button closebutton = new Button("X");
        closebutton.setOnAction((ActionEvent ae) -> exitPrompt(ae));//code linking the exit button to the close program code
        BorderPane.setAlignment(helpbutton, Pos.BOTTOM_LEFT);
        closebutton.getStyleClass().add("button_layout_2");
        mainborderpane.setBottom(closebutton);

        //making program fullscreen by default
        stage.setFullScreen(true);

        //shows stage
        stage.show();
    }

    //code that makes the exit button close the program
    private static void exitPrompt(ActionEvent ae) {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("ALERT");
        alert.setHeaderText("Are you sure you want to exit?");

        Optional result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            System.exit(420);
        } else {
            ae.consume();
        }

    }
    public static void main(String[] args) {
        launch(args);
    }
}