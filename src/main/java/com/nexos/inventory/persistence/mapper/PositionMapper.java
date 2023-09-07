package com.nexos.inventory.persistence.mapper;


import com.nexos.inventory.domain.PositionDto;
import com.nexos.inventory.persistence.entity.Position;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PositionMapper {
    PositionDto toPositionDto(Position position);

    List<PositionDto> toPositionsDto(List<Position> positions);

    @InheritInverseConfiguration
    @Mapping(target = "users", ignore = true)
    Position toPosition(PositionDto positionDto);
}
