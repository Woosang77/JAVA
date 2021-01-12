package Practice.Lesson.IOpackage.Serializable.Serialversion;

import java.io.Serializable;

public class ClassC implements Serializable{
	
	static final long serialVersionUID = 12345676;
	//serialVersionUID를 명시적으로 선언한다면, 컴파일시 자동재생성되는 것을 방지해, 
	//자주 변경하는 객체를 역직렬화할 때 오류를 없앨 수 있다.
	int field1;
	int field2;
	int field3;
	int field4;
}
