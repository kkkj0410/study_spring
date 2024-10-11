//@GetMapping("/")
public String homeLoginV3(HttpServletRequest request, Model model){
    HttpSession session = request.getSession(false);

    if(session == null)
    {
        return "home";
    }

    Member loginMember = (Member)session.getAttribute(SessionConst.LOGIN_MEMBER);

    //회원 데이터 X면
    if(loginMember == null){
        return "home";
    }

    //회원 데이터 있으면
    model.addAttribute("member", loginMember);
    return "loginHome";
}
