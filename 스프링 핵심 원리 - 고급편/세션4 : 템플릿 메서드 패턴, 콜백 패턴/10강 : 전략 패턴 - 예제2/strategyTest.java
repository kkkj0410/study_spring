  @Test
    void strategyV2(){
        ContextV1 context1 = new ContextV1(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직1 실행");
            }
        });
        context1.execute();



        ContextV1 context2 = new ContextV1(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직2 실행");
            }
        });
        context2.execute();
    }

    @Test
    void strategyV4(){

        ContextV1 context1 = new ContextV1(() -> log.info("비즈니스 로직 실행1"));
        context1.execute();

        ContextV1 context2 = new ContextV1(() -> log.info("비즈니스 로직 실행2"));
        context2.execute();

    }
