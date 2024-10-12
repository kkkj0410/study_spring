@PostMapping("/login")
public String loginV4(@Valid @ModelAttribute LoginForm form, BindingResult bindingResult,
                      @RequestParam(defaultValue = "/") String redirectURL,
                      HttpServletRequest request){
    if(bindingResult.hasErrors()){
        return "login/loginForm";
    }
    Member loginMember = loginService.login(form.getLoginId(), form.getPassword());

    if(loginMember == null){
        bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다.");
        return "login/loginForm";
    }


    //true : 세션이 있으면 있는 세션 반환. 없으면 신규 세션
    //true : 세션이 있으면 있는 세션 반환. 없으면 null
    HttpSession session = request.getSession(true);
    //해당 세션에 로그인 정보 저장
    session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);


    return "redirect:" + redirectURL;
}
