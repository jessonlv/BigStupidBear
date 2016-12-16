package com.lv.service.dao;

import com.lv.service.po.MessagePo;
import com.lv.service.vo.RequestParamsVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**   
* @Title: TemplateDao.java 
* @Package com.momentcam.service.dao 
* @Description: TODO(用一句话描述该文件做什么) 
* @author jessonlv okstack@gmail.com   
* @date 24Oct.,2016 5:33:05 pm 
* @version V1.0   
*/

@Repository
public interface TemplateDao {
	public List<MessagePo> getMessageList(RequestParamsVo vo);
}


