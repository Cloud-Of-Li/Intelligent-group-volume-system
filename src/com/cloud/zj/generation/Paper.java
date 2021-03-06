package com.cloud.zj.generation;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.cloud.zj.entity.Exam;

/**
 * 遗传算法中的个体，即一套可能的试卷。对试卷进行编码，而不是对整个题库编码
 *
 * @author: cloud
 * @CreateDate: 2018-4-7
 * @version: 1.0
 */
public class Paper {
	
	private String partens;
	private String partensCounts;
	private String partensScoures;
	
	

	public String getPartens() {
		return partens;
	}

	public void setPartens(String partens) {
		this.partens = partens;
	}

	public String getPartensCounts() {
		return partensCounts;
	}

	public void setPartensCounts(String partensCounts) {
		this.partensCounts = partensCounts;
	}

	public String getPartensScoures() {
		return partensScoures;
	}

	public void setPartensScoures(String partensScoures) {
		this.partensScoures = partensScoures;
	}

	/**
     * 个体id
     */
    private int id;
    /**
     * 试卷科目
     */
    private int courseId;
    /**
     * 适应度
     */
    private double adaptationDegree = 0.00;
    /**
     * 知识点覆盖率
     */
    private double kPCoverage = 0.00;
    /**
     * 试卷总分
     */
    private double totalScore = 0.00;
    /**
     * 试卷难度系数
     */
    private double difficulty = 0.00;
    /**
     * 个体包含的试题集合
     */
    private List<Exam> questionList = new ArrayList<Exam>();
    /**
     * 试卷创建时间
     */
    private Timestamp createTime;
    /**
     * 试卷名称
     */
    private String paperName;

    public String getPaperName() {
		return paperName;
	}

	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}

	public Paper(int size) {
        for (int i = 0; i < size; i++) {
            questionList.add(null);
        }
    }

    public Paper() {
        super();
    }

    /**
     * 计算试卷总分
     *
     * @return
     */
    public double getTotalScore() {
        if (totalScore == 0) {
            double total = 0;
            for (Exam question : questionList) {
                total += question.getExamScore();
            }
            totalScore = total;
        }
        return totalScore;
    }

    /**
     * 计算试卷个体难度系数 计算公式： 每题难度*分数求和除总分
     *
     * @return
     */
    public double getDifficulty() {
        if (difficulty == 0) {
            double _difficulty = 0;
            for (Exam question : questionList) {
                _difficulty += question.getExamScore() * question.getExamDegree();
            }
            difficulty = _difficulty / getTotalScore();
        }
        return difficulty;
    }

    /**
     * 获取试题数量
     *
     * @return
     */
    public int getQuestionSize() {
        return questionList.size();
    }


    /**
     * 计算个体适应度 公式为：f=1-(1-M/N)*f1-|EP-P|*f2
     * 其中M/N为知识点覆盖率，EP为期望难度系数，P为种群个体难度系数，f1为知识点分布的权重
     * ，f2为难度系数所占权重。当f1=0时退化为只限制试题难度系数，当f2=0时退化为只限制知识点分布
     *
     * @param rule 组卷规则
     * @param f1   知识点分布的权重
     * @param f2   难度系数的权重
     */
    public void setAdaptationDegree(RuleBean rule, double f1, double f2) {
        if (adaptationDegree == 0) {
            adaptationDegree = 1 - (1 - getkPCoverage()) * f1 - Math.abs(rule.getDifficulty() - getDifficulty()) * f2;
        }
    }

    public void setAdaptationDegree(double adaptationDegree) {
		this.adaptationDegree = adaptationDegree;
	}

	public void setkPCoverage(double kPCoverage) {
		this.kPCoverage = kPCoverage;
	}

	public void setTotalScore(double totalScore) {
		this.totalScore = totalScore;
	}

	public void setDifficulty(double difficulty) {
		this.difficulty = difficulty;
	}

	public boolean containsQuestion(Exam question) {
        if (question == null) {
            for (int i = 0; i < questionList.size(); i++) {
                if (questionList.get(i) == null) {
                    return true;
                }
            }
        } else {
            for (Exam aQuestionList : questionList) {
                if (aQuestionList != null) {
                    if (aQuestionList.equals(question)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 增加问题
     *
     * @param question
     */
    public void saveQuestion(int index, Exam question) {
        this.questionList.set(index, question);
        this.totalScore = 0;
        this.adaptationDegree = 0;
        this.difficulty = 0;
        this.kPCoverage = 0;
    }

    public void addQuestion(Exam singleArray) {
        this.questionList.add(singleArray);
        this.totalScore = 0;
        this.adaptationDegree = 0;
        this.difficulty = 0;
        this.kPCoverage = 0;
    }

    public Exam getQuestion(int index) {
        return questionList.get(index);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getkPCoverage() {
        return kPCoverage;
    }

    public double getAdaptationDegree() {
        return adaptationDegree;
    }

    public List<Exam> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Exam> questionList) {
        this.questionList = questionList;
    }

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	
	

}
