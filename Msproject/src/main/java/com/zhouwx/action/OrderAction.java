package com.zhouwx.action;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhouwx.enity.Msmerchant;
import com.zhouwx.enity.Msorder;
import com.zhouwx.enity.Msproductinfo;
import com.zhouwx.enity.Msuser;
import com.zhouwx.service.MsmerchantService;
import com.zhouwx.service.MsoderService;
import com.zhouwx.service.MsproductService;
import com.zhouwx.service.pay.WeixinPay;
import com.zhouwx.service.pay.Yinghangkapay;
import com.zhouwx.service.pay.ZhifubaoPay;

@Controller
@RequestMapping("orderAction")
public class OrderAction {
	
	@Autowired
	MsoderService msoderService;
	
	@Autowired
	MsmerchantService msmerchantService;
	
	@Autowired
	MsproductService msproductService;
	
	@Autowired
	WeixinPay weixinPay;
	
	@Autowired
	Yinghangkapay yinghangkapay;
	
	@Autowired
	ZhifubaoPay zhifubaoPay;
	
  @RequestMapping("payorder")
  public String payorder(Msorder msorder){
	  Date now = new Date();
	  System.out.println("payorder");
	  msorder.setCreatetime(now);
	  int paystatus = 1;
	  msorder.setPaystatus(paystatus);
	  String tradeserialnumber = UUID.randomUUID().toString();
	  msorder.setTradeserialnumber(tradeserialnumber);
	  msoderService.insertMsOrder(msorder);
	  Msproductinfo msproductinfo = msproductService.querymsproductByproductid(msorder.getProductid());
	  System.out.println(msproductinfo);
	  System.out.println(msorder.getProductid());
	  System.out.println(msorder.getNum());
	  System.out.println(msproductinfo.getStockcount());
	  System.out.println(msproductinfo.getProductcount());
	  
	  
	  msproductinfo.setStockcount(msproductinfo.getStockcount()-msorder.getNum());
	  msproductinfo.setProductcount(msproductinfo.getProductcount()-msorder.getNum());
	  msproductService.updatemsproduct(msproductinfo);
	  return "redirect:/pagehomeAction/tohome";
	  
  }
  
  
  @RequestMapping("topayorder")
  public String topayorder(HttpServletRequest req,int id,int num){
	  Msproductinfo msproductinfo = msproductService.querymsproductByid(id);
	  req.setAttribute("msproductinfo", msproductinfo);
	  req.setAttribute("productnum", num);
	  int payamount = num * msproductinfo.getMiaoshaprice();
	  req.setAttribute("payamount", payamount);
	  HttpSession sess = req.getSession();
	  Msuser msuser = (Msuser) sess.getAttribute("msuser");
	  if(msuser != null ){
		  req.setAttribute("msuserid", msuser.getId());
	  }else{
		  req.setAttribute("error", "未登录");
		//  return "user/tologin";
		  return "redirect:/userregiterloginAction/tologin";
	  }
	  return "order/payorder";
	  
  }
  
  @RequestMapping("queryorderbyuserid")
  public String queryorderbyuserid(HttpServletRequest req){
	  String returnurl = "order/listOrder";
	  HttpSession sess = req.getSession();
	  Msuser msuser = (Msuser) sess.getAttribute("msuser");
	  if(msuser!=null){
		  List<Msorder> list = msoderService.queryorderbyuserid(msuser.getId());
		  req.setAttribute("list", list);
	  }else{
		  req.setAttribute("error", "未登陆");
		//  returnurl = "user/tologin";
		  return "redirect:/userregiterloginAction/tologin";
	  }
	 
	  return returnurl;
	  
  }
  
  
  @RequestMapping("queryorderbyMsmerchanid")
  public String queryorderbyMsmerchanid(HttpServletRequest req){
	  String returnurl = "order/listOrderwithmerchat";
	  HttpSession sess = req.getSession();
	  Msmerchant msmerchant = (Msmerchant) sess.getAttribute("msmerchant");
	  System.out.println("haha");
	  System.out.println(msmerchant);
	  if(msmerchant!=null){
		//  List<Msorder> list = msoderService.queryorderbymerchantid(msmerchant.getId());
		  List<Msorder> list = msoderService.queryorderbymerchantaccount(msmerchant.getMerchantaccount());
		  System.out.println(list);
		  req.setAttribute("list", list);
	  }else{
		  req.setAttribute("error", "未登陆");
		  returnurl = "msmerchant/tologin";
	  }
	 
	  return returnurl;
	  
  }
  
  /**
   * 跳转到支付页面
   * @param req
   * @param paytype 1代表支付宝  2代表微信  3代表银联
   * @param tradeserialnumber
   * @param payamount
   * @return
   */
  @RequestMapping("topaywithorder")
  public String topaywithorder(HttpServletRequest req,int id,String tradeserialnumber, int payamount){
	  req.setAttribute("id", id);
	  req.setAttribute("tradeserialnumber", tradeserialnumber);
	  req.setAttribute("payamount", payamount);
	  return "order/payreal";
	  
  }
  /**  
  * 
  * @param req
  * @param paytype 1代表支付宝  2代表微信  3代表银联
  * @param tradeserialnumber
  * @param payamount
  * @return
  */
 @RequestMapping(value="paywithorder",method=RequestMethod.POST)
 public String paywithorder(HttpServletRequest req,int paytype,int id,String tradeserialnumber, int payamount){
	  int paystatus = 2;
	  if(paytype == 1){//1代表支付宝
		  paystatus = zhifubaoPay.paywithorder(tradeserialnumber, payamount);
	  }else if(paytype == 2){//2代表微信
		  paystatus = weixinPay.paywithorder(tradeserialnumber, payamount);
	  }else if(paytype == 3){//3是代表银联
		  paystatus = yinghangkapay.paywithorder(tradeserialnumber, payamount);
	  }
	  if(paystatus == 1){
		  msoderService.updateorderpaystatusbyid(2,id,paytype,new Date());
	  }
	  return "redirect:queryorderbyuserid";
	  
 }
 
 @RequestMapping("applyrefund")
 public String applyrefund(HttpServletRequest req,int orderid,int paytype){
	  String returnurl = "redirect:queryorderbyuserid";
	  HttpSession sess = req.getSession();
	  Msuser msuser = (Msuser) sess.getAttribute("msuser");
	  if(msuser!=null){
		  msoderService.updateorderpaystatusbyid(4, orderid, paytype, new Date());
	  }else{
		  req.setAttribute("error", "未登陆");
		  returnurl = "user/tologin";
	  }
	  
	  return returnurl; 
 }
 
 
 @RequestMapping("auditrefund")
 public String auditrefund(HttpServletRequest req,String tradeserialnumber,int payamount,int orderid,int paytype,int paystatus){
	  String returnurl = "redirect:queryorderbyMsmerchanid";
	  HttpSession sess = req.getSession();
	  Msmerchant msmerchant = (Msmerchant) sess.getAttribute("msmerchant");
	  if(msmerchant!=null){
		  if(paystatus == 3){
			  int paystatustemp = 2;
			  if(paytype == 1){//1代表支付宝
				  paystatustemp = zhifubaoPay.refundwithorder(tradeserialnumber, payamount);
			  }else if(paytype == 2){//2代表微信
				  paystatustemp = weixinPay.refundwithorder(tradeserialnumber, payamount);
			  }else if(paytype == 3){//3是代表银联
				  paystatustemp = yinghangkapay.refundwithorder(tradeserialnumber, payamount);
			  }
			  if(paystatustemp == 1){//退款成功
				  msoderService.updateorderpaystatusbyid(paystatus, orderid, paytype, new Date());
				  
				  Msproductinfo msproductinfo = msproductService.querymsproductByproductid(msoderService.queryorderbyid(orderid).getProductid());
				  msproductinfo.setStockcount(msproductinfo.getStockcount()+msoderService.queryorderbyid(orderid).getNum());
				  msproductinfo.setProductcount(msproductinfo.getProductcount()+msoderService.queryorderbyid(orderid).getNum());
				  msproductService.updatemsproduct(msproductinfo);
				
			  }
			  
		  }else if(paystatus == 5){//退款失败
			  msoderService.updateorderpaystatusbyid(paystatus, orderid, paytype, new Date());
		  }
	  }else{
		  req.setAttribute("error", "未登陆");
		  returnurl = "msmerchant/tologin";
	  }
	  
	  return returnurl; 
 }
 
  
}
