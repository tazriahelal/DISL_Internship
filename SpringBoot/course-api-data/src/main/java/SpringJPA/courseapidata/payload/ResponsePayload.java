package SpringJPA.courseapidata.payload;

public class ResponsePayload {

    private boolean success;
    private String message;
    private Object payload;

    public ResponsePayload(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public ResponsePayload(boolean success, String message, Object payload) {
        this.success = success;
        this.message = message;
        this.payload = payload;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }
}
