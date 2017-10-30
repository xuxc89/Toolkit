package main.java.com.xuxc.logTest;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by xuxc
 * since  2017/10/20 11:55.
 * version 1
 */

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@Slf4j
public class logtest {
    @Value("${blog.value}")
    private String value;
    @Test
    public void testLog() {
        log.info(value);
        log.debug("testDebug");
        log.error("testError");
        log.info("testIngo");
        log.warn("testWarn");
        log.trace("testTrace");
    }
}
