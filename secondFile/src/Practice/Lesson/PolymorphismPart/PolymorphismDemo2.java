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
        I2 objI2 = new D();		//objI2�� ���忡���� DŬ������ ����������, I2 �������̽��� ��밡���ϴ�. 
        I3 objI3 = new D();		
         
        //Ŭ������ ����� �� ��� ����� ����ؾ��Ѵٸ�, Ŭ������ ������ Ÿ���� ��ü Ŭ������ �����ؾ߰�����
        //Ư�� �������̽��� ��ɸ� ����ؾ��Ѵٸ� Ŭ������ ������ Ÿ���� �ش� �������̽��� �����Ѵٸ�, �ش� �������̽��ܿ� �ٸ� �������̽��� ���ʿ� ���� ��ó�� ����� �� �ִ�.
        
        obj.A();
        obj.B();
         
        objI2.A();
        //objI2.B();		������ �߻��Ѵ�. objI2�� ������ Ÿ���� ������ DŬ������ I2�� ��ɸ� ����� �� �ֱ� ������ I3�� B�޼ҵ带 ����� �� ����.
         
        //objI3.A();
        objI3.B();
    }
}
