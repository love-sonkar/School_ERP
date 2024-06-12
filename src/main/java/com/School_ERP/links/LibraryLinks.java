package com.School_ERP.links;

public class LibraryLinks {
    public static final String LIBRARY = "/library";

    public static final String GET_ALL_BOOKS = "/get-all-book";

    public static final String DELETE_BOOK = "/{bookId}";
    public static final String ADD_BOOK = "/addbook";
    public static final String UPDATE_BOOK = "/update/book/{bookId}";
    public static final String ASSIGNEDBOOK_TO_STUDENT = "/assignee-book/{adm_no}/{bookId}";
    public static final String RETURNED_BOOK = "/returnbook/{bookId}";
    public static final String SEARCH_BY_BOOK_NAME = "/searchbybookName/{books}";
}
