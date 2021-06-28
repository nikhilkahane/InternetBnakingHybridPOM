package com.ibanking.utilities;

import org.omg.PortableInterceptor.TRANSPORT_RETRY;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.ibanking.base.TestBase;

public class RetryAnalyzer extends TestBase implements IRetryAnalyzer{
	
	int counter = 0;
	int retrylimit = 1;
	
	public boolean retry(ITestResult result) {
		if(counter<retrylimit) {
			counter++;
			return true;
		}
		return false;
	}

}
