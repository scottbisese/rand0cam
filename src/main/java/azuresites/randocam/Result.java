package azuresites.randocam;

import java.util.List;


class Result {
    private int offset;
    private int limit;
    private int total;
    private List<Webcam> webcams;

    // Getters and setters
    public int getOffset() { return offset; }
    public void setOffset(int offset) { this.offset = offset; }

    public int getLimit() { return limit; }
    public void setLimit(int limit) { this.limit = limit; }

    public int getTotal() { return total; }
    public void setTotal(int total) { this.total = total; }

    public List<Webcam> getWebcams() { return webcams; }
    public void setWebcams(List<Webcam> webcams) { this.webcams = webcams; }
}