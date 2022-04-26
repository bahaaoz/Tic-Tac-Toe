package application;

import java.util.Stack;

import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class RectangleTec {
	public StackPane stack ;
	public Rectangle rec;
	public Button btn;
	public boolean check;
	char xo;
	
	public RectangleTec() {
		stack =  new StackPane();
		btn = new Button("");
		btn.setMinHeight(75);
		btn.setMinWidth(75);
		btn.setStyle("-fx-background-color:transparent");
		
		
		rec = new Rectangle(80,80);
		rec.setStroke(Color.BLACK);
		rec.setFill(Color.WHITE);

		check = true;
		
		stack.getChildren().addAll(rec, btn);
	}

}
