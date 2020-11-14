package com.released2.calculation;
	import static java.lang.Math.*;
public class DoubleMethods {
	//сложение
		public static double additionD(double a, double b){
			return a+b;
		}
		//вычитание
		public static double substractionD(double a, double b){
			return a-b;
		}
		//деление
		public static double divisionD(double a, double b){
			return a/b;
		}
		//произведение
		public static double multiplicationD(double a, double b){
			return a*b;
		}
		//квадратный корень
		public static double squareRootD(double numb){
			return sqrt(numb);
		}
		//возведение в квадрат
		public static double squaringD(double numb){
			return pow(numb,2);
		}
		//возведение в требуемую степень
		public static double involutionD(double a, double b){
			return pow(a,b);
		}
		//вычисление корня требуемой степени
		public static double n_thRootD(double a, double b){
			return pow(a,(double)1/b);
		}
		//вычисление процента
		public static double pro_centumD(double b){
			return b/100;
		}
		//смена знака числа
		public static double plus_minusD(double b){
			return b = -b;
		}
	}
