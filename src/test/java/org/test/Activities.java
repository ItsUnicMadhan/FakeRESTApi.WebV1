package org.test;

import static io.restassured.RestAssured.baseURI;

import java.io.IOException;

import org.base.BaseClass;
import org.junit.Before;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author Madhan
 * @Date 30-05-3023
 * @see Activities of FakeRESTApi
 */
public class Activities extends BaseClass {

	/**
	 * @Date 30-05-2023
	 * @throws IOException
	 * @see Before Method for BaseURI
	 */
	@BeforeMethod
	public void beforeMethod() throws IOException {
		baseURI = getPropertyFileValue("baseURI");
	}

	/**
	 * @throws IOException
	 * @Date 30-05-2023
	 * @see To get Activities
	 */
	@Test(priority = 0)
	public void getActivities() throws IOException {
		GET(ACTIVITIES, 200, "[0].title", "Activity 1", "getActivities.json");
	}

	/**
	 * @throws IOException
	 * @Date 30-05-2023
	 * @see To Post New Activity
	 */
	@Test(priority = 1)
	public void postActivities() throws IOException {
		POST("jsonPathOfNewActivities", ACTIVITIES, 200, "title", "New Activity", "postActivities.json");
	}

	/**
	 * @throws IOException
	 * @Date 30-05-2023
	 * @see To get Activities By ID
	 */
	@Test(priority = 2)
	public void getActivitiesById() throws IOException {
		GET(ACTIVITIES_BY_ID, 200, "title", "Activity 1", "postActivities.json");
	}

	/**
	 * @throws IOException
	 * @Date 30-05-2023
	 * @see To Update Activities By ID
	 */
	@Test(priority = 3)
	public void putActivitiesById() throws IOException {
		PUT("jsonPathOfUpdateActivities", ACTIVITIES_BY_ID, 200, "title", "Update Activity", "postActivities.json");
	}

	/**
	 * @Date 30-05-2023
	 * @see To Delete Activities By ID
	 */
	@Test(priority = 4)
	public void deleteActivitiesById() {
		DELETE(ACTIVITIES_BY_ID, 200);
	}

}
