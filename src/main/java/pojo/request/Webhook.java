package pojo.request;

public class Webhook {
    private String URL;
    public Webhook(String url){
        this.URL = url;
    }

    public String getURL() {
        return URL;
    }
}
