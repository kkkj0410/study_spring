
interface A
{
    public void Print();
}

class B implements A
{
    public void Print()
    {
        System.out.println(123);
    }
}

public class HelloWorld {
    public static void main(String[] args) {
        B b = new B();
        A a = b; // a는 interface지만, 자식인 b를 받을 수 있다.
        
        a.Print();
    }
}
