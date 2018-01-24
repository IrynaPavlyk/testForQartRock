package com.orange.test;

import com.orange.app.OrangeHRM;
import com.orange.tools.App;
import com.orange.tools.AppTest;

public class AbstractTest implements AppTest {
	
	protected OrangeHRM orangeHRM = new OrangeHRM();
	
	public App getTestedApp() {
		return this.orangeHRM;
	}


}
