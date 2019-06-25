package com.zhouwx.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhouwx.dao.MsmerchantDao;
import com.zhouwx.dao.MsproductDao;
import com.zhouwx.dao.MsproductdetailDao;
import com.zhouwx.dao.MsuserDao;
import com.zhouwx.enity.Msmerchant;
import com.zhouwx.enity.Msproductdetail;
import com.zhouwx.enity.Msproductinfo;
import com.zhouwx.enity.Msuser;
import com.zhouwx.vo.msmerchant.MsmerchantVo;
import com.zhouwx.vo.msproductinfo.ConstomProduct;
import com.zhouwx.vo.msproductinfo.MsProductVo;
import com.zhouwx.vo.msuser.MsuserVo;

@Service
public class MsproductDetailService {
	
	@Autowired
	MsproductdetailDao msproductdetailDao;
	
	public void insertMsproductdetail(Msproductdetail msproductdetail){
		msproductdetailDao.insertMsproductdetail(msproductdetail);
	}
	public Msproductdetail queryMsproductdetailByid(int productid){
		return msproductdetailDao.queryMsproductdetailByid(productid);
	}
	public void updateMsproductdetail(Msproductdetail msproductdetail){
		msproductdetailDao.updateMsproductdetail(msproductdetail);
	}
	
}
