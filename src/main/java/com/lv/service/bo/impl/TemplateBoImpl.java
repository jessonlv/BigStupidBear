package com.lv.service.bo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lv.service.bo.TemplateBo;
import com.lv.service.dao.TemplateDao;
import com.lv.service.po.MessagePo;
import com.lv.service.vo.RequestParamsVo;

/**   
* @Title: TemplateBoImpl.java 
* @Package com.momentcam.service.bo.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author jessonlv okstack@gmail.com   
* @date 24Oct.,2016 5:31:39 pm 
* @version V1.0   
*/

@Service
public class TemplateBoImpl implements TemplateBo {

	@Autowired
	private TemplateDao dao;
	
	public List<MessagePo> getMessageList(RequestParamsVo vo) {
		return dao.getMessageList(vo);
	}

}


