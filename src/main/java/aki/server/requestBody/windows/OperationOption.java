package aki.server.requestBody.windows;

public class OperationOption {
    private Long peer;
    private String method;
    private int duration;
    private String inputContent;

    public Long getPeer( ){
        return  peer;
    }

    public String getMethod( ){
        return  method;
    }

    public int getDuration( ){
        return  duration;
    }

    public String getInputContent( ){
        return  inputContent;
    }

}
