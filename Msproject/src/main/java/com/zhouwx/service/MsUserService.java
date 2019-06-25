package com.zhouwx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhouwx.dao.MsmerchantDao;
import com.zhouwx.dao.MsuserDao;
import com.zhouwx.enity.Msmerchant;
import com.zhouwx.enity.Msuser;
import com.zhouwx.vo.msmerchant.MsmerchantVo;
import com.zhouwx.vo.msuser.MsuserVo;

@Service
public class MsUserService {
	
	@Autowired
	MsuserDao msuserDao ;
	
	public void insertUser(Msuser msuser){
		msuserDao.insertUser(msuser);
	}
	
	public Msuser queryMsuserByid(int id){
		return msuserDao.queryMsuserByid(id);
	}
	
	public void updateMsuser(Msuser msuser){
		msuserDao.updateMsuser(msuser);
	}
	public void deleteMsuserbyid(int id){
		msuserDao.deleteMsuserbyid(id);
	}
	public List<Msuser> queryMsuserbyvo(MsuserVo msuserVo){
		return msuserDao.queryMsuserbyvo(msuserVo);
	}
	
	public Msuser queryMsuserByuseraccount(String useraccount){
		return msuserDao.queryMsuserByuseraccount(useraccount);
	}
	
}
