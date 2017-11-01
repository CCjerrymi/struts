package com.service;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Service;

import com.entity.Student;
import com.tool.FileTool;


@Service
public class LoadServiceImpl implements LoadService {

	
	public void upload(File file) {
		List<Student> list = FileTool.analysisFile(file);
	}

}
