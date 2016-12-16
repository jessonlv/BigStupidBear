package com.momentcam.test.template;

import com.lv.service.controller.TemplateController;
import com.lv.service.po.MessagePo;
import com.lv.service.utils.JsonUtil;
import com.lv.service.vo.RequestParamsVo;
import com.momentcam.test.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * 测试用例
 *常用断言方法
 assertEquals("失败提示信息","期望数据","测试数据")   断言获取数据是否与所期望的相等
 assertNotNull("失败提示信息","测试数据")     断言获取数据不为null，否则提示错误
 assertNull("失败提示信息","测试数据")    断言获取数据是为null，否则提示错误
 assertTrue("失败提示信息",测试数据blooean值)      断言获取数据是否为ture，否则提示错误
 fail("失败提示信息");    此方法一般放到异常处，遇到此方法，测试将停止!
 assertSame("失败提示信息","期望数据","测试数据")     断言获取数据是否与所期望的相同
 *
 */

public class TemplateTest extends TestBase {

    @Autowired
    private TemplateController templateController;

    @Test
    public void test() {
        templateController.getMessageList(request,response);
    }

    public void setParam(MockHttpServletRequest request) {
        RequestParamsVo paramsVo = new RequestParamsVo();
        paramsVo.setType(1);
        paramsVo.setId(1);
        paramsVo.setLanguage("zh");
        paramsVo.setActionType(1);

        request.setParameter("extend",JsonUtil.toString(paramsVo));
        request.setParameter("sign","101");
    }

    public void checkResult(String result) {
        /**
         * result is not null
         */
        assertNotNull(result);

        assertEquals("test_value",result);

//        TemplatePo po = JsonUtil.toObject(result,TemplatePo.class);

//        assertEquals(0,po.getCode());

    }

    public class TemplatePo{
        private long CurrentTime;

        private int Code;

        private int Total;

        private List<MessagePo> Rows;

        public long getCurrentTime() {
            return CurrentTime;
        }

        public void setCurrentTime(long currentTime) {
            CurrentTime = currentTime;
        }

        public int getCode() {
            return Code;
        }

        public void setCode(int code) {
            Code = code;
        }

        public int getTotal() {
            return Total;
        }

        public void setTotal(int total) {
            Total = total;
        }

        public List<MessagePo> getRows() {
            return Rows;
        }

        public void setRows(List<MessagePo> rows) {
            Rows = rows;
        }
    }

}
