package com.zhouwx.dao;

import java.util.List;

import com.zhouwx.enity.Msproductdetail;
import com.zhouwx.enity.Msproductinfo;
import com.zhouwx.vo.msproductinfo.MsProductVo;

public interface MsproductdetailDao {
	public void insertMsproductdetail(Msproductdetail msproductdetail);
	public Msproductdetail queryMsproductdetailByid(int productid);
	public void updateMsproductdetail(Msproductdetail msproductdetail);
}
