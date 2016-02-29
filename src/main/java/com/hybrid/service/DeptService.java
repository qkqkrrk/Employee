package com.hybrid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hybrid.mapper.DeptMapper;
import com.hybrid.model.Dept;

@Service
public class DeptService {
	//필드주입
	@Autowired
	DeptMapper deptMapper;
	
	@Transactional
	public List<Dept> getlist(){
		
		List<Dept> depts = deptMapper.selectAll();
		
		return depts;
	}
	@Transactional
	public Dept getDept(Integer deptno){
		return deptMapper.selectByDeptno(deptno);
	}
	
	@Transactional
	public void insert(Dept dept){
		deptMapper.insert(dept);
	}
}
