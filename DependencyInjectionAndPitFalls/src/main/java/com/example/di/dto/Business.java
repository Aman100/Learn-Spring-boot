package com.example.di.dto;

import org.springframework.stereotype.Component;

@Component()
public class Business {
	private String businessName;

	public Business() {
		super();
	}
	
	public Business(String businessName) {
		super();
		this.businessName = businessName;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	@Override
	public String toString() {
		return "Business [businessName=" + businessName + "]";
	}

}
