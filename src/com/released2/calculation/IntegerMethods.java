package com.released2.calculation;
	import static java.lang.Math.*;
public class IntegerMethods {
		//сложение
		public static int additionI(int a, int b){
			return a+b;
		}
		//вычитание
		public static int substractionI(int a, int b){
			return a-b;
		}
		//произведение
		public static int multiplicationI(int a, int b){
			return a*b;
		}
		//возведение в квадрат
		public static int squaringI(int numb){
			return (int) pow(numb,2);
		}
		//возведение в требуемую степень
		public static int involutionI(int a, int b){
			return (int) pow(a,b);
		}
		//смена знака числа
		public static int plus_minusI(int b){
			return b = -b;
		}
	}
