package domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
class Product {
    private String site;
    private String name;
    private String brand;
    private String url;
    private Price price;
}
