package com.projeto_cidades.dio.projeto_cidades.Taxes.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/taxes")
public class TaxResource {

    private final TaxRepository taxRepository;
    Logger log = LoggerFactory.getLogger(TaxResource.class);

    private final TaxService service;

    public TaxResource(TaxRepository taxRepository, TaxService service){
        this.taxRepository = taxRepository;
        this.service = service;
    }


    @GetMapping("/all")
    public Page<Tax> cities(final Pageable page) {
        return taxRepository.findAll(page);
    }

    @GetMapping("/difal")
    public ResponseEntity difalcompleto(@RequestParam(name = "from") final Long state1,
                                        @RequestParam(name = "to") final Long state2){
        log.info("difal");
        return ResponseEntity.ok().body(service.calcTaxDifalStates(state1, state2));
    }


}
