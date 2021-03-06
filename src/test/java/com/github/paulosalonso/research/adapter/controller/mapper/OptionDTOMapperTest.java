package com.github.paulosalonso.research.adapter.controller.mapper;

import com.github.paulosalonso.research.adapter.controller.dto.OptionCriteriaDTO;
import com.github.paulosalonso.research.adapter.controller.dto.OptionInputDTO;
import com.github.paulosalonso.research.domain.Option;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

public class OptionDTOMapperTest {

    private OptionDTOMapper mapper = new OptionDTOMapper();

    @Test
    public void givenAnOptionWhenMapThenReturnDTO() {
        var option = Option.builder()
                .id(UUID.randomUUID())
                .description("description")
                .notify(true)
                .build();

        var dto = mapper.toDTO(option);

        assertThat(dto.getId()).isEqualTo(option.getId());
        assertThat(dto.getDescription()).isEqualTo(option.getDescription());
        assertThat(dto.isNotify()).isEqualTo(option.isNotify());
    }

    @Test
    public void givenAnOptionInputDTOWhenMapThenReturnOption() {
        var optionInputDTO = OptionInputDTO.builder()
                .description("description")
                .notify(true)
                .build();

        var question = mapper.toDomain(optionInputDTO);

        assertThat(question.getId()).isNull();
        assertThat(question.getDescription()).isEqualTo(optionInputDTO.getDescription());
        assertThat(question.isNotify()).isEqualTo(optionInputDTO.isNotify());
    }

    @Test
    public void givenAnOptionCriteriaDTOWhenMapThenReturnOptionCriteria() {
        var optionCriteriaDTO = OptionCriteriaDTO.builder()
                .description("description")
                .notify(true)
                .build();

        var questionCriteria = mapper.toDomain(optionCriteriaDTO);

        assertThat(questionCriteria.getDescription()).isEqualTo(optionCriteriaDTO.getDescription());
        assertThat(questionCriteria.getNotify()).isEqualTo(optionCriteriaDTO.getNotify());
    }
}
