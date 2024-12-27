package com.vinay;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class StockService {
	
	@Autowired
	private Stockrepo stockRepository;

	
	  public Stock addStock(Stock stock) {
	        return stockRepository.save(stock);
	    }
	  
	  public List<Stock> getAllStocks() {
	        return stockRepository.findAll();
	    }
	  
	  public Stock updateStock(int id, Stock updatedStock) {
	        return stockRepository.findById(id).map(stock -> {
	            stock.setStockName(updatedStock.getStockName());
	            stock.setTicker(updatedStock.getTicker());
	            stock.setQuantity(updatedStock.getQuantity());
	            stock.setBuyPrice(updatedStock.getBuyPrice());
	            return stockRepository.save(stock);
	        }).orElseThrow(() -> new RuntimeException("Stock not found"));
	    }
	  
	  
	  public void deleteStock(int id) {
	        if (stockRepository.existsById(id)) {
	            stockRepository.deleteById(id);
	        } else {
	            throw new RuntimeException("Stock not found");
	        }
	    }
	  
	  public BigDecimal calculatePortfolioValue() {
	        List<Stock> stocks = stockRepository.findAll();
	        return stocks.stream()
	                .map(stock -> stock.getBuyPrice().multiply(BigDecimal.valueOf(stock.getQuantity())))
	                .reduce(BigDecimal.ZERO, BigDecimal::add);
	    }
	  
	  
}
