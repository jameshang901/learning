package com.jh.sl.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class CommonUtilsTest {

    @Test
    public void testEncodeBase64() {
        String token = CommonUtils.load("/token.data");
        String[] ss = token.split("\\.");
        log.info(CommonUtils.decodeBase64(ss[0]));
        log.info(CommonUtils.decodeBase64(ss[1]));
        log.info(ss[2]);
    }

}
