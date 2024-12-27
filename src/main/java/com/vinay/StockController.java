package com.vinay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/stocks")
public class StockController {
	
	@Autowired
	StockService stockService;
	
	
	  @PostMapping("/addstock")
	    public ResponseEntity<Stock> addStock(@RequestBody Stock stock) {
	        return ResponseEntity.ok(stockService.addStock(stock));
	    }

	    // Get all stocks
	    @GetMapping("/getall")
	    public ResponseEntity<List<Stock>> getAllStocks() {
	        return ResponseEntity.ok(stockService.getAllStocks());
	    }

	    // Update a stock
	    @PutMapping("/{id}")
	    public ResponseEntity<Stock> updateStock(@PathVariable int id, @RequestBody Stock stock) {
	        return ResponseEntity.ok(stockService.updateStock(id, stock));
	    }

	    // Delete a stock
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteStock(@PathVariable int id) {
	        stockService.deleteStock(id);
	        return ResponseEntity.noContent().build();
	    }

	    // Get total portfolio value
	    @GetMapping("/portfolio-value")
	    public ResponseEntity<BigDecimal> getPortfolioValue() {
	        return ResponseEntity.ok(stockService.calculatePortfolioValue());
	    }

}
