package com.prottonne.util;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.jupiter.api.Test;

class HttpUtilTest {

    @Test
    void testMock() {
        Boolean myResult = Boolean.TRUE;
        assertThat(myResult,
                is(
                        true
                ));
    }

}
