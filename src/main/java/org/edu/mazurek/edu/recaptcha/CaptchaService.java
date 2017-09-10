package org.edu.mazurek.edu.recaptcha;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.edu.mazurek.edu.configuration.CaptchaSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class CaptchaService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private CaptchaSettings captchaSettings;

    private static final String GOOGLE_CAPTCHA_URL =
            "https://www.google.com/recaptcha/api/siteverify?secret={secret}&response={response}";


    @SneakyThrows
    public boolean checkCaptcha(String recaptchaResponse) {
        Map<String, String> params = new HashMap<>();
        params.put("secret", captchaSettings.getSecret());
        params.put("response", recaptchaResponse);

        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity(GOOGLE_CAPTCHA_URL, null, String.class, params);

        String body = stringResponseEntity.getBody();

        if (!stringResponseEntity.getStatusCode().is2xxSuccessful()) {
            log.info("Captcha error: status {} response {}", stringResponseEntity.getStatusCodeValue(), body);
            throw new IllegalStateException("Captcha error");
        }

        CaptchaResponse captchaResponse = objectMapper.readValue(body, CaptchaResponse.class);
        log.info("Catpcha success: {}", captchaResponse.isSuccess());
        return captchaResponse.isSuccess();

    }

}
