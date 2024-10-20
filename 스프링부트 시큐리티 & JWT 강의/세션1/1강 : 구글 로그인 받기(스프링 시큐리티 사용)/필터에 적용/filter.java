// /oauth2/authorization/google로 URL 접속 시, 아래 함수가 실행됨
.oauth2Login(oauth2 -> oauth2
						//로그인 시, 이동하는 창
						//하지만 구글 로그인 창으로 이동되므로, 무시되는 명령임
            .loginPage("/loginForm") // 구글 로그인이 완료된 뒤의 후 처리가 필요.
