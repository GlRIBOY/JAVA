package com.physical.management.client.service;

import lombok.Data;

@Data
public class ClientVO {
	private int clientId;
	private String clientCategory;
	private String clientName;
	private int clientAge;
	private int clientHeight;
	private int clientWeight;
	
	public String toString() {
		System.out.print(clientId + " ");
		System.out.print(clientCategory + " ");
		System.out.print(clientName + " ");
		System.out.print(clientAge + " ");
		System.out.print(clientHeight + " ");
		System.out.println(clientWeight);
		return null;
	}

}
