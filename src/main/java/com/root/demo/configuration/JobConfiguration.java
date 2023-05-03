package com.root.demo.configuration;

import com.root.demo.service.impl.CartServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class JobConfiguration {
    private static final Logger LOGGER = LoggerFactory.getLogger(JobConfiguration.class);

    private CartServiceImpl cartServiceImpl;

    public JobConfiguration(CartServiceImpl cartServiceImpl) {
        this.cartServiceImpl = cartServiceImpl;
    }

    //    @Scheduled(fixedDelay = 1000 * 60 * 4)
    @Scheduled(fixedDelay = 1000 * 60 * 10)
    public void scheduleExpiredCart() {
        LOGGER.info("Scheduler Task Cart Clean Expired");
        cartServiceImpl.cleanExpired();
    }
}
