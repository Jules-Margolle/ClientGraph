package com.julesmargolle.ClientGraph;

import java.net.Socket;

import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Client 
{
    private Stage stage;
    private Socket socket;

    public Client(String ip, int port, Stage stage)
    {
        this.stage = stage;
        


        try
        {
            this.socket = new Socket(ip, port);
        }
        catch(Exception e)
        {
            System.err.println("Client creation failed : " + e.getMessage());
        }
    }

    void start()
    {
        log();
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("Client.fxml"));
        }
        catch(Exception e)
        {
            System.err.println("FXML LOAD : " + e.getMessage());
        }
    }

    void log()
    {
        VBox root = new VBox();
        TextField input = new TextField();
        root.getChildren().add(input);  

        input.setOnAction(event->{
            String name = input.getText();
            System.out.println("User sent his name : "+name);
        });

        Scene logScene = new Scene(root, 300, 250);
        this.stage.setScene(logScene);

        this.stage.show();

    }
}
