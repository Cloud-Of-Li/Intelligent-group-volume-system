package com.cloud.zj.generation;

import java.sql.Date;

/**
 * 组卷规则Bean
 *
 * @author: cloud
 * @CreateDate: 2018-4-7
 * @version: 1.0
 */

public class RuleBean {
	/**
	 * 规则id
	 */
	private long id;
	/**
	 * 规则对应的考试id
	 */
	private long examId;
	/**
	 * 试卷总分
	 */
	private double totalMark;
	/**
	 * 试卷期望难度系数
	 */
	private double difficulty;
	/**
	 * 单选题数量
	 */
	private int singleNum;
	/**
	 * 单选题单个分值
	 */
	private double singleScore;
	
	
	/**
	 * 多选题数量
	 */
	private int multiNum;
	/**
	 * 多选题单个分值
	 */
	private double multiScore;
	
	
	/**
	 * 填空题数量
	 */
	private int completeNum;
	/**
	 * 填空题单个分值
	 */
	private double completeScore;
	
	
	/**
	 * 判断题数量
	 */
	private int tfNum;
	/**
	 * 判断题单个分值
	 */
	private double tfScore;
	
	
	/**
	 * 主观题数量
	 */
	private int subjectiveNum;
	/**
	 * 主观题单个分值
	 */
	private double subjectiveScore;
	/**
	 * 规则创建时间
	 */
	private Date createTime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getExamId() {
		return examId;
	}

	public void setExamId(long examId) {
		this.examId = examId;
	}

	public double getTotalMark() {
		return totalMark;
	}

	public void setTotalMark(double totalMark2) {
		this.totalMark = totalMark2;
	}

	public double getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(double difficulty) {
		this.difficulty = difficulty;
	}

	public int getSingleNum() {
		return singleNum;
	}

	public void setSingleNum(int singleNum) {
		this.singleNum = singleNum;
	}

	public double getSingleScore() {
		return singleScore;
	}

	public void setSingleScore(double singleScore) {
		this.singleScore = singleScore;
	}

	public int getCompleteNum() {
		return completeNum;
	}

	public void setCompleteNum(int completeNum) {
		this.completeNum = completeNum;
	}

	public double getCompleteScore() {
		return completeScore;
	}

	public void setCompleteScore(double completeScore) {
		this.completeScore = completeScore;
	}

	public int getSubjectiveNum() {
		return subjectiveNum;
	}

	public void setSubjectiveNum(int subjectiveNum) {
		this.subjectiveNum = subjectiveNum;
	}

	public double getSubjectiveScore() {
		return subjectiveScore;
	}

	public void setSubjectiveScore(double subjectiveScore) {
		this.subjectiveScore = subjectiveScore;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	

	public int getMultiNum() {
		return multiNum;
	}

	public void setMultiNum(int multiNum) {
		this.multiNum = multiNum;
	}

	public double getMultiScore() {
		return multiScore;
	}

	public void setMultiScore(double multiScore) {
		this.multiScore = multiScore;
	}

	public int getTfNum() {
		return tfNum;
	}

	public void setTfNum(int tfNum) {
		this.tfNum = tfNum;
	}

	public double getTfScore() {
		return tfScore;
	}

	public void setTfScore(double tfScore) {
		this.tfScore = tfScore;
	}


}
