package mvc.controllers;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import mvc.models.*;
import mvc.views.*;
public class Controller {
	private Model model;
	private View view;
	private ActionListener alPlus, alMinus, alTime, alDivide, alDelete, alAC, alPi, alPhantram, alE, al2nd, alMu, alNgoacL, alNgoacR, alGthua, alMu2, alSqrt, alDOLA, alBang, alCham;
	private ActionListener[] alNumbers = new ActionListener[10];
	private int key = 0;
	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
	}
	public void control() {
		alPlus = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (key == 1) {
					view.append("AND+");
					view.HAppend(view.getSolve() + "+");
				}
				else {	
					view.append("+");
					view.HAppend("+");
				}
			}
		};
		view.getPlus().addActionListener(alPlus);
		alMinus = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (key == 1) {
					view.append("AND-");
					view.HAppend(view.getSolve() + "-");
				}
				else {	
					view.append("-");
					view.HAppend("-");
				}
			}
		};
		view.getMinus().addActionListener(alMinus);
		alTime = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (key == 1) {
					view.append("ANDx");
					view.HAppend(view.getSolve() + "*");
				}
				else {	
					view.append("x");
					view.HAppend("*");
				}
			}
		};
		view.getTime().addActionListener(alTime);
		alDivide = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if (key == 1) {
					view.append("AND/");
					view.HAppend(view.getSolve() + "/");
				}
				else {	
					view.append("/");
					view.HAppend("/");
				}
			}
		};
		view.getDivide().addActionListener(alDivide);
		alCham = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				view.append(".");
				view.HAppend(".");
			}
		};
		view.getCham().addActionListener(alCham);
		
		alAC = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				view.setText("");
				view.setHid("");
				view.setSolve("0");
				model.setX(0);
				key = 0;
			}
		};
		view.getAC().addActionListener(alAC);
		
		alBang = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				view.setSolve("0");
				
				try {
					model.setX(Float.valueOf(doCalc(view.getText())));
				} catch (NumberFormatException | ScriptException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if (model.getX()%1==0)
					view.setSolve(String.valueOf(model.getIntX(model.getX())));
				else
					view.setSolve(String.valueOf(model.getX()));
				
				view.setHid("");
				view.append("\t\t=\t" + view.getSolve() + "\n");
				key = 1;
			}
		};
		view.getBang().addActionListener(alBang);
		
		for(int i=0; i<=9; i++) {
			alNs(i);
		}
		
		
		alDOLA = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				view.append("$");
				view.HAppend("*23.310");
				key = 0;
			}
		};
		view.getDOLA().addActionListener(alDOLA);
		
		alGthua = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				view.append("!");
				key = 0;
				model.Gthua(Integer.valueOf(view.getText()));
				view.HAppend("" + model.getX());
			}
		};
		view.getGthua().addActionListener(alGthua);
		alNgoacL = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				view.append("(");
				view.HAppend("(");
			}
		};
		view.getNgoacL().addActionListener(alNgoacL);
		
		alNgoacR = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				view.append(")");
				view.HAppend(")");
			}
		};
		view.getNgoacR().addActionListener(alNgoacR);
	
		alMu = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				view.append("^");
				view.HAppend("^");
			}
		};
		view.getMu().addActionListener(alMu);
		
		alMu2 = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				view.append("^(2)");
				view.HAppend("^2");
			}
		};
		view.getMu2().addActionListener(alMu2);
		
		alSqrt = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				view.append("sqrt(");
				view.HAppend("sqrt(");
			}
		};
		view.getSqrt().addActionListener(alSqrt);		
	}
	public void alNs(int number) {
		alNumbers[number] = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				view.append("" + number);
				view.HAppend("" + number);
				key = 0;
			}
		};
		view.getNs(number).addActionListener(alNumbers[number]);
	}

	public String doCalc(String str) throws ScriptException {
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		return String.valueOf(engine.eval(str));
	}
}
