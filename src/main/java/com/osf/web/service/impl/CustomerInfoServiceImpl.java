package com.osf.web.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.osf.web.dao.CustomerInfoDAO;
import com.osf.web.service.CustomerInfoService;

@Service
public class CustomerInfoServiceImpl implements CustomerInfoService {

	@Autowired
	private CustomerInfoDAO cidao;
	
	@Override
	public List<Map<String, String>> selectCustomerInfoList() {
		return cidao.selectCustomerInfoList();
	}

	@Override
	public Map<String, String> selectCustomerInfo() {
		return cidao.selectCustomerInfo();
	}

	@Override
	public int insertCustomerInfo(Map<String, String> ci) {
		return cidao.insertCustomerInfo(ci);
	}

	@Override
	public int updateCustomerInfo(Map<String, String> ci) {
		return cidao.updateCustomerInfo(ci);
	}

	@Override
	public int deleteCustomerInfo(Map<String, String> ci) {
		return cidao.deleteCustomerInfo(ci);
	}

}
