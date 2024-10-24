목적

- CORS 제한 해제
    - .addFilter(corsFilter)
- api/v1/~~ URL로 들어오는 접속자의 권한 제한
    - .requestMatchers("/api/v1/user/**").hasAnyRole("USER", "MANAGER", "ADMIN")
- 세션 막음
- 사용자 스스로가 만든 로그인 폼 못 쓰게 막음

※ CORS **:** 내가 아닌 다른 URL에게 내 자원을 쓰도록 허용하는 것
