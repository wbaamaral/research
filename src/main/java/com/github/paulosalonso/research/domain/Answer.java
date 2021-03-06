package com.github.paulosalonso.research.domain;

import lombok.*;

import java.time.OffsetDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder(toBuilder = true)
public class Answer {
    @Setter
    private OffsetDateTime date;
    private UUID researchId;
    private UUID questionId;
    private UUID optionId;
}
