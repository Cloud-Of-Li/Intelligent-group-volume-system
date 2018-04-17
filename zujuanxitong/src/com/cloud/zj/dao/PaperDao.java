package com.cloud.zj.dao;

import com.cloud.zj.generation.Paper;
import com.cloud.zj.generation.RuleBean;

public interface PaperDao {

	void savePaper(Paper resultPaper, RuleBean rule);

	Paper findPaperByPaperName(String paperName);
	
}
