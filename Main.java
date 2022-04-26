package application;
	

import java.util.Random;

import org.w3c.dom.css.Rect;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class Main extends Application {
	
	
	
	Board board;
	Label x;
	Label o;
	
	int mood;
	/*
	 * easy = 1
	 * hard = 2
	 * two = 3
	 */
	
	
	boolean check;
	Pane root;
	@Override
	public void start(Stage stage) {
		try {
			
			
			//_______________________________________

			root = new Pane();
			Scene scene = new Scene(root,800,600);
			
			Pane pane2 = new Pane();
			
			//_____________________________________
			stage.setResizable(false);
			
		      Stop[] stops2 = new Stop[] {
		    	         new Stop(0, Color.rgb(39, 29, 33)),
		    	         new Stop(.5, Color.rgb(69, 44, 53)),
		    	         new Stop(1, Color.rgb(96, 54, 69))
		    	         
		    	      };
		      LinearGradient gradient2 = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops2);
			Label titel = new Label("Tic Tac Toe");
			titel.setTextFill(gradient2);
			titel.setLayoutX(280);
			titel.setLayoutY(20);

			titel.setFont(Font.font("Bodoni MT Black", FontWeight.BLACK, 30));

			
			Rectangle rec = new Rectangle(800,600);
			rec.setStyle("-fx-fill:#2980B9;");
			root.getChildren().addAll(rec, titel);
			
			Button reset = new Button("Reset");
			reset.setLayoutX(350);
			reset.setLayoutY(400);

			//___________________________________________________________________________________

			Stop[] stops = new Stop[] {
		   	         new Stop(0, Color.DARKSLATEBLUE),
		   	         new Stop(1, Color.DARKRED)
		   	      };
		     LinearGradient gradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);
			    check = true;
				
			//players
			
			Label player1 = new Label("You ");
			
			Label player2 = new Label("Computer ");
			player1.setFont(Font.font("Bodoni MT Black", FontWeight.BLACK, 20));
			player2.setFont(Font.font("Bodoni MT Black", FontWeight.BLACK, 20));
			player1.setLayoutX(100);
			player1.setLayoutY(100);
			player2.setLayoutX(580);
			player2.setLayoutY(100);
			player1.setTextFill(Color.INDIGO);
			player2.setTextFill(Color.INDIGO);
			
			//X O
			Label x = new Label("X");
			x.setFont(Font.font("Forte", FontWeight.BOLD, 60));
			x.setTextFill(gradient);
			x.setLayoutX(100);
			x.setLayoutY(120);
			
			Label o = new Label("O");
			o.setTextFill(gradient);
			o.setFont(Font.font("Forte", FontWeight.BOLD, 60));
			o.setLayoutX(600);
			o.setLayoutY(120);
			
			//back button
			Button back = new Button("Back");
			back.setLayoutX(10);
			back.setLayoutY(10);

			//___________________________________________________________________________________
			
			String str = "-fx-background-radius:20px; -fx-background-color:black;-fx-text-fill:white;-fx-border-color:white;-fx-border-radius:20px";
			String str2 = "-fx-background-radius:20px; -fx-background-color:white;-fx-text-fill:black;-fx-border-color:black;-fx-border-radius:20px";
			Label choose = new Label("Choose the mode you prefer");
			choose.setFont(Font.font("Bodoni MT Black", FontWeight.BLACK, 20));
			choose.setTextFill(Color.BLACK);
			
			Button easy = new Button("Easy");
			easy.setMinWidth(280);
			easy.setMinHeight(40);
			easy.setStyle(str);
			Button hard = new Button("Hard");
			hard.setMinWidth(280);
			hard.setMinHeight(40);
			hard.setStyle(str);
			Button two = new Button("Two Player");
			two.setMinWidth(280);
			two.setMinHeight(40);
			two.setStyle(str);
			//.....
			easy.setOnMouseEntered(e->{
				easy.setStyle(str2);
			});
			hard.setOnMouseEntered(e->{
				hard.setStyle(str2);
			});
			two.setOnMouseEntered(e->{
				two.setStyle(str2);
			});
			//.....
			easy.setOnMouseExited(e->{
				easy.setStyle(str);
			});
			hard.setOnMouseExited(e->{
				hard.setStyle(str);
			});
			two.setOnMouseExited(e->{
				two.setStyle(str);
			});
			//....
			
			easy.setOnAction(e->{
				pane2.getChildren().clear();
				pane2.getChildren().addAll(  buildBord(), player1, player2, back, x, o, reset);
				player1.setText("You ");
				player2.setText("Computer");
				mood = 1;
			});
			hard.setOnAction(e->{
				pane2.getChildren().clear();
				pane2.getChildren().addAll(  buildBord(), player1, player2, back, x, o, reset);
				player1.setText("You ");
				player2.setText("Computer");
				mood = 2;
				
			});
			two.setOnAction(e->{
				pane2.getChildren().clear();
				pane2.getChildren().addAll(  buildBord(), player1, player2, back, x, o, reset);
				player1.setText("Player 1");
				player2.setText("Player 2");
				mood = 3;
			});
			
			VBox vbox = new VBox(10);
			vbox.getChildren().addAll(choose, easy, hard, two);
			vbox.setLayoutX(250);
			vbox.setLayoutY(120);
			
			pane2.getChildren().add(vbox);
			
			
			
			//___________________________________________________________________________________
			back.setOnAction(e->{
				pane2.getChildren().clear();
				pane2.getChildren().add(vbox);
				reset();
				try {
					root.getChildren().remove(3);
				}catch(Exception ex) {
					
				}
			});
			
			reset.setOnAction(e->{
				back.fire();
				if(mood == 1)
					easy.fire();
				else if(mood == 2)
					hard.fire();
				else
					two.fire();
			});
			
			root.getChildren().add(pane2);
			stage.setScene(scene);
			stage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	//_________________________________________________________________
	//_________________________________________________________________
	//_________________________________________________________________
	int step = 8;
	public void randomAi(Board board, int pos) {


		
		int[] array = new int[step];
		int loop = 0;
		for(int i = 0 ; i < 9 ; i++)
		{
			if(!board.isFull(i)) {
				array[loop] = i;
				loop++;
			}	
		}
		
	
		Random rand = new Random();
		if(step != 0)
			board.arr[array[rand.nextInt(step-1)]].btn.fire();

		step -=2;
	}
	
	//___________________________________________________________________________________
	//___________________________________________________________________________________
	//___________________________________________________________________________________
	

	//___________________________________________________________________________________
	//___________________________________________________________________________________
	//___________________________________________________________________________________
	
    public int miniMax(Board board, int depth, boolean isMax) {

        int boardVal = evaluateBoard(board);

        //
        if (Math.abs(boardVal) == 1 || depth == 0 || !board.anySpace()) {
           
            System.out.println(board.toString());
            System.out.println(boardVal);
            return boardVal;
        }
    	//
        if (isMax) {
            int maxValue = Integer.MIN_VALUE;
            for (int i = 0; i < board.getSize(); i++) {
               
                    if (!board.isFull(i)) {
                        board.setValue(i, 'o');
                        maxValue = Math.max(maxValue, miniMax(board,
                                depth - 1, false));
                        board.setValue(i, '\0');
                    
                }
            }
            return maxValue;
         //
        } else {
            int minValue = Integer.MAX_VALUE;
            for (int i = 0; i < board.getSize(); i++) {
              
                    if (!board.isFull(i)) {
                        board.setValue(i, 'x');
                        minValue = Math.min(minValue, miniMax(board,
                                depth - 1, true));
                        board.setValue(i, '\0');
                    
                }
            }
            return minValue;
        }
    }
    //_______________________________________________________________________________________--
    //_______________________________________________________________________________________--
    //_______________________________________________________________________________________--

    public int evaluateBoard(Board board) {
    	if(checkWin2('o')) {
    		return 1;
    	}
    	else if(checkWin2('x')) {
    		return -1;
    	}
    	
    	return 0;
    	
    }
    

    //_______________________________________________________________________________________--
    //_______________________________________________________________________________________--
    //_______________________________________________________________________________________--
    
    public int getBestMove(Board board) {
        int bestMove = 0;
        int bestValue = Integer.MIN_VALUE;

        for (int i = 0; i < board.getSize(); i++) {
           
                if (!board.isFull(i)) {
                	System.out.println("\n" +i + " wow");
                    board.setValue(i, 'o');
                    int moveValue = miniMax(board, 6, false);
                    board.setValue(i, '\0');
                    System.out.println(moveValue + " moveV");
                    if (moveValue > bestValue) {
                    	bestMove = i;
                        bestValue = moveValue;
                    
                }
                    System.out.println(bestMove + " beast");
            }
        }
        System.out.println(bestMove + "beast");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        return bestMove;
    }
	//___________________________________________________________________________________
	//___________________________________________________________________________________
	//___________________________________________________________________________________
	public VBox buildBord()
	{
		
		
		
		Stop[] stops = new Stop[] {
   	         new Stop(0, Color.DARKSLATEBLUE),
   	         new Stop(1, Color.DARKRED)
   	      };
     LinearGradient gradient = new LinearGradient(0, 0, 1, 0, true, CycleMethod.NO_CYCLE, stops);
	    check = true;
		board = new Board();

		VBox vbox = new VBox(5);
		
		int loop = 0;
		for(int i = 0 ; i < 3 ; i++)
		{
			
			HBox hbox = new HBox(5);
			for(int j = 0 ; j < 3 ; j++)
			{
				board.arr[loop] = new RectangleTec();
				
				int tempI = loop;
				
				

				board.arr[loop].btn.setOnAction(e ->{
					x = new Label("X");
					x.setFont(Font.font("Forte", FontWeight.BOLD, 60));
					o = new Label("O");
					
					x.setTextFill(gradient);
					
					o.setTextFill(gradient);
					o.setFont(Font.font("Forte", FontWeight.BOLD, 60));
					
					//if____________________________________________________________________________________
					if(check) {
						
						check = false;
						//......
						
						board.arr[tempI].stack.getChildren().add(x);
						board.arr[tempI].check = false;
						board.arr[tempI].xo = 'x';
						
						
						if(mood == 1)
						{
							if(checkWin2('x'))
								root.getChildren().add(lastMethod("You Win :)", 1 ));
							else if(checkWin2('o'))
								root.getChildren().add(lastMethod("You Lost :(", 3));
							else
								randomAi(board, tempI);
						}
						else if(mood == 2)
						{
							
								
							int wow = getBestMove(board);
							System.out.println(wow);
							board.arr[wow].btn.fire();
							if(checkWin2('o'))
							{
								root.getChildren().add(lastMethod("You Lost :(", 3));
							}
						}
						
						else if(mood == 3)
						{
							if(checkWin2('x'))
								root.getChildren().add(lastMethod("Player 1 Win", 1));
							if(checkWin2('o'))
								root.getChildren().add(lastMethod("Player 2 Win", 1));
							else if(!board.anySpace() && !checkWin2('o') && !checkWin2('x'))
								root.getChildren().add(lastMethod("Drow", 2));
						}
						
						if(!checkWin2('x') && !checkWin2('o') && !board.anySpace() && mood != 3)
						{
							root.getChildren().add(lastMethod("Draw :|", 2));
						}
						checkWin('x');
					}
					else {
						
						check = true;
						//......
						
						board.arr[tempI].stack.getChildren().add(o);
						board.arr[tempI].check = false;
						board.arr[tempI].xo = 'o';
					if(mood == 1)
						{
							if(checkWin2('x'))
								root.getChildren().add(lastMethod("You Win :)", 1 ));
							else if(checkWin2('o'))
								root.getChildren().add(lastMethod("You Lost :(", 3));
						}
						else if(mood == 3)
						{
							if(checkWin2('x'))
								root.getChildren().add(lastMethod("Player 1 Win", 1));
							if(checkWin2('o'))
								root.getChildren().add(lastMethod("Player 2 Win", 1));
							else if(!board.anySpace() && !checkWin2('o') && !checkWin2('x'))
								root.getChildren().add(lastMethod("Drow", 2));
						}
						checkWin('o');
					}
					//_______________________________________________________________________________
					board.arr[tempI].btn.setDisable(true);
				});
				
				hbox.getChildren().add(board.arr[loop].stack);
				loop++;
			}
			vbox.getChildren().add(hbox);
		}
		
		vbox.setLayoutX(250);
		vbox.setLayoutY(100);
		
		
		
		return vbox;
	}
	
	
	public void reset()
	{
		for(int i = 0 ; i < board.arr.length ; i++)
		{
			board.arr[i].check = true;
			board.arr[i].stack.getChildren().clear();
			board.arr[i].stack.getChildren().addAll(board.arr[i].rec, board.arr[i].btn);
			board.arr[i].xo = '\0';
			step = 8;
		}
	}
	
	
	public boolean checkWin(char b) {

			if(board.arr[0].xo == b && board.arr[1].xo == b && board.arr[2].xo == b)
			{
				board.arr[0].rec.setFill(Color.rgb(100, 235, 78));
				board.arr[1].rec.setFill(Color.rgb(100, 235, 78));
				board.arr[2].rec.setFill(Color.rgb(100, 235, 78));
				return true;
			}
			else if(board.arr[3].xo == b && board.arr[4].xo == b && board.arr[5].xo == b)
			{
				board.arr[3].rec.setFill(Color.rgb(100, 235, 78));
				board.arr[4].rec.setFill(Color.rgb(100, 235, 78));
				board.arr[5].rec.setFill(Color.rgb(100, 235, 78));
				return true;
			}
			else if(board.arr[6].xo == b && board.arr[7].xo == b && board.arr[8].xo == b)
			{
				board.arr[6].rec.setFill(Color.rgb(100, 235, 78));
				board.arr[7].rec.setFill(Color.rgb(100, 235, 78));
				board.arr[8].rec.setFill(Color.rgb(100, 235, 78));
				return true;
			}
			else if(board.arr[0].xo == b && board.arr[3].xo == b && board.arr[6].xo == b)
			{
				board.arr[0].rec.setFill(Color.rgb(100, 235, 78));
				board.arr[3].rec.setFill(Color.rgb(100, 235, 78));
				board.arr[6].rec.setFill(Color.rgb(100, 235, 78));
				return true;
			}
			else if(board.arr[1].xo == b && board.arr[4].xo == b && board.arr[7].xo == b)
			{
				board.arr[1].rec.setFill(Color.rgb(100, 235, 78));
				board.arr[4].rec.setFill(Color.rgb(100, 235, 78));
				board.arr[7].rec.setFill(Color.rgb(100, 235, 78));
				return true;
			}
			else if(board.arr[2].xo == b && board.arr[5].xo == b && board.arr[8].xo == b)
			{
				board.arr[2].rec.setFill(Color.rgb(100, 235, 78));
				board.arr[5].rec.setFill(Color.rgb(100, 235, 78));
				board.arr[8].rec.setFill(Color.rgb(100, 235, 78));
				return true;
			}
			else if(board.arr[0].xo == b && board.arr[4].xo == b && board.arr[8].xo == b)
			{
				board.arr[0].rec.setFill(Color.rgb(100, 235, 78));
				board.arr[4].rec.setFill(Color.rgb(100, 235, 78));
				board.arr[8].rec.setFill(Color.rgb(100, 235, 78));
				return true;
			}
			else if(board.arr[2].xo == b && board.arr[4].xo == b && board.arr[6].xo == b)
			{
				board.arr[2].rec.setFill(Color.rgb(100, 235, 78));
				board.arr[4].rec.setFill(Color.rgb(100, 235, 78));
				board.arr[6].rec.setFill(Color.rgb(100, 235, 78));
				return true;
			}
		return false;
	}
	
	
	
	
	
	public boolean checkWin2(char b) {

		if(board.arr[0].xo == b && board.arr[1].xo == b && board.arr[2].xo == b)
		{

			return true;
		}
		else if(board.arr[3].xo == b && board.arr[4].xo == b && board.arr[5].xo == b)
		{

			return true;
		}
		else if(board.arr[6].xo == b && board.arr[7].xo == b && board.arr[8].xo == b)
		{

			return true;
		}
		else if(board.arr[0].xo == b && board.arr[3].xo == b && board.arr[6].xo == b)
		{

			return true;
		}
		else if(board.arr[1].xo == b && board.arr[4].xo == b && board.arr[7].xo == b)
		{

			return true;
		}
		else if(board.arr[2].xo == b && board.arr[5].xo == b && board.arr[8].xo == b)
		{
			return true;
		}
		else if(board.arr[0].xo == b && board.arr[4].xo == b && board.arr[8].xo == b)
		{
			return true;
		}
		else if(board.arr[2].xo == b && board.arr[4].xo == b && board.arr[6].xo == b)
		{
			return true;
		}
	return false;
}
	
	public StackPane lastMethod(String str, int i)
	{
		Rectangle rectange = new Rectangle(270, 270);
		
		StackPane st = new StackPane();
		
		
		rectange.setFill(Color.TRANSPARENT);
		st.setLayoutX(242);
		st.setLayoutY(92);
		
		Label label = new Label(str);
		label.setFont(Font.font("Cooper Black", FontWeight.BOLD, 60));
		label.setRotate(-50);;
		
		if(i == 1)
			label.setTextFill(Color.GREEN);
		else if(i == 2)
			label.setTextFill(Color.BLUE);
		else
			label.setTextFill(Color.RED);

		st.getChildren().addAll(rectange, label);
		return st;
	}
	
	
	
}
