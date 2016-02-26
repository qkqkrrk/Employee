package com.hybrid.mapper;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.hybrid.model.Dept;

public class DeptMapperTest {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/beans_db.xml");
		
		DeptMapper mapper = ctx.getBean(DeptMapper.class);
		
		List<Dept> depts = mapper.selectAll();
		
		for (Dept dept : depts) {
			System.out.println(dept.getDeptno()+" "+dept.getDname()+" "+dept.getLoc());
		}
		
		ctx.close();
	}
	
	void test1(){
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/beans_db.xml");
		//SqlSessionTemplate sqlSession = ctx.getBean(SqlSessionTemplate.class);
		SqlSessionTemplate sqlSession = (SqlSessionTemplate) ctx.getBean("sqlSessionTemplate");
		DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
		
		List<Dept> depts = deptMapper.selectAll();
		
		for (Dept dept : depts) {
			System.out.println(dept.getDeptno()+dept.getDname()+dept.getLoc());
		}
		
		ctx.close();
	}

}

