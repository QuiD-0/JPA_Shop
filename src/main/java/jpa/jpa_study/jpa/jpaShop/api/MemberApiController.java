package jpa.jpa_study.jpa.jpaShop.api;

import jpa.jpa_study.jpa.jpaShop.api.dto.QueryDto;
import jpa.jpa_study.jpa.jpaShop.domain.Member;
import jpa.jpa_study.jpa.jpaShop.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;

    /**
     * 멤버 리스트 반환
     * @return List<Member>
     * @version : 1.0.1
     * @author : QuiD-0
     * @param : none
     */
    @GetMapping("/api/v1/members")
    public List<Member> membersV1() {
        return memberService.findMembers();
    }

    @GetMapping("/api/v2/members")
    public Result membersV2() {
        List<Member> members = memberService.findMembers();
        List<MemberDto> collect = members.stream().map(m -> new MemberDto(m.getName()))
                .collect(Collectors.toList());
        return new Result(collect);
    }

    @GetMapping("/api/v3/members")
    public List<QueryDto> findDto(){
        return memberService.findDto();
    }

    @PostMapping("/api/v1/member")
    public CreateMemberResponse saveMemberV1(@RequestBody @Valid Member member) {
        Long id = memberService.join(member);
        return new CreateMemberResponse(id);
    }

    // 엔티티를 외부에 노출하지 않는게 좋음
    @PostMapping("/api/v2/member")
    public CreateMemberResponse saveMemberV2(@RequestBody @Valid CreateMemberRequest request) {
        Member member = new Member();
        member.setName(request.getName());
        Long id = memberService.join(member);
        return new CreateMemberResponse(id);
    }

    @PutMapping("/api/v2/member/{id}")
    public Long updateMemberV2(@PathVariable Long id, @RequestBody UpdateMemberRequest request) {
        memberService.update(id, request.getName());
        Member member = memberService.findOne(id);
        return member.getId();
    }

    @Data
    @AllArgsConstructor
    static class Result<T> {
        private T data;
    }

    @Data
    @AllArgsConstructor
    static class MemberDto {
        private String name;
    }

    @Data
    static class CreateMemberRequest {
        private String name;
    }

    @Data
    @AllArgsConstructor
    static class CreateMemberResponse {
        private Long id;
    }

    @Data
    static class UpdateMemberRequest {
        private String name;
    }

}
