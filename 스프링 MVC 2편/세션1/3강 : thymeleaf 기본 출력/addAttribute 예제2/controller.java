@GetMapping("text-unescaped")
public String textUnescaped(Model model){
    model.addAttribute("data", "<b>Hello Spring!</b>");
    return "basic/text-unexcaped";
}
