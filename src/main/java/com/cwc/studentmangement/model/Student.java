package com.cwc.studentmangement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "student",schema = "student_database")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int stdId;
	
//	@Column(unique = true,length = 4,nullable = false)
	private int rollNo;
	private String stdName;
	private String section;
	private String branch;
	private String standard;
}
