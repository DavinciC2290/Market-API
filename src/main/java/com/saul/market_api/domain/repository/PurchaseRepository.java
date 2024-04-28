package com.saul.market_api.domain.repository;

import java.util.List;
import java.util.Optional;

import com.saul.market_api.domain.Purchase;

public interface PurchaseRepository {

    List<Purchase> getAll();
    Optional<List<Purchase>> getByClient(String clientId);
    Purchase save(Purchase purchase);
    
}
