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
		char buttonSymbol = number.charAt(0);
		
		if(getCalculView().getTextFromUserInput().equals("Hello")
				|| getCalculView().getTextFromUserInput().equals("Error!")
				|| getCalculView().getTextFromUserInput().equals("Everything is okay")
				)
			setCalculView("");
		String anwser = getCalculView().getTextFromUserInput() + number;
		
		if(buttonSymbol == '=')
		{
			anwser = model.Output(calculView.getTextFromUserInput().toString());
		}
		setCalculView(anwser);
	}
	//*****************************//
}
