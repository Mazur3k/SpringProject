package org.edu.mazurek.edu.recaptcha;

public interface RecaptchaService {

    boolean isResponseValid(String remoteIp, String response);
}
