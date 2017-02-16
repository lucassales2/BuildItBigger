package lucassales.com.builditbigger;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.ExecutionException;

/**
 * Created by lucas on 16/02/17.
 */
public class EndpointAsyncTaskTest {
    @Test
    public void test() throws ExecutionException, InterruptedException {
        String s = new EndpointAsyncTask().execute().get();

        Assert.assertNotNull(s);
        Assert.assertFalse(s.startsWith(EndpointAsyncTask.ERROR_TAG));
        Assert.assertTrue(s.length() > 0);
    }

}