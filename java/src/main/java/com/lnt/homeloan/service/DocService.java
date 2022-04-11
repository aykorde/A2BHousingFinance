package com.lnt.homeloan.service;

import org.springframework.web.multipart.MultipartFile;

public interface DocService {

	String savePan(MultipartFile aFile, int id);

	String saveVoter(MultipartFile aFile, int id);

	String saveSalarySlip(MultipartFile aFile, int id);

	String saveLoa(MultipartFile aFile, int id);

	String saveNoc(MultipartFile aFile, int id);

	String saveAts(MultipartFile aFile, int id);

}
