package com.dips.intent;

public class Business implements IBusiness,IBusiness2{

	@Override
	public void doSomeThings2() {
		// TODO Auto-generated method stub
		System.out.println("执行第二个");
	}

	@Override
	public boolean doSomeThing() {
		// TODO Auto-generated method stub
		System.out.println("执行第一个");
		return false;
	}

}
