package jp.dcnet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.dcnet.entity.MSG;
import jp.dcnet.object.MSGObject;
import jp.dcnet.repository.MSGRepository;

@Service
public class MSGService {

	@Autowired
	MSGRepository msgRepository;
	
	public void getMSGToDb(MSGObject msgobj) {
		// TODO 自動生成されたメソッド・スタブ
		MSG msg= new MSG();
		msg.setMesage(msgobj.getMesage());
		
		msgRepository.save(msg);
	}

	
	
	
	
}
