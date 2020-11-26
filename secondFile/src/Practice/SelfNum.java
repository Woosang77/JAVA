package Practice;
public class SelfNum {
	public static void main(String[] args) {
		int a,b,c,d,result,sum = 0;
		boolean [] arr = new boolean [5000];
		for (int i = 1; i < arr.length; i++) {
			a = i /1000;
			b = (i/100) % 10;
			c = (i/10) %10;
			d = i % 10;
			result = a + b + c + d + i;	
			if((result >= 1) && (result < 5000)) {
				arr[result] = true;
			}
		}
		for (int i = 1; i < arr.length; i++) {
			if(arr[i] == false) {
				sum += i;
			}
		}	
		System.out.println(sum);
	}
}
