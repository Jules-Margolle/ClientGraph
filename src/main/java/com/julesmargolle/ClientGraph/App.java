package com.julesmargolle.ClientGraph;


import javafx.application.Application;
import javafx.stage.Stage;


public class App extends Application
{
    public void start( Stage primaryStage ) throws Exception
    {
        Client client = new Client("127.0.0.1", 8080, primaryStage);
        client.start();
        
    
    }
    public static void main( String[] args )
    {
        launch(args);
    }
}
