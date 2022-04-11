package com.lnt.homeloan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lnt.homeloan.dao.AppDao;
import com.lnt.homeloan.dao.DocDao;

@Service
public class DocServiceImpl implements DocService {
	
	@Autowired
	private DocDao docdao;

	@Override
	public String savePan(MultipartFile aFile, int id) {
		
			return docdao.savePan(aFile,id);		
		
	}

	@Override
	public String saveVoter(MultipartFile aFile, int id) {
		return docdao.saveVoter(aFile,id);
	}

	@Override
	public String saveSalarySlip(MultipartFile aFile, int id) {
		return docdao.saveSalarySlip(aFile,id);
	}

	@Override
	public String saveLoa(MultipartFile aFile, int id) {
		return docdao.saveLoa(aFile,id);
	}

	@Override
	public String saveNoc(MultipartFile aFile, int id) {
		return docdao.saveNoc(aFile,id);
	}

	@Override
	public String saveAts(MultipartFile aFile, int id) {
		return docdao.saveAts(aFile,id);
	}

}
