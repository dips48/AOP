package com.dips.bcode;

import java.io.IOException;
import java.lang.instrument.Instrumentation;

import com.dips.intent.Business;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;
public class StartUP {
	public static void main(String args[]) throws AttachNotSupportedException, IOException{
		Business b=new Business();
		b.doSomeThing();
		b.doSomeThings2();
		VirtualMachine vm = VirtualMachine.attach("13712");
	}
}
