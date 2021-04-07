package com.sample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
@Table(name="numbers")
public class Numbers {
	

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="number_Id")
    private long numberId;
	
	@Column(name="number")
	@NotNull
	//@Size(min=1, message="String should have atleast 1 characters")
	private String number;
	
	public long getNumberId() {
		return numberId;
	}

	public void setNumberId(long numberId) {
		this.numberId = numberId;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	
	
	

	
	
	 
	

}
