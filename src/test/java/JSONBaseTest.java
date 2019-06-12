import junitparams.JUnitParamsRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import junitparams.Parameters;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.lang.reflect.Modifier;

import static org.junit.Assert.*;

public class JSONBaseTest {

    /**
     * Checking if JSONBase class is abstract.
     */
    @Test
    public void assertJSONBase_IsAbstractClass(){
        boolean isAbstract = Modifier.isAbstract(JSONBase.class.getModifiers());

        assertTrue(isAbstract);
    }

    /**
     * Checking if method accepts proper parameters.
     */
    @Test
    public void assertIf_getYear_ReturnString(){
        JSONBase mockObj = Mockito.mock(JSONBase.class);
        String testYear = "1990";
        Mockito.when(mockObj.getYear()).thenReturn(testYear);

        assertEquals(testYear, mockObj.getYear());
    }

    /**
     * Checking if method accepts proper parameters.
     */
    @Test
    public void assertIf_getGenre_ReturnString(){
        JSONBase mockObj = Mockito.mock(JSONBase.class);
        String testGenre = "fantasy";
        Mockito.when(mockObj.getGenre()).thenReturn(testGenre);

        assertEquals(testGenre, mockObj.getGenre());
    }

    /**
     * Checking if method accepts proper parameters.
     */
    @Test
    public void assertIf_getFormat_ReturnString(){
        JSONBase mockObj = Mockito.mock(JSONBase.class);
        String testFormat = "DVD";
        Mockito.when(mockObj.getFormat()).thenReturn(testFormat);

        assertEquals(testFormat, mockObj.getGenre());
    }
}
