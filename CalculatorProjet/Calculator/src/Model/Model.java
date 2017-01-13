package Model;

import java.util.List;
import java.util.ArrayList;

public class Model {
	
	//***************** Attributes ******************//
	private List<String> listOfNumber = new ArrayList<String>();
	private boolean isInputOkay = true;
	private String tempNumber = "";
	
	//***********************************************//
	
	//****************** Methodes *******************//
	public String Output(String input){
		
		calculatingResult(input);
		
		String anwser = "";
		if(!isInputOkay){
			anwser = "Error!";
		}else{
			anwser = "Everything is okay";
		}
		
		if(input.equals("") || input.equals("Error!") || input.equals("Everything is okay"))
			anwser = "0";
		
		System.out.println("Begin\n--------------------");
		for(String s : listOfNumber){
			System.out.println(s);
		}
		System.out.println("--------------------\nEnd");
		
		//When eveything is okay, now we can do the math.
		math();
		
		return anwser;
	}
	
	private void math() {
		// TODO Auto-generated method stub
		
		listOfNumber.clear();
	}

	/**
	 * 
	 * @param equation
	 */
	private void calculatingResult(String equation){
		
		for(char c : equation.toCharArray()){
			verifyingEquation(c);
		}
		listOfNumber.add(tempNumber);
		tempNumber = "";
	}
	
	/**
	 * This method calls others methods to verify if all inputs or good.
	 * @param numberSymbol
	 */
	public void verifyingEquation(char numberSymbol){
		
		int asciiValue = (int) numberSymbol;
		if((asciiValue > 47 && asciiValue < 58) || asciiValue == 46){
			tempNumber += "" + numberSymbol; //(asciiValue - 48) ;
			System.out.println("Dans tempNumber : "+tempNumber);
			isInputOkay = true;
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
				|| numberSymbol == '(' || numberSymbol == ')')) // TODO : The code of '(' and ')'.
		{
			isInputOkay = false;
		}
		if(tempNumber.length() > 0){
			if(tempNumber.charAt(tempNumber.length()-1) == '.'){
				isInputOkay = false;
			}
			if(tempNumber.charAt(0) == '.'){
				tempNumber = "0" + tempNumber;
			}
			listOfNumber.add(tempNumber);
			tempNumber = "";
		}
		return isInputOkay;
	}
	
	/**
	 * This method verify if their is an number entered before some operations.
	 * @return true/false
	 */
	private boolean verifyingOrderOfInput(){
		if(tempNumber.equals(""))
			return false;
		return true;
	}
	//***********************************************//
}
