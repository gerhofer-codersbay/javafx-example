import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Popup;
import javafx.stage.Stage;

import javax.swing.*;
import javax.swing.plaf.TabbedPaneUI;

public class HelloFX extends Application {

    @Override
    public void start(Stage stage) {
        Label welcomeLabel = new Label("Hello world!Hello world!Hello world!Hello world!Hello world!Hello world!Hello world!Hello world!");
        Button loginButton = new Button("Continue to login screen");
        loginButton.setOnAction(event -> {
            showLoginScreen(stage);
        });
        Scene scene = new Scene(new StackPane(welcomeLabel, loginButton), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    private void showLoginScreen(Stage stage) {
        GridPane grid = new GridPane();

        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);

        Button login = new Button("Login");
        login.setOnAction(click -> {
            login(userTextField.getText(), pwBox.getText(), stage);
        });
        grid.add(login, 1, 3);

        Button tabs = new Button("show tabs");
        tabs.setOnAction(click -> {
            showTabbedStuff(stage);
        });
        grid.add(tabs, 1, 4);

        Scene loginScene = new Scene(grid, 640, 480);
        stage.setTitle("Enter credentials to login");
        stage.setScene(loginScene);
        stage.show();
    }

    private static void login(String username, String password, Stage stage) {
        Popup popup = new Popup();
        popup.getContent().add(new Label("Hello " + username));
        popup.setAutoHide(true);
        popup.show(stage);
    }

    private static void showTabbedStuff(Stage stage) {
        TabPane tabPane = new TabPane();
        Tab tab1 = new Tab();
        tab1.setText("Tab 1");
        tab1.setContent(tab1Content());
        Tab tab2 = new Tab();
        tab2.setText("Tab 2");
        tab2.setContent(tab2Content());
        tabPane.getTabs().add(tab1);
        tabPane.getTabs().add(tab2);
        Scene tabbedScene = new Scene(tabPane, 640, 480);
        stage.setScene(tabbedScene);
        stage.show();

    }

    private static GridPane tab1Content() {
        GridPane gridpane = new GridPane();
        gridpane.add(new Label("Content of tab 1"), 100, 100);
        return gridpane;
    }

    private static GridPane tab2Content() {
        GridPane gridpane = new GridPane();
        gridpane.add(new Label("Content of tab 2"), 100, 100);

        TextArea textArea = new TextArea();
        gridpane.add(textArea, 1, 1);
        return gridpane;
    }

    public static void main(String[] args) {
        launch();
    }

}