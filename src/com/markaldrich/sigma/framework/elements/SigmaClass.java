package com.markaldrich.sigma.framework.elements;

import java.util.ArrayList;

/**
 * SigmaClass is an abstraction of a Java class in a Sigma script.
 * @author maste
 *
 */
public class SigmaClass extends SigmaElement {
	
	public String name;
	public SigmaAccessModifier access;
	public ArrayList<SigmaGlobalVariable> globalVariables = new ArrayList<>();
	public ArrayList<SigmaMethod> methods = new ArrayList<>();
	
	@Override
	public String toString() {
		if(name == null) System.err.println("Class has null name!");
		if(access == null) System.err.println("Class has null access modifier!");
		String toReturn = "";
		toReturn += (access == SigmaAccessModifier.NONE) ? "" : (access.toString().toLowerCase() + " ");
		toReturn += "class " + name + " {";
		
		for(SigmaGlobalVariable g : globalVariables) {
			toReturn += g.declarationToString();
		}
		
		for(SigmaMethod m : methods) {
			toReturn += m.toString();
		}
		
		toReturn += "}";
		
		return toReturn;
	}
}
