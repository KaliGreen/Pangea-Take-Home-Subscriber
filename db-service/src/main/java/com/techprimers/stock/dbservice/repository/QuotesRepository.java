package com.techprimers.stock.dbservice.repository;

import com.techprimers.stock.dbservice.models.Quote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Green on 21/03/2018.
 */
public interface QuotesRepository extends JpaRepository<Quote, Integer > {

    List<Quote> findByUsername(String username);
}
