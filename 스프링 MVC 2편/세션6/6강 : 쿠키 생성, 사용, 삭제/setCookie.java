@PostMapping("/login")
public String login(HttpServletResponse response){

    //로그인 성공 처리

    //쿠키에 시간 정보 없으면 세션 쿠키임(브라우저 종료시 모두 종료)
    Cookie idCookie = new Cookie("memberId", String.valueOf(loginMember.getId()));
    response.addCookie(idCookie);
    
    return "redirect:/";
}
