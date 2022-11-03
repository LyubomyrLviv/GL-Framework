package service;

public class ApiException extends Exception {

    private final int statusCode;
    private final String statusMessage;

    public ApiException(int statusCode, String statusMessage){
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    @Override
    public String toString() {
        return "ApiException{" +
                "statusCode=" + statusCode +
                ", statusMessage='" + statusMessage + '\'' +
                '}';
    }
}
