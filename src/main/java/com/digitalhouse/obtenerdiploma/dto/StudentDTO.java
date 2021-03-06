package com.digitalhouse.obtenerdiploma.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

public class StudentDTO {

    @NotEmpty(message = "El nombre del usuario no puede estar vacio.")
    @Pattern(regexp = "^[A-Z].*", message = "El nombre del alumno debe comenzar con mayuscula.")
    @Size(max=50, message = "La longitud del nombre no puede superar los 50 caracteres.")
    private String name;

    @NotEmpty(message = "La lista no puede ser vacía.")
    private List<@Valid SubjectDTO> subjects;

    public StudentDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SubjectDTO> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectDTO> subjects) {
        this.subjects = subjects;
    }

}
