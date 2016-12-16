package com.lv.service.bo;

import java.util.List;

import com.lv.service.po.MessagePo;
import com.lv.service.vo.RequestParamsVo;

/**   
* @Title: TemplateBo.java 
* @Package com.momentcam.service.bo 
* @Description: TODO(用一句话描述该文件做什么) 
* @author jessonlv okstack@gmail.com   
* @date 24Oct.,2016 5:30:23 pm 
* @version V1.0   
*/

public interface TemplateBo {
	public List<MessagePo> getMessageList(RequestParamsVo vo);
}


