package Controler;

import view.Calculator;

public class Controler {
	
	static protected Calculator calculView = new Calculator();
	
	public Calculator getCalculView() {
		return calculView;
	}

	/*public void setCalculView(Calculator calculView) {
		this.calculView = calculView;
	}*/
}
