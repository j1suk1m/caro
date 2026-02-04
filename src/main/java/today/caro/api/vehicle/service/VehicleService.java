package today.caro.api.vehicle.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import today.caro.api.vehicle.dto.VehicleBrandListResponse;
import today.caro.api.vehicle.repository.CarBrandRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final CarBrandRepository carBrandRepository;

    @Transactional(readOnly = true)
    public List<VehicleBrandListResponse> getAllBrands() {
        return carBrandRepository.findAll().stream()
            .map(VehicleBrandListResponse::from)
            .toList();
    }

}
