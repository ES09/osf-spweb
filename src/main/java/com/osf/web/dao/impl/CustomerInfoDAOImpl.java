package com.osf.web.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.osf.web.dao.CustomerInfoDAO;

@Repository
public class CustomerInfoDAOImpl implements CustomerInfoDAO {

	@Autowired
	private SqlSession ss;
	
	@Override
	public List<Map<String, String>> selectCustomerInfoList() {
		return ss.selectList("customer.selectCustomerInfoList");
	}

	@Override
	public Map<String, String> selectCustomerInfo() {
		return ss.selectOne("customer.selectCustomerInfo");
	}

	@Override
	public int insertCustomerInfo(Map<String,String> ci) {
		return ss.selectOne("customer.insertCustomerInfo");
	}

	@Override
	public int updateCustomerInfo(Map<String,String> ci) {
		return ss.selectOne("customer.updateCustomerInfo");
	}

	@Override
	public int deleteCustomerInfo(Map<String,String> ci) {
		return ss.selectOne("customer.deleteCustomerInfo");
	}

}
