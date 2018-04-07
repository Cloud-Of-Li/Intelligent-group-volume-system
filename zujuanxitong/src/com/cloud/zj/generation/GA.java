package com.cloud.zj.generation;

import java.util.List;

import com.cloud.zj.entity.Exam;
import com.cloud.zj.service.QuestionService;

/**
 * 遗传算法智能组卷实现类
 * 
 * @author: cloud
 * @CreateDate: 2018-4-7
 * @version: 1.0
 */

public class GA {
	/**
	 * 变异概率
	 */
	private static final double mutationRate = 0.085;
	/**
	 * 精英主义
	 */
	private static final boolean elitism = true;
	/**
	 * 淘汰数组大小
	 */
	private static final int tournamentSize = 5;

	// 进化种群
	public static Population evolvePopulation(int courseId, Population pop, RuleBean rule) {
		Population newPopulation = new Population(pop.getLength());
		int elitismOffset;
		// 精英主义
		if (elitism) {
			elitismOffset = 1;
			// 保留上一代最优秀个体
			Paper fitness = pop.getFitness();
			fitness.setId(0);
			newPopulation.setPaper(0, fitness);
		}
		// 种群交叉操作，从当前的种群pop来创建下一代种群newPopulation
		for (int i = elitismOffset; i < newPopulation.getLength(); i++) {
			// 较优选择parent
			Paper parent1 = select(pop);
			Paper parent2 = select(pop);
			while (parent2.getId() == parent1.getId()) {
				parent2 = select(pop);
			}
			// 交叉
			Paper child = crossover(courseId, parent1, parent2, rule);
			child.setId(i);
			newPopulation.setPaper(i, child);
		}
		// 种群变异操作
		Paper tmpPaper;
		for (int i = elitismOffset; i < newPopulation.getLength(); i++) {
			tmpPaper = newPopulation.getPaper(i);
			mutate(tmpPaper);
			// 计算适应度
			tmpPaper.setAdaptationDegree(rule, Global.KP_WEIGHT, Global.DIFFCULTY_WEIGHt);
		}
		return newPopulation;
	}

	/**
	 * 交叉算子
	 *
	 * @param parent1
	 * @param parent2
	 * @return
	 */
	public static Paper crossover(int courseId, Paper parent1, Paper parent2, RuleBean rule) {
		Paper child = new Paper(parent1.getQuestionSize());
		int s1 = (int) (Math.random() * parent1.getQuestionSize());
		int s2 = (int) (Math.random() * parent1.getQuestionSize());

		// parent1的startPos endPos之间的序列，会被遗传到下一代
		int startPos = s1 < s2 ? s1 : s2;
		int endPos = s1 > s2 ? s1 : s2;
		for (int i = startPos; i < endPos; i++) {
			child.saveQuestion(i, parent1.getQuestion(i));
		}

		// 继承parent2中未被child继承的question
		// 防止出现重复的元素
		for (int i = 0; i < startPos; i++) {
			if (!child.containsQuestion(parent2.getQuestion(i))) {
				child.saveQuestion(i, parent2.getQuestion(i));
			} else {
				String type = getTypeByIndex(i, rule);
				// getQuestionArray()用来选择指定类型的试题数组
				Exam[] singleArray = QuestionService.getQuestionArray(courseId, type);
				child.saveQuestion(i, singleArray[(int) (Math.random() * singleArray.length)]);
			}
		}
		for (int i = endPos; i < parent2.getQuestionSize(); i++) {
			if (!child.containsQuestion(parent2.getQuestion(i))) {
				child.saveQuestion(i, parent2.getQuestion(i));
			} else {
				String type = getTypeByIndex(i, rule);
				Exam[] singleArray = QuestionService.getQuestionArray(courseId, type);
				child.saveQuestion(i, singleArray[(int) (Math.random() * singleArray.length)]);
			}
		}

		return child;
	}

	private static String getTypeByIndex(int index, RuleBean rule) {
		String type = "";
		// 单选
		if (index < rule.getSingleNum()) {
			type = "单选题";
		} else if (index < rule.getSingleNum() + rule.getMultiNum()) {
			// 多选
			type = "多选题";
		} else if (index < rule.getSingleNum() + rule.getMultiNum() + rule.getCompleteNum()) {
			//填空
			type = "填空题";
		} else if (index < rule.getSingleNum() + rule.getMultiNum() + rule.getCompleteNum()
					+ rule.getTfNum()) {
			// 判断
			type = "判断题";
		} else {
			// 主观
			type = "简答题";
		}
		return type;
	}

	/**
	 * 突变算子 每个个体的每个基因都有可能突变
	 *
	 * @param paper
	 */
	public static void mutate(Paper paper) {
		Exam tmpQuestion;
		List<Exam> list;
		int index;
		for (int i = 0; i < paper.getQuestionSize(); i++) {
			if (Math.random() < mutationRate) {
				// 进行突变，第i道
				tmpQuestion = paper.getQuestion(i);
				// 从题库中获取和变异的题目类型一样分数相同的题目（不包含变异题目）
				list = QuestionService.getQuestionListWithOutSId(paper.getCourseId(), tmpQuestion);
				if (list.size() > 0) {
					// 随机获取一道
					index = (int) (Math.random() * list.size());
					// 设置分数
					list.get(index).setExamScore(tmpQuestion.getExamScore());
					paper.saveQuestion(i, list.get(index));
				}
			}
		}
	}

	/**
	 * 选择算子
	 *
	 * @param population
	 */
	private static Paper select(Population population) {
		Population pop = new Population(tournamentSize);
		for (int i = 0; i < tournamentSize; i++) {
			pop.setPaper(i, population.getPaper((int) (Math.random() * population.getLength())));
		}
		return pop.getFitness();
	}

}
