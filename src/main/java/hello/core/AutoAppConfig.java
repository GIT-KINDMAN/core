package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

@Configuration // 설정 정보니까!
@ComponentScan ( // 스프링 빈을 쫙 자동으로 끌어올려야 해서 필요한 녀석
//        basePackages = "hello.core.member", // 이러면 member만 픽업됨. 어디서부터 찾을지 지정 가능. 그 하위까지만. 이게 없으면 ㅋㅋ 모든 자바코드 다 뒤지면 뒤지게 오래걸림
        excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION, classes = Configuration.class) // 뺄 걸 지정해주는 코드. 어노테이션타입 중 Configuration.class 어노테이션 붙은 애는 뺀다? 아, AppConfig 빼는거인듯. 그니까, 그냥 예제를 유지하기 위해서.
)
public class AutoAppConfig {
//    @Bean(name = "memoryMemberRepository")
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }
}
