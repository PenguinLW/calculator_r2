package com.released2.calculation;
import static java.lang.Math.*;
import static com.released2.calculation.NumberSystemOperation.*;
import static com.released2.calculation.IntegerMethods.*;
import static com.released2.calculation.DoubleMethods.*;
import static com.released2.auxiliary.AXClass.*;
public class CalculationD {
	private static double a, b, val;
	private static String operation = "";
	
	public static double getA(){
		return a;
	}
	public static void setA() {
		a = 0;
	}
	public static void operation(String act, double A){
		a = A;
		operation = act;
	}
	public static void operation(String act){
		operation = act;
	}
	public static double solveD(double B){
			switch(operation){
			case "+":
				val = additionD(a, b = B); //сложение
				break;
			case "-":
				val = substractionD(a, b = B); //вычитание
				break;
			case "/":
				val = divisionD(a, b = B); //деление
				break;
			case "*":
				val = multiplicationD(a, b = B); //произведение
				break;
			case "<html>&radic;":
				val = squareRootD(b = B); //извлечение квадратного корня
				break;
			case "<html> x<sup>2</sup>":
				val = squaringD(b = B); //возведение в квадрат
				break;
			case "%":
				val = pro_centumD(b = B); //вычисление процента
				break;
			case "+/-":
				val = plus_minusD(b = B); //смена знака числа
				break;
			case "a^b":
				val = involutionD(a, b = B); //возведение числа a в степень b
				break;
			case "a^1/b":
				val = n_thRootD(a, b = B); //извлечение корня b-ой степени
				break;
			}
			return val;
	}
	public static int solveD(int A, int B){
		int a = A;
		int b = B;
		int val = 0;
		switch(operation){
		case "+":
			val = additionI(a, b = B); //сложение
			break;
		case "-":
			val = substractionI(a, b = B); //вычитание
			break;
		case "/":
			if(detectTypeI(divisionD(a, b = B)))
				val = (int)divisionD(a, b = B);
			break;
		case "*":
			val = multiplicationI(a, b = B); //произведение
			break;
		case "<html> x<sup>2</sup>":
			val = squaringI(b = B); //возведение в квадрат
			break;
		case "+/-":
			val = plus_minusI(b = B); //смена знака числа
			break;
		case "a^b":
			val = involutionI(a, b = B); //возведение числа a в степень b
			break;
		}
			return val;
	}
	public static String solveD(String B){
		String val = "";
		switch(operation){
		case "BIN":
			val = binary(detectNS(B));
			break;
		case "HEX":
			val = hex_a_decimal(detectNS(B));
			break;
		case "OCT":
			val = octal(detectNS(B));
			break;
		case "DEC":
			val = decimal(detectNS(B));
			break;
		}
		return val;
	}
}