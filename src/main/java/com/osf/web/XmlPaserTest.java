package com.osf.web;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.dbcp.BasicDataSource;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlPaserTest {
	
	public static void main(String[] args) {
		String path = "D:\\study\\새 폴더\\osf-spweb\\src\\main\\resources\\spring\\application-config.xml";
		File f = new File(path);
		DocumentBuilderFactory dBuildFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder dBuilder = dBuildFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(f); // document(브라우저에서 사용)의 기반 dom - xml이 태그기반이므로 다 가져온다.
			Element root = doc.getDocumentElement();
			NodeList nodes = root.getElementsByTagName("bean");
			for(int i=0;i<nodes.getLength();i++) {
				Element bean = (Element)nodes.item(i);
				String id = bean.getAttribute("id");
				String className = bean.getAttribute("class");
				if("ds".equals(id)) { // 가져와서 메모리 생성하기
					Class<?> clazz = Class.forName(className);
					Method[] methods = clazz.getDeclaredMethods(); // 이 클래스에서만 선언된 메소드
					Object obj = clazz.newInstance();
					NodeList props = bean.getElementsByTagName("property");
					for(int j=0;j<props.getLength();j++) {
						Element prop = (Element)props.item(j);
						String methodName = prop.getAttribute("name");
						String value = prop.getAttribute("value");
						String fStr = methodName.substring(0,1);
						methodName = "set" + fStr.toUpperCase() + methodName.substring(1); //메소드명 정하기
						for(Method method:methods) {
							if(methodName.equals(method.getName())) {
								method.invoke(obj, value);
							}
						}						
					}
					BasicDataSource bds = (BasicDataSource)obj;
					Connection con = bds.getConnection();
					System.out.println(con);
				}
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
