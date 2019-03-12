//import java.awt.Insets;
//import java.geometry;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

import javafx. *;


public class Main /*extends Application*/{

	public static void main(String[] args) {
        //launch(args);
		
		System.out.println("Hello World!");
		System.out.println("I hate everything.");
		System.out.println("This is way harder than it needs to be.");
		System.out.println("Goodbye World!");
		
		//TESTY TESTY
		TestBank banky = new TestBank();
		ArrayList<String> answers = new ArrayList<String>();
		answers.add("x = 4");
		answers.add("x = 87");
		answers.add("x = -2");
		answers.add("x = 34");
		
		Question q1 = new Question("What is 2 + 2?", answers, "Arithmetic", "Analyze");

		answers.set(0, "An integer");
		answers.set(1, "A word");
		answers.set(2, "A character");
		answers.set(3, "A data structure");

		Question q2 = new Question("What is an int?", answers, "Data Types", "Remember");
		
		answers.set(0, "A thing (right)");
		answers.set(1, "Something else");
		answers.set(2, "Some other thing");
		answers.set(3, "Something else ALTOGETHER");
		
		Question q3 = new Question("What does \'static\' mean?", answers, "Arithmetic", "Remember");
		
		answers.set(0, "An integer");
		answers.set(1, "A word");
		answers.set(2, "A character");
		answers.set(3, "A data structure");

		Question q4 = new Question("What is a char?", answers, "Data Types", "Remember");
		
		banky.addQuest(q1);
		banky.addQuest(q2);
		banky.addQuest(q3);
		banky.addQuest(q4);
	
		
		ArrayList<String> topics = new ArrayList<String>();
		topics.add("Arithmetic");
		topics.add("Data Types");
		Testing quiz = new Testing(1, topics, banky);
		
		for(int i = 0; i < 4; i++){
			System.out.println(quiz.getQ(i).getText());
			for(int j = 0; j < 4; j++){
				System.out.println("\t"+quiz.getQ(i).getAnswer(j));
			}
		}
		
    }
    
    /*@Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("AP Computer Science Prep");
        

        //creates a grid in the center
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        
        grid.setHgap(10);
        grid.setVgap(10);
        
        //controls padding around the edges
        grid.setPadding(new Insets(25,25,25,25));
        
        //makes size of the window
        Scene scene = new Scene(grid, 1080, 720);
        primaryStage.setScene(scene);
        
        
        //Layout Text for welcome screen
        Text scenetitle = new Text("Welcome Back!");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 26));
        grid.add(scenetitle, 12, 3, 2, 1);
        
        //add style sheet
        scene.getStylesheets().add
        (Main.class.getResource("StyleForCAI.css").toExternalForm());
        primaryStage.show();
    }*/
}