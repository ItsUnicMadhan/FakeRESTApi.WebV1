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
 * @see Authors of FakeRESTApi
 */
public class Authors extends BaseClass {

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
	 * @see To get Authors
	 */
	@Test(priority = 0)
	public void getAuthors() throws IOException {
		GET(AUTHORS, 200, "[0].firstName", "First Name 1", "getAuthors.json");
	}

	/**
	 * @throws IOException
	 * @Date 30-05-2023
	 * @see To Post New Authors
	 */
	@Test(priority = 1)
	public void postAuthors() throws IOException {
		POST("jsonPathOfNewAuthors", AUTHORS, 200, "firstName", "Madhan", "postAuthors.json");
	}

	/**
	 * @throws IOException
	 * @Date 30-05-2023
	 * @see To get Authors By Book ID
	 */
	@Test(priority = 2)
	public void getAuthorsByBookId() throws IOException {
		GET(AUTHORS_BY_BOOK_ID, 200, "[0].firstName", "First Name 1", "getAuthors.json");
	}

	/**
	 * @throws IOException
	 * @Date 30-05-2023
	 * @see To get Authors By ID
	 */
	@Test(priority = 3)
	public void getAuthorsById() throws IOException {
		GET(AUTHORS_BY_ID, 200, "firstName", "First Name 1", "postAuthors.json");
	}

	/**
	 * @throws IOException
	 * @Date 30-05-2023
	 * @see To Update Authors By ID
	 */
	@Test(priority = 4)
	public void putAuthorsById() throws IOException {
		PUT("jsonPathOfUpdateAuthors", AUTHORS_BY_ID, 200, "lastName", "Jayaraman", "postAuthors.json");
	}

	/**
	 * @Date 30-05-2023
	 * @see To Delete Authors By ID
	 */
	@Test(priority = 5)
	public void deleteActivitiesById() {
		DELETE(AUTHORS_BY_ID, 200);
	}

}
