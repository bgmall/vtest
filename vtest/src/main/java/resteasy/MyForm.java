package resteasy;

import javax.ws.rs.FormParam;

/**
 * Created by msg on 2017/2/4.
 */
public class MyForm {

    @FormParam("firstname")
    private String first;

    @FormParam("lastname")
    private String last;

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }
}
