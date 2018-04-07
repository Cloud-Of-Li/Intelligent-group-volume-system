package com.cloud.zj.generation;

import java.util.Random;

import com.cloud.zj.entity.Exam;
import com.cloud.zj.service.QuestionService;

/**
 * 种群，即多套试卷
 *
 * @author: cloud
 * @CreateDate: 2017-4-7
 * @version: 1.0
 */
public class Population {
    /**
     * 试卷集合
     */
    private Paper[] papers;

    /**
     * 初始种群
     *
     * @param populationSize 种群规模
     * @param initFlag       初始化标志 true-初始化
     * @param rule           规则bean
     */
    public Population(int courseId, int populationSize, boolean initFlag, RuleBean rule) {
        papers = new Paper[populationSize];
        if (initFlag) {
            Paper paper;
            Random random = new Random();
            for (int i = 0; i < populationSize; i++) {
                paper = new Paper();
                paper.setId(i + 1);
                paper.setCourseId(courseId);
                while (paper.getTotalScore() != rule.getTotalMark()) {
                    paper.getQuestionList().clear();
                    // 单选题
                    if (rule.getSingleNum() > 0) {
                        generateQuestion(courseId, "单选题", random, rule.getSingleNum(), rule.getSingleScore(),
                                "单选题数量不够，组卷失败", paper);
                    }
                    // 多选题
                    if (rule.getSingleNum() > 0) {
                        generateQuestion(courseId, "多选题", random, rule.getSingleNum(), rule.getSingleScore(),
                                "多选题数量不够，组卷失败", paper);
                    }
                    // 填空题
                    if (rule.getCompleteNum() > 0) {
                        generateQuestion(courseId, "填空题", random, rule.getCompleteNum(), rule.getCompleteScore(),
                                "填空题数量不够，组卷失败", paper);
                    }
                    // 判断题
                    if (rule.getSubjectiveNum() > 0) {
                        generateQuestion(courseId, "判断题", random, rule.getSubjectiveNum(), rule.getSubjectiveScore(),
                                "判断题数量不够，组卷失败", paper);
                    }
                    // 简答题
                    if (rule.getSubjectiveNum() > 0) {
                        generateQuestion(courseId, "简答题", random, rule.getSubjectiveNum(), rule.getSubjectiveScore(),
                                "判断题数量不够，组卷失败", paper);
                    }
                }
                // 计算试卷适应度
                paper.setAdaptationDegree(rule, Global.KP_WEIGHT, Global.DIFFCULTY_WEIGHt);
                papers[i] = paper;
            }
        }
    }

    private void generateQuestion(int courseId, String type, Random random, int qustionNum, double score,
                                  String errorMsg, Paper paper) {
        Exam[] singleArray = QuestionService.getQuestionArray(courseId,type);
        if (singleArray.length < qustionNum) {
            return;
        }
        Exam tmpQuestion;
        for (int j = 0; j < qustionNum; j++) {
            int index = random.nextInt(singleArray.length - j);
            // 初始化分数
            singleArray[index].setExamScore(score);
            paper.addQuestion(singleArray[index]);
            // 保证不会重复添加试题
            tmpQuestion = singleArray[singleArray.length - j - 1];
            singleArray[singleArray.length - j - 1] = singleArray[index];
            singleArray[index] = tmpQuestion;
        }
    }

    /**
     * 获取种群中最优秀个体
     *
     * @return
     */
    public Paper getFitness() {
        Paper paper = papers[0];
        for (int i = 1; i < papers.length; i++) {
            if (paper.getAdaptationDegree() < papers[i].getAdaptationDegree()) {
                paper = papers[i];
            }
        }
        return paper;
    }

    public Population(int populationSize) {
        papers = new Paper[populationSize];
    }

    /**
     * 获取种群中某个个体
     *
     * @param index
     * @return
     */
    public Paper getPaper(int index) {
        return papers[index];
    }

    /**
     * 设置种群中某个个体
     *
     * @param index
     * @param paper
     */
    public void setPaper(int index, Paper paper) {
        papers[index] = paper;
    }

    /**
     * 返回种群规模
     *
     * @return
     */
    public int getLength() {
        return papers.length;
    }

}