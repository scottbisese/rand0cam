package azuresites.randocam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class WebcamController {

    private final WebcamCommentService webcamCommentService;
    private final WebcamService webcamService;

    @Autowired
    public WebcamController(WebcamCommentService webcamCommentService, WebcamService webcamService) {
        this.webcamCommentService = webcamCommentService;
        this.webcamService = webcamService;
    }

    @PostMapping("/comments")
    public String addComment(@RequestBody WebcamComment comment) {
        webcamCommentService.save(comment);
        return "Comment added successfully";
    }
    
    @GetMapping("/webcam/random")
    public WebcamDTO getActiveWebcam() {
        WebcamResponse response = webcamService.getWebcam();
        if (response.getResult() != null && response.getResult().getWebcams() != null) {
            for (Webcam webcam : response.getResult().getWebcams()) {
                if ("active".equals(webcam.getStatus()) && webcam.getPlayer() != null && 
                    webcam.getPlayer().getLive() != null && webcam.getPlayer().getLive().isAvailable()) {
                    return new WebcamDTO(webcam.getId(), webcam.getTitle());
                }
            }
        }
        return null;
    }
}