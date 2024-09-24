@GetMapping("/literal")
public String literal(Model model){
    model.addAttribute("data", "Spring!");
    return "basic/literal";
}
