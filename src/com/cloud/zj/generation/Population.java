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
            
            String[] partenstr = rule.getPartens().split("_");
            String[] partenScorestr = rule.getPartenScores().split("_");
            String[] partenCountstr = rule.getPartenCounts().split("_");
            
            for(int i = 0; i < partenstr.length; i++ ) {
            	System.out.print("题型：" + partenstr[i] +" ");
            }
            System.out.println();
            
            int[] numbers = new int[partenCountstr.length];
            for(int i = 0; i < numbers.length; i++ ) {
            	numbers[i] = Integer.parseInt(partenCountstr[i]);
            	System.out.print("试题数量" + numbers[i] +" ");
            	
            }
            System.out.print("总数量" + numbers.length +" ");
            System.out.println();
            
            int[] scores = new int[partenScorestr.length];
            for(int i = 0; i < scores.length; i++ ) {
            	scores[i] = Integer.parseInt(partenScorestr[i]);
            	System.out.print("试题分值" + scores[i] +" ");
            }
            
            System.out.println();
            
            for (int i = 0; i < populationSize; i++) {
                paper = new Paper();
                paper.setId(i + 1);
                paper.setCourseId(courseId);
                paper.setkPCoverage(0);
                paper.setDifficulty(rule.getDifficulty());
                paper.setCourseId(courseId);
                while (paper.getTotalScore() != rule.getTotalMark()) {
                    paper.getQuestionList().clear();
                    // 单选题
                    for(int k = 0; k < numbers.length; k++) {
                    	 if (numbers[k] > 0) {
                             generateQuestion(courseId, partenstr[k], random, numbers[k], scores[k],
                                     "" + partenstr[k] + "数量不够，组卷失败", paper);
                         }
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
    	
    	//获取同一题型的题目集合
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