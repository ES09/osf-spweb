package com.osf.web.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.osf.web.dao.AddrDAO;

@Repository
public class AddrDAOImpl implements AddrDAO {

	@Autowired
	private SqlSession ss;
	
	@RequestMapping(value="addr/list", method=RequestMethod.GET)
	public List<Map<String, String>> selectAddrList() {
		Map<String,String> param = new HashMap<String,String>();
		param.put("adNum", "20");
		param.put("adSido", "부산광역시");
		return ss.selectList("addr.selectAddrList",param);
	}
}
