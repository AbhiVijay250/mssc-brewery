package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.BeerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Slf4j
@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDTO getBeerById(UUID beerId) {
        return BeerDTO.builder().id(beerId).beerName("KingFisher")
                .beerStyle("Chilled").build();
    }

    @Override
    public BeerDTO saveNewBeer(BeerDTO beerDTO) {
        return BeerDTO.builder().id(UUID.randomUUID())
                .beerName(beerDTO.getBeerName())
                .build();
    }

    @Override
    public void updateBeer(UUID beerId, BeerDTO beerDTO) {
        // TODO: 12/09/21 would update beer
    }

    @Override
    public void deleteById(UUID beerId) {
        log.debug("Deleting Beer With Id" + beerId.toString());
    }
}
