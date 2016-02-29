package com.hybrid.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hybrid.model.Dept;
import com.hybrid.service.DeptService;

@Controller
public class DeptController {
	static Log log = LogFactory.getLog(DeptController.class);
	
	@Autowired
	DeptService deptService;
	
	@RequestMapping(value="/dept/list")
	@ResponseBody
	public List<Dept> getList() {
		return deptService.getlist();
	}
	@RequestMapping(value="/dept", method=RequestMethod.GET)
	@ResponseBody
	public Dept getDept(Integer deptno){
		log.info("getdept"+deptno);
		return deptService.getDept(deptno);
	}
	@RequestMapping(value="/dept", method=RequestMethod.POST)
	@ResponseBody
	public Dept postDept(Dept dept){
		log.info("deptno = " + dept.getDeptno());
		log.info("dname = " + dept.getDname());
		log.info("loc = " + dept.getLoc());
		
		deptService.insert(dept);
		
		return dept;
	}
}
