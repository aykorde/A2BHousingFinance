package com.lnt.homeloan.service;

import java.util.List;

import com.lnt.homeloan.model.Documents;

public interface ChecklistService {


	List GenerateChecklist(int userid);

	List viewAllDocs(String appid);

	


}
