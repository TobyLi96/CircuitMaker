package circuitmaker.test;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.File;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.DirectoryChooser;



public class CircuitTest{
	
	
	@Test
	public void testImageView() {
		VBox components = new VBox();
		
		final ImageView battery = new ImageView();
        battery.setImage(new Image(CircuitTest.class.getResourceAsStream("../rsrc/Cell.png")));
        components.getChildren().add(battery);
       
        	
        ImageView currentImage = (ImageView)components.getChildren().get(0);
      
        boolean testEqual = imageEqual(currentImage.getImage(), new Image(CircuitTest.class.getResourceAsStream("../rsrc/Cell.png")));
       
        
        assertTrue( testEqual == true) ;
	}
	
	
	 boolean imageEqual(Image image1, Image image2) {
         PixelReader pr1 = image1.getPixelReader();
         PixelReader pr2 = image2.getPixelReader();
         boolean isEqual = true;
         for (int i = 0; i < 40; i++) {
             for (int j = 0; j < 40; j++) {
                 if (pr1.getArgb(i, j) != pr2.getArgb(i, j)) {
                     isEqual = false;
                 }
             }
         }
         return isEqual;
     }
	 
	 @Test
	 public void testPane() {
		Canvas wirePane = new Canvas();
        wirePane.setHeight(400);
        wirePane.setWidth(400);
        wirePane.setStyle("-fx-background-color: #99ccff;");
        double height = wirePane.getHeight();
        double width = wirePane.getWidth();
        String style =  wirePane.getStyle();
	    assertTrue( height == 400 && width == 400 && style == "-fx-background-color: #99ccff;") ;
	}
	
	
	@Test
	public void imageEqual(){
		Image image1 = new Image(CircuitTest.class.getResourceAsStream("../rsrc/Cell.png"));
		Image image2 = new Image(CircuitTest.class.getResourceAsStream("../rsrc/Cell.png"));
		
		boolean checkImage = imageEqual(image1, image2);
		assertTrue( checkImage == true) ;
		
	}
	
	
	
	
    
}
