package aki.server.requestBody.windows;

public class FindElementOption {
    private Long peer;
    private String method;
    private String parameter;
    private int index;

    public Long getPeer( ){
        return  peer;
    }

    public String getMethod( ){
       return  method;
    }

    public String getParameter( ){
        return  parameter;
    }

    public int getIndex( ){
        return  index;
    }

}
