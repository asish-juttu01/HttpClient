import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;


public class Test_Feign {
    public static void main(String[] args){
        FeignClient feignClient = Feign.builder()
                .client(new OkHttpClient())
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logger(new Slf4jLogger(FeignClient.class))
                .logLevel(Logger.Level.FULL)
                .target(FeignClient.class, "https://reqres.in/api/users");
        Root root = feignClient.findById(2);
        ObjectMapper objectMapper = new ObjectMapper();
        String rootAsString = "";
        try {
            rootAsString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(root);
        }
        catch(JsonProcessingException e){
            e.printStackTrace();
        }
        RootList list = feignClient.findAll();
        String listAsString ="";
        try{
            listAsString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(list);
        }
        catch(JsonProcessingException e){
            e.printStackTrace();
        }
        System.out.println(rootAsString);
        System.out.println(listAsString);
    }
}

