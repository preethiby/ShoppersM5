package TestCases;

import org.testng.annotations.Test;

import Utilities.BaseClass;

public class AddToCart2 extends BaseClass {
		
		@Test
		public void Tc_add_001() {
			System.out.println("new testcase");
			
			String Name=System.getProperty("Name");
			System.out.println(Name);
			System.out.println(Name);
			System.out.println(Name);
			System.out.println(Name);
		}
	}
	
// maven cmd = mvn -Dtest=className test

