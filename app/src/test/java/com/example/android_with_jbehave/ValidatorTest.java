package com.example.android_with_jbehave;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class ValidatorTest {

    @Test
    public void junitTestStyle() {

        assertTrue(false);
    }

    @Test
    public void assertjTestStyle() {
        Assertions.assertThat(333).isEqualTo(333);
    }

}