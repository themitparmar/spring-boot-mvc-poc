package com.poc.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptClient {

    private static Logger LOGGER = LoggerFactory.getLogger(BcryptClient.class);

    public static void main(String[] args) {
        String value = "password";

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String bcryptWord = bCryptPasswordEncoder.encode(value);

        LOGGER.info("Encrypted word:" + bcryptWord);
    }

}
