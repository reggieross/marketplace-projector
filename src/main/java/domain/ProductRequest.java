package domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import lombok.Data;

import java.io.IOException;
import java.util.List;

@Builder
@Data
public class ProductRequest {
    private List<Product> products;

    public static ProductRequest fromJSON(String json) throws JsonProcessingException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, ProductRequest.class);
    }
}
