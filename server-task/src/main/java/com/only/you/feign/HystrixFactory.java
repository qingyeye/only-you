package com.only.you.feign;
import com.only.you.entity.User;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class HystrixFactory implements FallbackFactory<HTKServerCilent> {

    static final Logger Error =  LoggerFactory.getLogger(HystrixFactory.class);
    @Override
    public HTKServerCilent create(Throwable throwable) {
        Error.info("fallback; reason was: {}", throwable.getMessage());

        return new UserFeignClientWithFactory(){

            @Override
            public User findById(Long id) {

                User user = new User();
                user.setUserId("-1");

                return user;
            }
        };
    }
}
