package dataProvider;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class TestDataProvider {
	
	@DataProvider
	public static Object[][] dataSuiteA(Method m) {
		Object data[][]=null;
		if (m.getName().equals("TestA")) {
			data = new Object[2][2];
			//row 1
			data[0][0]="U1";
			data[0][1]="P1";
			//row 2
			data[1][0]="U2";
			data[1][1]="P2";
	
		}else if(m.getName().equals("TestAA")) {
			data = new Object[2][2];
			//row 1
			data[0][0]="U3";
			data[0][1]="P3";
			//row 2
			data[1][0]="U4";
			data[1][1]="P4";
	
		}
		return data;
		
	}
	
	
	@DataProvider
	public static Object[][] dataSuiteB(Method m) {
		Object data[][]=null;
		if (m.getName().equals("TestB")) {
			data = new Object[2][2];
			//row 1
			data[0][0]="U5";
			data[0][1]="P5";
			//row 2
			data[1][0]="U6";
			data[1][1]="P6";
	
		}else if(m.getName().equals("TestBB")) {
			data = new Object[2][2];
			//row 1
			data[0][0]="U7";
			data[0][1]="P7";
			//row 2
			data[1][0]="U8";
			data[1][1]="P8";
	
		}
		return data;
		
	}
	
	@DataProvider
	public static Object[][] dataSuiteC(Method m) {
		Object data[][]=null;
		if (m.getName().equals("TestC")) {
			data = new Object[2][2];
			//row 1
			data[0][0]="U9";
			data[0][1]="P9";
			//row 2
			data[1][0]="U10";
			data[1][1]="P10";
	
		}else if(m.getName().equals("TestCC")) {
			data = new Object[2][2];
			//row 1
			data[0][0]="U11";
			data[0][1]="P11";
			//row 2
			data[1][0]="U12";
			data[1][1]="P12";
	
		}
		return data;
		
	}
	

}
