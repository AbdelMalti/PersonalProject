package Controler;

import Model.Model;
import view.Calculator;

public class Controler {
	
	//********Attributes***********//
	private Calculator calculView;
	private Model model = new Model();
	//*****************************//
	
	//*********Constructor*********//
	public Controler(Calculator c){
		calculView = c;
	}
	//*****************************//
	
	//****** Getter & Setter ******//
	public Calculator getCalculView() {
		return calculView;
	}
	
	public void setCalculView(String update) {
		calculView.setTextFromUserInput(update);
	}
	//*****************************//
	
	
	//********* Methodes **********//
	public void OnClick(String number){
		System.out.println("You click on : " + number);
		char buttonSymbol = number.charAt(0);
		
		if(getCalculView().getTextFromUserInput().equals("Hello"))
			setCalculView("");
		String anwser = getCalculView().getTextFromUserInput() + number;
		
		if(buttonSymbol == '=')
		{
			//model.verifyingEquation(buttonSymbol);
			anwser = model.Output(calculView.getTextFromUserInput().toString());
		}
		//To show the symbol pf the button.
		System.out.println("Reponse : "+anwser);
		setCalculView(anwser);
	}
	//*****************************//
}
