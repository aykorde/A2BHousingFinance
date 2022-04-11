package com.lnt.homeloan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lnt.homeloan.dao.ChecklistDao;

@Service
public class ChecklistServiceImpl implements ChecklistService {

	@Autowired
	private ChecklistDao checklistdao;
	@Override
	public List GenerateChecklist(int userid) {
		return checklistdao.GenerateChecklist(userid);
	}
	@Override
	public List viewAllDocs(String appid) {
		return checklistdao.viewAllDocs(appid);
	}

}
