package Model;

public class Node {
	//Attributes
	private float number1;
	private float number2;
	private char operator;
	
	//All possible type of construtor
	//***************************************//
	public Node(String number1, String operator, String number2){
		
		if(number1.length() > 0 && number2.length() > 0)//50.7426984*9.07066+3%45.41
		{
			this.number1 = Float.parseFloat(number1);
			this.operator = operator.charAt(0);
			this.number2 = Float.parseFloat(number2);
		}else{
			this.number1 = 0f;
			this.number2 = 0f;
		}
		
		if(this.operator == ' ')
			this.operator = '+';
	}
	
	public Node(float number1, char operator, float number2){
		this.number1 = number1;
		this.operator = operator;
		this.number2 = number2;
	}
	
	public Node(float number1, String operator, float number2){
		this.number1 = number1;
		this.operator = operator.charAt(0);
		this.number2 = number2;
		
		if(this.operator == ' ')
			this.operator = '+';
	}
	
	public Node(String number1, char operator, String number2){//50.7426984*9.07066+3%45.41
		if(number1.length() > 0 && number2.length() > 0)
		{
			this.number1 = Float.parseFloat(number1);
			this.operator = operator;
			this.number2 = Float.parseFloat(number2);
		}else{
			this.number1 = 0f;
			this.number2 = 0f;
		}
		
		if(this.operator == ' ')
			this.operator = '+';
	}
	
	//Constructors for '(' and ')'
	//*******************//
	public Node(String par){
		this.number1 = 0;
		this.operator = par.charAt(0);
	}
	
	public Node(char par){
		this.number1 = 0;
		this.operator = par;
	}
	//*******************//
	//***************************************//
	
	//Getters & Setters
	//***************************************//
		//Number1 Variable.
	public float getNumber1(){
		return this.number1;
	}
	
	public void setNumber1(String number1){
		this.number1 = Integer.parseInt(number1);
	}
	
	public void setNumber1(char number1){
		this.number1 = (int) number1;
	}
	
	public void setNumber1(int number1){
		this.number1 = number1;
	}
		
		//Operator Variable.
	public char getOperator(){
		return this.operator;
	}
	
	public void setOperator(String operator){
		this.operator = operator.charAt(0);
	}
	
	public void setOperator(char operator){
		this.operator = operator;
	}
	
	//Number2 Variable.
	public float getNumber2(){
		return this.number2;
	}
	
	public void setNumber2(String number2){
		this.number2 = Integer.parseInt(number2);
	}
	
	public void setNumber2(char number2){
		this.number2 = (int) number2;
	}
	
	public void setNumber2(int number2){
		this.number2 = number2;
	}
	//***************************************//
	//Methodes
	//***************************************//
	//***************************************//
}
