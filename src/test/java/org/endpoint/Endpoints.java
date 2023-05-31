package org.endpoint;

public interface Endpoints {
	public final static String ACTIVITIES = "v1/Activities";
	public final static String ACTIVITIES_BY_ID = "v1/Activities/1";

	public final static String AUTHORS = "v1/Authors";
	public final static String AUTHORS_BY_BOOK_ID = "v1/Authors/authors/books/1";
	public final static String AUTHORS_BY_ID = "v1/Authors/1";

	public final static String BOOKS = "v1/Books";
	public final static String BOOKS_BY_ID = "v1/Books/1";

	public final static String COVER_PHOTOS = "v1/CoverPhotos";
	public final static String COVER_PHOTOS_BY_BOOK_ID = "v1/CoverPhotos/books/covers/1";
	public final static String COVER_PHOTOS_BY_ID = "v1/CoverPhotos/1";

	public final static String USERS = "v1/Users";
	public final static String USERS_BY_ID = "v1/Users/1";

}
