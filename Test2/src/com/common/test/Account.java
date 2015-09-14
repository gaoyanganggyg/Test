package com.common.test;

import java.util.concurrent.ConcurrentHashMap;

import com.sun.corba.se.impl.encoding.OSFCodeSetRegistry.Entry;

public class Account {
	int remaining;
	int locked;
	
	ConcurrentHashMap<Integer, Integer> applyDetail = new ConcurrentHashMap<Integer,Integer>();
	ConcurrentHashMap<Integer, Integer> buyDetail = new ConcurrentHashMap<Integer,Integer>();
	
	/**
	 * 前台界面通过ajax显示的剩余可购基金余额
	 */
	public synchronized int getDisplay() {
		return remaining-locked;
	}
	
	/**
	 * 申请购买（剩余可购金额减除，购买信息存入申请详情applyDetail，资金归入locked）
	 * @param userid
	 * @param appliedvalue
	 * @return
	 */
	public synchronized boolean apply(int userid,int appliedvalue) {
		if(appliedvalue>20000 || appliedvalue%1000!=0 || appliedvalue<1000) {
			return false;
		}
		if(appliedvalue>remaining || applyDetail.get(userid)!=null) {
			return false;
		} else {
			remaining -= appliedvalue;
			locked += appliedvalue;
			applyDetail.put(userid, appliedvalue);
			return true;
		}
	}
	
	/**
	 * 付款（锁定资金减除，交易详情由申请订单放入购买订单）
	 * @param userid 用户id
	 * @return
	 */
	public synchronized boolean pay(int userid) {
		Integer value = applyDetail.get(userid);
		if(value==null) {
			return false;
		}
		buyDetail.put(userid, value);
		applyDetail.remove(userid);
		locked -= value;
		return true;
	}
	
	/**
	 * 取消订单
	 * @param userid 用户id
	 * @return 
	 */
	public synchronized boolean cancel(int userid) {
		Integer value = applyDetail.get(userid);
		if(value==null) {
			return false;
		}
		applyDetail.remove(userid);
		remaining+=value;
		locked -= value;
		return true;
	}
	
	/**
	 * 显示信息汇总：
	 * 1. 购买详情
	 * 2. 当前未付款详情
	 */
	public void getSummary() {
		System.out.println("购买详情：");
		for(java.util.Map.Entry<Integer, Integer> entry : buyDetail.entrySet()) {
			System.out.println(entry.getKey()+": "+entry.getValue());
		}
		System.out.println("加入订单未付款详情：");
		for(java.util.Map.Entry<Integer, Integer> entry : applyDetail.entrySet()) {
			System.out.println(entry.getKey()+": "+entry.getValue());
		}
	}
}
