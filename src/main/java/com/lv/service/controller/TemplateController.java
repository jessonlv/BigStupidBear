package com.lv.service.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.lv.service.bo.TemplateBo;
import com.lv.service.config.Config;
import com.lv.service.po.MessagePo;
import com.lv.service.utils.JsonUtil;
import com.lv.service.utils.StatusCode;
import com.lv.service.vo.RequestParamsVo;


/**
 * @Title: TemplateController
 * @Description: Template demo
 */

@Controller
@RequestMapping("url/url")
public class TemplateController {

	private static final Logger logger = Logger.getLogger(TemplateController.class);
	
	@Autowired
	private Config config; 
	
	@Autowired
	private TemplateBo bo;
	
	/**
	 *获取包含各种模板（动作）的列表
	 *1、type=1 通知
	 *2、系统通知中的非小魔的消息
	 * 通知(包含2和3中的非群发部分)  4 私聊
	 * 目前只用于用户的动态通知 Notificationtype 2:系统通知(优惠活动和活动推送除外)，3:动态通知,4:私聊
	 * 
	 **/
	@RequestMapping(value = "/getMessageList.do" , method = { RequestMethod.GET,RequestMethod.POST })
	public void getMessageList(HttpServletRequest request, HttpServletResponse response) {
		try {
			// 解决中文乱码问题，此步不可少
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			
			
			// 请求示例： http://localhost:8080/template/url/url/getMessageList.do?extend={page:1,rows:10,sender:88932,receiver:88892}
			
			// 获取参数  根据类型，决定获取的是动态通知还是系统通知
			// type 标识查询的为通知，notificationType 标识为查询的为通知类型 2 系统通知3 动态通知  4 私聊
			String extend = request.getParameter("extend");
			
			// 获取参数
			String sign = request.getParameter("sign");

			logger.info("sign:"+sign+",test key:" + config.getKey());
			
			// 校验参数
			/*if(extend == null || extend.length() == 0) {
				response.getWriter().write(config.getEmptyExtend());
				return;
			}
			if(sign != null && sign.length() != 0) {
				boolean result = MD5.checkSign(extend, sign);
				if(!result) {
					response.getWriter().write(config.getIncorrectSign());
					return;
				}
			}*/
			
//			logger.info("extend:"+extend + ",sign:"+sign);
			
			RequestParamsVo vo = JSON.parseObject(extend, RequestParamsVo.class);
			
			if(vo.getPage()==0){
				response.getWriter().write(config.getKey()); // demo
				return;
			}
			if(vo.getRows()==0){
				response.getWriter().write(config.getKey()); // demo
				return;
			}
			vo.setStartIndex(vo.getPage()); // set page index 

			
			List<MessagePo> list = bo.getMessageList(vo);
			
			String result = JsonUtil.toJsonString(list,StatusCode.SUCCESS.getCode());
			response.getWriter().write(result);
			
		} catch(Exception e) {
			e.printStackTrace();
			try {
				response.getWriter().write(config.getKey());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
