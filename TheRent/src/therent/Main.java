package therent;

import com.jfoenix.controls.JFXButton;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import therent.view.Cliente.control_MenuCliente;
import therent.view.LogWindowControl;
import therent.view.MainFrameControl;
import therent.view.*;
import java.io.IOException;

public class Main extends Application {
    Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("TheRent Link System");
        showLogin();

    }

    public void showMainFrame(String role) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/MainFrame.fxml"));
        try {
            AnchorPane root = loader.load();
            primaryStage.setScene(new Scene(root));
            primaryStage.setMaximized(true);
            MainFrameControl ctrl = loader.getController();
            ctrl.setRole(role);
            ctrl.setMain(this);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void showLogin() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/LogWindow.fxml"));
        try {
            AnchorPane root = loader.load();
            //la ventana de login NO se carga en el primaryStage
            Stage dlgStage = new Stage();
            dlgStage.setTitle("Inicio de Sesión");
            dlgStage.initModality(Modality.WINDOW_MODAL);
            dlgStage.setResizable(false);
            dlgStage.setScene(new Scene(root));
            LogWindowControl ctrl = loader.getController();
            ctrl.setDlgStage(dlgStage);
            ctrl.setMain(this);
            dlgStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showClient() {

        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(Main.class.getResource("view/Cliente/MenuCliente.fxml"));

        try {

            AnchorPane root=loader.load();

           control_MenuCliente ctrl=loader.getController();

            ctrl.setMain(this);

            primaryStage.setMaximized(false);

            primaryStage.setScene(new Scene(root));

            primaryStage.setMaximized(true);

            primaryStage.show();

        } catch (IOException e) {

            e.printStackTrace();

        }
    }

    //Abre la ventana cliente
    public void showClienteTel()
    {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/Cliente/viewTelefono.fxml"));
        try {
            AnchorPane root=loader.load();
            Stage dlgStage=new Stage();
            dlgStage.initModality(Modality.APPLICATION_MODAL);
            dlgStage.setScene(new Scene(root));
            dlgStage.setResizable(false);
            dlgStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Abre la ventana correo
    public void showClienteCorreo()
    {

        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/Cliente/viewCorreo.fxml"));
        try {
            AnchorPane root=loader.load();
            Stage dlgStage=new Stage();
            dlgStage.initModality(Modality.APPLICATION_MODAL);
            dlgStage.setScene(new Scene(root));
            dlgStage.setResizable(false);
            dlgStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Abre la ventana para mostrar los datos completos
    public  void showDatosCompleto()
    {
        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(Main.class.getResource("view/Cliente/viewDatosCompleto.fxml"));
        try {
            AnchorPane root=loader.load();
            Stage dlgStage=new Stage();
            dlgStage.initModality(Modality.APPLICATION_MODAL);
            dlgStage.setScene(new Scene(root));
            dlgStage.setResizable(false);
            dlgStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Cierra ventana, es creado para cerrar el showCliente y showCorreo
    public void closeViewCliente(JFXButton button)
    {
        Stage stage = (Stage) button.getScene().getWindow();
        stage.close();
    }

    /*TODO:
       1: implementar el resto de laas funcionalidades, cada quien en su rama
    *  issue 1: RESUELTO
    *  issue 2: investigar como crear una pantalla de carga, ya que el servidor bd
    *  remoto toma tiempo en responder*/

    public static void main(String[] args) {
        launch(args);
    }
}
