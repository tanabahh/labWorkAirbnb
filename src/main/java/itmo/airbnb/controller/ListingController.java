package itmo.airbnb.controller;

import itmo.airbnb.camunda.StarterService;
import itmo.airbnb.domain.Listing;
import itmo.airbnb.dto.request.ListingCreateRequest;
import itmo.airbnb.dto.request.SearchRequest;
import itmo.airbnb.dto.response.ListingGetResponse;
import itmo.airbnb.dto.response.SearchResponse;
import itmo.airbnb.service.ListingService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping(value = "/listing")
public class ListingController {

    private final ListingService listingService;
    private final StarterService starterService;

    ListingController(ListingService listingService,
                      StarterService starterService) {
        this.listingService = listingService;
        this.starterService = starterService;
    }

    @PostMapping("/search")
    @ResponseBody
    public SearchResponse search(@RequestBody SearchRequest searchRequest) {
        return listingService.search(searchRequest.getCity(), searchRequest.getStartDate(),
                searchRequest.getEndDate(), searchRequest.getPriceMin(), searchRequest.getPriceMax());
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public ListingGetResponse get(@PathVariable("id") Long id) {
        return listingService.get(id);
    }

    @PostMapping(value = "/create-request")
    @PreAuthorize("hasRole('HOST')")
    public ResponseEntity<Void> requestCreation(@RequestBody ListingCreateRequest request) {
        starterService.startListingCreationProcess(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/create")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> create(HttpServletRequest request) {
        // TODO: simple listing save
        return ResponseEntity.ok().build();
    }

}
