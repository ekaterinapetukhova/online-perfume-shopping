package com.perfumeOnlineStore.service;

import com.perfumeOnlineStore.entity.Discount;
import com.perfumeOnlineStore.repository.DiscountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DiscountService {
    private final DiscountRepository discountRepository;

    public List<Discount> findAllDiscounts() {
        return discountRepository.findAll();
    }

    public Optional<Discount> findDiscountById(UUID id) {
        return discountRepository.findById(id);
    }

    public void saveDiscount(Discount discount) {
        discountRepository.save(discount);
    }

    public void deleteDiscount(Discount discount) {
        discountRepository.delete(discount);
    }
}
