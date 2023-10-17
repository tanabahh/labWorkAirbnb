package itmo.airbnb.controller;

import itmo.airbnb.domain.Listing;
import itmo.airbnb.dto.request.SearchRequest;
import itmo.airbnb.dto.response.SearchResponse;
import itmo.airbnb.service.ListingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping(value = "/listing")
public class ListingController {

    private final ListingService listingService;

    ListingController(ListingService listingService) {
        this.listingService = listingService;
    }

    @PostMapping("/search")
    @ResponseBody
    public SearchResponse search(@RequestBody SearchRequest searchRequest) {
        return listingService.search(searchRequest.getCity(), searchRequest.getStartDate(),
                searchRequest.getEndDate(), searchRequest.getPriceMin(), searchRequest.getPriceMax());
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public Listing get(@PathVariable("id") Long id) {
        return listingService.get(id);
    }

}
