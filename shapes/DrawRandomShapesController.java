// Drawing random Shapes.
import java.security.SecureRandom;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class DrawRandomShapesController 
{ 
   private static final SecureRandom randomNumbers = new SecureRandom();
   @FXML private Canvas canvas;

   // draws random lines
   @FXML
   void drawLinesButtonPressed(ActionEvent event) 
   {
      // get the GraphicsContext, which is used to draw on the Canvas
      GraphicsContext gc = canvas.getGraphicsContext2D();

      MyLine[] lines = new MyLine[100]; // stores the MyLine objects
      
      final int width = (int) canvas.getWidth();
      final int height = (int) canvas.getHeight();

      // create lines
      for (int count = 0; count < lines.length; count++) 
      {
         // generate random coordinates
         int x1 = randomNumbers.nextInt(width);
         int y1 = randomNumbers.nextInt(height);
         int x2 = randomNumbers.nextInt(width);
         int y2 = randomNumbers.nextInt(height);
         
         // generate a random color
         Color color = Color.rgb(randomNumbers.nextInt(256), 
            randomNumbers.nextInt(256), randomNumbers.nextInt(256));
         
         // add a new MyLine to the array
         lines[count] = new MyLine(x1, y1, x2, y2, color);
      } 

      // clear the Canvas then draw the lines
      gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight()); 

      for (MyLine line : lines) 
      {
         line.draw(gc);
      } 
   }

   // draws random ovals
   @FXML
   void drawOvalsButtonPressed(ActionEvent event) 
   {
      // get the GraphicsContext, which is used to draw on the Canvas
      GraphicsContext gc = canvas.getGraphicsContext2D();

      MyOval[] ovals = new MyOval[100]; // stores the MyOval objects
      
      final int width = (int) canvas.getWidth();
      final int height = (int) canvas.getHeight();

      // create lines
      for (int count = 0; count < ovals.length; count++) 
      {
         // generate random coordinates
         int x1 = randomNumbers.nextInt(width);
         int y1 = randomNumbers.nextInt(height);
         int x2 = randomNumbers.nextInt(width);
         int y2 = randomNumbers.nextInt(height);
         
         // generate a random color
         Color color = Color.rgb(randomNumbers.nextInt(256), 
            randomNumbers.nextInt(256), randomNumbers.nextInt(256));
         
         // add a new MyOval to the array
         ovals[count] = new MyOval(x1, y1, x2, y2, color, randomNumbers.nextBoolean());
      } 

      // clear the Canvas then draw the lines
      gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight()); 

      for (MyOval oval : ovals) 
      {
         oval.draw(gc);
      } 
   }
   
   // draws random rectangles
   @FXML
   void drawRectanglesButtonPressed(ActionEvent event) {
      // get the GraphicsContext, which is used to draw on the Canvas
      GraphicsContext gc = canvas.getGraphicsContext2D();

      MyRectangle[] rectangles = new MyRectangle[100]; // stores the MyRect objects
      
      final int width = (int) canvas.getWidth();
      final int height = (int) canvas.getHeight();

      // create lines
      for (int count = 0; count < rectangles.length; count++) 
      {
         // generate random coordinates
         int x1 = randomNumbers.nextInt(width);
         int y1 = randomNumbers.nextInt(height);
         int x2 = randomNumbers.nextInt(width);
         int y2 = randomNumbers.nextInt(height);
         
         // generate a random color
         Color color = Color.rgb(randomNumbers.nextInt(256), 
            randomNumbers.nextInt(256), randomNumbers.nextInt(256));
         
         // add a new MyRectangle to the array
         rectangles[count] = new MyRectangle(x1, y1, x2, y2, color, randomNumbers.nextBoolean());
      } 

      // clear the Canvas then draw the lines
      gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight()); 

      for (MyRectangle rectangle : rectangles) 
      {
         rectangle.draw(gc);
      } 
   }
   
   // draws random rounded rectangles
   @FXML
   void drawRoundedRectanglesButtonPressed(ActionEvent event) {
      // get the GraphicsContext, which is used to draw on the Canvas
      GraphicsContext gc = canvas.getGraphicsContext2D();

      MyRoundedRectangle[] roundedRectangles = new MyRoundedRectangle[100]; // stores the MyRoundedRect objects
      
      final int width = (int) canvas.getWidth();
      final int height = (int) canvas.getHeight();

      // create lines
      for (int count = 0; count < roundedRectangles.length; count++) 
      {
         // generate random coordinates
         int x = randomNumbers.nextInt(width);
         int y = randomNumbers.nextInt(height);
         int w = randomNumbers.nextInt(width);
         int h = randomNumbers.nextInt(height);
         int arcHeight = randomNumbers.nextInt(h/2);
         int arcWidth = randomNumbers.nextInt(w/2);
         
         // generate a random color
         Color color = Color.rgb(randomNumbers.nextInt(256), 
            randomNumbers.nextInt(256), randomNumbers.nextInt(256));
         
         // add a new MyRectangle to the array
         roundedRectangles[count] = new MyRoundedRectangle(x, y, w, h, arcHeight, arcWidth, color, randomNumbers.nextBoolean());
      } 

      // clear the Canvas then draw the lines
      gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight()); 

      for (MyRoundedRectangle roundedRectangle : roundedRectangles) 
      {
         roundedRectangle.draw(gc);
      } 
   }
}
