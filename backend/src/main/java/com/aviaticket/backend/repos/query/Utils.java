package com.aviaticket.backend.repos.query;

public class Utils {
    public static final String FIND_CLIENT_BY_LOGIN="select u.* from users u where u.user_login=:login";
    public static final String CHECK_EXIST_LOGIN = "SELECT count(u.user_login) from users u where u.user_login=:login";
    public static final String CHECK_EXIST_EMALE = "SELECT count(u.user_email) from users u where u.user_email=:emale";
    public static final String FIND_POINT_START = "SELECT p.* from point p where p.id_location=(SELECT l.id_location from location l where l.city=:cityS) and (SELECT lo.id_location from location lo where lo.city=:cityE)=(select po.id_location from point po where po.id_route=p.id_route and po.number>p.number and (SELECT loc.id_location from location loc where loc.city=:cityE)=po.id_location)";
    public static final String FIND_POINT = "SELECT p.* from point p where p.id_location=(SELECT l.id_location from location l where l.city=:city) ";
    public static final String FIND_WAYS_START = "SELECT w.* from way w where w.point_first=(select p.id_point from point where p.id_location=(SELECT l.id_location from location l where l.city=:cityS)) and w.point_end=(select p.id_point from point where p.id_location=(SELECT l.id_location from location l where l.city=:cityE))";
    public static final String FIND_POINTS_BY_ROUTE = "SELECT p.* from point p where p.id_route=:route";
}
