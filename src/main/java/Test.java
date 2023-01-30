
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

public class Test {
    static final String uri = "https://reqres.in/api/users";
    static final String uriId = "https://reqres.in/api/users/2";

    static final String message = "The method is down.";
    public static void main(String[] args) {
    //GetMethod();
    PostMethod();
    //PutMethod();
    //DeleteMethod();
    }

    static void GetMethod(){
        final HttpClient httpClient = new DefaultHttpClient();
        final HttpGet httpGet = new HttpGet(uriId);
        HttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
        } catch (IOException ex) {
            if (LOGGER.isLoggable(Level.INFO)) {
                LOGGER.info(message + ex.getMessage());
            }
        }
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        } catch (IOException ex) {
            if (LOGGER.isLoggable(Level.INFO)) {
                LOGGER.info(message + ex.getMessage());
            }
        }
        String line = "";
        while (true) {
            try {
                if ((line = reader.readLine()) == null) break;
            } catch (IOException ex) {
                if (LOGGER.isLoggable(Level.INFO)) {
                    LOGGER.info(message + ex.getMessage());
                }
            }
            System.out.println(line);
        }
        System.out.println(response.getStatusLine());
    }

    static void PostMethod(){
        final HttpClient httpClient = new DefaultHttpClient();
        final HttpPost httpPost = new HttpPost(uri);
        StringEntity input = null;
        try {
            input = new StringEntity("{\"name\":\"morpheus\",\"job\":\"leader\"}");
        } catch (UnsupportedEncodingException ex) {
            if (LOGGER.isLoggable(Level.INFO)) {
                LOGGER.info(message + ex.getMessage());
            }
        }
        httpPost.addHeader("content-type", "application/json");
        httpPost.setEntity(input);
        HttpResponse response = null;
        try {
            response = httpClient.execute(httpPost);
        } catch (IOException ex) {
            if (LOGGER.isLoggable(Level.INFO)) {
                LOGGER.info(message + ex.getMessage());
            }
        }
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        } catch (IOException ex) {
            if (LOGGER.isLoggable(Level.INFO)) {
                LOGGER.info(message + ex.getMessage());
            }
        }
        String line = "";
        while (true) {
            try {
                if ((line = reader.readLine()) == null) break;
            } catch (IOException ex) {
                if (LOGGER.isLoggable(Level.INFO)) {
                    LOGGER.info(message + ex.getMessage());
                }
            }
            System.out.println(line);
        }
        System.out.println(response.getStatusLine());
    }
    static void PutMethod() {
        final HttpClient httpClient = new DefaultHttpClient();
        final HttpPut httpPut = new HttpPut(uriId);
        StringEntity input = null;
        try {
            input = new StringEntity("{\"name\":\"morpheus\",\"job\":\"zion resident\"}");
        } catch (UnsupportedEncodingException ex) {
            if (LOGGER.isLoggable(Level.INFO)) {
                LOGGER.info(message + ex.getMessage());
            }
        }
        httpPut.addHeader("content-type", "application/json");
        httpPut.setEntity(input);
        HttpResponse response = null;
        try {
            response = httpClient.execute(httpPut);
        } catch (IOException ex) {
            if (LOGGER.isLoggable(Level.INFO)) {
                LOGGER.info(message + ex.getMessage());
            }
        }
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        } catch (IOException ex) {
            if (LOGGER.isLoggable(Level.INFO)) {
                LOGGER.info(message + ex.getMessage());
            }
        }
        String line = "";
        while (true) {
            try {
                if ((line = reader.readLine()) == null) break;
            } catch (IOException ex) {
                if (LOGGER.isLoggable(Level.INFO)) {
                    LOGGER.info(message + ex.getMessage());
                }
            }
            System.out.println(line);
        }
        System.out.println(response.getStatusLine());
    }
    static void DeleteMethod(){
        final HttpClient httpClient = new DefaultHttpClient();
        final HttpDelete httpDelete = new HttpDelete(uriId);
        HttpResponse response = null;
        try {
            response = httpClient.execute(httpDelete);
        } catch (IOException ex) {
            if (LOGGER.isLoggable(Level.INFO)) {
                LOGGER.info(message + ex.getMessage());
            }
        }
        System.out.println(response.getStatusLine());
    }
}
