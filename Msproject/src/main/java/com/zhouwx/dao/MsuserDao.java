package com.zhouwx.dao;

import java.util.List;

import com.zhouwx.enity.Msmerchant;
import com.zhouwx.enity.Msuser;
import com.zhouwx.vo.msmerchant.MsmerchantVo;
import com.zhouwx.vo.msuser.MsuserVo;

public interface MsuserDao {
	public void insertUser(Msuser msuser);
	public Msuser queryMsuserByid(int id);
	public void updateMsuser(Msuser msuser);
	public void deleteMsuserbyid(int id);
	public List<Msuser> queryMsuserbyvo(MsuserVo msuserVo);
	public Msuser queryMsuserByuseraccount(String useraccount);
}
