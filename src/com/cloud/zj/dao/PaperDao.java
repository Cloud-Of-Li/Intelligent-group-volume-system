package com.cloud.zj.dao;

import com.cloud.zj.generation.Paper;
import com.cloud.zj.generation.RuleBean;

public interface PaperDao extends BaseDao<Paper> {

	void savePaper(Paper resultPaper, RuleBean rule);

	Paper findPaperByPaperName(String paperName);

	int getExamNumByCourseIdAndKind(Integer courseId, String string);
	
}
