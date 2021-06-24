package jp.dcnet.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jp.dcnet.entity.Staff;
import jp.dcnet.object.StaffObject;
import jp.dcnet.object.UserSession;
import jp.dcnet.service.CompanyService;
import jp.dcnet.service.StaffInfoService;

@Controller
//@RequestMapping("/allstaff") 
public class AllStaffController {

	@Autowired
	CompanyService companyService;
	@Autowired
	StaffInfoService staffInfoSer;

//	  @GetMapping 
//	  public String index(Model model) { // ② 
//		  List<Staff> staffs = staffInfoSer.findAll(); 
//	  model.addAttribute("staff", staffs); // ③ 
//	  return "allstaff/allstaffs"; // ④ 
//	  }

	@RequestMapping("/allstaff")
	public ModelAndView theStaffIndex(HttpSession  session) {
		UserSession us=(UserSession) session.getAttribute("userRole");
		int userId =us.getId();
		int companyId =companyService.getCompanyId(userId);
		System.out.println(companyId);
		List<Staff> staffs = staffInfoSer.findAll(companyId);
		ModelAndView mv = new ModelAndView("allstaff");
		mv.addObject("staff", staffs);
		return mv;

	}

	@RequestMapping("/allstaff/newstaff")
	public ModelAndView newStaff() {

		ModelAndView mv = new ModelAndView("newstaff");

		return mv;
	}

	@RequestMapping("/zeditstaff/{id}")
	public ModelAndView editStaff(@PathVariable("id") int staffId) {

		ModelAndView mv = new ModelAndView("editstaff");
		StaffObject staffObj = staffInfoSer.viewTheStaff(staffId);
		System.out.println(staffObj.getStaffName());
		
		
		
		mv.addObject("staff", staffObj);
		return mv;
	}

	/*
	 * @RequestMapping("/newstaff") public String viewTheStaff(Model model) { Staff
	 * staff = staffInfoSer.findOne(staffId); model.addAttribute("staff", staff);
	 * return "allstaff/editstaff"; }
	 */
	@PostMapping("/editstaff/{id}")
	public String editStaffs( @PathVariable("id") int staffId,StaffObject staffobj
			
			) {
	
//		StaffObject staffobj = new StaffObject();
//		staffobj.setStaffName(staffName);
//		System.out.println(staffName);
//		staffobj.setExperience(experience);
//		staffobj.setTel(tel);
		
		staffInfoSer.updateStaff(staffobj,staffId);
		

		return "redirect:/allstaff";

	}

	@RequestMapping("/showstaff/{id}")
	public ModelAndView showStaff(@PathVariable("id") int staffId) {

		ModelAndView mv = new ModelAndView("showstaff");
		Staff staff = staffInfoSer.findOne(staffId);
		mv.addObject("staff", staff);
		return mv;
	}
	/*
	 * @RequestMapping("allstaff/{id}") public String showStaff(@PathVariable("id")
	 * int staffId, Model model) { Staff staff = staffInfoSer.findOne(staffId);
	 * model.addAttribute("staff", staff); return "allstaff/showstaff"; }
	 */

	@PostMapping("/allstaff")
	public String create(
			@RequestParam String staffName,
			@RequestParam String experience, 
			@RequestParam String tel,
			HttpSession session) {
		
		UserSession sess = (UserSession) session.getAttribute("userRole");
		int companyId = companyService.getCompanyId(sess.getId());
		StaffObject staffobj = new StaffObject();
		staffobj.setCompanyId(companyId);
		staffobj.setStaffName(staffName);
		staffobj.setExperience(experience);
		staffobj.setTel(tel);
		staffInfoSer.createStaff(staffobj);

		return "redirect:/allstaff";
	}

	@PutMapping("/allstaff/{id}")
	public String update(@PathVariable("id") int staffId, @ModelAttribute Staff staff) {
		staff.setStaffId(staffId);
		staffInfoSer.save(staff);
		return "redirect:/allstaff";
	}

	@RequestMapping("/deletestaff/{id}")
	public String destroy(@PathVariable("id") int staffId) {
		staffInfoSer.delete(staffId);
		return "redirect:/allstaff";

	}

}
