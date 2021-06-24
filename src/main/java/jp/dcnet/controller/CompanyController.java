package jp.dcnet.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.dcnet.object.CompanyObject;
import jp.dcnet.object.UserSession;
import jp.dcnet.service.CompanyService;

@Controller
public class CompanyController {

	@Autowired
	CompanyService companyService;

	@RequestMapping("/company")
	public ModelAndView companyInfo(HttpSession session) {
		ModelAndView mv = new ModelAndView("company");
		
		return mv;
	}

	@PostMapping("/saveCompanyInfo")
	public String companyInfo(@RequestParam("companyname") String companyname,
			@RequestParam("companyaddress") String companyaddress, @RequestParam("companytel") int companytel,
			@RequestParam("companymanager") String companymanager, @RequestParam("licensenumber") String licensenumber,
			RedirectAttributes redirectAttributes, HttpSession session) {

		UserSession userRole = (UserSession) session.getAttribute("userRole");
		CompanyObject companyObj = new CompanyObject();

		companyObj.setUserId(userRole.getId());
		companyObj.setCompanyname(companyname);
		companyObj.setCompanyaddress(companyaddress);
		companyObj.setCompanytel(companytel);
		companyObj.setCompanymanager(companymanager);
		companyObj.setLicensenumber(licensenumber);

		companyService.companyService(companyObj);

		return "redirect:/center";
	}
}
