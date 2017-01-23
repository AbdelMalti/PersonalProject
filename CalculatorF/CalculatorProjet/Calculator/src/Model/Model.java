package Model;

import java.util.List;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Model {
	
	//***************** Attributes ******************//
	private List<Node> listOfNumber = new ArrayList<Node>();
	private boolean isInputOkay = true;
	private String number1 = "";
	private String number2 = "";
	private char symbol = ' ';
	private boolean haveComma = false;
	private boolean invalidInput = false;
	
	//***********************************************//
	
	//****************** Methodes *******************//
	public String Output(String input){
		
		invalidInput = false;
		calculatingResult(input);
		
		String anwser = "";
		if(!isInputOkay || invalidInput){
			anwser = "Error!";
		}else{
			anwser = "Everything is okay";
		}
		
		if(input.equals("") || input.equals("Error!") || input.equals("Everything is okay"))
			anwser = "0";
		
		System.out.println("Begin\n--------------------");
		for(Node n : listOfNumber){
			System.out.println(n.getNumber1() + " : "+n.getOperator() + " : " + n.getNumber2());
		}
		System.out.println("--------------------\nEnd");
		
		//When everything is okay, now we can do the math.
		if(isInputOkay)
			anwser = math();
		
		return anwser;
	}
	
	/**
	 * Method that will take the lists and return the valid answer. 
	 */
	
	private String math() {
		Calculation cal = new Calculation();
		float anwser = cal.doMath(listOfNumber);
		listOfNumber.clear();
		
		DecimalFormat df = new DecimalFormat("#.###");
		return df.format(anwser) + "";
	}

	/**
	 * 
	 * @param equation
	 */
	private void calculatingResult(String equation){
		
		for(char c : equation.toCharArray()){
			verifyingEquation(c);
			
		}
		if(! invalidInput)
		{
			Node nodeTemp = new Node(number1, symbol, number2);
			listOfNumber.add(nodeTemp);
		}
		number1 = "";
		number2 = "";
		symbol = ' ';
	}
	
	/**
	 * This method calls others methods to verify if all inputs or good.
	 * @param numberSymbol
	 */
	public void verifyingEquation(char numberSymbol){
		
		int asciiValue = (int) numberSymbol;
		if((asciiValue > 47 && asciiValue < 58) || asciiValue == 46){
			number2 += "" + numberSymbol;
			isInputOkay = true;
			
			if(asciiValue == 46 && haveComma)
				invalidInput = true;
			if(asciiValue == 46 && ! haveComma)
				haveComma = true;
		}else
			isInputOkay = false;
		
		switch(numberSymbol){
			case '+':
				isInputOkay = verifyingInput(numberSymbol, asciiValue);
				break;
				
			case '-':
				isInputOkay = verifyingInput(numberSymbol, asciiValue);
				break;
				
			case '*':
				isInputOkay = verifyingOrderOfInput() && verifyingInput(numberSymbol, asciiValue);
				break;
				
			case '/':
				isInputOkay = verifyingOrderOfInput() && verifyingInput(numberSymbol, asciiValue);
				break;
				
			case '%':
				isInputOkay = verifyingOrderOfInput() && verifyingInput(numberSymbol, asciiValue);
				break;
			
			case '=' :
				break;
				
			case '(':
				Node nodeTemp = new Node(numberSymbol);
				listOfNumber.add(nodeTemp);
				break;
				
			case ')':
				nodeTemp = new Node(numberSymbol);
				listOfNumber.add(nodeTemp);
				break;
		}
	}
	
	/**
	 *	This method verify if the input is :
	 *		1 - A valid one
	 *		2 - if it doesn't finish with a dot
	 *		3 - if it began with a dot, it will be added a 0 at the beginning 
	 * 
	 * @param numberSymbol
	 * @param asciiValue
	 * @return isInputOkay
	 */
	private boolean verifyingInput(char numberSymbol, int asciiValue){
		if(!((asciiValue > 47 && asciiValue < 58) 
				|| numberSymbol == '=' || numberSymbol == '+' 
				|| numberSymbol == '-' || numberSymbol == '*' 
				|| numberSymbol == '/' || numberSymbol == '%'
				|| numberSymbol == '(' || numberSymbol == ')'))
		{
			isInputOkay = false;
		}
		if(number2.length() > 0){
			if(number2.charAt(number2.length()-1) == '.'){
				isInputOkay = false;
			}
			if(number2.charAt(0) == '.'){
				number2 = "0" + number2;
			}
			
			
			
			if( ! number1.equals("") )
			{
				if(! invalidInput)
				{
					Node nodeTemp = new Node(number1, symbol, number2);
					listOfNumber.add(nodeTemp);
				}
				this.symbol = numberSymbol;
			}else
				this.symbol = numberSymbol;
				number1 = number2;
				number2 = "";
		}
		return isInputOkay;
	}
	
	/**
	 * This method verify if their is an number entered before some operations.
	 * @return true/false
	 */
	private boolean verifyingOrderOfInput(){
		if(number2.equals(""))
			return false;
		return true;
	}
	//***********************************************//
}
