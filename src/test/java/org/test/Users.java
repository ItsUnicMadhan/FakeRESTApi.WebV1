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
 * @see Users of FakeRESTApi
 */
public class Users extends BaseClass {

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
	 * @see To get Users
	 */
	@Test(priority = 0)
	public void getUsers() throws IOException {
		GET(USERS, 200, "[0].userName", "User 1", "getUsers.json");
	}

	/**
	 * @throws IOException
	 * @Date 30-05-2023
	 * @see To Post New User
	 */
	@Test(priority = 1)
	public void postUsers() throws IOException {
		POST("jsonPathOfNewUsers", USERS, 200, "userName", "Madhan", "postUsers.json");
	}

	/**
	 * @throws IOException
	 * @Date 30-05-2023
	 * @see To get Users By ID
	 */
	@Test(priority = 2)
	public void getUsersById() throws IOException {
		GET(USERS_BY_ID, 200, "password", "Password1", "postUsers.json");
	}

	/**
	 * @throws IOException
	 * @Date 30-05-2023
	 * @see To Update Users By ID
	 */
	@Test(priority = 3)
	public void putUsersById() throws IOException {
		PUT("jsonPathOfUpdateUsers", USERS_BY_ID, 200, "userName", "Madhan J", "postUsers.json");
	}

	/**
	 * @Date 30-05-2023
	 * @see To Delete Users By ID
	 */
	@Test(priority = 4)
	public void deleteUsersById() {
		DELETE(USERS_BY_ID, 200);
	}

}
