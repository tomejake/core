package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.order.OrderServiceImp;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        // 테스트용(원래는 구체 타입으로 꺼내면 안좋다.)
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImp orderService = ac.getBean("orderService", OrderServiceImp.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        // MemberRepository memberRepository1 = memberService.getMemberRepository();
        // MemberRepository memberRepository2 = orderService.getMemberRepository();
        assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
        assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);
    }

    @Test
    void configurationDepp(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);
        System.out.println("bean = " + bean.getClass());
    }

}
