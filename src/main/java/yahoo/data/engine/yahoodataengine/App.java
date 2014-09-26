package yahoo.data.engine.yahoodataengine;

import java.net.MalformedURLException;
import java.net.URL;
import data.engine.request.builder.BufferedResponse;
import data.engine.request.unmarshaller.ChannelUnmarshaller;
import data.engine.request.unmarshaller.WeatherUnmarshaller;


public class App {

    /**
     * @param args
     */
    private static String reqUrl = "https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%3D28743736&format=json&diagnostics=true&callback=";

    public static void main(String[] args) {
        URL url = null;
        try {
            url = new URL(reqUrl);
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        BufferedResponse br = new BufferedResponse(url);
        ChannelUnmarshaller channelUnmarshaller=new ChannelUnmarshaller(br.getJsonResponse());  
        WeatherUnmarshaller weatherUnmarshaller=channelUnmarshaller.getWeatherUnmarshaller();

    }


}
