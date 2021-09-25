package mvc.views;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
public class View {
	private JFrame frame;
	private JPanel panelDisplay, panelDisplay2, panelButtons;
	private JButton[] btNumbers = new JButton[10];
	private JButton btPlus, btMinus, btTime, btDivide, btDelete, btAC, btPi, btPhantram, btE, bt2nd, btMu, btNgoacL, btNgoacR, btGthua, btMu2, btSqrt, btDOLA, btBang, btCham;
	private JTextArea txtArea, HField = new JTextArea();;
	private JTextField txtSolve;
	
	public View() {
		frame = new JFrame();
		frame.getContentPane().setLayout(new BorderLayout());
		frame.setTitle("Calculator Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);
		
		panelDisplay = new JPanel(new FlowLayout());
		frame.add(panelDisplay, BorderLayout.NORTH);
		panelDisplay2 = new JPanel(new GridLayout());
		frame.add(panelDisplay2);
		panelButtons = new JPanel(new GridLayout(6,5));
		frame.add(panelButtons, BorderLayout.CENTER);
		
		txtArea = new JTextArea(4,35);
		JScrollPane scrollPane = new JScrollPane(txtArea);
		panelDisplay.add(scrollPane);
		txtSolve = new JTextField("0",9);
		panelDisplay2.add(txtSolve);
		
		for(int i=0; i<=9; i++)
			btNumbers[i] = new JButton(new String("" + i));
		btPlus = new JButton("+");
		btMinus = new JButton("-");
		btTime = new JButton("*");
		btDivide = new JButton("/");
		btDelete = new JButton("X");
		btAC = new JButton("AC");
		btPi = new JButton("Pi");
		btPhantram = new JButton("%");
		btE = new JButton("e");
		bt2nd = new JButton("+1");
		btMu = new JButton("^");
		btNgoacL = new JButton("(");
		btNgoacR = new JButton(")");
		btGthua = new JButton("!");
		btMu2 = new JButton("^2");
		btSqrt = new JButton("sqrt");
		btDOLA = new JButton("$");
		btBang = new JButton("=");
		btCham = new JButton(".");
		
		panelButtons.add(btMu);
		panelButtons.add(btMu2);
		panelButtons.add(btNgoacL);
		panelButtons.add(btNgoacR);
		panelButtons.add(panelDisplay2);
		panelButtons.add(btGthua);
		panelButtons.add(btAC);
		panelButtons.add(btSqrt);
		panelButtons.add(btTime);
		panelButtons.add(btDelete);
		panelButtons.add(btPi);
		for(int i=7; i<=9; i++)
			panelButtons.add(btNumbers[i]);
		panelButtons.add(btDivide);
		panelButtons.add(btE);
		for(int i=4; i<=6; i++)
			panelButtons.add(btNumbers[i]);
		panelButtons.add(btMinus);
		panelButtons.add(btPhantram);
		for(int i=1; i<=3; i++)
			panelButtons.add(btNumbers[i]);
		panelButtons.add(btPlus);
		panelButtons.add(btDOLA);
		panelButtons.add(bt2nd);
		panelButtons.add(btNumbers[0]);
		panelButtons.add(btCham);
		panelButtons.add(btBang);
		
		frame.setVisible(true);
	}
	
	public JButton getNs(int numbers) {
		return btNumbers[numbers];
	}
	public JButton getAC() {
		return btAC;
	}
	public JButton getBang() {
		return btBang;
	}
	public JButton getPlus() {
		return btPlus;
	}
	public JButton getMinus() {
		return btMinus;
	}
	public JButton getTime() {
		return btTime;
	}
	public JButton getDivide() {
		return btDivide;
	}
	public JButton getCham() {
		return btCham;
	}
	public JButton getDOLA() {
		return btDOLA;
	}
	public JButton getGthua() {
		return btGthua;
	}
	public JButton getNgoacL() {
		return btNgoacL;
	}
	public JButton getNgoacR() {
		return btNgoacR;
	}
	public JButton getMu() {
		return btMu;
	}
	public JButton getMu2() {
		return btMu2;
	}
	public JButton getSqrt() {
		return btSqrt;
	}
	
	public void setText(String text) {
		txtArea.setText(text);
	}
	public void setSolve(String text) {
		txtSolve.setText(text);
	}
	public String getSolve() {
		return txtSolve.getText();
	}
	public void append(String text) {
		txtArea.append(text);
	}
	public void HAppend(String text) {
		HField.append(text);
	}
	public void setHid(String text) {
		HField.setText(text);
	}
	public String getText() {
		return HField.getText();
	}
}
