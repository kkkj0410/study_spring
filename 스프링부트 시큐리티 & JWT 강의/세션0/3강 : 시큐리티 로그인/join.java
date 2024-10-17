@Autowired
private BCryptPasswordEncoder bCryptPasswordEncoder;

@PostMapping("/join")
public String join(User user){
    user.setRole("ROLE_USER");
    String rawPassword = user.getPassword();
    String encPassword = bCryptPasswordEncoder.encode(rawPassword);
    user.setPassword(encPassword);

    System.out.println("user : " + user);
    userRepository.save(user);
    return "redirect:/loginForm";
}
