package com.cwc.studentmangement.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumns;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.context.annotation.Primary;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
@Entity
@Table(name = "student", schema = "student_database")
@DynamicUpdate
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stdId;

	@Column(name = "roll_number")
	@NotNull(message = "positive number value is required")
	@Min(value=1, message="rollnumber: positive number, min 1 is required")
	private int rollNo;
	
	@NotBlank(message = "Enter proper student name")
	@Size(min = 5, message = "Name should be atleast 5 characters")
	@Size(max = 12, message = "Name should not be greater than 12 characters")
	@Column(name = "student_name")
	private String stdName;

	private String section;
	private String branch;
	private String standard;
	
	//Collection
	@ElementCollection
	@JoinTable(name = "address",joinColumns = @JoinColumn(name="student_id"))
	private Set<Address> homeaddresses = new HashSet<>();
	
	
}
