package mira.space.oms.domen.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class KafkaMessage {
    private Integer number;
    private String message;
}
