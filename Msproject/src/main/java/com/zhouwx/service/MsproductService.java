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
import com.zhouwx.dao.MsuserDao;
import com.zhouwx.enity.Msmerchant;
import com.zhouwx.enity.Msproductinfo;
import com.zhouwx.enity.Msuser;
import com.zhouwx.vo.msmerchant.MsmerchantVo;
import com.zhouwx.vo.msproductinfo.ConstomProduct;
import com.zhouwx.vo.msproductinfo.MsProductVo;
import com.zhouwx.vo.msuser.MsuserVo;

@Service
public class MsproductService {
	
	@Autowired
	MsproductDao msproductDao;
	
	/**
	 * ������ɱ��Ʒ
	 * @param msproductinfo
	 */
	public void applymsproduct(Msproductinfo msproductinfo){
		String starttime = msproductinfo.getStarttimestring();//
		String endtime = msproductinfo.getEndtimestring();
		DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date starttimedate = dateformat.parse(starttime);
			msproductinfo.setStarttime(starttimedate);
			Date endtimedate = dateformat.parse(endtime);
			msproductinfo.setEndtime(endtimedate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 msproductinfo.setApplydate(new Date());
		 msproductinfo.setAuditstate(0);
		msproductDao.applymsproduct(msproductinfo);
	}
	
	/**
	 * ��ɱ��Ʒ�б�
	 * @param msproductinfo
	 */
	public List<Msproductinfo> listmsproduct(MsProductVo msProductVo){
		return msproductDao.listmsproduct(msProductVo);
	}
	
	/**
	 * ������ɱ��Ʒid��ѯ��ɱ��Ʒ
	 * @param msproductinfo
	 */
	public Msproductinfo querymsproductByid(int id){
		return msproductDao.querymsproductByid(id);
	}
	
	public Msproductinfo querymsproductByproductid(int productid){
		return msproductDao.querymsproductByproductid(productid);
	}
	
	public void deletemsproductByid(int id){
		msproductDao.deletemsproductByid(id);
	}
	
	public void updatemsproduct(Msproductinfo msproductinfo){
//		String starttime = msproductinfo.getStarttimestring();//
//		String endtime = msproductinfo.getEndtimestring();
//		DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
//		try {
//			Date starttimedate = dateformat.parse(starttime);
//			msproductinfo.setStarttime(starttimedate);
//			Date endtimedate = dateformat.parse(endtime);
//			msproductinfo.setEndtime(endtimedate);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		msproductDao.updatemsproduct(msproductinfo);
	}
	
	/**
	 * ����ת̬
	 * @param id
	 * @param state
	 */
	public void updatemsproductstate(int id,int state){
		MsProductVo msProductVo = new MsProductVo();
		ConstomProduct constomProduct = new ConstomProduct();
		constomProduct.setId(id);
		constomProduct.setAuditstate(state);
		constomProduct.setAuditdate(new Date());
		msProductVo.setConstomProduct(constomProduct);
		msproductDao.updatemsproductstate(msProductVo);
	}
	
	
	
}
