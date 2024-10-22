@GetMapping("/test/login")
public @ResponseBody String testLogin(Authentication authentication,
                                      @AuthenticationPrincipal PrincipalDetails userDetails){
    System.out.println("/test/login ================");

    PrincipalDetails principalDetails = (PrincipalDetails)authentication.getPrincipal();
    System.out.println("principalDetails : " + principalDetails.getUser());
    System.out.println("userDetails : " + userDetails.getUser());
    return "세션 정보 확인";
}
