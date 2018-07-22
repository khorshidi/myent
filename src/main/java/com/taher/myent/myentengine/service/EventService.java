package com.taher.myent.myentengine.service;

import com.taher.myent.myentengine.Event;
import org.influxdb.dto.Point;
import org.influxdb.dto.Point.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.influxdb.InfluxDBTemplate;
import org.springframework.stereotype.Service;

/**
 * @author Taher Khorshidi
 */
@Service
public class EventService {

    private final InfluxDBTemplate<Point> influxDBTemplate;

    @Autowired
    public EventService(InfluxDBTemplate<Point> influxDBTemplate) {
        this.influxDBTemplate = influxDBTemplate;
    }

    public void save(Event event) {
        Point point = buildPoint(event);
        influxDBTemplate.write(point);
    }

    private Point buildPoint(Event event) {
        Builder builder = Point.measurement("myent")
              .addField("priority", event.getPriority())
              .addField("title", event.getTitle())
              .addField("description", event.getDescription());
        for (String tag : event.getTags()) {
            builder.tag(tag, "T");
        }
        return builder.build();
    }
}
