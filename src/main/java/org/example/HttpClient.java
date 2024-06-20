package org.example;
import java.net.HttpRequest;
import java.time.LocalDateTime;

public class HttpClient {

    private final String version;
    private final String followRedirects;
    private final LocalDateTime connectTimeout;
    private final String proxy;
    private final int inetSocketAddress;
    private final boolean authenticator;

    public HttpClient(String version, String followRedirects, LocalDateTime connectTimeout, String proxy, int inetSocketAddress, boolean authenticator) {
        this.version = version;
        this.followRedirects = followRedirects;
        this.connectTimeout = connectTimeout;
        this.proxy = proxy;
        this.inetSocketAddress = inetSocketAddress;
        this.authenticator = authenticator;
    }
    public static Builder builder(){
        return new Builder();
    }

    public String getVersion() {
        return version;
    }

    public String getFollowRedirects() {
        return followRedirects;
    }

    public LocalDateTime getConnectTimeout() {
        return connectTimeout;
    }

    public String getProxy() {
        return proxy;
    }

    public int getInetSocketAddress() {
        return inetSocketAddress;
    }

    public boolean isAuthenticator() {
        return authenticator;
    }

    public  static class Builder {
        private String version;
        private String followRedirects;
        private LocalDateTime connectTimeout;
        private String proxy;
        private int inetSocketAddress;
        private boolean authenticator;

        private  Builder() {
        }

        public void setVersion(String version) {
            this.version = version;
            return this;//текущий объект возвращает
        }

        public void setFollowRedirects(String followRedirects) {
            this.followRedirects = followRedirects;
            return this;//текущий объект возвращает
        }

        public void setConnectTimeout(LocalDateTime connectTimeout) {
            this.connectTimeout = connectTimeout;
            return this;//текущий объект возвращает
        }

        public void setProxy(String proxy) {
            this.proxy = proxy;
            return this;//текущий объект возвращает
        }

        public void setInetSocketAddress(int inetSocketAddress) {
            this.inetSocketAddress = inetSocketAddress;
            return this;//текущий объект возвращает
        }

        public void setAuthenticator(boolean authenticator) {
            this.authenticator = authenticator;
            return this;//текущий объект возвращает
        }

        public HttpClient build() {
            return new HttpClient(version, followRedirects, connectTimeout,proxy, inetSocketAddress, authenticator);
        }


    }

    }
