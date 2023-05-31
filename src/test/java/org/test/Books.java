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
 * @see Books of FakeRESTApi
 */
public class Books extends BaseClass {

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
	 * @see To get Books
	 */
	@Test(priority = 0)
	public void getBooks() throws IOException {
		GET(BOOKS, 200, "[0].title", "Book 1", "getBooks.json");
	}

	/**
	 * @throws IOException
	 * @Date 30-05-2023
	 * @see To Post New Book
	 */
	@Test(priority = 1)
	public void postBooks() throws IOException {
		POST("jsonPathOfNewBooks", BOOKS, 200, "description", "History of India", "postBooks.json");
	}

	/**
	 * @throws IOException
	 * @Date 30-05-2023
	 * @see To get Books By ID
	 */
	@Test(priority = 2)
	public void getBooksById() throws IOException {
		GET(BOOKS_BY_ID, 200, "title", "Book 1", "postBooks.json");
	}

	/**
	 * @throws IOException
	 * @Date 30-05-2023
	 * @see To Update Books By ID
	 */
	@Test(priority = 3)
	public void putActivitiesById() throws IOException {
		PUT("jsonPathOfUpdateBooks", BOOKS_BY_ID, 200, "title", "New India", "postBooks.json");
	}

	/**
	 * @Date 30-05-2023
	 * @see To Delete Books By ID
	 */
	@Test(priority = 4)
	public void deleteBooksById() {
		DELETE(BOOKS_BY_ID, 200);
	}

}
