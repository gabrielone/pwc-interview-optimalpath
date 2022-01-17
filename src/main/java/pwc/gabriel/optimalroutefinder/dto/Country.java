package pwc.gabriel.optimalroutefinder.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {

    private String cca3;

    @EqualsAndHashCode.Exclude
    private List<String> borders = new ArrayList<>();

}
