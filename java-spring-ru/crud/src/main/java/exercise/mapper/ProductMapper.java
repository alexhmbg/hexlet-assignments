package exercise.mapper;

import exercise.dto.*;
import exercise.model.Product;
import org.mapstruct.*;

// BEGIN
@Mapper(
        uses = { JsonNullableMapper.class, ReferenceMapper.class },
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public abstract class ProductMapper {
    @Mapping(target = "category", source = "categoryId")
    public abstract Product map(ProductCreateDTO dto);

    @Mapping(target = "categoryId", source = "category.id")
    @Mapping(target = "categoryName", source = "category.name")
//    @InheritInverseConfiguration
    public abstract ProductDTO map(Product model);

    @Mapping(target = "category", source = "categoryId")
//    @InheritConfiguration
    public abstract void update(ProductUpdateDTO dto, @MappingTarget Product model);
}
// END
