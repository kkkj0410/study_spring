@GetMapping("/")
//required = false : 쿠키가 없어도 정상 실행
//memberId는 쿠키 상태에서 String. 하지만 스프링에서 Long으로 치환해주는 기능 있음
public String homeLogin(@CookieValue(name = "memberId", required = false) Long memberId, Model model){
    if(memberId == null){
        return "home";
    }

    Member loginMember = memberRepository.findById(memberId);
    if(loginMember == null){
        return "home";
    }

    model.addAttribute("member", loginMember);
    return "loginHome";
}
