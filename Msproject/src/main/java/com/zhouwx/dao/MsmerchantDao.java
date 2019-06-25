package com.zhouwx.dao;

import java.util.List;

import com.zhouwx.enity.Msmerchant;
import com.zhouwx.vo.msmerchant.MsmerchantVo;

public interface MsmerchantDao {
	public void insertMsmerchant(Msmerchant msmerchant);
	public Msmerchant queryMsmerchantByid(int id);
	public void updateMsmerchant(Msmerchant msmerchant);
	public void deleteMsmerchantbyid(int id);
	public List<Msmerchant> queryMsmerchantbyvo(MsmerchantVo msmerchantVo);
	public Msmerchant queryMsmerchantByaccount(String account);
}
