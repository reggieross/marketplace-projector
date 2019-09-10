package rest;

import domain.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "catalogClient", url = "${feign.catalog.api.uri}")
public interface ICatalogClient {

    @RequestMapping(method = RequestMethod.POST, value = "/products")
    long createProduct(@RequestBody Product product);
}
