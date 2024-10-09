@PostMapping("/logout")
public String logoutV3(HttpServletResponse response, HttpServletRequest request){
    HttpSession session = request.getSession(false);
    if(session != null){
        //세션 삭제
        session.invalidate();
    }

    return "redirect:/";
}
