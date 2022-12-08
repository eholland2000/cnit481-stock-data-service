package org.cnit481.group11.connections;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.cnit481.group11.models.PolygonData;

import javax.enterprise.context.ApplicationScoped;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@ApplicationScoped
public class PolygonConnection {

    private final SimpleDateFormat simpleDateFormat;
    private final ObjectMapper objectMapper;

    public PolygonConnection() {
        String pattern = "yyyy-MM-dd";
        this.simpleDateFormat = new SimpleDateFormat(pattern);
        this.objectMapper = new ObjectMapper();
    }

    public PolygonData retrieveDataFromPolygon(String stockSymbol, Date date) {
        try {
            simpleDateFormat.format(date);
            HttpUriRequest request = new HttpGet( "https://api.polygon.io/v1/open-close/" +
                    stockSymbol.trim() + "/" + simpleDateFormat.format(date) +
                    "?adjusted=true&apiKey=GET_YOUR_OWN");
            HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );
            if (httpResponse.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Error response from Polygon API with code: " +
                        httpResponse.getStatusLine().getStatusCode() + " and response: " +
                        httpResponse.getEntity().getContent());
            }
            String responseString = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
            return objectMapper.readValue(responseString, PolygonData.class);
        } catch (IOException ioexc) {
            ioexc.printStackTrace();
        }
        return null;
    }
}
