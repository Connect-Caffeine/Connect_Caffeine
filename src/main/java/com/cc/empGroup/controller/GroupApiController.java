package com.cc.empGroup.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.multipart.MultipartFile;

import com.cc.empGroup.domain.EmpGroupDto;
import com.cc.empGroup.service.EmpGroupService;

@Controller
public class GroupApiController {
	private EmpGroupService empGroupService;
	
	@Autowired
	public GroupApiController(EmpGroupService empGroupService) {
		this.empGroupService = empGroupService;
	}
	
	// 등록
		@ResponseBody
		@PostMapping("/empGroup")
		public Map<String, String> createGroup(EmpGroupDto dto){
			Map<String, String> resultMap = new HashMap<String, String>();
			resultMap.put("res_code", "404");
			resultMap.put("res_msg", "그룹 정보 등록 중 오류가 발생하였습니다.");
			
			if(empGroupService.createGroup(dto) != null) {
				resultMap.put("res_code", "200");
				resultMap.put("res_msg", "그룹 정보가 성공적으로 등록되었습니다.");
			}
			return resultMap;
		}
}
