package org.example;

public class HttpRequest {
    private final String uri;
    private final String headers;
    private final String POST;

    public HttpRequest(String uri, String headers, String POST) {
        this.uri = uri;
        this.headers = headers;
        this.POST = POST;
    }
    public static Builder builder(){
        return new Builder();
    }

    public String getUri() {
        return uri;
    }

    public String getHeaders() {
        return headers;
    }

    public String getPOST() {
        return POST;
    }
    public  static class Builder {
        private String uri;
        private String headers;
        private String POST;

        private  Builder() {
        }

        public void setUri(String uri) {
            this.uri = uri;
            return this;//текущий объект возвращает
        }

        public void setHeaders(String headers) {
            this.headers = headers;
            return this;//текущий объект возвращает
        }

        public void setPOST(String POST) {
            this.POST = POST;
            return this;//текущий объект возвращает
        }

        public HttpRequest build() {
            return new HttpRequest(uri, headers, POST);
        }

    }

}


