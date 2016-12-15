package com.neusoft.norm;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * 作者: 张明楠 创建于 16/9/14.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ExecutionOrderTest {
    @Test
    public void testB() {

        assertThat(1 +  1, is(2));

    }

    @Test
    public void test1() {

        assertThat(1 + 1, is(2));

    }

    @Test
    public void testA() {

        assertThat(1 + 1, is(2));

    }

    @Test
    public void test2() {

        assertThat(1 + 1, is(2));

    }

    @Test
    public void testC() {

        assertThat(1 + 1, is(2));

    }
}
