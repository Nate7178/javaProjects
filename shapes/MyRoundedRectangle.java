// Declaration of class MyRoundedRectangle.
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyRoundedRectangle 
{
   private int x; // x coordinate of center
   private int y; // y coordinate of center
   private int w; // width of the rounded rectangle
   private int h; // height of the rounded rectangle
   private int arcHeight;   // height of the arcs
   private int arcWidth;    // width of the arcs
   private Color myColor; // Color of this rectangle
   private boolean filled; // whether this shape is filled

   // constructor initializes private variables with default values
   public MyRoundedRectangle() 
   {
      this(0, 0, 0, 0, 0, 0, Color.BLACK, false); // call constructor
   }

   // constructor with input values
   public MyRoundedRectangle(int x, int y, int w, int h,
      int arcHeight, int arcWidth, Color color, boolean isFilled) 
   {
      setX(x); // set x coordinate of center
      setY(y); // set y coordinate of center
      setW(w); // set width of rectangle
      setH(h); // set height of rectangle
      setArcHeight(arcHeight);  // set height of arcs
      setArcWidth(arcWidth);    // set width of arcs
      setColor(color); // set the color
      setFilled(isFilled);
   }

   // set the x-coordinate of the center
   public void setX(int x) 
   {
     this.x = (x >= 0 ? x : 0);
   }

   // get the x-coordinate of the center
   public int getX() 
   {
     return x;
   }

   // set the width
   public void setW(int w) 
   {
     this.w = (w >= 0 ? w : 1);
   }

   // get the width
   public int getW() 
   {
     return w;
   }

   // set the y-coordinate of the center
   public void setY(int y) 
   {
     this.y = (y >= 0 ? y : 0);
   }

   // get the y-coordinate of the center
   public int getY() 
   {
     return y;
   }

   // set the height
   public void setH(int h) 
   {
     this.h = (h >= 0 ? h : 1);
   }

   // get the height
   public int getH() 
   {
     return h;
   }
   
   // set the arc height
   public void setArcHeight(int arcHeight) 
   {
     this.arcHeight = (arcHeight >= 0 ? arcHeight : 0);
   }

   // get the arc height
   public int getArcHeight() 
   {
     return arcHeight;
   }
   
   // set the arc width
   public void setArcWidth(int arcWidth) 
   {
     this.arcWidth = (arcWidth >= 0 ? arcWidth : 0);
   }

   // get the arc width
   public int getArcWidth() 
   {
     return arcWidth;
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

   // get shape width
   public int getWidth() 
   {
      return getW();
   } 

   // get shape height
   public int getHeight() 
   {
      return getH();
   } 
      
   // determines whether this shape is filled
   public boolean isFilled() 
   {
      return filled;
   } 
   
   // sets whether this shape is filled
   public void setFilled(boolean isFilled) 
   {
      filled = isFilled;
   }
   
   // draws a rounded rectangle in the specified color
   public void draw(GraphicsContext gc) 
   {      
      if (isFilled()) 
      {
         gc.setFill(getColor());
         gc.fillRoundRect(getX(), getY(),
            getWidth(), getHeight(), getArcWidth(), getArcHeight());
      }
      else 
      {
         gc.setStroke(getColor());
         gc.strokeRoundRect(getX(), getY(),
            getWidth(), getHeight(), getArcWidth(), getArcHeight());
      }
   }
}