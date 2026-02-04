package today.caro.api.vehicle.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import today.caro.api.common.exception.BusinessException;
import today.caro.api.common.exception.ErrorCode;
import today.caro.api.vehicle.dto.VehicleBrandListResponse;
import today.caro.api.vehicle.dto.VehicleModelListResponse;
import today.caro.api.vehicle.repository.CarBrandRepository;
import today.caro.api.vehicle.repository.CarModelRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final CarBrandRepository carBrandRepository;
    private final CarModelRepository carModelRepository;

    @Transactional(readOnly = true)
    public List<VehicleBrandListResponse> getAllBrands() {
        return carBrandRepository.findAll().stream()
            .map(VehicleBrandListResponse::from)
            .toList();
    }

    @Transactional(readOnly = true)
    public List<VehicleModelListResponse> getModelsByBrand(Long brandId, String keyword) {
        if (!carBrandRepository.existsById(brandId)) {
            throw new BusinessException(ErrorCode.BRAND_NOT_FOUND);
        }

        if (keyword != null && !keyword.isBlank()) {
            return carModelRepository.findByBrandIdAndKeyword(brandId, keyword).stream()
                .map(VehicleModelListResponse::from)
                .toList();
        }

        return carModelRepository.findByBrandId(brandId).stream()
            .map(VehicleModelListResponse::from)
            .toList();
    }

}
