//시큐리티가 /login POST 요청을 낚아채서 로그인을 진행
//로그인 완료 후, 시큐리티 기능으로 session을 만들어줌(session key = Security ContextHolder)
//오브젝트 타입 => Authentication 타입 객체
//Authenticcation 안에 User 정보가 있어야 함
//User 오브젝트 타입 => UserDetails 타입 객체

//Security Session => Authentication => UserDetails

//---------------------------------------------------------

// UsernamePasswordAuthenticationFilter에게 건내줄 사용자 정보 객체 타입을 정의함
// UsernamePasswordAuthenticationFilter는 해당 객체를 통해 User 정보가 시큐리티 내에 있는지 확인함
// 또한 UserDetails 내에 사용된 다양한 함수들에서 사용자의 만료 정보 등도 참고해서, 사용자가 로그인 가능한지 따지게 됨
// 따라서 오버라이딩 된 boolean 타입 함수들 중, 하나라도 false이면 접근 권한을 얻을 수 없음.
public class PrincipalDetails implements UserDetails {

    private User user;

    public PrincipalDetails(User user){
        this.user = user;
    }


    //해당 User의 권한 return
    //체인 필터에게 사용자의 접근 권한을 전달하기 위해서 필요
    //체인은 해당 값을 통해 해당 사용자가 접근 권한이 있는지를 판별 가능
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collect = new ArrayList<>();
        collect.add(new GrantedAuthority(){
            @Override
            public String getAuthority(){
                return user.getRole();
            }
        });


        return collect;
    }



    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {

        //1년동안 회원을 로그인을 안할 시, 휴먼 계정으로 전환
        //현재시간 - 로그인 시간 = 1년 => 휴먼 계정 전환

        return true;
    }


    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }
}
