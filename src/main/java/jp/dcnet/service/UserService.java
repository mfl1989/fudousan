package jp.dcnet.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.dcnet.entity.Company;
import jp.dcnet.entity.UserInfo;
import jp.dcnet.entity.UserInto;
import jp.dcnet.object.UserIntoObject;
import jp.dcnet.repository.CompanyRepository;
import jp.dcnet.repository.UserInfoRepository;
import jp.dcnet.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	UserInfoRepository userInfoRepository;
	@Autowired
	CompanyRepository companyRepository;

	/**
	 * 新規 ユーザー
	 * 
	 */

	public int registService(UserIntoObject uo) {

		UserInto user = new UserInto();

		if (userRepository.findByEmail(uo.getEmail()) == null) {

			user.setEmail(uo.getEmail());
			user.setPassword(uo.getPassword());
			user.setStatus(0);
			user.setUserRole("user");
			user.setCreatetime(new Timestamp(System.currentTimeMillis()));
			userRepository.saveAndFlush(user);
			UserInfo userInfo = new UserInfo();

			userInfo.setUserId(user.getUserId());
			userInfo.setCreatetime(new Timestamp(System.currentTimeMillis()));
			userInfoRepository.saveAndFlush(userInfo);
			return 0;
		}

		return 1;
	}

	/**
	 * company 新規
	 * 
	 * @param uo
	 * @return
	 */
	public int companyRegistService(UserIntoObject uo) {
		UserInto user = new UserInto();
		if (userRepository.findByEmail(uo.getEmail()) == null) {

			user.setEmail(uo.getEmail());
			user.setPassword(uo.getPassword());
			user.setStatus(0);
			user.setUserRole("company");
			user.setCreatetime(new Timestamp(System.currentTimeMillis()));
			userRepository.saveAndFlush(user);
			Company company = new Company();
			// ｆｋ の設定
			company.setUserId(user.getUserId());

			companyRepository.saveAndFlush(company);
			return 0;
		}

		return 1;
	}

	/**
	 * admin 類
	 * 
	 */

	public int adminService(UserIntoObject uo) {

		UserInto user = new UserInto();

		if ("admin".equals(uo.getEmail()) && "123".equals(uo.getPassword())) {

			user.setEmail(uo.getEmail());
			user.setPassword(uo.getPassword());
			user.setStatus(0);
			user.setUserRole("admin");
			user.setCreatetime(new Timestamp(System.currentTimeMillis()));
			userRepository.saveAndFlush(user);
			UserInfo userInfo = new UserInfo();
			// ｆｋ の設定
			userInfo.setUserId(user.getUserId());
			userInfo.setCreatetime(new Timestamp(System.currentTimeMillis()));
			userInfoRepository.saveAndFlush(userInfo);
			return 0;
		}

		return 1;
	}

	/**
	 * 
	 * 登録
	 * 
	 */

	public int loginService(UserIntoObject uo) {
		UserInto user = new UserInto();
		user = userRepository.findByEmail(uo.getEmail());
		if (user != null) {

			if (user.getPassword().equals(uo.getPassword())) {
				// 登録成功
				return 0;
			} else {
				// パスワード間違い
				return 1;
			}
		} else {
			// ユーザ存在しません
			return 2;
		}

	}

	public int adminService1(UserIntoObject uo) {
		UserInto user = new UserInto();
		if ("admin".equals(uo.getEmail()) && "123".equals(uo.getPassword())) {

			if (user.getPassword().equals(uo.getPassword())) {
				// 登録成功
				return 0;
			} else {
				// パスワード間違い
				return 1;
			}
		} else {
			// ユーザ存在しません
			return 2;
		}

	}

	/**
	 * パスワード変更 所有内容都要从新getset 防止null point
	 */
	public int passwordUpDate(UserIntoObject uo, String newpassword) {

		UserInto user = userRepository.findByEmail(uo.getEmail());
		UserInto newuser = new UserInto();
		if (user.getPassword().equals(uo.getPassword())) {
			newuser.setPassword(newpassword);
			newuser.setEmail(user.getEmail());
			newuser.setCreatetime(new Timestamp(System.currentTimeMillis()));
			newuser.setStatus(user.getStatus());
			newuser.setUserRole(user.getUserRole());
			newuser.setUserId(user.getUserId());
			userRepository.save(newuser);

			return 0;
		}

		return 1;

	}
	/*
	 * 通过email取到当前帐户信息
	 * 
	 */

	public UserIntoObject getUserLogin(String email) {
		UserInto findByEmail = userRepository.findByEmail(email);
		UserIntoObject usreLogin = new UserIntoObject();
		usreLogin.setUserId(findByEmail.getUserId());
		usreLogin.setEmail(findByEmail.getEmail());
		usreLogin.setStatus(findByEmail.getStatus());
		usreLogin.setUserRole(findByEmail.getUserRole());
		return usreLogin;
	}

	public List<UserIntoObject> findAll() {

		List<UserIntoObject> userobj = new ArrayList<>();
		List<UserInto> users = userRepository.findAll();
		for (UserInto user : users) {
			UserIntoObject userinto = new UserIntoObject();
			userinto.setUserId(user.getUserId());
			userinto.setEmail(user.getEmail());
			userinto.setPassword(user.getPassword());
			userinto.setStatus(user.getStatus());
			userinto.setUserRole(user.getUserRole());
			userinto.setCreatetime(user.getCreatetime());
			userobj.add(userinto);
		}

		return userobj;
	}

	public UserIntoObject updateAdminTheview(int userId) {
		
		UserInto user = userRepository.findById(userId).get();
		UserIntoObject userobj =new UserIntoObject();
		
		userobj.setUserId(user.getUserId());
		userobj.setEmail(user.getEmail());
		userobj.setPassword(user.getPassword());
		userobj.setStatus(user.getStatus());
		userobj.setUserRole(user.getUserRole());
		userobj.setCreatetime(user.getCreatetime());
		
		
		return userobj;
	}
	
	@Transactional
	public void updateAdminTheRep(UserIntoObject obj,int userId) {
		
		UserInto user = userRepository.findById(userId).get();
		
		if("company".equals(obj.getUserRole())) {
			//插入company表数据
			//插入user表数据
			  companyRegistService(obj);
		}else if ("user".equals(obj.getUserRole())) {
			//插入user表数据
			//刪除company表数据
			
			companyRepository.deleteByUserId(userId);
			user.setEmail(obj.getEmail());
			user.setPassword(obj.getPassword());
			user.setStatus(obj.getStatus());
			user.setUserRole(obj.getUserRole());
			user.setCreatetime(obj.getCreatetime());
			userRepository.save(user);
		}
		
		//user.setUserId(userobj.getUserId());
		
		
	
		
		
		
		
	}

	public void deleteById(int userId) {
		// TODO 自動生成されたメソッド・スタブ
		userRepository.deleteById(userId);
	}

	
	
	
	
	
}