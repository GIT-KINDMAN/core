package hello.core.member;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository; // 여기 memberRepository에 MemomeryRepository가 들어오게 됨. Memory관련은 이제 여기 없다. 추상화 관련만 있다. 그건 이제, AppConfig에서 해준다.
    }

    public void join(Member member) {
        memberRepository.save(member);
    }

    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}