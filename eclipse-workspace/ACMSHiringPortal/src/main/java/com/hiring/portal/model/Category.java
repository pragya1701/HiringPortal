package com.hiring.portal.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.math.BigDecimal;

@Entity
@Table(name = "category")
@EntityListeners(AuditingEntityListener.class)

public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cid;

	@NotBlank
	private String type;

	@NotBlank
	private String categoryname;

	@NotBlank
	private String coordid;

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

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public String getCoordid() {
		return coordid;
	}

	public void setCoordid(String coordid) {
		this.coordid = coordid;
	}
}
