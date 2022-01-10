package hello.thymeleafmvc.web;

import hello.thymeleafmvc.domain.member.Gender;
import hello.thymeleafmvc.domain.member.Hobby;
import hello.thymeleafmvc.domain.member.Member;
import hello.thymeleafmvc.domain.member.MemberRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberRepository memberRepository;

    @ModelAttribute("Genders")
    public Gender[] genders() {
        return Gender.values();
    }

    @ModelAttribute("hobbies")
    public List<Hobby> hobbies() {
        return Hobby.hobbyList();
    }

    @PostConstruct
    public void postConstruct() {
        memberRepository.save(new Member("lee", "seoul", Gender.MALE, true, "MOVIE"));
        memberRepository.save(new Member("kim", "busan", Gender.FEMALE, false, "SPORT"));
    }

    @GetMapping
    public String members(Model model) {
        model.addAttribute("members", memberRepository.findAll());
        return "members";
    }

    @GetMapping("/{memberId}")
    public String member(@PathVariable Long memberId, Model model) {
        Member member = memberRepository.findById(memberId);
        model.addAttribute("member", member);
        return "member";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("member", new Member());
        return "addForm";
    }

    @PostMapping("/add")
    public String saveMember(@ModelAttribute Member member, RedirectAttributes redirectAttributes) {
        log.info("member={}", member);
        memberRepository.save(member);
        redirectAttributes.addAttribute("memberId", member.getId());
        return "redirect:/members/{memberId}";
    }

    @GetMapping("/{memberId}/edit")
    public String editForm(@PathVariable Long memberId, Model model) {
        Member member = memberRepository.findById(memberId);
        model.addAttribute("member", member);
        return "editForm";
    }

    @PostMapping("/{memberId}/edit")
    public String editMember(@PathVariable Long memberId, @ModelAttribute Member member) {
        Member findMember = memberRepository.findById(memberId);
        findMember.setName(member.getName());
        findMember.setAddress(member.getAddress());
        return "redirect:/members/{memberId}";
    }
}
