// Main application class that loads and displays 
//the DrawRandomShapes GUI.
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DrawRandomShapes extends Application 
{
   @Override
   public void start(Stage stage) throws Exception 
   {
      // loads Welcome.fxml and configures the DrawRandomShapesController
      Parent root = 
         FXMLLoader.load(getClass().getResource("DrawRandomShapes.fxml"));

      Scene scene = new Scene(root); // attach scene graph to scene
      stage.setTitle("Draw Random Shapes"); // displayed in window's title bar
      stage.setScene(scene); // attach scene to stage
      stage.show(); // display the stage
   }

   public static void main(String[] args) 
   {
      launch(args); 
   }
}
