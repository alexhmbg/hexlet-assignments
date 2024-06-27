package exercise.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import exercise.dto.ProductParamsDTO;
import exercise.model.Product;

import java.util.BitSet;

// BEGIN
@Component
public class ProductSpecification {

    public Specification<Product> build(ProductParamsDTO data) {
        return withTitleCont(data.getTitleCont())
                .and(withCategoryId(data.getCategoryId()))
                .and(withPriceLt(data.getPriceLt()))
                .and(withPriceGt(data.getPriceGt()))
                .and(withRatingGt(data.getRatingGt()));
    }

    private Specification<Product> withTitleCont(String titleCont) {
        return (root, query, cb) -> titleCont == null ? cb.conjunction() : cb.like(cb.lower(root.get("title")), "%" + titleCont.toLowerCase() + "%");
    }

    private Specification<Product> withCategoryId(Long categoryId) {
        return (root, query, cb) -> categoryId == null ? cb.conjunction() : cb.equal(root.get("category").get("id"), categoryId);
    }

    private Specification<Product> withPriceLt(Integer priceLt) {
        return (root, query, cb) -> priceLt == null ? cb.conjunction() : cb.lt(root.get("price"), priceLt);
    }

    private Specification<Product> withPriceGt(Integer priceGt) {
        return (root, query, cb) -> priceGt == null ? cb.conjunction() : cb.gt(root.get("price"), priceGt);
    }

    private Specification<Product> withRatingGt(Double ratingGt) {
        return (root, query, cb) -> ratingGt == null ? cb.conjunction() : cb.gt(root.get("rating"), ratingGt);
    }

}
// END