package com.hexaware.FTP115.integration.test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import org.junit.Test;
import static org.junit.Assert.*;
import java.text.ParseException;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import static com.jayway.restassured.RestAssured.given;

public class LeaveDetailsRestTest {
 
 @Test
	public void testLeaveDetailsList() throws AssertionError, URISyntaxException, ParseException{
		  final SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd");
		  final String s1="2019-03-06";
          final Date s = sdf.parse(s1);
		  final String s2="2019-03-06";
          final Date e = sdf.parse(s2);
		   final String s3="2019-02-18";
          final Date l = sdf.parse(s3);
		LeaveDetails res = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/leavedetails/1")).getBody().as(LeaveDetails.class);
				 LeaveDetails l1 = new LeaveDetails(1, 1, s, e, LeaveType.EL, "sick", l, LeaveStatus.APPROVED, "take care", 2000);
		 assertEquals(l1.getLeaId(), res.getLeaId());
     assertEquals(l1.getLeaNoOfDays(), res.getLeaNoOfDays());
    //   assertEquals(l1.getLeaStDate(), res.getLeaStDate());
        //  assertEquals(l1.getLeaEndDate(), res.getLeaEndDate());
          assertEquals(l1.getLeaType(), res.getLeaType());
           assertEquals(l1.getLeaReas(), res.getLeaReas());
        //    assertEquals(l1.getLeaAppOn(), res.getLeaAppOn());
           assertEquals(l1.getLeaStatus(), res.getLeaStatus());
             assertEquals(l1.getLeaMngCmts(), res.getLeaMngCmts());
             

             
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
    final String s4 = "2019-03-08";
    final Date s11 = sdf1.parse(s4);
    final String s5 = "2019-03-06";
    final Date e11 = sdf1.parse(s5);
    final String s6 = "2019-02-18";
    final Date l11 = sdf1.parse(s6);

LeaveDetails res1 = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/leavedetails/2")).getBody().as(LeaveDetails.class);
              LeaveDetails l2 = new LeaveDetails(2, 1, s11, e11, LeaveType.PL, "sick", l11, LeaveStatus.APPROVED, null, 2000);
		 assertEquals(l2.getLeaId(), res1.getLeaId());
     assertEquals(l2.getLeaNoOfDays(), res1.getLeaNoOfDays());
    //   assertEquals(l1.getLeaStDate(), res.getLeaStDate());
        //  assertEquals(l1.getLeaEndDate(), res.getLeaEndDate());
          assertEquals(l2.getLeaType(), res1.getLeaType());
           assertEquals(l2.getLeaReas(), res1.getLeaReas());
        //    assertEquals(l1.getLeaAppOn(), res.getLeaAppOn());
           assertEquals(l2.getLeaStatus(), res1.getLeaStatus());
             assertEquals(l2.getLeaMngCmts(), res1.getLeaMngCmts());
             }

	
    @Test 
    public void testLeaveHistory() throws AssertionError, URISyntaxException,ParseException { 
              
     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
          final String s1 = "2019-03-28";
    final Date s = sdf.parse(s1);
    final String s2 = "2019-03-28";
    final Date e = sdf.parse(s2);
    final String s3 = "2019-02-18";
    final Date l = sdf.parse(s3);
           LeaveDetails[] res = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/leavedetails/leavehistory/3000")).getBody().as(LeaveDetails[].class);
           LeaveDetails l2 = new LeaveDetails(3, 1, s, e, LeaveType.EL, "sick", l, LeaveStatus.REJECTED, "meeting", 3000);
           assertEquals(res[0].getLeaId(), l2.getLeaId());
    }

     @Test 
    public void testLeavePending() throws AssertionError, URISyntaxException,ParseException { 
                       
     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
          final String s1 = "2019-03-12";
    final Date s = sdf.parse(s1);
    final String s2 = "2019-03-12";
    final Date e = sdf.parse(s2);
    final String s3 = "2019-03-11";
    final Date l = sdf.parse(s3);
           LeaveDetails[] res = given().accept(ContentType.JSON).when()
				.get(CommonUtil.getURI("/api/leavedetails/leavepending/2000")).getBody().as(LeaveDetails[].class);
           LeaveDetails l2 = new LeaveDetails(16, 1, s, e, LeaveType.EL, "sick", l, LeaveStatus.PENDING, null, 4000);
           assertEquals(res[0].getLeaId(), l2.getLeaId());
    }

     @Test
    public void testApplyLeave() throws AssertionError, URISyntaxException {
         String res1=given().accept(ContentType.JSON).contentType("application/json").body("{\"leaNoOfDays\":\"1\",\"leaStDate\":\"2019-12-09\",\"leaEndDate\":\"2019-12-08\",\"leaType\":\"EL\",\"leaReas\":\"sick\"}").
        when().post(CommonUtil.getURI("/api/leavedetails/applyleave/3000")).getBody().asString();
    
     assertEquals("enter correct number of days as...0", res1);

     String res2=given().accept(ContentType.JSON).contentType("application/json").body("{\"leaStDate\":\"2020-05-16\",\"leaEndDate\":\"2020-05-14\",\"leaType\":\"EL\",\"leaNoOfDays\":\"3\",\"leaReas\":\"ffff\"}").
        when().post(CommonUtil.getURI("/api/leavedetails/applyleave/2000")).getBody().asString();
    
     assertEquals("StartDate cannot be Saturday or sunday...", res2);

    String res3=given().accept(ContentType.JSON).contentType("application/json").body("{\"leaStDate\":\"2020-05-15\",\"leaEndDate\":\"2020-05-13\",\"leaType\":\"EL\",\"leaNoOfDays\":\"3\",\"leaReas\":\"ffff\"}").
        when().post(CommonUtil.getURI("/api/leavedetails/applyleave/2000")).getBody().asString();
    
     assertEquals("EndDate must be greater than StartDate..", res3);

    String res4=given().accept(ContentType.JSON).contentType("application/json").body("{\"leaStDate\":\"2020-05-13\",\"leaEndDate\":\"2020-05-15\",\"leaType\":\"EL\",\"leaNoOfDays\":\"1\",\"leaReas\":\"ffff\"}").
        when().post(CommonUtil.getURI("/api/leavedetails/applyleave/2000")).getBody().asString();
    
    assertEquals("enter correct number of days as...3", res4);

    String res5=given().accept(ContentType.JSON).contentType("application/json").body("{\"leaStDate\":\"2019-05-09\",\"leaEndDate\":\"2019-05-09\",\"leaType\":\"EL\",\"leaNoOfDays\":\"1\",\"leaReas\":\"ffff\"}").
        when().post(CommonUtil.getURI("/api/leavedetails/applyleave/2000")).getBody().asString();
    
    assertEquals("Already Applied on Given Date...", res5);
}

@Test
    public void testApproveDeny() throws AssertionError, URISyntaxException {
        String res1=given().accept(ContentType.JSON).contentType("application/json").body("{\"leaId\":\"9\",\"leaMngCmts\":\"Enjoy Madi\"}").
        when().post(CommonUtil.getURI("/api/leavedetails/approveDeny/2000/YES")).getBody().asString();
        assertEquals("You are unauthorized to approve the Leave", res1);

        String res2=given().accept(ContentType.JSON).contentType("application/json").body("{\"leaId\":\"9\",\"leaMngCmts\":\"Enjoy Madi\"}").
        when().post(CommonUtil.getURI("/api/leavedetails/approveDeny/1000/YES")).getBody().asString();
        assertEquals("Leave Approved Successfully...", res2);
       
    }

}




