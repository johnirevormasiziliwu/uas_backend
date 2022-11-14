/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ukrim.co.id.serversideukrim.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ukrim.co.id.serversideukrim.model.Region;
import ukrim.co.id.serversideukrim.service.RegionService;

/**
 *
 * @author MSI-JO
 */
@RestController
@RequestMapping("/region")
public class RegionController {

    private RegionService regionService;

    @Autowired
    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    // http://localhost:8088/region
    @GetMapping
    public List<Region> getAll() {
        return regionService.getAll();
    }

    @GetMapping("/{id}")
    public Region getById(@PathVariable Long id) {
        return regionService.getById(id);
    }
    // http://localhost:8088/region/1   (PathVariable) Detail

    @PostMapping
    public Region create(@RequestBody Region region) {
        return regionService.create(region);
    }
    // http://localhost:8088/region 

    @PutMapping("/{id}")
    public Region update(@PathVariable Long id, @RequestBody Region region) {
        return regionService.update(id, region);
    }
    // http://localhost:8088/region/1

    @DeleteMapping("/{id}")
    public Region delete(@PathVariable Long id) {
        return regionService.delete(id);
    }
    // http://localhost:8088/region/1

}
