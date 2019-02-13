// Declaration of class MyLine.
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyLine 
{
   private int x1; // x coordinate of first endpoint
   private int y1; // y coordinate of first endpoint
   private int x2; // x coordinate of second endpoint
   private int y2; // y coordinate of second endpoint
   private Color myColor; // color of this shape

   // constructor initializes private variables with default values
   public MyLine() 
   {
      this(0, 0, 0, 0, Color.BLACK); // call constructor to set values
   }

   // constructor with input values
   public MyLine(int x1, int y1, int x2, int y2, Color color) 
   {
      setX1(x1); // set x coordinate of first endpoint
      setY1(y1); // set y coordinate of first endpoint
      setX2(x2); // set x coordinate of second endpoint
      setY2(y2); // set y coordinate of second endpoint
      setColor(color); // set the color
   }

   // set the x-coordinate of the first point
   public void setX1(int x1) 
   {
     this.x1 = (x1 >= 0 ? x1 : 0);//using ?: as if...else
   }

   // get the x-coordinate of the first point
   public int getX1() 
   {
     return x1;
   }

   // set the x-coordinate of the second point
   public void setX2(int x2) 
   {
     this.x2 = (x2 >= 0 ? x2 : 0);
   }

   // get the x-coordinate of the second point
   public int getX2() 
   {
     return x2;
   }

   // set the y-coordinate of the first point
   public void setY1(int y1) 
   {
     this.y1 = (y1 >= 0 ? y1 : 0);
   }

   // get the y-coordinate of the first point
   public int getY1() 
   {
     return y1;
   }

   // set the y-coordinate of the second point
   public void setY2(int y2) 
   {
     this.y2 = (y2 >= 0 ? y2 : 0);
   }

   // get the y-coordinate of the second point
   public int getY2() 
   {
     return y2;
   }

   // set the color
   public void setColor(Color color) 
   {
      myColor = color;
   }

   // get the color
   public Color getColor() 
   {
      return myColor;
   }
   
   // draw the line in the specified color
   public void draw(GraphicsContext gc) 
   {
      gc.setStroke(getColor());
      gc.strokeLine(getX1(), getY1(), getX2(), getY2());
   }
}

