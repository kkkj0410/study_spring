@PostMapping("/logout")
public String logout(HttpServletResponse response){
    expireCookie(response, "memberId");
    return "redirect:/";
}

private static void expireCookie(HttpServletResponse response, String cookieName) {
    Cookie cookie = new Cookie(cookieName, null);
    //쿠키의 사용기한 0 
    cookie.setMaxAge(0);
    response.addCookie(cookie);
}
