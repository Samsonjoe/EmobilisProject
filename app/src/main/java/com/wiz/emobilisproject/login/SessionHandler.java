package com.wiz.emobilisproject.login;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Date;

public class SessionHandler {

        private static final String PREF_NAME = "UserSession";
        private static final String KEY_USERNAME = "username";
        private static final String KEY_EXPIRES = "expires";

    private static final String KEY_FIRST_NAME = "first_name";
    private static final String KEY_SECOND_NAME = "second_name";
    private static final String KEY_LAST_NAME = "last_name";

    private static final String KEY_UPLOADS_JSON = "uploads_json";
    private static final String KEY_DEPENDANT_JSON = "dependants_json";
    private static final String KEY_ALL_SCHOOL_JSON = "all_schools_json";


        private static final String KEY_FULL_NAME = "full_name";
        private static final String KEY_JOB_GROUP = "job_group";
        private static final String KEY_PHONE_NUMBER= "cellphone";
        private static final String KEY_ID_NUMBER = "id_number";
        private static final String KEY_KRA_PIN = "kra_pin";
        private static final String KEY_DATE_OF_BIRTH= "date_of_birth";
        private static final String KEY_GENDER = "gender";
        private static final String KEY_COUNTY = "county";
        private static final String KEY_ROLE = "role";
        private static final String KEY_EMPTY = "";
        private static final String KEY_NHIF_NUMBER = "nhif_number";



        private Context mContext;
        private SharedPreferences.Editor mEditor;
        private SharedPreferences mPreferences;

        public SessionHandler(Context mContext) {
            this.mContext = mContext;
            mPreferences = mContext.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
            this.mEditor = mPreferences.edit();
        }

        /**
         * Logs in the user by saving user details and setting session
         *
         * @param username
         * @param fullName
         */

        //String firstName,String secondName,String lastName,

        public void loginUser(String username, String fullName,  String UserJobGroup, String UserIdNumber,String UserPhoneNumber,
                String UserKraPin, String UserDateofBirth, String UserGender, String UserCounty, String UserRole,String UserNhifNumber)
        {
            /*
            * mEditor.putString(KEY_FIRST_NAME, firstName);
            * mEditor.putString(KEY_SECOND_NAME, secondName);
            * mEditor.putString(KEY_LAST_NAME, lastName);
            * mEditor.putString(KEY_STATION_NAME, lastName);
            * */

            mEditor.putString(KEY_USERNAME, username);
            mEditor.putString(KEY_FULL_NAME, fullName);
            mEditor.putString(KEY_JOB_GROUP, UserJobGroup);
            mEditor.putString(KEY_ID_NUMBER, UserIdNumber);
            mEditor.putString(KEY_PHONE_NUMBER, UserPhoneNumber);
            mEditor.putString(KEY_KRA_PIN, UserKraPin);
            mEditor.putString(KEY_DATE_OF_BIRTH, UserDateofBirth);
            mEditor.putString(KEY_GENDER, UserGender);
            mEditor.putString(KEY_COUNTY, UserCounty);
            mEditor.putString(KEY_ROLE, UserRole);
            mEditor.putString(KEY_NHIF_NUMBER, UserNhifNumber);
            Date date = new Date();

            //Set user session for next 7 days
            long millis = date.getTime() + (7 * 24 * 60 * 60 * 1000);
            mEditor.putLong(KEY_EXPIRES, millis);
            mEditor.commit();
        }



        /**
         * Checks whether user is logged in
         *
         * @return
         */
        public boolean isLoggedIn() {
            Date currentDate = new Date();

            long millis = mPreferences.getLong(KEY_EXPIRES, 0);

        /* If shared preferences does not have a value
         then user is not logged in
         */
            if (millis == 0) {
                return false;
            }
            Date expiryDate = new Date(millis);

        /* Check if session is expired by comparing
        current date and Session expiry date
        */
            return currentDate.before(expiryDate);
        }

        /**
         * Fetches and returns user details


         * @return user details
         */
        public User getUserDetails() {
            //Check if user is logged in first
            if (!isLoggedIn()) {
                return null;
            }
            User user = new User();

            /*
            * user.setFirstName(mPreferences.getString(KEY_FIRST_NAME, KEY_EMPTY));
            * user.setSecondName(mPreferences.getString(KEY_SECOND_NAME, KEY_EMPTY));
            * user.setLastName(mPreferences.getString(KEY_LAST_NAME, KEY_EMPTY));
            * user.setUserStationName(mPreferences.getString(KEY_STATION_NAME, KEY_EMPTY));
            * */
            user.setUsername(mPreferences.getString(KEY_USERNAME, KEY_EMPTY));
            user.setFullName(mPreferences.getString(KEY_FULL_NAME, KEY_EMPTY));
            user.setUserJobGroup(mPreferences.getString(KEY_JOB_GROUP, KEY_EMPTY));
            user.setUserIdNumber(mPreferences.getString(KEY_ID_NUMBER, KEY_EMPTY));
            user.setUserPhoneNumber(mPreferences.getString(KEY_PHONE_NUMBER, KEY_EMPTY));
            user.setUserKraPin(mPreferences.getString(KEY_KRA_PIN, KEY_EMPTY));
            user.setUserDateofBirth(mPreferences.getString(KEY_DATE_OF_BIRTH, KEY_EMPTY));
            user.setUserGender(mPreferences.getString(KEY_GENDER, KEY_EMPTY));
            user.setUserCounty(mPreferences.getString(KEY_COUNTY, KEY_EMPTY));
            user.setUserRole(mPreferences.getString(KEY_ROLE, KEY_EMPTY));
            user.setUserNHIFNumber(mPreferences.getString(KEY_NHIF_NUMBER, KEY_EMPTY));
            return user;
        }

        //Dependants get
        public void loginSaveUserDependants(String UserDependants) {

            mEditor.putString(KEY_DEPENDANT_JSON, UserDependants);

            Date date = new Date();

            //Set user session for next 7 days
            //long millis = date.getTime() + (7 * 24 * 60 * 60 * 1000);
            //mEditor.putLong(KEY_EXPIRES, millis);
            mEditor.commit();
        }

    //Uploads get
    public void loginSaveUserUploads(String UserUploads) {

        mEditor.putString("uploads", UserUploads);

        Date date = new Date();

        //Set user session for next 7 days
        long millis = date.getTime() + (7 * 24 * 60 * 60 * 1000);
        mEditor.putLong(KEY_EXPIRES, millis);
        mEditor.commit();
    }

    //All Schools get
    public void loginSaveUserAllSchools(String UserAllSchools) {

        mEditor.putString(KEY_ALL_SCHOOL_JSON, UserAllSchools);

        Date date = new Date();

        //Set user session for next 7 days
        long millis = date.getTime() + (7 * 24 * 60 * 60 * 1000);
        mEditor.putLong(KEY_EXPIRES, millis);
        mEditor.commit();
    }

    /**
     * Fetches and returns user dependants
     *
     * @return user dependants
     */

    public User getUserDependants() {
        //Check if user is logged in first
        if (!isLoggedIn()) {
            return null;
        }
        User user = new User();

        user.setUserDependants(mPreferences.getString(KEY_DEPENDANT_JSON, KEY_EMPTY));
        return user;
    }

    /**
     * Fetches and returns user uploads
     *
     * @return user uploads
     */

    public User getUserUploads() {
        //Check if user is logged in first
        if (!isLoggedIn()) {
            return null;
        }
        User user = new User();

        user.setUserUploads(mPreferences.getString(KEY_UPLOADS_JSON, KEY_EMPTY));
        return user;
    }


    /**
     * Fetches and returns user All Schools
     *
     * @return user All Schools
     */

    public User getUserAllSchools() {
        //Check if user is logged in first
        if (!isLoggedIn()) {
            return null;
        }
        User user = new User();

        user.setUserAllSchools(mPreferences.getString(KEY_ALL_SCHOOL_JSON, KEY_EMPTY));
        return user;
    }



        /**
         * Logs out user by clearing the session
         */
        public void logoutUser(){
            mEditor.clear();
            mEditor.commit();
        }

    }