package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.service.ILocalService;



@RestController
public class LocalController {

	@Autowired
	ILocalService localService;
	public LocalController() {
		// TODO Auto-generated constructor stub
	}

}
