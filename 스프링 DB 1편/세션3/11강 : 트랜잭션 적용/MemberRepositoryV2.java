package hello_DB.jdbc.repository;


import hello_DB.jdbc.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.support.JdbcUtils;

import javax.sql.DataSource;
import java.sql.*;
import java.util.NoSuchElementException;

// JDBC - ConnectionParam
// h2에 트랜잭션 적용

@Slf4j
public class MemberRepositoryV2 {

    private final DataSource dataSource;

    public MemberRepositoryV2(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Member save(Member member) throws SQLException
    {
        String sql ="insert into member(member_id, money) values (?, ?)";

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);

            //sql의 member_id에 해당하는 ?를 1로 바꾸겠다는 뜻
            pstmt.setString(1,member.getMemberId());
            pstmt.setInt(2,member.getMoney());

            //sql의 문구를 DB에서 실행
            pstmt.executeUpdate();
            return member;
        } catch (SQLException e) {
            log.error("db error", e);
            throw e;
        }finally{

            close(con,pstmt,null);
        }

    }

    public Member findById (String memberId) throws SQLException
    {
        String sql = "select * from member where member_id = ?";

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            con = getConnection();
            pstmt = con.prepareStatement(sql);

            //sql의 member_id = ?에서 ?를 1로 바꾸겠다는 뜻
            pstmt.setString(1,memberId);

            rs = pstmt.executeQuery();
            if(rs.next()){
                Member member = new Member();
                member.setMemberId(rs.getString("member_id"));
                member.setMoney(rs.getInt("money"));
                return member;
            }else{
                throw new NoSuchElementException("member not found memberId=" + memberId);
            }

        }catch(SQLException e){
            log.error("db error", e);
            throw e;
        }finally{
            close(con,pstmt,rs);
        }
    }

    //해당 커넥션을 유지하기 위해 Connection con을 가져옴
    //해당 커넥션이 유지되어야 락 권한을 계속 가지고 있는게 가능함
    public Member findById (Connection con, String memberId) throws SQLException
    {
        String sql = "select * from member where member_id = ?";

        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try{
            pstmt = con.prepareStatement(sql);

            //sql의 member_id = ?에서 ?를 1로 바꾸겠다는 뜻
            pstmt.setString(1,memberId);

            rs = pstmt.executeQuery();
            if(rs.next()){
                Member member = new Member();
                member.setMemberId(rs.getString("member_id"));
                member.setMoney(rs.getInt("money"));
                return member;
            }else{
                throw new NoSuchElementException("member not found memberId=" + memberId);
            }

        }catch(SQLException e){
            log.error("db error", e);
            throw e;
        }finally{
            JdbcUtils.closeResultSet(rs);
            JdbcUtils.closeStatement(pstmt);

            //커넥션 종료X
            //id를 찾은 다음에 connection을 종료해버리면 락 권한이 없어지기 때문임
            //JdbcUtils.closeConnection(con);
        }
    }

    public void update(String memberId, int money) throws SQLException
    {
        String sql = "update member set money=? where member_id=?";

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,money);
            pstmt.setString(2,memberId);
            int resultSize = pstmt.executeUpdate();
            log.info("resultSize = {}", resultSize);
        } catch (SQLException e) {
            log.error("db error", e);
            throw e;
        }finally{
            close(con,pstmt,null);
        }
    }

    public void update(Connection con, String memberId, int money) throws SQLException
    {
        String sql = "update member set money=? where member_id=?";

        PreparedStatement pstmt = null;

        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,money);
            pstmt.setString(2,memberId);
            int resultSize = pstmt.executeUpdate();
            log.info("resultSize = {}", resultSize);
        } catch (SQLException e) {
            log.error("db error", e);
            throw e;
        }finally{
            JdbcUtils.closeStatement(pstmt);
            //JdbcUtils.closeConnection(con);
        }
    }


    public void delete(String memberId) throws SQLException
    {
        String sql = "delete from member where member_id=?";

        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,memberId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            log.error("db error", e);
            throw e;
        }finally{
            close(con,pstmt,null);
        }
    }


    private void close(Connection con, Statement stmt, ResultSet rs)
    {
        JdbcUtils.closeResultSet(rs);
        JdbcUtils.closeStatement(stmt);
        JdbcUtils.closeConnection(con);

    }

    private Connection getConnection () throws SQLException
    {
        Connection con = dataSource.getConnection();

        log.info("get connection={}, class={}", con, con.getClass());
        return con;
    }

}
