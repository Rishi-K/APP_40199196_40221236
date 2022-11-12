import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Books {

    List<String> publishers;
    String title;

    @JsonProperty(value = "number_of_pages")
    int pageCount;
    String key;
    List<String> authors;
    List<String> ISBN;
    List<String> covers;
    List<String> languages;
    String publish_date;
    int copiesBought;

}
