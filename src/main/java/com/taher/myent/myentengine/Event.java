package com.taher.myent.myentengine;

import java.util.Date;
import java.util.List;
import lombok.Data;

/**
 * @author Taher Khorshidi
 */
@Data
public class Event {

    private Date time;
    private String title;
    private String description;
    private Integer priority;
    private List<String> tags;

}
