package com.zhouwx.service.pay;

/**
 * ֧��
 * @author Administrator
 *
 */
public interface Ordertopay {
	
	/**
	 * 
	 * @param tradeserialnumber
	 * @param payamount
	 * @return 1 ����֧���ɹ� 2������֧��ʧ��
	 */
	public int paywithorder(String tradeserialnumber, int payamount);
}
