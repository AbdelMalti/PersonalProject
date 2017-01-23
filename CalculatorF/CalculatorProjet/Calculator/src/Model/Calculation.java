package Model;

import java.util.ArrayList;
import java.util.List;

public class Calculation {

	private List<Node> mainList = new ArrayList<Node>();
	private List<Node> secondList;
	private float finalResult = 0;
	private Node leftNode;
	private Node rightNode;
	
	public float doMath(List<Node> listOfNumber) {
		
		secondList = listOfNumber;
		
		//TODO Remove the for loop after
		for(Node n : secondList){
			System.out.print(n.toString());
		}
		
		System.out.println();
		
		int i = 0;
		while(i < secondList.size()){
			rightNode = null;
			leftNode = secondList.get(i);
			++i;
			if(i < secondList.size())
				rightNode = secondList.get(i);
			
			if(!secondCanBePutInMainList(leftNode.getOperator()))
			{
				if(rightNode != null)
					rightNode.setNumber1(equation(leftNode));
				else if(rightNode == null && i == 0)
					return equation(leftNode);
				else if(rightNode == null && i != 0)
				{
					//return equation(leftNode);
				}
			}
			
			if(rightNode != null && this.secondCanBePutInMainList(rightNode.getOperator()))
			{
				mainList.add(leftNode);
				System.out.println("ADD : " + leftNode.toString());
				
			}else if(rightNode != null){
				leftNode.setNumber2(equation(rightNode));
			}
			
			if(rightNode == null){
				mainList.add(leftNode);
				System.out.println("ADD : " + leftNode.toString());
			}
		}
		return finalResult;
	}
	
	private float equation(Node n){
		float answer = 0;
		switch(n.getOperator()){
			case '+':
				answer = n.getNumber1() + n.getNumber2();
				break;
				
			case '-':
				answer = n.getNumber1() - n.getNumber2();
				break;
				
			case '*':
				answer = n.getNumber1() * n.getNumber2();
				break;
				
			case '/':
				answer = n.getNumber1() / n.getNumber2();
				break;
				
			case '%':
				answer = n.getNumber1() % n.getNumber2();
				break;
			
			case '=' :
				break;
				
			case '(':
				break;
				
			case ')':
				break;
		}
		
		return answer;
		
	}
	
	private boolean secondCanBePutInMainList(char operationSymbol){
		if(operationSymbol == '*' || operationSymbol == '/' || operationSymbol == '%')
			return false;
		return true;
	}
}
