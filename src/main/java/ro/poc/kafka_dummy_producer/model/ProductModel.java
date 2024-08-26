package ro.poc.kafka_dummy_producer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductModel {
    private String id;
    private String name;
    private BigDecimal price;
    private String categoryId;
}
