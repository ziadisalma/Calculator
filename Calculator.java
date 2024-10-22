import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*; 
import javafx.scene.control.*;
import java.util.*;

import javafx.geometry.Pos;
import javafx.geometry.Insets;

public class Calc2 extends Application {
	
	public static void main(String[] args) {
		launch(args); 
	}
	
	
	Button btnEqual;
	Button btnAC;
	Button btnAdd;
	Button btnSub;
	Button btnMul; 
	Button btnDiv;
	Button btnMod;
	Button btnDot;
	
	ArrayList<Button> btnDigits;
	TextField txtF;
	
	//Stores the operands and operator
	String s1, s2, s3;
	
	
	/**
	 * Sets the stage for the application by initializing buttons, textfield and their layout.
	 */
	
	@Override public void start(Stage primaryStage) {
	
		// Create the textfield
		txtF = new TextField();
		
		// Create the buttons
		btnEqual = new Button();
		btnAC = new Button();
		btnAdd = new Button();
		btnSub = new Button();
		btnMul = new Button("*");
	    btnDiv = new Button("/");
	    btnMod = new Button("%");
	    btnDot = new Button(".");
		
		btnDigits = new ArrayList<Button>(10);
		
		// Initialize the operands and operators
		s1="";
		s2="";
		s3="";
		
		//========= TODO:1 Set labels for AC, +, -, =, *, /, %, . buttons ===========
		//System.out.println("Need to set labels for AC, +, -, = buttons");
		btnAC.setText("AC");
		btnAdd.setText("+");
		btnSub.setText("-");
		btnEqual.setText("=");
		btnMul.setText("*");
		btnDiv.setText("/");
		btnMod.setText("%");
		btnDot.setText(".");


		//==============================================================
		
		for(int i = 0;i < 10; i++)
		{
			Button temp = new Button();
			temp.setText(String.valueOf(i));
			btnDigits.add(temp);
		}
		
		
		
		//============== TODO:2 Set background color for AC Button ==============
		//System.out.println("Need to set background color of AC button");
		btnAC.setStyle("-fx-background-color: red;");

		//======================================================================
		
		
		
		//==== TODO:3 For the TextField (a) Set text alignment, (b) Disable editing via typing, (c) Set a width ====
		//System.out.println("Need to set some UI properties on the TextField");
		txtF.setAlignment(Pos.CENTER_RIGHT);  // Align text to the right
		txtF.setEditable(false);  // Disable typing
		txtF.setPrefWidth(100);  // Set appropriate width

		//==========================================================================================================
		
		//set the OnAction property on the buttons
		btnAC.setOnAction(this::buttonClickReset);
		btnAdd.setOnAction(this::buttonClickAdd);
		btnSub.setOnAction(this::buttonClickSub);
		btnEqual.setOnAction(this::buttonClickEqual);
		btnMul.setOnAction(this::buttonClickMul);
		btnDiv.setOnAction(this::buttonClickDiv);
		btnMod.setOnAction(this::buttonClickMod);
		btnDot.setOnAction(this::buttonClickDot);
		
		//==== TODO:4 For each digit button, set the OnAction property ====
		//System.out.println("Need to set action property on digit buttons");
		for (Button digit : btnDigits) {
		    digit.setOnAction(this::buttonClickDigit);
		}

		//=================================================================
		
		
		// Add buttons to HBox'es and then to VBox 
		VBox pane = new VBox(20); 
		
		HBox top_box = new HBox(23);
		
		HBox.setMargin(txtF, new Insets(0,10,0,10));
		
		top_box.getChildren().addAll(txtF, btnAC, btnEqual); // add the textfield, AC, and Equal on the same row
		
		
		
		HBox[] mid_box = new HBox[3];//(40);
		mid_box[0] = new HBox(40);
		HBox.setMargin(btnDigits.get(1), new Insets(0,0,0,10)); // add the button with label "1" in 1st row
		mid_box[0].getChildren().addAll(btnDigits.subList(1, 4)); // add buttons 2 and 3 in 1st row
		mid_box[0].getChildren().add(btnAdd); // add plus sign button in 1st row 
		
		mid_box[1] = new HBox(40);
		HBox.setMargin(btnDigits.get(4), new Insets(0,0,0,10)); //add  the button with label "4" in second row
		mid_box[1].getChildren().addAll(btnDigits.subList(4, 7)); //add buttons 5 and 6 in second row
		mid_box[1].getChildren().add(btnSub); // add minus button
		
		mid_box[2] = new HBox(40);
		HBox.setMargin(btnDigits.get(7), new Insets(0,0,0,10)); //add  the button with label "7" in third row
		mid_box[2].getChildren().addAll(btnDigits.subList(7, 10)); //add buttons 8 and 9 in second row
		mid_box[2].getChildren().add(btnMul); // add multiplication button
		
		
		HBox bot_box = new HBox(40);
		
		
		
		HBox.setMargin(btnDigits.get(0), new Insets(0,0,0,5)); 
		HBox.setMargin(btnDot, new Insets(0,0,0,10));
		bot_box.getChildren().add(btnDot); // add dot button to last row
		bot_box.getChildren().add(btnDigits.get(0)); // add 0 to last row
		bot_box.getChildren().add(btnMod); // add modular button to last row 
		bot_box.getChildren().add(btnDiv); // add division button to last row 
		
		
		
		
		
		
		pane.getChildren().addAll(top_box, mid_box[0], mid_box[1], mid_box[2], bot_box);
		
		
		// Add the root pane to a scene
		Scene scene = new Scene(pane, 250, 250);
		
		
		// Finalize and show the stage
		primaryStage.setScene(scene); 
		primaryStage.setTitle("Calculator-2pt0"); 
		primaryStage.show();
	}
	
	/**
	 * Reset the operands, operators and the textfield when AC is clicked
	 * @param the click event e
	 * @return void
	 */
	public void buttonClickReset(ActionEvent e) {
		// ============== TODO:5  You need to implement this method. ==============
		
		//System.out.println("buttonClickReset is not defined");
		
		txtF.clear(); //clear the textfield from any text
		s1 = s2 = s3 = "";  // Reset operands and operator
		

		
		// ========================================================================
		
	}	
	
	/**
	 * Determine the operands when digits are clicked
	 * @param the click event e
	 * @return void
	 */
	public void buttonClickDigit(ActionEvent e) {
		// ============== TODO:6  You need to implement this method. ==============
		
		/**
		 * Hint : A digit is concatenated to an operand to form a number until a non-digit button is clicked.
		 */
		
		//System.out.println("buttonClickDigit is not defined");
		String digit = ((Button) e.getSource()).getText();
	    if (s3.isEmpty()) { // if a non-digit button isn't clicked 
	        s1 += digit;  // Concatenate to first operand
	        txtF.setText(s1); 
	    } else {
	        s2 += digit;  // Concatenate to second operand
	        txtF.setText(s2);
	    }
		
		// ========================================================================
	}
	
	/**
	 * Determine the operators when "+" is clicked
	 * @param the click event e
	 * @return void
	 */
	public void buttonClickAdd(ActionEvent e) {
		// ============== TODO:7  You need to implement this method. ==============
	    
		//System.out.println("buttonClickAdd is not defined");
		
		s3 = "+";  // Store operator
	    // =======================================================================
		
	}
	
	/**
	 * Determine the operator when "-" is clicked
	 * @param the click event e
	 * @return void
	 */
	public void buttonClickSub(ActionEvent e) {
		// ============== TODO:8  You need to implement this method. ==============
	    	
		//System.out.println("buttonClickSub is not defined");
		 
		 s3 = "-";  // Store operator
	    // =======================================================================
	}
	
	/**
	 * Determine the operators when "*" is clicked
	 * @param the click event e
	 * @return void
	 */
	public void buttonClickMul(ActionEvent e) {
		
		s3 = "*"; // store operator 
		
	}
	
	/**
	 * Determine the operators when "/" is clicked
	 * @param the click event e
	 * @return void
	 */
	public void buttonClickDiv(ActionEvent e) {
		
		s3 = "/"; //store operator 
		
	}
	
	/**
	 * Determine the operators when "%" is clicked
	 * @param the click event e
	 * @return void
	 */
	public void buttonClickMod(ActionEvent e) {
		 
		s3 = "%"; //store operator 
		
	}
	
	/**
	 * Determine the operators when "." is clicked
	 * @param the click event e
	 * @return void
	 */
	public void buttonClickDot(ActionEvent e) {
		
		if (s3.isEmpty()) { 
	        if (!s1.contains(".")) {  // Ensure only one dot in the first operand
	            s1 += ".";
	            txtF.setText(s1);
	        }
	    } else {
	        if (!s2.contains(".")) {  // Ensure only one dot in the second operand
	            s2 += ".";
	            txtF.setText(s2);
	        }
	    }
		
	}
	
	
	/**
	 * Determine the result in the textfield when "=" is clicked
	 * @param the click event e
	 * @return void
	 */
	public void buttonClickEqual(ActionEvent e) {
		// ============== TODO:9  You need to implement this method. ==============
	    
		/*
		 *  Hint: Use the operands and operator string to determine the result.
		 */
	    
		//System.out.println("buttonClickEqual is not defined");
		
		try {
            float num1 = Float.parseFloat(s1);
            float num2 = Float.parseFloat(s2);
            float result = 0;
            

            switch (s3) {
                case "+": // in the case of addition
                    result = num1 + num2; //add up the two numbers 
                    break;
                case "-": //in the case of subtraction 
                    result = num1 - num2; // subtract num2 from num1
                    break;
                case "*": //in the case of multiplication 
                    result = num1 * num2; //multiply both numbers 
                    break; //in case of division 
                case "/":
                    if (num2 != 0) { // denominator needs to be different than 0 
                        result = num1 / num2; //divide num1 by num2 
                    } else {
                        txtF.setText("Error"); // if denominator is 0 say Error 
                        return;
                    }
                    break;
                case "%": //in case of modulo 
                    result = num1 % num2; // do num1 mod num2
                    break;
            }
            if (result == Math.floor(result)) { // Display as an integer if it has no decimal part
                txtF.setText(String.valueOf((int) result));
            } else { // Otherwise, display as a floating-point number
                txtF.setText(String.valueOf(result));
            }
        } catch (NumberFormatException ex) {
            txtF.setText("Error"); 
        } finally {
            s1 = s2 = s3 = "";
        }
    
	    
		// ========================================================================
		
		
		// Resetting the operands and operator after the result is calculated.
			s3="";	
			s2="";
			s1="";
	}

}