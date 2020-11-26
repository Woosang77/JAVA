package Practice.Lesson.ExceptionPart;

import java.io.*;

class BB {
	void run() throws FileNotFoundException, IOException{			//class의 단계를 건너가면서 예외처리가 가능할 때는 THROW를 통해서 다음 클래스로 넘길수 있다. 
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
