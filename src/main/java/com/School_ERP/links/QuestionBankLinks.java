package com.School_ERP.links;

import com.School_ERP.entity.QuestionBank;

public class QuestionBankLinks {

    public static final String QUESTIONBANK = "questionbank";

    public static final String GET_ALL_QUESTIONPAPER = "/getallquestionpaper";
    public static final String GET_QUESTIONBANKS_BY_YEAR = "/get/year/{year}";
    public static final String GET_QUESTIONBANKS_BY_SUBJECT = "/get/subject/{subject}";
    public static final String ADD_QUESTIONBANK = "/addquestionBank";
    public static final String GET_QUESTIONBANK_BY_SUBJECT_AND_YEAR = "/get/{subject}/{year}";
    public static final String UPDATE_QUESTIONBANK_BY_SUBJECT_AND_YEAR = "/update/{subject}/{year}";
}
