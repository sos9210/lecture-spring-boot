package spring.myspring.config.autoconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import spring.myspring.config.MyConfigurationProperties;

@MyConfigurationProperties(prefix = "server")//prefix는 필드메서드 앞에 결합하는것으로 인식(server.port, server.contextPath...등)
public class ServerProperties {
    private String contextPath;
    private int port;

    public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
