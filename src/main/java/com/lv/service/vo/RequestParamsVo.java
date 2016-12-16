package com.lv.service.vo;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.JSON;

/**
 * @Title: NotificationVo.java
 * @Package com.manboker.service.po
 * @author 吕国栋 JessonLv mail:okstack@gmail.com
 * @date 2015年12月8日 下午1:11:30
 * @Description: TODO 此Vo作为通用性VO存在
 * @version V1.0
 */

public class RequestParamsVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private int type;
	
	private int id;
	private String sessionId;
	private String userId; // 主要用于客服未读消息的查询
	private Date time; // 时间  查询服务器的当前时间
	private String language;
	
	// added 20151228 用于根据类型查询通知
	private int notificationType; //2:系统通知(优惠活动和活动推送除外)，3:动态通知,4:私聊
	
	// the page number
	private int page;

	// the data rows in one page
	private int rows;

	// start index in mysql
	private int startIndex;

	// 添加于20160517
	private int actionType;// 1 物流消息 2中奖通知 3私聊 4 被赞 5 被评论 6 谁成了你的粉丝　７客服消息　８优惠活动　９　活动推送
	private int receiver; //　接收者
	private int sender; // 发送者
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getStartIndex() {
		return startIndex;
	}

	// count the start index in mysql
	// the param startIndex is useless
	public void setStartIndex(int page) {

		if (this.page == 1) {
			startIndex = 0;
		} else {
			startIndex = (page - 1) * this.rows;
		}
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(int notificationType) {
		this.notificationType = notificationType;
	}
	
	public int getActionType() {
		return actionType;
	}

	public void setActionType(int actionType) {
		this.actionType = actionType;
	}
	public int getReceiver() {
		return receiver;
	}

	public void setReceiver(int receiver) {
		this.receiver = receiver;
	}
	public int getSender() {
		return sender;
	}

	public void setSender(int sender) {
		this.sender = sender;
	}

	public static void main(String args[]){
		RequestParamsVo vo = new RequestParamsVo();
		vo.setPage(2);
		
		vo.setRows(20);
		vo.setType(1);
		vo.setStartIndex(2);
		
		String str = JSON.toJSONString(vo);
		System.out.println(str);
	}
	
}
