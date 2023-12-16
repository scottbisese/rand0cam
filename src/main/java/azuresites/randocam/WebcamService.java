package azuresites.randocam;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;


@Service
public class WebcamService {
//inject from application.properties which will be ignored by git for privacy/security, thats what the @value decorator does here
    @Value("${x-windy-host}")
    private String windyHost;

    @Value("${x-windy-key}")
    private String windyKey;

    public WebcamResponse getWebcam() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://api.windy.com/api/webcams/v2/list/property=live,hd,active/orderby=random/limit=1?lang=en&show=webcams:image,player";
    
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-windy-host", windyHost);
        headers.set("x-windy-key", windyKey);
        HttpEntity<String> entity = new HttpEntity<>(headers);
    
        WebcamResponse response = restTemplate.exchange(url, HttpMethod.GET, entity, WebcamResponse.class).getBody();
        if (response != null && response.getResult() != null && response.getResult().getWebcams() != null && !response.getResult().getWebcams().isEmpty()) {
            Webcam firstWebcam = response.getResult().getWebcams().get(0);
            System.out.println("Webcam title: " + firstWebcam.getTitle() + ", ID: " + firstWebcam.getId());
        } else {
            System.out.println("No webcam found in response");
        }
        return response;
    }
    
}