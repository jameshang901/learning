package com.jh.dp;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

@Slf4j
public class AppTest {

    @Test
    public void testPing() {
        App app = new App();
        Assert.assertTrue(app.ping());
    }

}
