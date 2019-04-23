package com.osf.web.controller;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Exam {
	
	public String str;
	/*
	 * log4j level 순서 - 외우기
	 * 1. TRACE - 아주 상세한 정보
	 * 2. DEBUG - 개발 시 필요한 정보
	 * 3. INFO - just info
	 * 4. WARN - 원인 - 경고 warnning
	 * 5. ERROR - 
	 * 6. FATAL	- 아주 심각한 에러
	 */	
	
	public static void main(String[] args) {
		String str = null;
		if("abc".equals(str)) {
			log.info("이름이 같습니다.");
		} else {
			log.info("이름이 다릅니다.");
		}
		log.warn("프로그램 비정상 종료, 문제는 없음");
	}
}
