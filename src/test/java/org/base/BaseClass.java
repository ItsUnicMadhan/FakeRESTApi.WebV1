package org.base;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.endpoint.Endpoints;

import io.restassured.http.ContentType;

/**
 * @date 29-05-2023
 * @author Madhan
 * @see To maintain the genrics and Reusuable methods
 *
 */
public class BaseClass implements Endpoints {

	/**
	 * @date 29-05-2023
	 * @param value
	 * @return String value
	 * @throws IOException
	 * @see To read the File and get the value
	 */
	public static String getPropertyFileValue(String value) throws IOException {
		FileInputStream file = new FileInputStream("Config\\config.properties");
		Properties p = new Properties();
		p.load(file);
		return p.getProperty(value);
	}

	/**
	 * @date 29-05-2023
	 * @param param
	 * @param statusCode
	 * @param jsonObj
	 * @param value
	 * @see GET Method
	 */
	public void GET(String param, int statusCode, String jsonObj, String value) {
		given().header("accept", "application/json").get(param).then().assertThat().statusCode(statusCode)
				.body(jsonObj, equalTo(value)).log().all();
	}

	/**
	 * @date 29-05-2023
	 * @param responseBody
	 * @param param
	 * @param statusCode
	 * @param jsonObj
	 * @param value
	 * @throws IOException
	 * @see POST Method
	 */
	public void POST(String responseBody, String param, int statusCode, String jsonObj, String value)
			throws IOException {
		given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(new File(getPropertyFileValue(responseBody))).when().post(param).then().assertThat()
				.statusCode(statusCode).body(jsonObj, equalTo(value)).log().all();
	}

	/**
	 * @date 29-05-2023
	 * @param param
	 * @param statusCode
	 * @param jsonObj
	 * @param value
	 * @param responseBody
	 * @throws IOException
	 * @see PATCH Method
	 */
	public void PATCH(String responseBody, String param, int statusCode, String jsonObj, String value)
			throws IOException {
		given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(new File(getPropertyFileValue(responseBody))).when().patch(param).then().assertThat()
				.statusCode(statusCode).body(jsonObj, equalTo(value)).log().all();
	}

	/**
	 * @date 29-05-2023
	 * @param param
	 * @param statusCode
	 * @param jsonObj
	 * @param value
	 * @param responseBody
	 * @throws IOException
	 * @see PUT Method
	 */
	public void PUT(String responseBody, String param, int statusCode, String jsonObj, String value)
			throws IOException {
		given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(new File(getPropertyFileValue(responseBody))).when().put(param).then().assertThat()
				.statusCode(statusCode).body(jsonObj, equalTo(value)).log().all();
	}

	/**
	 * @date 29-05-2023
	 * @param param
	 * @param statusCode
	 * @see DELETE Method
	 */
	public void DELETE(String param, int statusCode) {
		given().when().delete(param).then().assertThat().statusCode(statusCode).log().all();
	}

}