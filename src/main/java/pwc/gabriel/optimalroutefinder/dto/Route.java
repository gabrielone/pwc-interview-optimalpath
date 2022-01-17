package pwc.gabriel.optimalroutefinder.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Route {
    private List<String> route = new ArrayList<>();
}
