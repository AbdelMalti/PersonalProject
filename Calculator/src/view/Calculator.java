package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.*;

import Controler.EnterNumberListener;

public class Calculator extends JFrame{
	
	//**************Attributes***************//
	private Dimension FrameDimension = new Dimension(350, 450);
	private Dimension userInputDimension = new Dimension(300, 100);
	private Dimension leftPanelDimension = new Dimension(200,180);
	private Dimension rightPanelDimension = new Dimension(100, 180);
	private Dimension OperationButtonDimension = new Dimension(65, 45);
	private Dimension NumberButtonDimension = new Dimension(70,70);
	
	private Font userInputPolice = new Font("Georgia", Font.BOLD, 24);
	
	private JTextField userInput = new JTextField("Hello", SwingConstants.RIGHT);
	private JPanel leftPanel = new JPanel();
	private JPanel rightPanel = new JPanel();
	
	private Character OperationCaractere[] = {'C','+','-','*','/', '%'};
	private Character numberCaracter[] = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '.','0', '='};
	//**************************************//
	
	//*************Constructors***************//
	public Calculator(){
		this.SetUpMainPanel();
		this.setSize(FrameDimension);
		this.setResizable(false);
	}
	//****************Methodes****************//
	private void SetUpMainPanel(){
		this.SetUpInput();
		this.getContentPane().add(userInput, BorderLayout.NORTH);
		
		this.add(leftPanel, BorderLayout.CENTER);
		
		this.add(rightPanel, BorderLayout.EAST);
		this.SetUpLeftPanel();
		this.SetUpRightPanel();
	}
	private void SetUpInput(){
		userInput.setPreferredSize(userInputDimension);
		userInput.setHorizontalAlignment(JTextField.RIGHT);
		userInput.setMargin(new Insets(10, 10, 10, 10));
		userInput.setBorder(BorderFactory.createLineBorder(new Color(10,10,10)));
		userInput.setFont(userInputPolice);
	}
	private void SetUpLeftPanel() {
		leftPanel.setPreferredSize(leftPanelDimension);
		int numOfRows = 4;
		int numOfCols = 3;
		//leftPanel.setLayout(new GridLayout(numOfRows, numOfCols));
		leftPanel.setSize(leftPanelDimension);
		final int numberOfCase = numOfRows * numOfCols;
		
		for(int i=0; i<numberOfCase ; ++i){
			String caracterOfButton = numberCaracter[i].toString();
			JButton b = new JButton(caracterOfButton);
			b.setPreferredSize(NumberButtonDimension);
			leftPanel.add(b);
			b.addActionListener(new EnterNumberListener());
		}
	}
	private void SetUpRightPanel(){
		rightPanel.setPreferredSize(rightPanelDimension);
		int numOfRows = OperationCaractere.length;
		int numOfCols = 1;
		final int numberOfCase = numOfRows * numOfCols;
		
		for(int i=0 ; i < numberOfCase ; ++i){
			String caracterOfButton = OperationCaractere[i].toString();
			JButton b = new JButton(caracterOfButton);
			b.setPreferredSize(OperationButtonDimension);
			rightPanel.add(b);
		}
	}

	public String getTextFromUserInput(){
		return userInput.getText();
	}
	public void setTextFromUserInput(String update){
		userInput.setText(update);
	}
}