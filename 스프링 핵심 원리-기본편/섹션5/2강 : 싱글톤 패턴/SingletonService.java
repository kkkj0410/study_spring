package hello.core.singleton;

public class SingletonService {

    //자기자신(=SingletonServie)을 생성하고, instance에 집어넣음(=자기자신을 자기자신에게 넣음)
    private static final SingletonService instance = new SingletonService();

    //외부에서 getInstance 함수를 통해 SingletonService를 호출하는 코드
    //SingletonService인 instance는 static이니, 여러번 호출하더라도 완전히 동일한 instance 객체만 호출됨
    public static SingletonService getInstance()
    {
        return instance;
    }

    //다른 소스 코드에서 SingletonService 클래스 호출을 막음
    private SingletonService()
    {

    }
    
    public void logic()
    {
        System.out.println("싱글톤 객체 로직 호출");
    }
    
}
