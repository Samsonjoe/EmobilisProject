package com.wiz.emobilisproject.login;

import java.util.Date;

public class User {

        /*
        String firstName;
        String secondName;
        String lastName;
        String UserStationName;
         */

        String username;
        String fullName;
        String UserPhoneNumber;
        String UserJobGroup;
        String UserIdNumber;
        String UserKraPin;
        String UserDateofBirth;
        String UserGender;
        String UserCounty;
        String UserRole;
        String UserNhifNumber;

        String UserDependants;
        String UserUploads;
        String UserAllSchools;


        Date sessionExpiryDate;

        //LOGIN AND USER PROFILE INFORMATION
        public void setUsername(String username) {
            this.username = username;
        }
        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        /*
        * public void setFirstName(String firstName) {
            this.firstName = firstName;
        }
        * public void setSecondName(String secondName) {
            this.secondName = secondName;
        }
        * public void setLastName(String lastName) {
            this.lastName = lastName;
        }
        * public void setUserStationName(String UserStationName) {
            this.UserStationName = UserStationName;
        }
        * */

        public void setUserJobGroup(String UserJobGroup) {
            this.UserJobGroup = UserJobGroup;
        }
        public void setUserPhoneNumber(String UserPhoneNumber) {
            this.UserPhoneNumber = UserPhoneNumber;
        }
        public void setUserIdNumber(String UserIdNumber) {
            this.UserIdNumber = UserIdNumber;
        }
        public void setUserKraPin(String UserKraPin) {
            this.UserKraPin = UserKraPin;
        }
        public void setUserDateofBirth(String UserDateofBirth) {
            this.UserDateofBirth = UserDateofBirth;
        }
        public void setUserGender(String UserGender) {
            this.UserGender = UserGender;
        }
        public void setUserCounty(String UserCounty) {
            this.UserCounty = UserCounty;
        }
        public void setUserRole(String UserRole) {
            this.UserRole = UserRole;
        }
        public void setUserNHIFNumber(String UserNhifNumber) {
            this.UserNhifNumber = UserNhifNumber;
        }

        public void setSessionExpiryDate(Date sessionExpiryDate) {
            this.sessionExpiryDate = sessionExpiryDate;
        }

            public String getUsername() {
                return username;
            }
            public String getFullName() {
                return fullName;
            }
            /*
            *  public String getFirstName() {
                return firstName;
            }
            *  public String getSecondName() {
                return secondName;
            }
            *  public String getLastName() {
                return lastName;
            }
            * public String getUserStationName() {
                return UserStationName;
            }
            * */
            public String getUserJobGroup() {
                return UserJobGroup;
            }
            public String getUserPhoneNumber() {
                return UserPhoneNumber;
            }
            public String getUserIdNumber() {
                return UserIdNumber;
            }
            public String getUserKraPin() {
                return UserKraPin;
            }
            public String getUserDateofBirth() {
                return UserDateofBirth;
            }
            public String getUserGender() {
                return UserGender;
            }
            public String getUserCounty() {
                return UserCounty;
            }
            public String getUserRole() {
                return UserRole;
            }
            public String getUserNhifNumber() {
                return UserNhifNumber;
            }

            //DEPENDANTS
            public void setUserDependants(String UserDependants) {
                this.UserDependants = UserDependants;
            }
            public String getUserDependants() {
                return UserDependants;
            }

            //UPLOADS
            public void setUserUploads(String UserUploads) {
                this.UserUploads = UserUploads;
            }
            public String getUserUploads() {
                return UserUploads;
            }

            //ALL SCHOOLS
            public void setUserAllSchools(String UserAllSchools) {
                this.UserAllSchools = UserAllSchools;
            }
            public String getUserAllSchools() {
                return UserAllSchools;
            }




        public Date getSessionExpiryDate() {
            return sessionExpiryDate;
        }
    }