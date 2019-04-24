package com.gecko.jee.community.formation.exercice1;

public class TechicalException extends Exception {

	private int code;

	public TechicalException(String message, int code) {
		super(message);
		this.code=code;
	}
}
