package com.zhouwx.enity;

import java.util.Date;

/**
 * ��ɱ����
 * @author Administrator
 *
 */
public class Msorder {
	private int id;//����
	private int productid;//��ɱ��Ʒid
	private int payamount;//֧�����
	private int userid;//�û�id
	private int merchantid;//�̼�id
	private Date createtime;//����ʱ��
	private Date paytime;//֧��ʱ��
	private int paystatus;//֧��ת̬
	private String receivingaddress;//�ջ��˵�ַ
	private String receivingname;//�ջ�������
	private String receivingphone;//�ջ��˵绰
	private String tradeserialnumber;//������ˮ��
	private int num;//����
	private int paytype;//1����֧����  2����΢��  3��������
	public int getPaytype() {
		return paytype;
	}
	public void setPaytype(int paytype) {
		this.paytype = paytype;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public int getPayamount() {
		return payamount;
	}
	public void setPayamount(int payamount) {
		this.payamount = payamount;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getMerchantid() {
		return merchantid;
	}
	public void setMerchantid(int merchantid) {
		this.merchantid = merchantid;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Date getPaytime() {
		return paytime;
	}
	public void setPaytime(Date paytime) {
		this.paytime = paytime;
	}
	public int getPaystatus() {
		return paystatus;
	}
	public void setPaystatus(int paystatus) {
		this.paystatus = paystatus;
	}
	public String getReceivingaddress() {
		return receivingaddress;
	}
	public void setReceivingaddress(String receivingaddress) {
		this.receivingaddress = receivingaddress;
	}
	public String getReceivingname() {
		return receivingname;
	}
	public void setReceivingname(String receivingname) {
		this.receivingname = receivingname;
	}
	public String getReceivingphone() {
		return receivingphone;
	}
	public void setReceivingphone(String receivingphone) {
		this.receivingphone = receivingphone;
	}
	public String getTradeserialnumber() {
		return tradeserialnumber;
	}
	public void setTradeserialnumber(String tradeserialnumber) {
		this.tradeserialnumber = tradeserialnumber;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	@Override
	public String toString() {
		return "Msorder [id=" + id + ", productid=" + productid + ", payamount=" + payamount + ", userid=" + userid
				+ ", merchantid=" + merchantid + ", createtime=" + createtime + ", paytime=" + paytime + ", paystatus="
				+ paystatus + ", receivingaddress=" + receivingaddress + ", receivingname=" + receivingname
				+ ", receivingphone=" + receivingphone + ", tradeserialnumber=" + tradeserialnumber + ", num=" + num
				+ ", paytype=" + paytype + "]";
	}

	
	
	
	
	
}
