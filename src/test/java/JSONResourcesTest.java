import com.anarsoft.vmlens.concurrent.junit.ConcurrentTestRunner;
import com.anarsoft.vmlens.concurrent.junit.ThreadCount;
import org.json.simple.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

@RunWith(ConcurrentTestRunner.class)
public class JSONResourcesTest {

    private final static int THREAD_COUNT = 5;


    @Test
    @ThreadCount(THREAD_COUNT)
    public void getTitleJsonTest()
    {
        //arrange
        JSONResources jsonResources = Mockito.mock(JSONResources.class);
        JSONObject object = new JSONObject();
        object.put("Resource:", "title");
        //act
        Mockito.when(jsonResources.getTitleJson("title")).thenReturn(object);

        assertEquals(object, jsonResources.getTitleJson("title"));

    }

    @Test
    public void testGetTitleJson()
    {
        //arrange
        JSONResources jsonResources = new JSONResources();
        JSONObject jsonObject = new JSONObject();
        //act
        jsonObject = jsonResources.getTitleJson("Elvis Forever");
        //assert
        assertEquals("{\"artist\":\"Elvis Presley\",\"year\":\"2015\",\"genre\":\"Rock\",\"format\":\"Vinyl\",\"title\":\"Elvis Forever\",\"category\":\"Music\"}", jsonObject.toJSONString());
    }

}
