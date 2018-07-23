package com.taher.myent.myentengine.service;

import com.taher.myent.myentengine.Tag;
import org.influxdb.dto.Query;
import org.influxdb.dto.QueryResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.influxdb.InfluxDBTemplate;
import org.springframework.stereotype.Service;

/**
 * @author Taher Khorshidi
 */
@Service
public class TagService {

    private final InfluxDBTemplate influxDBTemplate;

    @Autowired
    public TagService(InfluxDBTemplate influxDBTemplate) {
        this.influxDBTemplate = influxDBTemplate;
    }

    public Page<Tag> findAll() {
        QueryResult query = influxDBTemplate.query(new Query("show tag keys", "myent"));
        return null;
    }

}
