package com.zhouwx.dao;

import java.util.List;

import com.zhouwx.enity.Msproductinfo;
import com.zhouwx.vo.msproductinfo.MsProductVo;

public interface MsproductDao {
	public void applymsproduct(Msproductinfo msproductinfo);
	public List<Msproductinfo> listmsproduct(MsProductVo msProductVo);
	public Msproductinfo querymsproductByid(int id);
	public Msproductinfo querymsproductByproductid(int productid);
	public void deletemsproductByid(int id);
	public void updatemsproduct(Msproductinfo msproductinfo);
	public void updatemsproductstate(MsProductVo msProductVo);
}
