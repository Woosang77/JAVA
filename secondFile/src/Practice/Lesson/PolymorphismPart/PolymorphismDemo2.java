package Practice.Lesson.PolymorphismPart;

interface I2{
    public String A();
}
interface I3{
    public String B();
}
class D implements I2, I3{
    public String A(){
        return "A";
    }
    public String B(){
        return "B";
    }
}
public class PolymorphismDemo2 {
    public static void main(String[] args) {
        D obj = new D();
        I2 objI2 = new D();		//objI2의 입장에서는 D클래스를 가져왔지만, I2 인터페이스만 사용가능하다. 
        I3 objI3 = new D();		
         
        //클래스를 사용할 때 모든 기능을 사용해야한다면, 클래스의 데이터 타입을 전체 클래스로 설정해야겠지만
        //특정 인터페이스의 기능만 사용해야한다면 클래스의 데이터 타입을 해당 인터페이스를 지정한다면, 해당 인터페이스외에 다른 인터페이스는 애초에 없던 것처럼 사용할 수 있다.
        
        obj.A();
        obj.B();
         
        objI2.A();
        //objI2.B();		오류가 발생한다. objI2로 데이터 타입이 지정된 D클래스는 I2의 기능만 사용할 수 있기 때문에 I3의 B메소드를 사용할 수 없다.
         
        //objI3.A();
        objI3.B();
    }
}
