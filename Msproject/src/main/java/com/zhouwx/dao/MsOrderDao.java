package com.zhouwx.dao;

import java.util.List;

import com.zhouwx.enity.Msorder;
import com.zhouwx.vo.order.MsorderVo;

public interface MsOrderDao {
	public void insertMsOrder(Msorder msorder);
	public List<Msorder> queryorderbyuserid(int userid);
	public void updateorderpaystatusbyid(MsorderVo msorderVo);
	public List<Msorder> queryorderbymerchantid(int merchantid);
	public List<Msorder> queryorderbymerchantaccount(String merchantaccount);
	public Msorder queryorderbyid(int id);
}
