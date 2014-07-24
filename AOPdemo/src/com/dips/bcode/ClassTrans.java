package com.dips.bcode;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

public class ClassTrans implements ClassFileTransformer{
	public static void premain(String agentArgs, Instrumentation inst){
		inst.addTransformer(new ClassTrans());
	}

	@Override
	public byte[] transform(ClassLoader loader, String className,
			Class<?> classBeingRedefined, ProtectionDomain protectionDomain,
			byte[] classfileBuffer) throws IllegalClassFormatException {
		// TODO Auto-generated method stub
		try{
			CtClass cc=ClassPool.getDefault().get(className);
			CtMethod m=cc.getDeclaredMethod("doSomenThing");
			m.insertBefore("{System.out.println(\"¼ÇÂ¼ÈÕÖ¾\");}");
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
}
