package com.zhouwx.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhouwx.dao.MsOrderDao;
import com.zhouwx.enity.Msorder;
import com.zhouwx.vo.order.ConstomOrder;
import com.zhouwx.vo.order.MsorderVo;

@Service
public class MsoderService {
	
	@Autowired
	MsOrderDao msOrderDao;
	
	public void insertMsOrder(Msorder msorder){
		msOrderDao.insertMsOrder(msorder);
	}
	
	public List<Msorder> queryorderbyuserid(int userid){
		return msOrderDao.queryorderbyuserid(userid);
	}
	
	public List<Msorder> queryorderbymerchantid(int merchantid){
		return msOrderDao.queryorderbymerchantid(merchantid);
	}
	
	public List<Msorder> queryorderbymerchantaccount(String merchantaccount){
		return msOrderDao.queryorderbymerchantaccount(merchantaccount);
	}
	
	public Msorder queryorderbyid(int id) {
		return msOrderDao.queryorderbyid(id);
	}
	
	public void updateorderpaystatusbyid(int paystatus,int id,int paytype,Date date){
		MsorderVo msorderVo = new MsorderVo();
		ConstomOrder constomOrder = new ConstomOrder();
		constomOrder.setPaystatus(paystatus);
		constomOrder.setId(id);
		constomOrder.setPaystatus(paystatus);
		constomOrder.setPaytype(paytype);
		constomOrder.setPaytime(date);
		msorderVo.setConstomOrder(constomOrder);
		msOrderDao.updateorderpaystatusbyid(msorderVo);
	}

	
	
}
