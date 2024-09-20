
@GetMapping("/basic-objects")
public String basicObjects(Model model, HttpServletRequest request,
                           HttpServletResponse response, HttpSession session) {
    session.setAttribute("sessionData", "Hello Session");
    model.addAttribute("request", request);
    model.addAttribute("response", response);
    model.addAttribute("servletContext", request.getServletContext());
    return "basic/basic-objects";
}

@Component("helloBean")
static class HelloBean{
    public String hello(String data){
        return "Hello " + data;
    }
}

@Data
static class User{
    private String username;
    private int age;

    public User(String username, int age){
        this.username = username;
        this.age = age;
    }

