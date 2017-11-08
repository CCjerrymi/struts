package com.service;

import java.util.List;
import com.dao.GradeDao;
import com.entity.Grade;
import com.tool.BeanTool;

public class GradeManagerService implements IGradeManagerService {
	private GradeDao gradeDao;
	
	@Override
	public List<Grade> getAllGradeInfo() {
		gradeDao = (GradeDao)BeanTool.getBean("gradeDao");
		List<Grade> list = gradeDao.getAllGeade();
		return list;
	}
}
