package com.aviaticket.backend.repos.query;

public class Utils {
    public static final String FIND_CLIENT_BY_LOGIN="select u.* from user u where u.login=:login";
    public static final String CHECK_EXIST_LOGIN = "SELECT count(u.login) from user u where u.login=:login";
    public static final String CHECK_EXIST_EMALE = "SELECT count(u.EMAIL) from user u where u.EMAIL=:emale";

}
