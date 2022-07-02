package com.kafkaStream.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class BookStore {

	@Id
	private int id;
	private String name;
}
