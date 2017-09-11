package com.github.vverrier.jackpotapi.penalty;

import com.github.vverrier.jackpotapi.util.exception.TechnicalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;

/**
 * @author vverrier
 */
@RestController
@RequestMapping("/api/penalties")
public class PenaltyController {

    @Autowired
    private PenaltyRepository rep;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Penalty read(@PathVariable("id") Long id) {
        Penalty p = rep.findById(id);
        p = new Penalty();
        p.setName("test");
        return p;
    }

    // TODO : gestion automatique des status et des exceptions
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Penalty penalty, HttpServletResponse response) throws Exception {
        Penalty p = rep.save(penalty);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(p.getId()).toUri();

        response.setHeader("location", location.toString());
        throw new TechnicalException("test");
    }
}
