package jp.dcnet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.dcnet.entity.UserInfo;
import jp.dcnet.object.UserInfoObject;
import jp.dcnet.repository.UserInfoRepository;

@Service
public class UserInfoService {
	@Autowired
	UserInfoRepository userInfoRepository;

	/**
	 * userinformation db保存
	 * 
	 * @param infoobj
	 * @return
	 */

	public void userInfoGet(UserInfoObject infoobj) {
		
		
		
		UserInfo userInfo = new UserInfo();
		userInfo.setUserId(infoobj.getUserId());
		userInfo.setName(infoobj.getName());
		userInfo.setTel(infoobj.getTel());
		userInfo.setAddress(infoobj.getAddress());

		userInfoRepository.save(userInfo);

	}

	/*
	 * userinformation 画面表示
	 */
	public UserInfoObject userInfoDisplay(int userId) {

		UserInfo userInfo = userInfoRepository.findByUserId(userId);

		UserInfoObject infoobj = new UserInfoObject();

		infoobj.setIcon(userInfo.getIcon());
		infoobj.setName(userInfo.getName());
		infoobj.setTel(userInfo.getTel());
		infoobj.setAddress(userInfo.getAddress());
           return infoobj;

	}
	/**
	 * アイコン保存
	 * @param userIcon
	 * @param id
	 */
	public void saveIcon( UserInfoObject userIcon , int id){
		  //picture のaddress
		  String icon = "../images/icon/"+ userIcon.getIcon();
		 
		UserInfo us = userInfoRepository.findByUserId(id);
		  
		UserInfo userInfo= new UserInfo();
		userInfo.setUserId(us.getUserId());
		userInfo.setIcon(icon);
		userInfo.setName(us.getName());
		userInfo.setTel(us.getTel());
		userInfo.setAddress(us.getAddress());
		
		
		userInfoRepository.save(userInfo);
	
	}
	
	
	
}
