package Practice.Lesson.collection_framework.stack;

import java.util.Stack;

public class StackExample {
	public static void main(String[] args) {
		Stack<Coin> coinBox = new Stack<>();
		
		coinBox.push(new Coin(100));
		coinBox.push(new Coin(50));
		coinBox.push(new Coin(500));
		coinBox.push(new Coin(10));
		
		while (!coinBox.isEmpty()) {
			Coin coin = coinBox.pop();
			System.out.print(coin.getValue() + "  ");
			//10  500  50  100  
			//Stack은 LIFO의 대표적 클래스이다. 후입선출로 입력한 순서의 역순으로 출력한다.
		}
	}
}
