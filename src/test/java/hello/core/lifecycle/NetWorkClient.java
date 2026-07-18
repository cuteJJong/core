package hello.core.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.Lifecycle;

//인터페이스를 통한 초기화 소멸
//public class NetWorkClient implements InitializingBean, DisposableBean {
public class NetWorkClient {
    private String url;

    public NetWorkClient() {
        System.out.println("생성자 호출, url = " + url);

    }

    public void setUrl(String url) {
        this.url = url;
    }

    //서비스 시작 호출
    public void connect() {
        System.out.println("connect = " + url);
    }

    public void call(String message) {
        System.out.println("call = " + url + ", message = " + message);
    }

    //서비스 종료시 호출
    public void disconnect() {
        System.out.println("close = " + url);
    }

    /*
    인터페이스를 통한 초기화, 소멸 방법
    //의존관계 주입이 끝나면 호출
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("NetworkClient.afterPropertiesSet");
        connect();
        call("초기화 연결 메시지");
    }
    */

    /*
    인터페이스를 통한 초기화 소멸
    @Override
    public void destroy() throws Exception {
        System.out.println("NetWorkClient.destroy");
        disconnect();
    }
    */

    //최신 권장 방법
    @PostConstruct
    public void init(){
        System.out.println("NetworkClient.afterPropertiesSet");
        connect();
        call("초기화 연결 메시지");
    }

    //최신 권장 방법
    @PreDestroy
    public void close() {
        System.out.println("NetWorkClient.destroy");
        disconnect();
    }
}
