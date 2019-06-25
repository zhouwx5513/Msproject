package com.zhouwx.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhouwx.enity.Msproductdetail;
import com.zhouwx.enity.Msproductinfo;
import com.zhouwx.service.MsoderService;
import com.zhouwx.service.MsproductDetailService;
import com.zhouwx.service.MsproductService;
import com.zhouwx.vo.msproductinfo.ConstomProduct;
import com.zhouwx.vo.msproductinfo.MsProductVo;

@Controller
@RequestMapping("pagehomeAction")
public class PagehomeAction {
	
	
	@Autowired
	private MsoderService msoderService;
	
	
	@Autowired
	private MsproductDetailService msproductDetailService;
	
	@Autowired
	private MsproductService msproductService;
	
	@RequestMapping("tohome")
	public String tohome(HttpServletRequest req){
		System.out.println("hahasdd");
		MsProductVo msProductVo = new MsProductVo();
		ConstomProduct constomProduct = new ConstomProduct();
		Date now = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowstring = dateFormat.format(now);
		constomProduct.setStartendtime(nowstring);
		constomProduct.setAuditstate(1);
		msProductVo.setConstomProduct(constomProduct);
		
//		private Date startstarttime;//秒杀开始时间查询范围开始时间
//		private Date endstarttime;//秒杀开始时间查询范围结束时间
		
//		private String startstarttime;//秒杀开始时间查询范围开始时间
//		private String endstarttime;//秒杀开始时间查询范围结束时间
//		private String startendtime;//秒杀结束时间查询范围开始时间	
//		private String endendtime;//秒杀结束时间查询范围结束时间
		
//		msProductVo.setConstomProduct(constomProduct);
		List<Msproductinfo> list = msproductService.listmsproduct(msProductVo);
		req.setAttribute("list", list);
		return "homepage/homepage";
		
		
	}
	
	
	@RequestMapping("viewproductdetail")
	public String viewproductdetail(HttpServletRequest req,int id, int productid){
		Msproductinfo msproduct = msproductService.querymsproductByid(id);
		Msproductdetail msproductdetail = msproductDetailService.queryMsproductdetailByid(productid);
		req.setAttribute("msproduct", msproduct);
		req.setAttribute("msproductdetail", msproductdetail);
		return "order/selldetail";
	}
	
}
