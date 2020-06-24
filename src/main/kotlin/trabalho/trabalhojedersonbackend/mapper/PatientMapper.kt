package trabalho.trabalhojedersonbackend.mapper

import org.mapstruct.InjectionStrategy
import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.ReportingPolicy
import trabalho.trabalhojedersonbackend.model.Patient
import trabalho.trabalhojedersonbackend.model.request.PatientRequest

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PatientMapper {

    @Mapping(source = "address", target = "address")
    fun convertToPatient(patientRequest: PatientRequest): Patient
}