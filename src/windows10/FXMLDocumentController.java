/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package windows10;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.Window;

public class FXMLDocumentController implements Initializable
{
    private double lastX = 0.0d;
    private double lastY = 0.0d;
    private double lastWidth = 0.0d;
    private double lastHeight = 0.0d;
    
    int a = 1;
    
    @FXML
    private HBox hb;
    private Button maxbtn;
    
    public void Exit(ActionEvent e)
    {
        System.exit(0);
    }
    
    public void Minimize(ActionEvent evt)
    {
        Stage s = (Stage)((Button)evt.getSource()).getScene().getWindow();
        s.setIconified(true);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        
    }
    
    public void ChangeStyleGray(MouseEvent e)
    {
        hb.setStyle("-fx-background-color: gray;");
    }
    
    public void ChangeStyleBlack(MouseEvent e)
    {
        hb.setStyle("-fx-background-color: black;");
    }
    
    public void ChangeStyleBlue(MouseEvent e)
    {
        hb.setStyle("-fx-background-color: blue;");
    }
    
    public void ChangeStyleGreen(MouseEvent e)
    {
        hb.setStyle("-fx-background-color: green;");
    }
    
    public void ChangeStyleBrown(MouseEvent e)
    {
        hb.setStyle("-fx-background-color: brown;");
    }
    
    public void ChangeStyleWhite(MouseEvent e)
    {
        hb.setStyle("-fx-background-color: white;");
    }
    
    
    public void maximize(ActionEvent evt)
    {
        Node n = (Node)evt.getSource();

        Window w = n.getScene().getWindow();

        double currentX = w.getX();
        double currentY = w.getY();
        double currentWidth = w.getWidth();
        double currentHeight = w.getHeight();

        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        if( currentX != bounds.getMinX() && currentY != bounds.getMinY() &&
                currentWidth != bounds.getWidth() &&
                currentHeight != bounds.getHeight() ) {

            w.setX(bounds.getMinX());
            w.setY(bounds.getMinY());
            w.setWidth(bounds.getWidth());
            w.setHeight(bounds.getHeight());

            lastX = currentX; // save old dimensions
            lastY = currentY;
            lastWidth = currentWidth;
            lastHeight = currentHeight;

        } else {

            // de-maximize the window (not same as minimize)

            w.setX(lastX);
            w.setY(lastY);
            w.setWidth(lastWidth);
            w.setHeight(lastHeight);
        }
        
        evt.consume();
    }
}
