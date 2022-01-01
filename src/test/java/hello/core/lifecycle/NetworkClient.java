package hello.core.lifecycle;

public class NetworkClient {
    private String url;

    public NetworkClient() {
        System.out.println("start: " + url);
        connect();
        call("connection message");
    }

    public void setUrl(String url){
        this.url = url;
    }

    public void connect(){
        System.out.println("connect: " + url);
    }

    public void call(String message){
        System.out.println("call: " + message);
    }

    public void disconnect(){
        System.out.println("close:  "+ url);
    }

}
