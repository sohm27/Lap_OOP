package hust.soict.dsai.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.*;

import java.awt.Color;

import org.w3c.dom.events.MouseEvent;

public class PainterController {
    

    @FXML
    private Pane drawingAreaPane;
    private String decision ="";
    @FXML
    void clearButtonPressed(ActionEvent event){
        drawingAreaPane.getChildren().clear();
    }
    @FXML
	void menuButtonPressed(ActionEvent event) {
		tool = ((RadioButton)event.getSource()).getText();
	}
    @FXML
    void drawingAreaMouseDragged(MouseEvent event){
        Circle newCircle = new Circle();
        if (decision.equals("Pen")){
        Circle(event.getX(),event.getY(),4,Color.BLACK);
        }
        else if (decision.equals("Eraser")){
            newCircle = new Circle(event.getX(), event.getY(), 4, Color.WHITE);
        }
        drawingAreaPane.getChildren().add(newCircle);
    }
}
