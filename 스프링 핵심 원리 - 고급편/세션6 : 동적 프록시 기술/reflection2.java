@Test
void reflection2() throws Exception {
    //클래스 정보
    Class classHello = Class.forName("hello.advanced.jdkdynamic.ReflectionTest$Hello");

    Hello target = new Hello();
    //callA 메서드 정보
    Method methodCallA = classHello.getMethod("callA");
    dynamicCall(methodCallA, target);


    //callB 메서드 정보
    Method methodCallB = classHello.getMethod("callB");
    dynamicCall(methodCallB, target);
}

//로그 추적기 + 비즈니스 로직
private void dynamicCall(Method method, Object target) throws Exception{
    log.info("start");
    Object result = method.invoke(target);
    log.info("result={}", result);
}
