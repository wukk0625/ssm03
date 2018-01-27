package com.javen.controller;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javen.model.User;
import com.javen.service.UserService;

@Controller
@RequestMapping("/user")
// /user/**
public class UserController {
	private static Logger log = LoggerFactory.getLogger(UserController.class);
	@Resource
	private UserService userService;

	@RequestMapping(value = "/test1", method = RequestMethod.GET)
	public String getUserByIdTest(@RequestParam("id") String id) {
		User user = userService.getUserById(Integer.parseInt(id));
		System.out.println(user);
		return "index";
	}

	// 文件上传、
	@RequestMapping(value = "/upload")
	public String showUploadPage() {
		return "file";
	}

	@RequestMapping(value = "/doUpload", method = RequestMethod.POST)
	public String doUploadFile(@RequestParam("file") MultipartFile file,Model model) throws IOException {
		if (!file.isEmpty()) {
			log.info("Process file:{}", file.getOriginalFilename());
		}
		String filename=System.currentTimeMillis() + file.getOriginalFilename();
		log.info(">>>>>>>>>>>>>>>>>>>"+filename);
		FileUtils.copyInputStreamToFile(file.getInputStream(),
				new File("E:\\", filename));
		model.addAttribute("filename", filename);
		return "success";
	}
}