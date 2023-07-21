package com.cwc.studentmangement.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString

@Entity
//@Embeddable
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addId;
	private String currentAddress;
	private String perAddress;

}
