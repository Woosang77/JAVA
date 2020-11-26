package Practice;

import java.util.Arrays;
import java.util.Scanner;

public class day01_calculator {
   static Scanner sc = new Scanner(System.in);
   
   public static void plus(int left, int right) {
      System.out.println("�� : " + (left + right));
   }
   public static void minus(int left, int right) {
      System.out.println("�� : " + (left - right));
   }
   public static void multi(int left, int right) {
      System.out.println("�� : " + (left * right));
   }
   public static void division(float left, float right) {
      if(left == 0 || right == 0) {
         System.out.println("�������� 0�� ���ԵǾ��ֽ��ϴ�."); 
      }else {
         System.out.println("�� : " + (left / right));         
      }
   }
   
   public static void main (String[] args) {
	   
      String[] function = {"+", "-", "x", "/"};
      int[] number = new int[2];
      System.out.println("����� ����� �������ּ��� :" + Arrays.toString(function));
      String sign = sc.nextLine();
      System.out.println("�� ���� �Է����ּ��� : ");
      for (int i = 0; i < 2; i++) {
         int num = sc.nextInt();
         number[i] = num;
      }
      switch(sign) {
         case "+":
            plus(number[0], number[1]);
            break;
         case "-":
            minus(number[0], number[1]);
            break;
         case "x":
            multi(number[0], number[1]);
            break;
         case "/":
            division(number[0], number[1]);
            break;
      }      
   }
}