package com.perfumeOnlineStore.discount;

import com.perfumeOnlineStore.product.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DiscountService {
    private final DiscountRepository discountRepository;

    public List<Discount> findAllDiscounts() {
        return discountRepository.findAll();
    }

    public Optional<Discount> findDiscountById(Long id) {
        return discountRepository.findById(id);
    }

    public void saveDiscount(Discount discount) {
        discountRepository.save(discount);
    }

    public void deleteDiscount(Discount discount) {
        discountRepository.delete(discount);
    }
}
