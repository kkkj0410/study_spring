    @Test
    void field(){
        log.info("main start");

//        Runnable userA = new Runnable(){
//            @Override
//            public void run(){
//                fieldService.logic("userA");
//            }
//        }

        Runnable userA = () -> {
            fieldService.logic("userA");
        };

        Runnable userB = () -> {
            fieldService.logic("userB");
        };

        Thread threadA = new Thread(userA);
        threadA.setName("thread-A");
        Thread threadB = new Thread(userB);
        threadB.setName("thread-B");

        threadA.start();
        //sleep(2000); //동시성 문제 발생 X
        sleep(0); // 동시성 문제 발생O
        threadB.start();

        //메인 쓰레드가 끝나버려서 threadB가 강제 종료됨
        //따라서 threadB가 끝날떄까지 메인쓰레드 대기
        sleep(3000);
        log.info("main exit");
    }

    private void sleep(int millis){
        try{
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
