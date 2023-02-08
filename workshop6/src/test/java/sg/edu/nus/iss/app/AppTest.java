package sg.edu.nus.iss.app;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import sg.edu.nus.iss.app.server.Cookie;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private List<String> cookies = null;
    
    // before the test cases run
    @Before
    public void init() throws IOException{
        cookies = Cookie.getDataFromText("cookies_file.txt");
    }

    @Test
    public void testCookieDataFromFile() throws IOException{
        assertTrue(!cookies.isEmpty());
    }

    @Test
    public void testCookieDataFromFileNotNull(){
        assertTrue(cookies != null);
    }
    
    @Test
    public void testCookieSizeDataFromFile(){
        assertTrue(cookies.size() >= 27);
    }

    @Test
    public void testCookieSourceFile(){
        String cookieName = Cookie.getRandomCookie("cookies_file.txt");
        assertTrue(cookieName.length() > 4);
    }

}
