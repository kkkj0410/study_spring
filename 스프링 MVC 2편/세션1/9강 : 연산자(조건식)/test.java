@GetMapping("/operation")
public String operation(Model model){
    model.addAttribute("nullData", null);
    model.addAttribute("data", "spring!");

    return "basic/operation";
}
