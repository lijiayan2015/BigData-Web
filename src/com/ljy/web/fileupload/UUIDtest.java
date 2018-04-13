package com.ljy.web.fileupload;

import java.util.UUID;

import org.junit.Test;

public class UUIDtest {
	@Test
	public void testUUID() {
		for(int i = 0;i<100;i++){
			System.out.println(UUID.randomUUID().toString());
		}
	}
	
	@Test
	public void testGUID(){
		/*for(int i = 0;i<100;i++){
			System.out.println(new BigInteger(165, new Random()).toString(36).toUpperCase());
		}*/
		
		GUID guid = new GUID();
		for(int i = 0;i<100;i++){
			System.out.println(guid.getToken());
		}
	}
}
