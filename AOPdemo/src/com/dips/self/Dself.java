package com.dips.self;

import com.dips.intent.Business;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;
import javassist.Translator;
import javassist.tools.reflect.Loader;

public class Dself {
	public static void main(String args[]) throws Throwable{
		ClassPool cp=ClassPool.getDefault();
		Loader cl=new Loader();
		cl.addTranslator(cp, new MyTranslator());
		cl.run("com.dips.self.Dself$MyTranslator",args);
		
	}
	public static class MyTranslator implements Translator{

		@Override
		public void onLoad(ClassPool arg0, String arg1)
				throws NotFoundException, CannotCompileException {
			// TODO Auto-generated method stub
			 if (!"com.dips.intent.Business".equals(arg1)) {
	                return;
	            }
			try{
				CtClass cc=arg0.get(arg1);
				CtMethod m=cc.getDeclaredMethod("doSomeThing");
				m.insertBefore("{System.out.println(\"¼ÇÂ¼ÈÕÖ¾\");}");
			}catch(Exception e){
				return;
			}
		}

		@Override
		public void start(ClassPool arg0) throws NotFoundException,
				CannotCompileException {
			// TODO Auto-generated method stub
		}
		public static void main(String args[]){
			Business b=new Business();
			b.doSomeThing();
			b.doSomeThings2();
		}
	}

}
