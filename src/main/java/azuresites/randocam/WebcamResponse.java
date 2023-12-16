package azuresites.randocam;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WebcamResponse {
    private String status;
    private Result result;

    // Getters and setters
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Result getResult() { return result; }
    public void setResult(Result result) { this.result = result; }

}