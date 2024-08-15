//트랜잭션 - 파라미터 연동, 풀을 고려한 종료

@RequiredArgsConstructor
@Slf4j
public class MemberServiceV2 {

    private final DataSource dataSource;
    private final MemberRepositoryV2 memberRepository;


    public void accountTransfer(String fromId, String toId, int money) throws SQLException
    {
        Connection con = dataSource.getConnection();
        try{
            con.setAutoCommit(false); //트랜잭션 시작

            //비즈니스 로직
            bizLogic(con, fromId, toId, money);

            con.commit(); // 성공 시, 커밋
        } catch (Exception e){
            con.rollback(); //실패 시, 롤백
            throw new IllegalStateException(e);
        } finally {

                release(con);
        }

    }

    private void bizLogic(Connection con, String fromId, String toId, int money) throws SQLException {
        Member fromMember = memberRepository.findById(con, fromId);
        Member toMember = memberRepository.findById(con, toId);

        memberRepository.update(con, fromId,fromMember.getMoney() - money);

        //이체 도중 예외를 발생시킴
        validation(toMember);

        memberRepository.update(con, toId, toMember.getMoney() + money);
    }

    private static void release(Connection con) {
        try{
            con.setAutoCommit(true); //트랜잭션 종료
            con.close();//커넥션 종료
        }catch(Exception e){
            log.info("error",e);
        }
    }

    private static void validation(Member toMember) {
        if(toMember.getMemberId().equals("ex")){
            throw new IllegalStateException("이체중 예외 발생");
        }
    }

}
