    /**
     * 전략 패턴 익명 내부 클래스
     */

    @Test
    void strategyV2(){
        ContextV2 context = new ContextV2();
        context.execute(new StrategyLogic1() {
            @Override
            public void call() {
                log.info("비즈니스 로직1 실행");
            }
        });

        context.execute(new StrategyLogic2(){
            @Override
            public void call(){
                log.info("비즈니스 로직2 실행");
            }
        });
    }

    /**
     * 전략 패턴 익명 내부 클래스2, 람다
     */
     //strategyV2와 같은 함수. 람다로 구성함
    @Test
    void strategyV3(){
        ContextV2 context = new ContextV2();
        context.execute(() -> log.info("비즈니스 로직1 실행"));
        context.execute(() -> log.info("비즈니스 로직2 실행"));
    }
