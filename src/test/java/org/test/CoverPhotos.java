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
 * @see CoverPhotos of FakeRESTApi
 */
public class CoverPhotos extends BaseClass {

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
	 * @see To get Cover Photos
	 */
	@Test(priority = 0)
	public void getCoverPhotos() throws IOException {
		GET(COVER_PHOTOS, 200, "[0].url", "https://placeholdit.imgix.net/~text?txtsize=33&txt=Book 1&w=250&h=350", "getCoverPhotos.json");
	}

	/**
	 * @throws IOException
	 * @Date 30-05-2023
	 * @see To Post New Cover Photo
	 */
	@Test(priority = 1)
	public void postCoverPhotos() throws IOException {
		POST("jsonPathOfNewCoverPhotos", COVER_PHOTOS, 200, "url", "www.google.com", "postCoverPhotos.json");
	}

	/**
	 * @throws IOException 
	 * @Date 30-05-2023
	 * @see To get Cover Photo By Book ID
	 */
	@Test(priority = 2)
	public void getCoverPhotosByBookId() throws IOException {
		GET(COVER_PHOTOS_BY_BOOK_ID, 200, "[0].url",
				"https://placeholdit.imgix.net/~text?txtsize=33&txt=Book 1&w=250&h=350", "getCoverPhotos.json");
	}

	/**
	 * @throws IOException 
	 * @Date 30-05-2023
	 * @see To get Cover Photos By ID
	 */
	@Test(priority = 3)
	public void getCoverPhotosById() throws IOException {
		GET(COVER_PHOTOS_BY_ID, 200, "url", "https://placeholdit.imgix.net/~text?txtsize=33&txt=Book 1&w=250&h=350", "postCoverPhotos.json");
	}

	/**
	 * @throws IOException
	 * @Date 30-05-2023
	 * @see To Update Cover Photo By ID
	 */
	@Test(priority = 4)
	public void putCoverPhotosById() throws IOException {
		PUT("jsonPathOfUpdateCoverPhotos", COVER_PHOTOS_BY_ID, 200, "url", "www.india.com", "postCoverPhotos.json");
	}

	/**
	 * @Date 30-05-2023
	 * @see To Delete Cover Photo By ID
	 */
	@Test(priority = 5)
	public void deleteCoverPhotosById() {
		DELETE(COVER_PHOTOS_BY_ID, 200);
	}

}
