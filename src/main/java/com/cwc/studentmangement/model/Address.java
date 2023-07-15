package com.cwc.studentmangement.model;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

//@Entity
//@Embeddable
public class Address {
	private String currentAddress;
	private String perAddress;

}
