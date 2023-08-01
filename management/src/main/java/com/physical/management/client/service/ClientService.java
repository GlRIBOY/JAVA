package com.physical.management.client.service;

import java.util.List;

public interface ClientService {
	List<ClientVO> clientList();
	ClientVO clientSelect(ClientVO vo);
	int clientInsert(ClientVO vo);
	int clientDelete(ClientVO vo);
	int clientUpdate(ClientVO vo);
	List<ClientVO> clientSelects(int n);
	List<ClientVO >clientSelectName(String name);
	
}
