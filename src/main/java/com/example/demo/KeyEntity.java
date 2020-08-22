package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
@MappedSuperclass
public class KeyEntity {
	@Id
	@Column(name="PK",unique = true)
	private long pk;
	
	public void setPk(long pk) {this.pk = pk;}
}
