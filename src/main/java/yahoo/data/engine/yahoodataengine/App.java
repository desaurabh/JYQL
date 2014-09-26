package yahoo.data.engine.yahoodataengine;
import java.net.MalformedURLException;
import java.net.URL;
import data.engine.request.builder.BufferedResponse;
import java.io.IOException;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.node.JsonNodeFactory;
import org.codehaus.jackson.JsonNode;



public class App {

	/**
	 * @param args
	 */
	private static String reqUrl="https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%3D28743736&format=json&diagnostics=true&callback=";
	public static void main(String[] args) {
		URL url=null;
		try {
			url = new URL(reqUrl);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedResponse br=new BufferedResponse(url);
		System.out.print(br.getJsonResponse());
		

	}
        
        public void parseJson() throws IOException{
            JsonNodeFactory factory = new JsonNodeFactory();
            
            JsonFactory jsonFactory=new JsonFactory();
            JsonGenerator jsonGenerator=jsonFactory.createJsonGenerator(System.out);
            ObjectMapper mapper=new ObjectMapper();
            JsonNode weather=factory.objectNode();
            mapper.writeTree(jsonGenerator, weather);
                    
            
            
        }

}
