@GetMapping("link")
public String link(Model model){
    model.addAttribute("param1", "data1");
    model.addAttribute("param2", "data2");

    return "basic/link";
}
