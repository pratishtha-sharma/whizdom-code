package dataProvider;

import java.lang.reflect.Method;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider
	public static Object[][] dataSuiteA(ITestContext con, Method m) {
		//System.out.println(m.getName());
		String browsers[] = con.getCurrentXmlTest().getParameter("browsers").split(",");
		System.out.println("----"+browsers[0]+"----");
		System.out.println("----"+browsers[1]+"----");
		
		Object[]  [] data = null;
		if (m.getName().toUpperCase().equals("TESTA")) {
			data = new Object[3][3];
			
			//although the program is running but it is running 3 times, 1- with U1P1, 2- with U2P2, 3- with null
			// need to check why did it run with  null

			// row 1
//			data[0][0] = "Chrome";
			data[0][0] = browsers[0];
			data[0][1] = "U1";
			data[0][2] = "P1";

			// row 2
//			data[1][0] = "Mozilla";
			data[1][0] = browsers[1];
			data[1][1] = "U2";
			data[1][2] = "P2";
		} else if (m.getName().toUpperCase().equals("TESTAA")) {

			data = new Object[3][3];

			// row 1
//			data[0][0] = "Chrome";
			data[0][0] = browsers[0];
			data[0][1] = "A1";
			data[0][2] = "B1";

			// row 2
//			data[1][0] = "Mozilla";
			data[1][0] = browsers[1];
			data[1][1] = "A2";
			data[1][2] = "B2";

		}

		return data;
	}

	@DataProvider
	public static Object[][] dataSuiteB(Method m) {
		System.out.println(m.getName());
		Object[][] data = null;
		if (m.getName().toUpperCase().equals("TESTB")) {
			data = new Object[2][2];

			// row 1
			data[0][0] = "U3";
			data[0][1] = "P3";

			// row 2
			data[1][0] = "U4";
			data[1][1] = "P4";
		} else if (m.getName().toUpperCase().equals("TESTBB")) {

			data = new Object[2][2];

			// row 1
			data[0][0] = "A3";
			data[0][1] = "B3";

			// row 2
			data[1][0] = "A4";
			data[1][1] = "B4";

		}
		return data;
	}

	@DataProvider
	public static Object[][] dataSuiteC(Method m) {
		System.out.println(m.getName());
		Object[][] data = null;
		if (m.getName().toUpperCase().equals("TESTC")) {
			data = new Object[2][2];

			// row 1
			data[0][0] = "U5";
			data[0][1] = "P5";

			// row 2
			data[1][0] = "U6";
			data[1][1] = "P6";
		} else if (m.getName().toUpperCase().equals("TESTCC")) {

			data = new Object[2][2];

			// row 1
			data[0][0] = "A5";
			data[0][1] = "B5";

			// row 2
			data[1][0] = "A6";
			data[1][1] = "B6";

		}

		return data;
	}

}
