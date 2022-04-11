package com.lnt.homeloan.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lnt.homeloan.config.AppConfig;
import com.lnt.homeloan.service.AppService;
import com.lnt.homeloan.service.DocService;

@RestController
@RequestMapping(path = "/documents")
@CrossOrigin
public class DocumentsUpload {

	@Autowired
	private DocService docservice;

	@RequestMapping(value = "/pancard/{id}", method = RequestMethod.POST, produces = "text/plain")
	public String savePan(HttpServletRequest request, @RequestParam("file") MultipartFile[] fileUpload,
			@PathVariable("id") int id) throws Exception {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		if (fileUpload != null && fileUpload.length > 0) {
			for (MultipartFile aFile : fileUpload) {

				return docservice.savePan(aFile, id);

			}

		}
		return null;

	}
	
	@RequestMapping(value = "/voterid/{id}", method = RequestMethod.POST, produces = "text/plain")
	public String saveVoter(HttpServletRequest request, @RequestParam("file") MultipartFile[] fileUpload,
			@PathVariable("id") int id) throws Exception {

		if (fileUpload != null && fileUpload.length > 0) {
			for (MultipartFile aFile : fileUpload) {

				return docservice.saveVoter(aFile, id);

			}

		}
		return null;

	}
	
	@RequestMapping(value = "/salaryslip/{id}", method = RequestMethod.POST, produces = "text/plain")
	public String saveSalarySlip(HttpServletRequest request, @RequestParam("file") MultipartFile[] fileUpload,
			@PathVariable("id") int id) throws Exception {

		if (fileUpload != null && fileUpload.length > 0) {
			for (MultipartFile aFile : fileUpload) {

				return docservice.saveSalarySlip(aFile, id);

			}

		}
		return null;

	}
	
	@RequestMapping(value = "/loa/{id}", method = RequestMethod.POST, produces = "text/plain")
	public String saveLoa(HttpServletRequest request, @RequestParam("file") MultipartFile[] fileUpload,
			@PathVariable("id") int id) throws Exception {

		if (fileUpload != null && fileUpload.length > 0) {
			for (MultipartFile aFile : fileUpload) {

				return docservice.saveLoa(aFile, id);

			}

		}
		return null;

	}
	
	@RequestMapping(value = "/noc/{id}", method = RequestMethod.POST, produces = "text/plain")
	public String saveNoc(HttpServletRequest request, @RequestParam("file") MultipartFile[] fileUpload,
			@PathVariable("id") int id) throws Exception {

		if (fileUpload != null && fileUpload.length > 0) {
			for (MultipartFile aFile : fileUpload) {

				return docservice.saveNoc(aFile, id);

			}

		}
		return null;

	}
	
	@RequestMapping(value = "/ats/{id}", method = RequestMethod.POST, produces = "text/plain")
	public String saveAts(HttpServletRequest request, @RequestParam("file") MultipartFile[] fileUpload,
			@PathVariable("id") int id) throws Exception {

		if (fileUpload != null && fileUpload.length > 0) {
			for (MultipartFile aFile : fileUpload) {

				return docservice.saveAts(aFile, id);

			}

		}
		return null;

	}
}
