package com.lv.service.po;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**   
 * @Title: MessagePo.java 
 * @Package com.manboker.service.po 
 * @author 吕国栋  JessonLv mail:okstack@gmail.com   
 * @date 2015年6月18日 下午3:56:06 
 * @Description: TODO 消息实体
 * @version V1.0   
 */

public class MessagePo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BigInteger id;
	private String messageID; // 消息ID  对应ONS中的key
	private int messageType;  // 1 正常消息 2 转接命令
	private String sender;
	private String receiver;
	private String sessionId; // 会话ID
	
	@JSONField(serialize=false)
	private int status = 0;   // -1 发送异常 1 已读 2 未读
	private Date createTime;
	private String content;
	private int contentType;  // 消息内容类型1 纯文 2 纯图 3 GIF 4 音频 5 图文混排 
	private String extend;
	public BigInteger getId() {
		return id;
	}
	public void setId(BigInteger id) {
		this.id = id;
	}

	public String getMessageID() {
		return messageID;
	}
	public void setMessageID(String messageID) {
		this.messageID = messageID;
	}
	public int getMessageType() {
		return messageType;
	}
	public void setMessageType(int messageType) {
		this.messageType = messageType;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getContentType() {
		return contentType;
	}
	public void setContentType(int contentType) {
		this.contentType = contentType;
	}
	public String getExtend() {
		return extend;
	}
	public void setExtend(String extend) {
		this.extend = extend;
	}
}


