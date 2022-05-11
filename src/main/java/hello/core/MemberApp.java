package hello.core;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import
        org.springframework.context.annotation.AnnotationConfigApplicationContext;
public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService(); // 앱콘피그에서 멤버서비스 달라그러면, 멤버서비스인터페이스를 준다. 그럼 그 안에는 뭐가 들어있겠나? 멤버서비스임플이 들어있겠지. 그 이후는 다 똑같다.
////        MemberService memberService = new MemberServiceImpl(); // 기존에는 직접 MemberSerivceImpl을 직접 Main에서 생성해줬었고, 그러면 임플에서 또 메모리멤버리포지토리를 만들어줬었다. 근데 이젠, AppConfig에서 다 해결한다.

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);// 메서드 이름으로 등록된 @Bean을 불러오는 것

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}