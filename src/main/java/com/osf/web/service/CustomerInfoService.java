package com.osf.web.service;

import java.util.List;
import java.util.Map;

public interface CustomerInfoService {

	public List<Map<String,String>> selectCustomerInfoList();
	public Map<String,String> selectCustomerInfo();
	public int insertCustomerInfo(Map<String,String> ci);
	public int updateCustomerInfo(Map<String,String> ci);
	public int deleteCustomerInfo(Map<String,String> ci);
}
