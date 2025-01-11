@Test
void templateMethodV2(){
    AbstractTemplate template1 = new AbstractTemplate(){
        @Override
        protected void call() {
            log.info("비즈니스 로직1 실행");
        }
    };
    template1.execute();


    AbstractTemplate template2 = new AbstractTemplate(){
        @Override
        protected void call() {
            log.info("비즈니스 로직2 실행");
        }
    };
    template2.execute();
}
