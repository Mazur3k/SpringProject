package org.edu.mazurek.edu.recaptcha;

public interface ICaptchaService {

    public void processResponse(String response);
    public boolean responseSanityCheck(String response);
}
