package hello.core.lifecycle;

import javax.annotation.PostConstruct; // javax는 java에서 공식적으로 지원하는 기능
import javax.annotation.PreDestroy;

public class NetworkClient {
    
    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
        connect();
        call("초기화 연결 메시지");
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 서비스 시작 시 호출
    public void connect() {
        System.out.println("connect: " + url);
    }

    public void call(String message) {
        System.out.println("call: " +url + " message = "+message);
    }

    // 서비스 종료 시 호출
    public void disconnect() {
        System.out.println("close " + url);
    }

    @PostConstruct
    public void init() {
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메시지");
    }

    @PreDestroy
    public void close() {
        System.out.println("NetworkClient.close");
        disconnect();   // 종료
    }
//    초기 방식 (Deprecated)
//    @Override
//    public void afterPropertiesSet() throws Exception { // '의존관계 주입이 끝나면' 이라는 뜻의 메서드
//        connect();
//        call("초기화 연결 메시지"); // 이러면 제대로 됨
//    }
//
//    @Override
//    public void destroy() throws Exception { // 종료
//        disconnect();   // 종료
//    }
}
