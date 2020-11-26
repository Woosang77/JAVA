package Practice.Lesson.ExceptionPart;

import java.io.*;

class BB {
	void run() throws FileNotFoundException, IOException{			//class�� �ܰ踦 �ǳʰ��鼭 ����ó���� ������ ���� THROW�� ���ؼ� ���� Ŭ������ �ѱ�� �ִ�. 
		BufferedReader bReader = null;
		String input = null;
		bReader = new BufferedReader(new FileReader("out.txt"));		
		input = bReader.readLine();	
		System.out.println(input);
		bReader.close();
	}
}

class C {
	void run() {
		BB b = new BB();
		try {
			b.run();			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

public class ExceptionDemo4 {
	public static void main(String[] args) {
		C c = new C();
		c.run();
	}
}
