package com.neusoft.norm;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import java.util.ArrayList;

import static junit.framework.TestCase.fail;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
/**
 * 作者: 张明楠 创建于 16/9/14.
 */


@RunWith(Suite.class)
@Suite.SuiteClasses(RoleTest.class)
public class AdminTest {
    @Test
    public void testDivisionWithException() {
        try {
            int i = 1 / 0;
            fail(); //加在期望中不可能到达的地方，一旦到达，表明测试失败，结果与预期不同。
        } catch (ArithmeticException e) {
            assertThat(e.getMessage(), is("/ by zero"));
            //assert others
        }
    }

    @Test
    public void testEmptyList() {
        try {
            new ArrayList<>().get(0);
            fail();
        } catch (IndexOutOfBoundsException e) {
            assertThat(e.getMessage(), is("Index: 0, Size: 0"));
        }
    }

    @Ignore("忽略此单元测试!")
    @Test
    public  void ignore(){

    }


    /**
     * 执行超时测试
     */
    @Test(timeout = 1000)
    public void infinity() {
        while (true) ;
    }

}
