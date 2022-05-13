package hello.core.scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.assertThat;

public class PrototypeTest {

    @Test
    void PrototypeBeanFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class); // @Configuration과 동치?

        System.out.println("find prototypeBean1");
        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
        System.out.println("find prototypeBean2");
        PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);

        System.out.println("prototypeBean1 = " + prototypeBean1);
        System.out.println("prototypeBean2 = " + prototypeBean2);
        assertThat(prototypeBean1).isNotSameAs(prototypeBean2);
        
        prototypeBean1.destroy(); // 직접 삭제
        prototypeBean2.destroy();
        ac.close(); // 클로즈 안되고 있는 모습을 볼 수 있다. 프로토타입이니 걍 만들고 버린거 ㅋㅋ
    }

    // 여긴 컴포넌트가 없는데용?? --> new에 PrototypeBean.class를 넣어줬기 때문에 이 클래스 자체가 컴포넌트 스캔의 대상 자체처럼 동작하기 때문에 바로 스프링 빈에 등록해버림. 그래서 없어도 됨
    @Scope("prototype")
    static class PrototypeBean {
        @PostConstruct
        public void init() {
            System.out.println("prototypeBean.init");
//            System.out.println("SingletonBean.init");
        }

        @PreDestroy
        public void destroy() {
            System.out.println("prototypeBean.destroy");
//            System.out.println("singletonBean.destroy");
        }
    }
}
