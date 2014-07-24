package com.dips.intent;
import java.lang.reflect.InvocationHandler;  
import java.lang.reflect.Method;
public class LogInvocationHandler implements InvocationHandler{
	
	private Object target;
	LogInvocationHandler(Object target){
		this.target=target;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object rev=method.invoke(target, args);
		if(method.getName().equals("doSomeThings2")){
			System.out.println("¼ÇÂ¼ÖÐ¡£¡£¡£");
		}
		return null;
	}

}
