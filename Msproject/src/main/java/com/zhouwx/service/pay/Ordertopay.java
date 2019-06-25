package com.zhouwx.service.pay;

/**
 * 支付
 * @author Administrator
 *
 */
public interface Ordertopay {
	
	/**
	 * 
	 * @param tradeserialnumber
	 * @param payamount
	 * @return 1 代表支付成功 2，代表支付失败
	 */
	public int paywithorder(String tradeserialnumber, int payamount);
}
