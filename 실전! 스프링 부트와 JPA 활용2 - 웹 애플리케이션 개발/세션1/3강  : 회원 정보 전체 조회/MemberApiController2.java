//Controller + ResponseBody
@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;

    @GetMapping("/api/v2/members")
    public Result memberV2(){
        List<Member> findMembers = memberService.findMembers();
        List<MemberDto> collect = findMembers.stream()
                //.map : 각 원소 m을 어떻게 수정할 지를 정함
                //따라서, 각 원소 m은 MemberDto 타입으로 변환
                .map(m->new MemberDto(m.getName()))
                //.toList : 결과물을 List 형태로 저장
                .collect(Collectors.toList());

        return new Result(collect);
    }

    @Data
    @AllArgsConstructor
    static class Result<T>{
        private T data;
    }

    @Data
    @AllArgsConstructor
    static class MemberDto{
        private String name;
    }
}
