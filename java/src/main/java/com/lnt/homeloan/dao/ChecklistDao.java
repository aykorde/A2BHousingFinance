package com.lnt.homeloan.dao;

import java.util.List;

public interface ChecklistDao {

	public List GenerateChecklist(int userid) ;

	public List viewAllDocs(String appid);

}
