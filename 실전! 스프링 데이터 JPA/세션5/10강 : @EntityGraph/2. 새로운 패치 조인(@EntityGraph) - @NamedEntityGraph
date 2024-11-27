@EntityGraph("Member.all")
List<Member> findEntityGraph2ByUsername(@Param("username") String username);

@NamedEntityGraph(name = "Member.all", attributeNodes = @NamedAttributeNode("team"))
public class Member {
}
