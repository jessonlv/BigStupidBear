package com.momentcam.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.io.UnsupportedEncodingException;

import static org.junit.Assert.fail;

/**
 * 测试用例基础类
 *
 *
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:**/spring-*.xml"})
public abstract class TestBase {
    /**
     * 模拟request，response
     */
    public MockHttpServletRequest request;
    public MockHttpServletResponse response;

    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("Set up before class");
    }

    @Before
    public void setUp(){
        System.out.println("---begin test---");
        request = new MockHttpServletRequest();
        request.setCharacterEncoding("UTF-8");
        response = new MockHttpServletResponse();
        setParam(request);
    }

    /**
     * 设置参数
     */
    public abstract void setParam(MockHttpServletRequest request);

    /**
     * checkResult
     * 检查结果
     * 添加断言
     * @param result
     */
    public abstract void checkResult(String result);

    @After
    public void tearDown(){
        String result = null;
        try {
            result = response.getContentAsString();
            System.out.println("Result:" + result);
            checkResult(result);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            System.out.println("Fail");
            fail();
        }
        System.out.println("---end test---");
    }

    @AfterClass
    public static void tearDownAfterClass() {
        System.out.println("Tear down After class");
    }

}
