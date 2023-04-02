package com.example.creditbankfirstclient.controller;

public interface ConstantProject {

    /** path const */
    public static final String API_PATH = "/fill";

    public static final String SEND_FORM_PATH = API_PATH + "/sendform";


    /** message const */
    public final static String APPROVE_MESSAGE = "I/O error on POST request for \"http://localhost:8097/check/clientresponse\": Connection refused: connect";

    public static final String TEST_FIELD = "test_string_123456";

    public static final String APPROVE_NOT_VALID_MESSAGE = "В поле firstName содержатся некорректные символы\n" +
            " В поле surName содержатся некорректные символы\n" +
            " В поле LastName содержатся некорректные символы\n" +
            " Поле passportNum заполнено некорректно, в нем должно быть 10 цифр, после 4й цифры -пробел\n" +
            " в поле timeOfEmployment содержатся некорректные символы , допустимы только цифры\n" +
            " в поле salary содержатся некорректные символы , допустимы только цифры\n" +
            " в поле loanPayments содержатся некорректные символы , допустимы только цифры\n" +
            " в поле creditAmount содержатся некорректные символы , допустимы только цифры\n" +
            " в поле creditTerm содержатся некорректные символы , допустимы только цифры";

}
