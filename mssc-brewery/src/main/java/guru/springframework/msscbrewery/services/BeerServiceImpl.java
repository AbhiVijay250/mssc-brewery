package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.BeerDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDTO getBeerById(UUID beerId) {
        return BeerDTO.builder().id(beerId).beerName("KingFisher")
                .beerStyle("Chilled").build();
    }
}
