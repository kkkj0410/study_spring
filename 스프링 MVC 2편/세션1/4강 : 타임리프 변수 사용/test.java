
@GetMapping("/variable")
public String variable(Model model){
    User userA = new User("userA", 10);
    User userB = new User("userB", 20);

    List<User> list = new ArrayList<>();
    list.add(userA);
    list.add(userB);

    Map<String, User> map = new HashMap<>();
    map.put("userA", userA);
    map.put("userB", userB);

		//객체, List, Map 저장
		//타임리프에서 조회할 거임
    model.addAttribute("user", userA);
    model.addAttribute("users", list);
    model.addAttribute("userMap", map);
    return "basic/variable";
}

@Data
static class User{
    private String username;
    private int age;

    public User(String username, int age){
        this.username = username;
        this.age = age;
    }

