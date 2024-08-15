package hello_DB.jdbc.service;

import hello_DB.jdbc.domain.Member;
import hello_DB.jdbc.repository.MemberRepositoryV2;
import hello_DB.jdbc.repository.MemberRepositoryV3;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

//트랜잭션 - 트랜잭션 매니저

@RequiredArgsConstructor
@Slf4j
public class MemberServiceV3_1 {

    //private final DataSource dataSource;
    private final PlatformTransactionManager transactionManager;
    private final MemberRepositoryV3 memberRepository;


    public void accountTransfer(String fromId, String toId, int money) throws SQLException
    {
        //트랜잭션 시작
        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());


        try{
            //비즈니스 로직
            bizLogic(fromId, toId, money);
            transactionManager.commit(status);
        } catch (Exception e){
            transactionManager.rollback(status);
            throw new IllegalStateException(e);
        }

    }

    private void bizLogic(String fromId, String toId, int money) throws SQLException {
        Member fromMember = memberRepository.findById(fromId);
        Member toMember = memberRepository.findById(toId);

        memberRepository.update(fromId,fromMember.getMoney() - money);

        //이체 도중 예외를 발생시킴
        validation(toMember);

        memberRepository.update(toId, toMember.getMoney() + money);
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
