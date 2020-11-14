package com.released2.calculator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static com.released2.calculation.CalculationD.*;
import static com.released2.auxiliary.AXClass.*;
public class CalcGUI extends JFrame{
	private static int I = 0, D = 0;
	//объявление элементов управления
	private static JTextField jtxt; //текстовое поле (не редактируется)
	private JButton[] jbtnNumb = new JButton[10]; //кнопки "цифр" (0-9)
	//основная панель (содержит две следующие панели), панель кнопок цифр, панель кнопок операций
	private JPanel jpnl, jpnlNumb, jpnlOperate;
	//кнопки операций ("=", ".", "C", "<", "+", "-", "/", "*", "<html>&radic;", "<html> x<sup>2</sup>", "x^n", "<html>&radic;^b", "%", "+/-")
	private JButton[] jbtnOperat = new JButton[14];
	//кнопки операций СС ("0x", "<html>&#048;", "0b", "BIN", "HEX", "OCT", "DEC")
	private JButton[] jbtnNSOperate = new JButton[7];
	
	public CalcGUI(){
		initComponents();
	}
	private void initComponents(){
//		this.setDefaultLookAndFeelDecorated(defaultLookAndFeelDecorated);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //выход при закрытии
		this.setTitle("Engineering Calculator");
		this.setLayout(new GridBagLayout());
		GridBagConstraints pen = new GridBagConstraints();
		pen.fill = GridBagConstraints.BOTH;
		pen.insets = new Insets(2,2,2,2);
		
		jtxt = new JTextField(); jtxt.setEditable(false); //текстовое поле недоступно для редактирования
		jbtnOperat[2] = new JButton("C"); jbtnOperat[2].setToolTipText("CL");
		jbtnOperat[3] = new JButton("<"); jbtnOperat[3].setToolTipText("CLR");
		jbtnOperat[4] = new JButton("+"); jbtnOperat[4].setToolTipText("Plus");
		jbtnOperat[5] = new JButton("-"); jbtnOperat[5].setToolTipText("Minus");
		jbtnOperat[6] = new JButton("/"); jbtnOperat[6].setToolTipText("Division");
		jbtnOperat[7] = new JButton("*"); jbtnOperat[7].setToolTipText("Product");
		jbtnOperat[8] = new JButton("<html>&radic;"); jbtnOperat[8].setToolTipText("SQRT");
		jbtnOperat[9] = new JButton("<html> x<sup>2</sup>"); jbtnOperat[9].setToolTipText("SQR");
		jbtnOperat[10] = new JButton("a^b"); jbtnOperat[10].setToolTipText("SQR in b");
		jbtnOperat[11] = new JButton("a^1/b"); jbtnOperat[11].setToolTipText("SQRT in b");
		jpnl = new JPanel(); //основная панель
		jpnlOperate = new JPanel(); //панель кнопок операций
		jpnlOperate.setLayout(new GridLayout(6,2));
		jpnlNumb = new JPanel(); //панель кнопок цифр
		jpnlNumb.setLayout(new GridLayout(7,3));
		
		for(int i = 0; i <= jbtnNSOperate.length-1; i++){
			//инициализация кнопок операций СС
			switch(i){
			case 0:
				jbtnNSOperate[i] = new JButton("0x");
				jbtnNSOperate[i].setToolTipText("Write hexadecimal number");
				break;
			case 1:
				jbtnNSOperate[i] = new JButton("<html>&#048;");
				jbtnNSOperate[i].setToolTipText("Write octal number");
				break;
			case 2:
				jbtnNSOperate[i] = new JButton("0b");
				jbtnNSOperate[i].setToolTipText("Write binary number");
				break;
			case 3:
				jbtnNSOperate[i] = new JButton("BIN");
				jbtnNSOperate[i].setToolTipText("Transfer to binary NS");
				break;
			case 4:
				jbtnNSOperate[i] = new JButton("HEX");
				jbtnNSOperate[i].setToolTipText("Transfer to hex_a_decimal NS");
				break;
			case 5:
				jbtnNSOperate[i] = new JButton("OCT");
				jbtnNSOperate[i].setToolTipText("Transfer to octal NS");
				break;
			case 6:
				jbtnNSOperate[i] = new JButton("DEC");
				jbtnNSOperate[i].setToolTipText("Transfer to decimal NS");
				break;
			}
			//кнопки операций СС добавляем в панель перед кнопоками цифр
			jpnlNumb.add(jbtnNSOperate[i]);
			}
		jbtnOperat[12] = new JButton("%");
		jbtnOperat[12].setToolTipText("'PC (pro centum)'"); 
		jpnlNumb.add(jbtnOperat[12]);
		jbtnOperat[13] = new JButton("+/-");
		jbtnOperat[13].setToolTipText("Plus/Minus"); 
		jpnlNumb.add(jbtnOperat[13]);
		
		for(int i = 0; i <= jbtnNumb.length - 1; i++){
			//создаем (кнопки цифр 1-9) под номерами 0-8 (создание в куче)
			jbtnNumb[i] = new JButton(Integer.toString(i+1));
			if(i == 9){
				//10 (десятый) по счёту элемент с номером 9 (девять) и есть 0 (ноль)
				jbtnNumb[i] = new JButton(Integer.toString(0));
				//объявление элементов управления операций "=" и "*" (создание в куче)
				jbtnOperat[0] = new JButton("=");
				jbtnOperat[1] = new JButton(".");
				//требуется добавить 0 (ноль) в определенном порядке
				//(между элементами управления отвечающими за операции: "=" и "*")
				jpnlNumb.add(jbtnOperat[0]);
				jpnlNumb.add(jbtnNumb[i]);
				jpnlNumb.add(jbtnOperat[1]);
			}
			else{
				//добавляем (кнопки цифр 1-9) под номерами 0-8
				jpnlNumb.add(jbtnNumb[i]);
			}
		}
		jpnlOperate.add(jbtnOperat[2]);
		jpnlOperate.add(jbtnOperat[3]);
		jpnlOperate.add(jbtnOperat[4]);
		jpnlOperate.add(jbtnOperat[5]);
		jpnlOperate.add(jbtnOperat[6]);
		jpnlOperate.add(jbtnOperat[7]);
		jpnlOperate.add(jbtnOperat[8]);
		jpnlOperate.add(jbtnOperat[9]);
		jpnlOperate.add(jbtnOperat[10]);
		jpnlOperate.add(jbtnOperat[11]);
		
		//добавляем обе панели (кнопок цифр и кнопок операций) в общую панель
		jpnl.add(jpnlNumb);
		jpnl.add(jpnlOperate);
		
		pen.gridx = 0;
		pen.gridy = 0;
		this.add(jtxt, pen); //текстовое поле на фрейм
		pen.gridx = 0;
		pen.gridy = 1;
		this.add(jpnl, pen); //общую панель на фрейм
		this.pack();
		this.setResizable(false);
		this.setLocationRelativeTo(null); //запуск приложения "по центру" экрана
		
		//добавление слушателей на все кнопки цифр
		for(int i = 0; i <= jbtnNumb.length-1; i++)
			jbtnNumb[i].addActionListener(new JbtnList());
		//добавление слушателей на все кнопки операций
		for(int i = 0; i <= jbtnOperat.length-1; i++)
			jbtnOperat[i].addActionListener(new JbtnList());
		//добавление слушателей кнопки операций СС
		for(int i = 0; i <= jbtnNSOperate.length-1; i++)
			jbtnNSOperate[i].addActionListener(new JbtnList());
	}
	//закрытый класс для "инициализации" слушателей
	private class JbtnList implements ActionListener{
		public void actionPerformed(ActionEvent e){
		try{
			String act = e.getActionCommand();
			switch(act){
			//кнопки "цифр"
			case "0":
			case "1":
			case "2":
			case "3":
			case "4":
			case "5":
			case "6":
			case "7":
			case "8":
			case "9":
				jtxt.setText(jtxt.getText()+act);
				break;
			//кнопки бинарных операций
			case "+":
			case "-":
			case "/":
			case "*":
			case "a^b":
			case "a^1/b":
					operation(e.getActionCommand(), Double.parseDouble(jtxt.getText()));
				jtxt.setText("");
				break;
			//кнопки унарных операций (для числа)
			case "<html>&radic;":
			case "%":
			case "+/-":
			case "<html> x<sup>2</sup>":
				operation(act);
				if(detectTypeI(Double.parseDouble(jtxt.getText() )) && detectTypeI( solveD(Double.parseDouble(jtxt.getText() ))) )
					jtxt.setText(Integer.toString( (int) solveD(Double.parseDouble(jtxt.getText() ))));
				else
					jtxt.setText(Double.toString( solveD(Double.parseDouble(jtxt.getText() ))));
				break;
			//кнопки унарных операций для числа в СС, отличающейся от десятичной
			case "BIN":
			case "HEX":
			case "OCT":
			case "DEC":
				operation(e.getActionCommand());
				jtxt.setText(solveD(jtxt.getText()));
				break;
			//кнопки для записи числа в СС, отличающейся от десятичной
			case "0x":
			case "0b":
					jtxt.setText(act);
				break;
			case "<html>&#048;":
				jtxt.setText(""+0);
				break;
			//кнопка "очистить"
			case "C":
				jtxt.setText("");
				setA();
				break;
			//кнопка "удали последний символ"
			case "<":
				jtxt.setText(jtxt.getText().substring(0, jtxt.getText().length()-1));
				break;
			//кнопка "завершить вычисление"
			case "=":
				if(getA() != 0) {
					if( detectTypeD(Double.parseDouble(jtxt.getText())) || detectTypeD(getA()) )// {
						jtxt.setText(Double.toString(solveD(Double.parseDouble(jtxt.getText() ))) );
//						JOptionPane.showMessageDialog(null, "Какое-то из чисел вещественное");
//					}
					else
						if(detectTypeI(Double.parseDouble(jtxt.getText())) && detectTypeI(getA())) {
							if(detectTypeI(solveD( (int) getA(), (int) Double.parseDouble(""+jtxt.getText()))) )// {
								jtxt.setText(Integer.toString( solveD( (int) getA(), (int) Double.parseDouble(""+jtxt.getText())) ));
//								JOptionPane.showMessageDialog(null, "Оба числа целые и результат операции также целый");
//							}
							else// {
								jtxt.setText(Double.toString( solveD( Double.parseDouble(""+jtxt.getText())) ));
//								JOptionPane.showMessageDialog(null, "Оба числа целые, но результат операции вещественный");
//							}
						}
				}
				else
					jtxt.setText(jtxt.getText());
				break;
			//кнопка "добавление десятичного разделителя (дробной точки/запятой)"
			case ".":
				if(jtxt.getText().contains(".")){
					JOptionPane.showMessageDialog(null, "Недопустимая операция!!");
				}
				else
					//при условии что поле не содержит разделителя
					jtxt.setText(jtxt.getText() + ".");
				break;
			}
		}catch(StringIndexOutOfBoundsException | NumberFormatException exc){
				JOptionPane.showMessageDialog(null,  "Не корректно заданное значение!!\n" + exc);
			}
		}
	}
	public static void main(String[] args) {
		//создание анонимного экземпляра класса CalcGUI()
		new CalcGUI().setVisible(true);
	}
}