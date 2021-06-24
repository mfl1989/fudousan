package jp.dcnet.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.dcnet.entity.Company;
import jp.dcnet.object.CompanyObject;
import jp.dcnet.repository.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
	CompanyRepository companyRepository;

	@Transactional
	public void companyService(CompanyObject companyobject) {

		Company company = companyRepository.findByUserId(companyobject.getUserId());

		company.setCompanyname(companyobject.getCompanyname());
		company.setCompanyaddress(companyobject.getCompanyaddress());
		company.setCompanytel(companyobject.getCompanytel());
		company.setCompanymanager(companyobject.getCompanymanager());
		company.setLicensenumber(companyobject.getLicensenumber());
		companyRepository.saveAndFlush(company);

	}

	@Transactional
	public CompanyObject companyView(int companyId) {

		CompanyObject companyobj = new CompanyObject();
		Company company = companyRepository.findByCompanyId(companyId);
		companyobj.setCompanyId(company.getCompanyId());
		companyobj.setUserId(company.getUserId());
		companyobj.setCompanyname(company.getCompanyname());
		companyobj.setCompanyaddress(company.getCompanyaddress());
		companyobj.setCompanytel(company.getCompanytel());
		companyobj.setCompanymanager(company.getCompanymanager());
		companyobj.setLicensenumber(company.getLicensenumber());
		return companyobj;

	}

	/**
	 * userIdでcompanyIdを取得する
	 * 
	 * @param id
	 * @return
	 */
	@Transactional
	public int getCompanyId(int id) {
		return companyRepository.findByUserId(id).getCompanyId();
	}
}
