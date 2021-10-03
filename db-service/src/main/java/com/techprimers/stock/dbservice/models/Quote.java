package com.techprimers.stock.dbservice.models;

import javax.persistence.*;

/**
 * Created by Green on 21/03/2018.
 */

@Entity
@Table(name = "quotes", catalog = "test")
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_name")
    private String username;

    @Column(name = "quote")
    private String quote;

    public Quote(){}
    
    public Quote(String username, String quote) {
		this.username = username;
		this.quote = quote;
	}



	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
}
