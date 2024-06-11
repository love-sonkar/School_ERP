package com.School_ERP.links;

public class StudentLinks {
	// Parent : Request Path
	public final static String STUDENT_PATH = "/student";
	// Get student by id : Request Path
	public final static String GET_STUDENT_BY_ID = "/get/{studentId}";
	// Add Student : Request Path
	public final static String ADD_STUDENT = "/add";
	// Get all the student : Request Path
	public final static String GET_ALL_STUDENT = "/get/all";
	// Update student details : Request Path
	public final static String UPDATE_STUDENT_DATA = "/update/{studentId}";
	// Delete student data : Request path
	public final static String DELETE_STUDENT_DATA = "/delete/{studentId}";
}
