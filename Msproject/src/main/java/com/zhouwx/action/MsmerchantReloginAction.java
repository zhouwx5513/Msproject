package com.zhouwx.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhouwx.enity.Msmerchant;
import com.zhouwx.enity.Msuser;
import com.zhouwx.service.MsUserService;
import com.zhouwx.service.MsmerchantService;
import com.zhouwx.vo.msmerchant.MsmerchantVo;
import com.zhouwx.vo.msuser.MsuserVo;

/**
 * �̼�ע���¼ģ��
 * @author Administrator
 *
 */
@Controller
@RequestMapping("msmerchantReloginAction")
public class MsmerchantReloginAction {
	
	@Autowired
	MsmerchantService msmerchantService;
	
	@RequestMapping(value = "toregiter")
	public String toregiter(){
		return "msmerchant/toregiter";
	}
	
	@RequestMapping(value = "regiter",method=RequestMethod.POST)
	public String regiter(HttpServletRequest req,Msmerchant msmerchant){
		msmerchantService.insertMsmerchant(msmerchant);
		HttpSession sess = req.getSession();
		sess.setAttribute("msmerchant", msmerchant);
		return "adminpagehome/homepage";
	}
	
	@RequestMapping(value = "tologin")
	public String tologin(HttpServletRequest req,Msuser msuser){
		
		return "msmerchant/tologin";
	}
	
	@RequestMapping(value = "login",method=RequestMethod.POST)
	public String login(HttpServletRequest req,Msuser msuser){
		String returnurl = "adminpagehome/error";
		String account = msuser.getUseraccount();
		String password = msuser.getUserpassword();
		Msmerchant msmerchant = msmerchantService.queryMsmerchantByaccount(account);
		if(msmerchant == null ){
			System.out.println("�޴��̼�");
			req.setAttribute("errorinfo", "�޴��̼�");
		}else if(!msmerchant.getMerchantpassword().equals(password)){
			System.out.println("�̼��������");
			req.setAttribute("errorinfo", "�̼��������");
		}else{
			HttpSession sess = req.getSession();
			sess.setAttribute("msmerchant", msmerchant);
			if(sess.getAttribute("msmerchant") instanceof Msmerchant)
				System.out.println("msmerchant session ����");
			returnurl = "adminpagehome/homepage";
		}
		return returnurl;
	}
	
	@RequestMapping(value = "exit")
	public String exit(HttpServletRequest req){
		HttpSession sess = req.getSession();
		sess.removeAttribute("msmerchant");
		return "adminpagehome/homepage";
	}
	
	
	
	
	
}
