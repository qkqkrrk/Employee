package com.hybrid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.hybrid.model.Dept;

public class MyBatisTest {
	static Log log = LogFactory.getLog(MyBatisTest.class);
	
	public static void main(String[] args) throws SQLException {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/mybatis.xml");
		
		SqlSessionTemplate sqlSession = ctx.getBean(SqlSessionTemplate.class);
		
		List<Dept> depts = sqlSession.selectList("com.hybrid.mapper.DeptMapper.selectAll");
		
		for (Dept d : depts) {
			log.info(d.getDeptno() + " " + d.getDname() + " " + d.getLoc());
		}
	}
	
	static void test1() throws SQLException{
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/mybatis.xml");
		
		DriverManagerDataSource ds = ctx.getBean(DriverManagerDataSource.class);
		
		log.info(ds.getUrl());
		log.info(ds.getUsername());
		log.info(ds.getPassword());
		
		Connection con =  ds.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from dept");
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()){
			log.info(rs.getString("deptno") + " " + rs.getString("dname"));
		}
		
		rs.close();
		ps.clearParameters();
		con.close();
		ctx.close();
		
		
		
	}
}
