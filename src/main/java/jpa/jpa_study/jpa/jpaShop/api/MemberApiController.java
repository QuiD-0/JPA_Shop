package jpa.jpa_study.jpa.jpaShop.api;

import jpa.jpa_study.jpa.jpaShop.domain.Member;
import jpa.jpa_study.jpa.jpaShop.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;

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
    public Long updateMemberV2(@PathVariable Long id,@RequestBody UpdateMemberRequest request){

        memberService.update(id,request.getName());
        Member member = memberService.findOne(id);
        return member.getId();
    }

    @Data
    static class CreateMemberRequest{
        private String name;
    }

    @Data
    @AllArgsConstructor
    static class CreateMemberResponse {
        private Long id;
    }

    @Data
    static class UpdateMemberRequest{
        private String name;
    }

}
