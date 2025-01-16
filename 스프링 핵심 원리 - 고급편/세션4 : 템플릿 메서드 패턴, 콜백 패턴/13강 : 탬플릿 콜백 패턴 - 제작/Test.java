/**
 * 탬플릿 콜백 패턴 - 익명 내부 클래스
 */
@Test
void callbackV1(){
    TimeLogTemplate template = new TimeLogTemplate();
    template.execute(new Callback(){
        @Override
        public void call(){
            log.info("비즈니스 로직1 실행");
        }
    });

    template.execute(new Callback(){
        @Override
        public void call(){
            log.info("비즈니스 로직2 실행");
        }
    });
}

/**
 * 탬플릿 콜백 패턴 - 람다
 */
@Test
void callbackV2(){
    TimeLogTemplate template = new TimeLogTemplate();
    template.execute(() -> log.info("비즈니스 로직1 실행"));

    template.execute(() -> log.info("비즈니스 로직2 실행"));
}
