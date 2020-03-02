package guru.springframework.msscbrewery.web.controller;

import guru.springframework.msscbrewery.services.BeerService;
import guru.springframework.msscbrewery.web.model.BeerDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Created by jt on 2019-04-20.
 */
@RequestMapping("/api/v1/beers")
@RestController
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @GetMapping("/{beerId}")
    @ResponseStatus(HttpStatus.OK)
    public BeerDto getBeer(@PathVariable("beerId") UUID beerId){
        return beerService.getBeerById(beerId);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BeerDto> getBeers() {
        return beerService.listAllBeers();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void handlePost(@RequestBody BeerDto beerDto) {
        beerService.saveNewBeer(beerDto);
    }

    @PutMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBeer(@PathVariable("beerId") UUID beerId, @RequestBody BeerDto beerDto) {
        var updatedBeer = beerService.updateBeer(beerDto);
        if (updatedBeer == null) System.out.println("Couldn't find resource");
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeer(@PathVariable("beerId") UUID beerId) {
        var deletedBeer = beerService.deleteBeer(beerId);
        if (deletedBeer == null) System.out.println("Couldn't find resource");
    }

}
