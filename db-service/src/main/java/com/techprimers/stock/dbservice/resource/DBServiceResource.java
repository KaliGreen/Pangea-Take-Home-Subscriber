package com.techprimers.stock.dbservice.resource;

import com.techprimers.stock.dbservice.models.Quote;
import com.techprimers.stock.dbservice.repository.QuotesRepository;

import requests.Quotes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Green on 21/03/2018.
 */

@RestController
@RequestMapping("/rest/db")
public class DBServiceResource {

    @Autowired
    private QuotesRepository quotesRepository;

    @GetMapping("/{username}")
    public List<String> getQuotes(@PathVariable("username") final String username){

            return  getQuotesByUsername(username);
    }
    
    @PostMapping("/delete/{username}")
    public List<String> delete(@PathVariable("username") final String username) {
    List <Quote> quotes = quotesRepository.findByUsername(username);
    
    	quotesRepository.delete(quotes);
    	return getQuotesByUsername(username);
    }

	@RequestMapping(value = "/add", method = RequestMethod.POST)
    public List<String> add(@RequestBody final Quotes quotes){
    	quotes.getQuotes()
	    	.stream()
	    	.map(quote -> new Quote(quotes.getUserName(), quote))
	    	.forEach(quote -> quotesRepository.save(quote));
 
    	return  getQuotesByUsername(quotes.getUserName());
    }
    
    private List<String> getQuotesByUsername(@PathVariable("username") final String username){

    	return quotesRepository.findByUsername(username)
                .stream()
                .map(Quote::getQuote)
                .collect(Collectors.toList());
    }
}
