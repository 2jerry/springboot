package com.jay.demo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

@Service
public class LoggingRunner implements ApplicationRunner {

    private Logger logger = LoggerFactory.getLogger(LoggingRunner.class);

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.trace("TRACE 메세지");
        logger.debug("DEBUG 메세지");
        logger.info("INFO 메세지");
        logger.warn("WARN 메세지");
        logger.error("ERROR 메세지");
    }
}
