package com.dips.intent;
import java.lang.reflect.Proxy;
public class Ddl {
	public static void main(String args[]){
		Class[] proxyInterfaces=new Class[]{IBusiness.class,IBusiness2.class};
		LogInvocationHandler handler=new LogInvocationHandler(new Business());
		IBusiness2 proxyBusiness=(IBusiness2)Proxy.newProxyInstance(handler.getClass().getClassLoader(), proxyInterfaces, handler);
		proxyBusiness.doSomeThings2();
		((IBusiness)proxyBusiness).doSomeThing();
		
	}
}
