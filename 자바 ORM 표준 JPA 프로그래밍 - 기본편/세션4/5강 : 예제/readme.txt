### 해당 코드는 무슨 문제점을 가지는가?

- 객체끼리의 상호작용능력 부족
    - 예시
        - Order DB를 통해 해당 Member를 조회하려고 한다
        
        ```java
        Long findId = Order.getMemberId()
        for(Member 전체)
        {
        	if(findId == Member.getId()
        	{
        		Member 찾기 성공
        	}
        }
        ```
        
        - 무엇이 문제인가?
            - 객체였다면, Order 객체 안에 Member 객체를 저장하고 사용하면 됨
            - 하지만 DB이므로, DB의 Order품목 안에 Member객체 삽입이 안되는 상황
            - 이에대한 해결 방법을 다음 세션에서 다룬다.
