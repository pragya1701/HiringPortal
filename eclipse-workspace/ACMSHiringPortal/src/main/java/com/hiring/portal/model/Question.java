package com.hiring.portal.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.math.BigDecimal;

@Entity
@Table(name = "question")
@EntityListeners(AuditingEntityListener.class)

public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long qid;

	@NotNull
	private Long cid;

	@NotBlank
	private String type;
	
	@NotBlank
	private String level;
	
	@NotBlank
	private String question;
	
	@NotNull
	private Long coordid;

	//option1
	private String option1;

	private String option2;

	private String option3;

	private String option4;
	
	private String answer;
	
	private String sampleinput;
	
	private String sampleoutput;
	
	private String testinput;
	
	private String testoutput;
	
	private String prototype;
	
	private String body;

	public Long getQid() {
		return qid;
	}

	public void setQid(Long qid) {
		this.qid = qid;
	}

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Long getCoordid() {
		return coordid;
	}

	public void setCoordid(Long coordid) {
		this.coordid = coordid;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getSampleinput() {
		return sampleinput;
	}

	public void setSampleinput(String sampleinput) {
		this.sampleinput = sampleinput;
	}

	public String getSampleoutput() {
		return sampleoutput;
	}

	public void setSampleoutput(String sampleoutput) {
		this.sampleoutput = sampleoutput;
	}

	public String getTestinput() {
		return testinput;
	}

	public void setTestinput(String testinput) {
		this.testinput = testinput;
	}

	public String getTestoutput() {
		return testoutput;
	}

	public void setTestoutput(String testoutput) {
		this.testoutput = testoutput;
	}

	public String getPrototype() {
		return prototype;
	}

	public void setPrototype(String prototype) {
		this.prototype = prototype;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	}
