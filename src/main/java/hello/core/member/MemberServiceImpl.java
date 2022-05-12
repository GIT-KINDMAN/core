package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Autowired // 의존관계 자동 주입: 필요한 이유- Impl이 떡하고 등록되면 안되자너. 그래서 구현체 생성자에 붙이면 어? [생성자 타입에 맞는 애를 찾아와서] 의존관계 주입을 자동으로 연결해서 해줌 -> 마치 ac.getBean(MemberRepository.class) 해왔던 것과 같음
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository; // 여기 memberRepository에 MemomeryRepository가 들어오게 됨. Memory관련은 이제 여기 없다. 추상화 관련만 있다. 그건 이제, AppConfig에서 해준다.
    }

    public void join(Member member) {
        memberRepository.save(member);
    }

    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }


    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}