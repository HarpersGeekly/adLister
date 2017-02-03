package com.codeup.adlister.dao;

public class DaoFactory {
    private static Ads adsDao;
    private static Config config = new Config();
    private static Users usersDao;

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new MySQLAdsDao(config);
        }
        return adsDao;
    }
    public static Users getUsersDao() {
        //check if you already have a dao. If it doesn't exist, it's null.
        if (usersDao == null) {
            // so I need to create one
            usersDao = new MySQLUsersDao(config);
        }
        return usersDao;
    }


}
