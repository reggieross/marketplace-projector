package com.rross.marketplace.domain.model;

import com.rross.marketplace.constants.Site;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
class Price {
    private String currency;
    private String amount;
    private Site site;
}
