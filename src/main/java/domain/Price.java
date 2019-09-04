package domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
class Price {
    private String currency;
    private String amount;
}
