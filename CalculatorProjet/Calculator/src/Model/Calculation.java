package Model;

import java.util.ArrayList;
import java.util.List;

public class Calculation {

	private List<Node> mainList = new ArrayList<Node>();
	private List<Node> secondList;
	private float finalResult = 0;
	
	public float doMath(List<Node> listOfNumber) {
		
		secondList = listOfNumber;
		
		for(Node n : secondList){
			equation(n);
		}
		
		return finalResult;
	}
	
	private void equation(Node n){
		
		switch(n.getOperator()){
			case '+':
				break;
				
			case '-':
				break;
				
			case '*':
				break;
				
			case '/':
				break;
				
			case '%':
				break;
			
			case '=' :
				break;
				
			case '(':
				break;
				
			case ')':
				break;
	}
		
	}
}
