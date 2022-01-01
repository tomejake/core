package hello.core.scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.assertThat;

public class PrototypeTest {
    @Test
    public void prototypeFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeTestBean.class);
        PrototypeTestBean prototypeTestBean1 = ac.getBean(PrototypeTestBean.class);
        PrototypeTestBean prototypeTestBean2 = ac.getBean(PrototypeTestBean.class);
        System.out.println("prototypeTestBean1 = " + prototypeTestBean1);
        System.out.println("prototypeTestBean2 = " + prototypeTestBean2);
        assertThat(prototypeTestBean1).isNotSameAs(prototypeTestBean2);
        ac.close();
    }

    @Scope("prototype")
    static class PrototypeTestBean{
        @PostConstruct
        public void init(){
            System.out.println("SingleTonBean.init");
        }

        @PreDestroy
        void destroy(){
            System.out.println("SingleTonBean.close");
        }
    }
}
