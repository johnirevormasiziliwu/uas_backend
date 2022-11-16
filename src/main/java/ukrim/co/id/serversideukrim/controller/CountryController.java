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
import ukrim.co.id.serversideukrim.model.Country;
import ukrim.co.id.serversideukrim.service.CountryService;

@RestController
@RequestMapping("/country")
public class CountryController {

  private CountryService countryService;

  @Autowired
  public CountryController(CountryService countryService) {
    this.countryService = countryService;
  }

  // http://localhost:8088/country
  @GetMapping
  public List<Country> getAll() {
    return countryService.getAll();
  }

  @GetMapping("/{id}")
  public Country getById(@PathVariable Long id) {
    return countryService.getById(id);
  }

  // http://localhost:8088/region/1   (PathVariable) Detail

  @PostMapping
  public Country create(@RequestBody Country country) {
    return countryService.create(country);
  }

  // http://localhost:8088/country

  @PutMapping("/{id}")
  public Country update(@PathVariable Long id, @RequestBody Country country) {
    return countryService.update(id, country);
  }

  // http://localhost:8088/country/1

  @DeleteMapping("/{id}")
  public Country delete(@PathVariable Long id) {
    return countryService.delete(id);
  }
}
