package com.perfumeOnlineStore.discount;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/discounts")
@RequiredArgsConstructor
public class DiscountController {
    private final DiscountService discountService;


    @GetMapping
    public ResponseEntity<List<Discount>> getAllProducts() {
        List<Discount> discounts = discountService.findAllDiscounts();

        return !discounts.isEmpty() ? new ResponseEntity<>(discounts, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{discountId}")
    public ResponseEntity<Discount> getDiscountById(@PathVariable("discountId") Long discountId) {
        Optional<Discount> discount = discountService.findDiscountById(discountId);

        return discount.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Discount> createProduct(@RequestBody Discount newDiscount) {
        try {
            discountService.saveDiscount(newDiscount);
            return new ResponseEntity<>(newDiscount, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{discountId}")
    public ResponseEntity<HttpStatus> deleteDiscount(@PathVariable("discountId") Long discountId) {
        Optional<Discount> existingDiscount = discountService.findDiscountById(discountId);
        if (existingDiscount.isPresent()) {
            discountService.deleteDiscount(existingDiscount.get());
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping(
            value = "/{discountId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Discount> updateProductById(@PathVariable("discountId") Long discountId,
                                                        @RequestBody Discount updatedDiscount) {
        Optional<Discount> existingDiscount = discountService.findDiscountById(discountId);

        if (existingDiscount.isPresent()) {
            Discount discount = existingDiscount.get();

            discount.setName(updatedDiscount.getName());
            discount.setDescription(updatedDiscount.getDescription());
            discount.setPercent(updatedDiscount.getPercent());
            discount.setStartedDate(updatedDiscount.getStartedDate());
            discount.setEndedDate(updatedDiscount.getEndedDate());

            discountService.saveDiscount(discount);

            return ResponseEntity.ok(discount);
        } else return ResponseEntity.notFound().build();
    }
}
