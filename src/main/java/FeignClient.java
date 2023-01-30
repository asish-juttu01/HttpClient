
import feign.Headers;
import feign.Param;
import feign.RequestLine;


public interface FeignClient{
@RequestLine("GET /{id}")
Root findById(@Param("id") int id);
@RequestLine("GET")
RootList findAll();
@RequestLine("POST")
    @Headers(("Content-Type: application/json"))
    void insert(Root root);
}
