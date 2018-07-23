package com.taher.myent.myentengine.controller;

import com.taher.myent.myentengine.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Taher Khorshidi
 */
@RepositoryRestController
@RequestMapping(value = "/analysis")
public class TagController {

    private final TagService tagService;

    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping
    public ResponseEntity readAll(Pageable pageable, Sort sort) {
        return ResponseEntity.ok(tagService.findAll());
    }


}
