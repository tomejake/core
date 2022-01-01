package hello.core.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient{
    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출: " + url);
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

    @PostConstruct
    public void init(){
        connect();
        call("초기화 메시지 연결");
    }

    @PreDestroy
    public void close(){
        disconnect();
    }
}
