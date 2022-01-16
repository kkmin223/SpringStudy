package kkmin223.hellospring;

import kkmin223.hellospring.aop.TimeTraceAop;
import kkmin223.hellospring.repository.*;
import kkmin223.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){

        return new MemberService(memberRepository);
    }


//    @Bean
//    public MemberRepository memberRepositry() {
//        //return new JpaMemberRepository(em);
//    }

}
