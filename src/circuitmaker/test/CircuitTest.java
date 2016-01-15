package circuitmaker.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;



public class CircuitTest {

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
	
	private Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                return node;
            }
        }
        return null;
    }
	
	@Test
	public void testImageView() {
		VBox components = new VBox();
		
		final ImageView battery = new ImageView();
        battery.setImage(new Image(CircuitTest.class.getResourceAsStream("../rsrc/Cell.png")));
        components.getChildren().add(battery);
       
        	
        ImageView currentImage = (ImageView)components.getChildren().get(0);
      
        boolean testEqual = imageEqual(currentImage.getImage(), new Image(CircuitTest.class.getResourceAsStream("../rsrc/Cell.png")));
       
        
        assertTrue(testEqual) ;
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
	    assertTrue(height == 400 && width == 400 && style == "-fx-background-color: #99ccff;") ;
	}
	
	 @Test
	 public void testDrawLine(){
		 Line line = new Line();
		 line.setStartX(0.0);
		 line.setStartY(0.0);
		 line.setEndX(100.0);
		 line.setEndY(100.0);
		 double startX = line.getStartX();
		 double startY = line.getStartY();
		 double endX = line.getEndX();
		 double endY = line.getEndY();
		 assertTrue(startX == 0.0 && startY == 0.0 && endX == 100.0 && endY == 100.0);
	 }
	
	@Test
	public void testImageEqual(){
		Image image1 = new Image(CircuitTest.class.getResourceAsStream("../rsrc/Cell.png"));
		Image image2 = new Image(CircuitTest.class.getResourceAsStream("../rsrc/Cell.png"));
		
		boolean checkImage = imageEqual(image1, image2);
		assertTrue(checkImage) ;
		
	}
	
	@Test
	public void testCellContent(){
		GridPane grid = new GridPane();
		grid.setPrefSize(400, 400);
		for (int i = 0; i < 10; i++) {
	        for (int j = 0; j < 10; j++) {
	            ImageView cell = new ImageView();
	            cell.setFitWidth(40);
	            cell.setFitHeight(40);
	            if(i == 5 && j == 5){
	            	cell.setImage(new Image(CircuitTest.class.getResourceAsStream("../rsrc/Cell.png")));
	            }
	            grid.add(cell, i, j);
	        }
	    }
	
		ImageView currentImage = (ImageView)getNodeFromGridPane(grid, 5, 5);
		boolean testEqual = imageEqual(currentImage.getImage(), new Image(CircuitTest.class.getResourceAsStream("../rsrc/Cell.png")));
		
		assertTrue(testEqual);
		
		
	}
}