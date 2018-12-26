package com.hexaware.ftp87.integration.test;

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
    public void testLeavesList() throws AssertionError, URISyntaxException {
        LeaveDetails[] res = given().accept(ContentType.JSON).when()
                .get(CommonUtil.getURI("/api/leavedetails")).getBody().as(LeaveDetails[].class);
        for (LeaveDetails e: res) {
            switch (e.getempid()) {
                case 1000:
                    assertEquals(1000, e.getempid());
                    break;
                case 2000:
                    assertEquals(2000, e.getempid());
                    break;              
                case 3000:
                    assertEquals(3000, e.getempid());
                    break;              
                case 4000:
                    assertEquals(4000, e.getempid());
                    break;              
                case 5000:
                    assertEquals(5000, e.getempid());
                    break;          
                default:
                    fail("Unknown LeaveDetails with id:" + e);  
            }
        }
    }
@Test
    public void leavedetailsListPending() throws AssertionError, URISyntaxException {
        LeaveDetails[] res = given().accept(ContentType.JSON).when()
                .get(CommonUtil.getURI("/api/leavedetails/pending/1000")).getBody().as(LeaveDetails[].class);
        if (res.length == 0) {
            assertEquals(0, res.length);
        }
    }

   @Test
     public void testPendingLeaveById404() throws AssertionError, URISyntaxException {
         given().accept(ContentType.JSON).when()
                 .get(CommonUtil.getURI("/api/leavedetails/pending/9999")).then().assertThat().statusCode(200);
     }
   @Test
    public void testLeavHisList() throws AssertionError, URISyntaxException {
         LeaveDetails[] res = given().accept(ContentType.JSON).when()
                 .get(CommonUtil.getURI("/api/leavedetails/history/1000")).getBody().as(LeaveDetails[].class);
         if (res.length == 0) {
             assertEquals(0, res.length);
         }
     }
   @Test
     public void testLeavHisLeaveById404() throws AssertionError, URISyntaxException {
         given().accept(ContentType.JSON).when()
                 .get(CommonUtil.getURI("/api/leavedetails/history/9999")).then().assertThat().statusCode(200);
     }
   @Test
     public void testApplyLeave() throws AssertionError, URISyntaxException {
         String res1=given().accept(ContentType.JSON).contentType("application/json").body("{\"leavesdate\":\"2018-11-29\",\"leaveedate\":\"2018-11-29\",\"leavendays\":\"1\",\"leavereason\":\"sick\",\"leavetype\":\"EL\",\"leaveappliedon\":\"2018-11-29\"}").
         when().post(CommonUtil.getURI("/api/leavedetails/applyleave/1000")).getBody().asString();
         assertEquals("already applied on given date", res1);

        String res2 = given().accept(ContentType.JSON).contentType("application/json").body("{\"leavesdate\":\"2019-12-12\",\"leaveedate\":\"2019-12-10\",\"leavendays\":\"3\",\"leavereason\":\"sick\",\"leavetype\":\"EL\",\"leaveappliedon\":\"2018-11-29\"}").
        when().post(CommonUtil.getURI("/api/leavedetails/applyleave/1000")).getBody().asString();
        assertEquals("StartDate Must be Greater than EndDate...", res2);

        String res3 = given().accept(ContentType.JSON).contentType("application/json").body("{\"leavesdate\":\"2019-12-12\",\"leaveedate\":\"2019-12-12\",\"leavendays\":\"10\",\"leavereason\":\"sick\",\"leavetype\":\"EL\",\"leaveappliedon\":\"2018-11-30\"}").
        when().post(CommonUtil.getURI("/api/leavedetails/applyleave/1000")).getBody().asString();
        assertEquals("NO Of Days Should be right", res3);
        
        String res4 = given().accept(ContentType.JSON).contentType("application/json").body("{\"leavesdate\":\"2019-11-12\",\"leaveedate\":\"2019-12-12\",\"leavendays\":\"30\",\"leavereason\":\"sick\",\"leavetype\":\"EL\",\"leaveappliedon\":\"2018-11-30\"}").
        when().post(CommonUtil.getURI("/api/leavedetails/applyleave/3000")).getBody().asString();
        assertEquals("insufficient leav balance", res4);

        // String res5 = given().accept(ContentType.JSON).contentType("application/json").body("{\"leavesdate\":\"2020-10-11\",\"leaveedate\":\"2020-10-12\",\"leavendays\":\"2\",\"leavereason\":\"sick\",\"leavetype\":\"EL\",\"leaveappliedon\":\"2018-11-30\"}").
        // when().post(CommonUtil.getURI("/api/leavedetails/applyleave/1000")).getBody().asString();
        // assertEquals("Leave AutoApproved Successfully...", res5);

        // String res5 = given().accept(ContentType.JSON).contentType("application/json").body("{\"leavesdate\":\"2020-10-11\",\"leaveedate\":\"2020-10-12\",\"leavendays\":\"2\",\"leavereason\":\"sick\",\"leavetype\":\"EL\",\"leaveappliedon\":\"2018-11-30\"}").
        // when().post(CommonUtil.getURI("/api/leavedetails/applyleave/3000")).getBody().asString();
        // assertEquals("Leave Applied Successfully...", res5);
}
@Test
public void testApplyById200() throws AssertionError, URISyntaxException {
    given().accept(ContentType.JSON).when()
            .get(CommonUtil.getURI("/api/leavedetails/applyleave/9999")).then().assertThat().statusCode(405);
}

@Test
public void testapproveDeny() throws AssertionError, URISyntaxException {
        String res1=given().accept(ContentType.JSON).contentType("application/json").body("{\"leaveid\":\"58\",\"leavestatus\":\"APPROVED\",\"leavemanagercomm\":\"Enjoy\",\"empid\":\"1000\"}").
        when().post(CommonUtil.getURI("/api/leavedetails/Ad/58")).getBody().asString();
        assertEquals("Leave Approved Successfully", res1);

        // String res2=given().accept(ContentType.JSON).contentType("application/json").body("{\"leaveid\":\"59\",\"leavestatus\":\"DENIED\",\"leavemanagercomm\":\"Sorry\",\"empid\":\"1000\"}").
        // when().post(CommonUtil.getURI("/api/leavedetails/Ad/59")).getBody().asString();
        // assertEquals("Leave Rejected", res2);

        String res3=given().accept(ContentType.JSON).contentType("application/json").body("{\"leaveid\":\"23\",\"leavestatus\":\"APPROVED\",\"leavemanagercomm\":\"Enjoy\",\"empid\":\"1000\"}").
        when().post(CommonUtil.getURI("/api/leavedetails/Ad/23")).getBody().asString();
        assertEquals("Invalid leaveid", res3);
    }
    @Test
    public void testapproveDenyById404() throws AssertionError, URISyntaxException {
        given().accept(ContentType.JSON).when()
                .get(CommonUtil.getURI("/api/leavedetails/Ad/9999")).then().assertThat().statusCode(405);
 }
}
