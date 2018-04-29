package com.cloud.zj.dao;

import java.util.List;

import com.cloud.zj.generation.Paper;
import com.cloud.zj.generation.RuleBean;

public interface PaperDao{

	void savePaper(Paper resultPaper, RuleBean rule);

	Paper findPaperByPaperName(String paperName);

	int getExamNumByCourseIdAndKind(Integer courseId, String string);

	List<Paper> findAllpapers();
	
}
