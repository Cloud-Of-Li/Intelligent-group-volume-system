package com.cloud.zj.service;

import com.cloud.zj.dao.PaperDao;
import com.cloud.zj.dao.imp.PaperDaoImp;
import com.cloud.zj.generation.GA;
import com.cloud.zj.generation.Paper;
import com.cloud.zj.generation.Population;
import com.cloud.zj.generation.RuleBean;

public class CreatePaperService {
	private PaperDao paperDao;
	
	

	public CreatePaperService() {
		// TODO Auto-generated constructor stub
		paperDao = new PaperDaoImp();
	}

	public Paper createPaper(int courseId, RuleBean rule) {
		// TODO Auto-generated method stub
		int count = 0;
		int runCount = 3;
		double expand = 0.98;
		Paper resultPaper = null;
		if (rule != null) {
			// 初始化种群
			Population population = new Population(courseId, 20, true, rule);
			System.out.println("初次适应度  " + population.getFitness().getAdaptationDegree());
			while (count < runCount && population.getFitness().getAdaptationDegree() < expand) {
				count++;
				population = GA.evolvePopulation(courseId, population, rule);
				System.out.println("第 " + count + " 次进化，适应度为： " + population.getFitness().getAdaptationDegree());
			}
			System.out.println("进化次数： " + count);
			System.out.println(population.getFitness().getAdaptationDegree());
			resultPaper = population.getFitness();
		}
		System.out.println(resultPaper);
		resultPaper.setCourseId(courseId);
		resultPaper.setTotalScore(rule.getTotalMark());
		return resultPaper;
	}

	public void addPaper(Paper resultPaper, RuleBean rule) {
		paperDao.savePaper(resultPaper, rule);
	}

}
