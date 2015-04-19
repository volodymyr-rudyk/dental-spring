//package com.dental.service;
//
//import org.hibernate.procedure.spi.ParameterRegistrationImplementor;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
///**
// * Created by light on 4/18/2015.
// */
//public class PasswordEncoderImpl implements PasswordEncoder {
//
//    private static final String SALT = "12345";
//
//    @Override
//    public String encode(CharSequence rawPassword) {
//        return rawPassword + SALT;
//    }
//
//    @Override
//    public boolean matches(CharSequence rawPassword, String encodedPassword) {
//        return rawPassword.subSequence(0, rawPassword.length() - SALT.length()).equals(encodedPassword);
//    }
//}
