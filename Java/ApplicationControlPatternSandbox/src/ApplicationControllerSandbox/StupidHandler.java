package ApplicationControllerSandbox;

import java.util.HashMap;

/**
 * Created by rome on 11/30/2015.
 */
public class StupidHandler implements Handler{

    @Override
    public void handleIt(HashMap<String, Object> data) {
        System.out.println(data);
    }
}
