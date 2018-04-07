package com.cloud.zj.entity;

public class Exam {
	private Integer examId;
	private int courseId;
	private String examKind;
	private String examChapter;
	private float examDegree;
	private double examScore;
	private String examContent;
	private String examAnwser;
	public Integer getExamId() {
		return examId;
	}
	public void setExamId(Integer examId) {
		this.examId = examId;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getExamKind() {
		return examKind;
	}
	public void setExamKind(String examKind) {
		this.examKind = examKind;
	}
	public String getExamChapter() {
		return examChapter;
	}
	public void setExamChapter(String examChapter) {
		this.examChapter = examChapter;
	}
	public float getExamDegree() {
		return examDegree;
	}
	public void setExamDegree(float examDegree) {
		this.examDegree = examDegree;
	}
	public double getExamScore() {
		return examScore;
	}
	public void setExamScore(double examScore) {
		this.examScore = examScore;
	}
	public String getExamContent() {
		return examContent;
	}
	public void setExamContent(String examContent) {
		this.examContent = examContent;
	}
	public String getExamAnwser() {
		return examAnwser;
	}
	public void setExamAnwser(String examAnwser) {
		this.examAnwser = examAnwser;
	}
}