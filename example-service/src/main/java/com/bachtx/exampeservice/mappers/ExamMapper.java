package com.bachtx.exampeservice.mappers;

import com.bachtx.exampeservice.dto.response.ExamResponse;
import com.bachtx.exampeservice.entities.Exam;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExamMapper {
    ExamMapper INSTANCE = Mappers.getMapper(ExamMapper.class);

    @Mappings({
            //...some config for mapper method
    })
    ExamResponse examToExamResponse(Exam exam);
}
