package com.dips.dynamtic;
import java.lang.reflect.Method;

import com.dips.intent.Business;
import com.dips.intent.IBusiness;
import com.dips.intent.IBusiness2;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
public class Dl {
	public static class LogIntercept implements MethodInterceptor{

		@Override
		public Object intercept(Object arg0, Method arg1, Object[] arg2,
				MethodProxy arg3) throws Throwable {
			if(arg1.getName().equals("doSomeThings2")){
				System.out.println("记录日志中");
			}
			Object rev=arg3.invokeSuper(arg0, arg2);
			return rev;
		}
		
	}
	
	public static void main(String args[]){
		byteCode();
	}
	public static void byteCode(){
		Enhancer en=new Enhancer();
		en.setSuperclass(Business.class);
		en.setCallback(new LogIntercept());
		IBusiness2 nb=(IBusiness2)en.create();
		nb.doSomeThings2();
		
		
	}
}
