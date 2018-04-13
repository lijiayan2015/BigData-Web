package com.ljy.web.fileupload;

import java.math.BigInteger;
import java.util.Random;

public class GUID {
	private Random random=null;
	public GUID(){
		random = new Random();
	}
	
	public String getToken(){
		return new BigInteger(165,random).toString(36).toUpperCase();
	}
	
}
