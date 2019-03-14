package com.hexaware.FTP115.integration.test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import org.junit.Test;


import static org.junit.Assert.*;
import java.text.ParseException;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import static com.jayway.restassured.RestAssured.given;

public class EmployeeRestTest {

	@Test
	public void testEmployeesList() throws AssertionError, URISyntaxException, ParseException{
		  final SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd");
		  final String s1="2018-12-20";
          final Date doj = sdf.parse(s1);
		  final String s2="2017-10-15";
          final Date doj1 = sdf.parse(s2);
		   final String s3="2018-06-10";
          final Date doj2 = sdf.parse(s3);
		   final String s4="2019-01-05";
          final Date doj3 = sdf.parse(s4);
		   final String s5="2018-08-25";
		  final Date doj4 = sdf.parse(s5);
		  final String s6= "2018-10-05";
		  final Date doj5 = sdf.parse(s6);

		Employee[] res = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/employees")).getBody().as(Employee[].class);
				Employee e1=new Employee(1000, "NIKITA SALVE", "NIKITASAL@GMAIL.COM", "7028365639", doj, "HEXAVARSITY", 0, 12);
         Employee e2=new Employee(2000, "OMKAR WAGHE", "OMKARWA@GMAIL.COM", "9587456125", doj1, "INNOVATION", 1000, 20);
         Employee e3=new Employee(3000,"MEGHANA PRA", "MEGHANAP@GMAIL.COM", "7845123698", doj2, "HEXAVARSITY", 1000, 16);
		 Employee e4=new Employee(4000,"BHUVANA MAN", "BHUVANAM@GMAIL.COM", "9865321245", doj3, "HEXAVARSITY", 2000, 17);
		 Employee e5=new Employee(5000,"NIVEDHA ABC", "NIVEDHAGB@GMAIL.COM", "7845562315", doj4, "HEXAVARSITY", 3000, 18);
		 Employee e6=new Employee(6000,"NEHAL SAVANT","NEHAL@GMAIL.COM","70284520",doj5,"HEXAVERSITY",0,20);
		for (Employee e: res) {
	 		switch (e.getEmpId()) {
				case 1000:
					assertEquals(res[0], e1);
					break;
				case 2000:
					assertEquals(res[1], e2);
					break;				
				case 3000:
					assertEquals(res[2], e3);
					break;				
				case 4000:
					assertEquals(res[3], e4);
					break;				
				case 5000:
					assertEquals(res[4], e5);
					break;
					case 6000:
					assertEquals(res[5], e6);
					break;					
				default:
					fail("Unknown employee with id:" + e);	
			}
		}
	 }
	

	@Test
	public void testEmployeeById() throws AssertionError, URISyntaxException, ParseException{
		 SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd");
		 final String s1="2018-12-20";
              final Date doj = sdf.parse(s1);
			   final String s2="2017-10-15";
          final Date doj1 = sdf.parse(s2);
		   final String s3="2018-06-10";
          final Date doj2 = sdf.parse(s3);
		   final String s4="2019-01-05";
          final Date doj3 = sdf.parse(s4);
		   final String s5="2018-08-25";
		  final Date doj4 = sdf.parse(s5);
		  final String s6= "2018-10-05";
		  final Date doj5 = sdf.parse(s6);

			  Employee e1=new Employee(1000, "NIKITA SALVE", "NIKITASAL@GMAIL.COM", "7028365639", doj, "HEXAVARSITY", 0, 12);
			 Employee res0 = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/employees/1000")).getBody().as(Employee.class);
                   assertEquals(e1, res0);

			 Employee e2=new Employee(2000, "OMKAR WAGHE", "OMKARWA@GMAIL.COM", "9587456125", doj1, "INNOVATION", 1000, 20);	
			 Employee res1 = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/employees/2000")).getBody().as(Employee.class);
				assertEquals(e2, res1);

			 Employee e3=new Employee(3000,"MEGHANA PRA", "MEGHANAP@GMAIL.COM", "7845123698", doj2, "HEXAVARSITY", 1000, 16);
			 Employee res2 = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/employees/3000")).getBody().as(Employee.class);
				assertEquals(e3, res2);	

			Employee e4=new Employee(4000,"BHUVANA MAN", "BHUVANAM@GMAIL.COM", "9865321245", doj3, "HEXAVARSITY", 2000, 17);
			Employee res3 = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/employees/4000")).getBody().as(Employee.class);
				assertEquals(e4, res3);

				Employee e5=new Employee(5000,"NIVEDHA ABC", "NIVEDHAGB@GMAIL.COM", "7845562315", doj4, "HEXAVARSITY", 3000, 18);
				Employee res5 = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/employees/5000")).getBody().as(Employee.class);
				assertEquals(e5,res5);

				Employee e6=new Employee(6000,"NEHAL SAVANT","NEHAL@GMAIL.COM","70284520",doj5,"HEXAVERSITY",0,20);
				Employee res6 = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/employees/6000")).getBody().as(Employee.class);
				assertEquals(e6,res6);
		
  }
  
  @Test
	public void testEmployeeById404() throws AssertionError, URISyntaxException {

		given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/employees/9999")).then().assertThat().statusCode(404);
	}
}
