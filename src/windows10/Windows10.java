/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package windows10;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Windows10 extends Application
{
    private double xOffset = 0;
    private double yOffset = 0;
    @Override
    public void start(Stage stage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        root.setOnMousePressed(
                new EventHandler<MouseEvent>()
                {
                    public void handle(MouseEvent ev)
                    {
                        xOffset = ev.getSceneX();
                        yOffset = ev.getSceneY();
                    }
                });


        root.setOnMouseDragged(
                new EventHandler<MouseEvent>()
                {
                    public void handle(MouseEvent event)
                    {
                        stage.setX(event.getScreenX() - xOffset);
                        stage.setY(event.getScreenY() - yOffset);
                    }
                });
        
        Scene scene = new Scene(root);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
    }

    
    public static void main(String[] args)
    {
        launch(args);
    }
    
}
