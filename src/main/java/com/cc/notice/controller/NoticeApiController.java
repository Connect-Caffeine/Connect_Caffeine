package com.cc.notice.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cc.notice.domain.NoticeDto;
import com.cc.notice.service.NoticeService;
import com.cc.notification.service.NotificationService;

@Controller
public class NoticeApiController {

	private final NoticeService noticeService;
	private final NotificationService notificationService;

	@Autowired
	public NoticeApiController(NoticeService noticeService,NotificationService notificationService) {
		this.noticeService = noticeService;
		this.notificationService = notificationService;
	}

	@ResponseBody
	@PostMapping("/noticeCreate")
	public Map<String, String> createNotice(NoticeDto dto) throws Exception {
		System.out.println(dto);
		Map<String, String> resultMap = new HashMap<String, String>();
		resultMap.put("res_code", "404");
		resultMap.put("res_msg", "공지사항 등록중 오류가 발생했습니다.");

		if(noticeService.createNotice(dto) != null) {
			resultMap.put("res_code", "200");
			resultMap.put("res_msg", "공지사항이 성공적으로 등록되었습니다.");
			String message = "[공지사항] " + dto.getNotice_title() + "이(가) 등록되었습니다.";
			notificationService.sendNoticeNotification(message);
		}
		
		return resultMap;
	}
	
	@ResponseBody
	@PostMapping("/noticeUpdate/{notice_no}")
	public Map<String, String> updateNotice(NoticeDto dto){
		Map<String, String> resultMap = new HashMap<String, String>();
		resultMap.put("res_code", "404");
		resultMap.put("res_msg", "공지사항 수정중 오류가 발생했습니다.");
		if(noticeService.updateNotice(dto) != null) {
			resultMap.put("res_code", "200");
			resultMap.put("res_msg", "공지사항이 성공적으로 수정되었습니다.");
		}
		return resultMap;
	}
	
	@ResponseBody
	@PostMapping("/noticeDelete/{notice_no}")
	public Map<String, String> deleteNotice(@PathVariable("notice_no") Long notice_no){
		Map<String, String> resultMap = new HashMap<String, String>();
		
		resultMap.put("res_code", "404");
		resultMap.put("res_msg", "공지사항 삭제중 오류가 발생했습니다.");
		System.out.println(notice_no);
		if(noticeService.deleteNotice(notice_no) != null) {
			resultMap.put("res_code", "200");
			resultMap.put("res_msg", "정상적으로 공지사항이 삭제되었습니다.");
		}
		
		return resultMap;
	}
}
