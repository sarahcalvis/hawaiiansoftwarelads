import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import javafx. *;


public class Main extends Application{
	int whatPageWeOn = 1;
	Student studentObj = new Student();
	public static void main(String[] args) {
		//GridPane grid = new GridPane();
		//TESTY TESTY
		//create bank
		
				
        launch(args);
		
		
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("AP Computer Science Prep");
        GridPane grid = new GridPane();
        VBox vb = new VBox();
        //vb.setSpacing(10);
        //vb.setPadding(new Insets(10,10,10,10));
        
        //vb.setAlignment(Pos.CENTER);

        //creates a grid in the center
        //GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        
        grid.setHgap(10);
        grid.setVgap(10);
        
        //controls padding around the edges
        //grid.setPadding(new Insets(10,10,10,10));
        
        //makes size of the window
        Scene scene = new Scene(grid, 1080, 720);
        primaryStage.setScene(scene);
        //adds preliminary home screen UI
        Text scenetitle = new Text("Welcome Back!");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 26));
        grid.add(scenetitle, 2,1);
        buttons(grid, primaryStage);
        scene.getStylesheets().add
        (Main.class.getResource("Buttons.css").toExternalForm());
    }
        
    
        public void buttons(GridPane grid, Stage primaryStage){
	        //
	        //NAVIGATION BAR
	        //Maybe copy this code for the other pages???
	        //
        	//create a VBox to put all the buttons in???
        	VBox vb = new VBox();
	        //home button
	        Button home = new Button();
	        home.setText("Home");
	        home.setTextFill(Color.BLUE);
	        home.setMaxWidth(Double.MAX_VALUE);
	        home.setOnAction(new EventHandler<ActionEvent>() {
	        	@Override
	        	public void handle(ActionEvent event) {
	        		System.out.println("Pressed Home Button");
	        		// clear current screen
	        		grid.getChildren().clear(); 
	        		//add home screen shenanigans
	                Text scenetitle = new Text("Welcome Back!");
	                scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 26));
	                grid.add(scenetitle, 2,1);
	        		//calls buttons to set up the navbar again
	        		buttons(grid, primaryStage);
	                System.out.println("finished creating");
	        	}
	        });
	        grid.add(home, 5, 3);
	        
	        //textbook button
	        Button textbk = new Button();
	        textbk.setText("Textbook");
	        textbk.setTextFill(Color.BLUE);
	        textbk.setMaxWidth(Double.MAX_VALUE);
	        textbk.setOnAction(new EventHandler<ActionEvent>() {
	        	@Override
	        	public void handle(ActionEvent event) {
	        		System.out.println("Pressed Textbook Button");
	        		grid.getChildren().clear();
	        		//add textbook information here
	        		Text scenetitle = new Text("Think Java");
	                scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 26));
	                grid.add(scenetitle, 2, 1);
	                //add the nav bar back
	        		buttons(grid, primaryStage);
	        		System.out.println("finished creating");
	        		String pageNumber = Integer.toString(whatPageWeOn);
	        		if (pageNumber.length() == 1) {
	        			pageNumber = "00"+pageNumber;
	        		}
	        		else if (pageNumber.length() == 2) {
	        			pageNumber = "0"+pageNumber;
	        		}
	        		
	        		String file = "file:src/thinkjava(1)-page-"+pageNumber+".jpg";
	        		System.out.println(file);
	        		Image image = new Image(file);
	        		ImageView ivText = new ImageView();
	                ivText.setImage(image);
	                ivText.setFitHeight(700);
	                ivText.setFitWidth(400);
	                grid.add(ivText, 2, 2);
	        		Button btnNextPage = new Button("Next Page");
	        		btnNextPage.setOnAction(new EventHandler<ActionEvent>() {
	        			@Override
	        			public void handle(ActionEvent event) {
	        				grid.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 2 &&GridPane.getColumnIndex(node) == 2);
	        				if (whatPageWeOn < 291) {
	        					whatPageWeOn++;
	        					String pageNumber = Integer.toString(whatPageWeOn);
	        	        		if (pageNumber.length() == 1) {
	        	        			pageNumber = "00"+pageNumber;
	        	        		}
	        	        		else if (pageNumber.length() == 2) {
	        	        			pageNumber = "0"+pageNumber;
	        	        		}
	        					String file = "file:src/thinkjava(1)-page-"+pageNumber+".jpg";
	        	        		System.out.println(file);
	        	        		Image image = new Image(file);
	        	        		ImageView ivText = new ImageView();
	        	                ivText.setImage(image);
	        	                ivText.setFitHeight(700);
	        	                ivText.setFitWidth(400);
	        	                grid.add(ivText, 2, 2);
	        				}
        					
	        			}
	        		});
	        		grid.add(btnNextPage, 4, 1);
	        		Button btnPrevPage = new Button("Previous Page");
	        		btnPrevPage.setOnAction(new EventHandler<ActionEvent>() {
	        			@Override
	        			public void handle(ActionEvent event) {
	        				grid.getChildren().removeIf(node -> GridPane.getRowIndex(node) == 2 &&GridPane.getColumnIndex(node) == 2);
	        				if (whatPageWeOn > 1) {
	        					whatPageWeOn--;
	        					String pageNumber = Integer.toString(whatPageWeOn);
	        	        		if (pageNumber.length() == 1) {
	        	        			pageNumber = "00"+pageNumber;
	        	        		}
	        	        		else if (pageNumber.length() == 2) {
	        	        			pageNumber = "0"+pageNumber;
	        	        		}
	        					String file = "file:src/thinkjava(1)-page-"+pageNumber+".jpg";
	        	        		System.out.println(file);
	        	        		Image image = new Image(file);
	        	        		ImageView ivText = new ImageView();
	        	                ivText.setImage(image);
	        	                ivText.setFitHeight(650);
	        	                ivText.setFitWidth(425);
	        	                grid.add(ivText, 2, 2);
	        				}
	        			}
	        		});
	        		grid.add(btnPrevPage, 3, 1);
	        	}
	        });
	        grid.add(textbk, 4, 10);
	        
	        //lesson button
	        Button lessons = new Button();
	        lessons.setText("Lessons");
	        lessons.setTextFill(Color.BLUE);
	        lessons.setMaxWidth(Double.MAX_VALUE);
	        lessons.setOnAction(new EventHandler<ActionEvent>() {
	        	@Override
	        	public void handle(ActionEvent event) {
	        		System.out.println("Pressed Lessons Button");
	        		grid.getChildren().clear();
	        		//add lessons information here
	        		Text scenetitle = new Text("Lessons");
	                scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 26));
	                grid.add(scenetitle, 2,1);
	                //add the nav bar back
	        		buttons(grid, primaryStage);
	        		System.out.println("finished creating");
	        	}
	        });
	        grid.add(lessons, 5, 18);
	        
	        //Test/quizzes button
	        Button exams = new Button();
	        exams.setText("Quizzes and Exams");
	        exams.setTextFill(Color.BLUE);
	        exams.setMaxWidth(Double.MAX_VALUE);
	        exams.setOnAction(new EventHandler<ActionEvent>() {
	        	@Override
	        	public void handle(ActionEvent event) {
	        		System.out.println("Pressed Exams Button");
	        		grid.getChildren().clear();
	        		//add Exams information here
	        		Text scenetitle = new Text("Tests and Quizzes");
	                scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 26));
	                grid.add(scenetitle, 2, 1);
	                //add the nav bar back
	        		buttons(grid, primaryStage);
	        		System.out.println("finished creating");
	        		

	        		
	        		
					//add button here 
			        Button takeQuizButt = new Button();
			        takeQuizButt.setText("Take Quiz");
			        takeQuizButt.setTextFill(Color.BLUE);
			        takeQuizButt.setMaxWidth(Double.MAX_VALUE);
			        takeQuizButt.setOnAction(new EventHandler<ActionEvent>() {
			        	@Override
			        	public void handle(ActionEvent event) {
			        		
			        		grid.getChildren().remove(takeQuizButt);
			        		//add questions
			                // create a tile pane 
			                TilePane quest = new TilePane(); 
			          
			                // create a label 
			                //this will become the question
			                Label l = new Label("An object is an instance of a ________. "); 
			          
			                // string array
			                //this will become the possible answers
			                String st[] = { "method", "object", "class", "interface" }; 
			          
			                // add label 
			                quest.getChildren().add(l); 
			                
			                //make array for the checkboxes
			                ArrayList<CheckBox> boxes = new ArrayList<CheckBox>();
			          
			                for (int i = 0; i < st.length; i++) { 
			          
			                    // create a checkbox 
			                    CheckBox c = new CheckBox(st[i]); 
			                    // add label 
			                    quest.getChildren().add(c);
			                    //add to arraylist
			                    boxes.add(c);

			                }
				             // create a event handler for each checkbox
			                EventHandler<ActionEvent> boxEvent = new EventHandler<ActionEvent>() { 
			      
			                    public void handle(ActionEvent e) 
			                    { 
			                    	for (int i = 0; i < boxes.size(); i++) {
			                    		CheckBox c = boxes.get(i);
				                        if (c.isSelected()) 
				                            System.out.println(c.toString() + " selected");
				                        //else
				                           //System.out.println("not selected");
				                        
				                    } 
			                    }
			      
			                }; 
			                
			                //add event to all checkboxes
			                for (int i = 0; i < boxes.size(); i++) {
	                    		CheckBox c = boxes.get(i);
	                    		c.setOnAction(boxEvent); 
			                }
			      
			                
			                //add all this to grid
			                grid.add(quest, 2, 4);
			        }
			        });
			        grid.add(takeQuizButt, 10, 18);
	        		
	        	}
	        });
	        grid.add(exams, 3, 25);
	        
	        
	        //diagnostics button
	        Button diagnostics = new Button();
	        diagnostics.setText("Diagnostics");
	        diagnostics.setTextFill(Color.BLUE);
	        diagnostics.setMaxWidth(Double.MAX_VALUE);
	        diagnostics.setOnAction(new EventHandler<ActionEvent>() {
	        	@Override
	        	public void handle(ActionEvent event) {
	        		System.out.println("Pressed Diagnostics Button");
	        		grid.getChildren().clear();
	        		//add diagnostics information here
	        		Text scenetitle = new Text("Diagnostics");
	                scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 26));
	                grid.add(scenetitle, 2, 1);
	                //add the nav bar back
	        		buttons(grid, primaryStage);
	        		System.out.println("finished creating");
	        		Map<String,Tuple> stats = studentObj.getStats();
	        		ArrayList<String> keys = new ArrayList<String>();
	        		for (int i = 1; i < 7; i++) {
	        			keys.add("Bloom " + i);
	        		}
	        		keys.add("Comments");
	        		keys.add("Primitive Types");
	        		keys.add("Operators");
	    			keys.add("Object Comparison");
	    			keys.add("Escape Sequences");
	    			keys.add("I/O");
	    			keys.add("Exceptions");
	    			keys.add("Arrays");
	    			keys.add("Control Statements");
	    			keys.add("Variables");
	    			keys.add("Methods");
	    			keys.add("Constructors");
	    			keys.add("Classes");
	    			keys.add("Interfaces");
	    			keys.add("Packages");
	    			keys.add("Miscellaneous Object Oriented Programming");
	        		
	        		String s = "";
	        		for (int i = 0; i < keys.size(); i++) {
	        			s += keys.get(i) + ": " + stats.get(keys.get(i)).getTuple() + "\n";
	        		}
	        		Text diagnosticInfo = new Text(s);
	        		diagnosticInfo.setFont(Font.font("Tahoma", FontWeight.NORMAL, 18));
	        		grid.add(diagnosticInfo, 2, 2);
	        	}
	        });
	        grid.add(diagnostics, 5, 33);
	        
	        //settings button
	        Button settings = new Button();
	        settings.setText("Settings");
	        settings.setTextFill(Color.BLUE);
	        settings.setMaxWidth(Double.MAX_VALUE);
	        settings.setOnAction(new EventHandler<ActionEvent>() {
	        	@Override
	        	public void handle(ActionEvent event) {
	        		System.out.println("Pressed Settings Button");
	        		grid.getChildren().clear();
	        		//add settings information here
	        		Text scenetitle = new Text("Settings");
	                scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 26));
	                grid.add(scenetitle, 2, 1);
	                //add the nav bar back
	        		buttons(grid, primaryStage);
	        		System.out.println("finished creating");
	        	}
	        });
	        grid.add(settings, 5, 40);
	        
	        //add buttons to VB
	        vb.getChildren().addAll(home,lessons,textbk,diagnostics,exams,settings);
	        //add VB to grid
	        grid.add(vb,0,1,1,4);
	        
	        //add style sheet
	        //scene.getStylesheets().add
	        //(Main.class.getResource("Buttons.css").toExternalForm());
	        primaryStage.show();
        }
    }