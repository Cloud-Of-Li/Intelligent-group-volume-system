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
	 * 试题类型
	 */
	private String partens;
	/**
	 * 各个试题数量
	 */
	private String partenCounts;
	/**
	 * 各个试题分值
	 */
	private String partenScores;
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
	public void setTotalMark(double totalMark) {
		this.totalMark = totalMark;
	}
	public double getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(double difficulty) {
		this.difficulty = difficulty;
	}
	public String getPartens() {
		return partens;
	}
	public void setPartens(String partens) {
		this.partens = partens;
	}
	public String getPartenCounts() {
		return partenCounts;
	}
	public void setPartenCounts(String partenCounts) {
		this.partenCounts = partenCounts;
	}
	public String getPartenScores() {
		return partenScores;
	}
	public void setPartenScores(String partenScores) {
		this.partenScores = partenScores;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	


}
