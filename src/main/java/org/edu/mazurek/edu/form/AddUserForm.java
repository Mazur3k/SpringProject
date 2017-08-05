package org.edu.mazurek.edu.form;

import lombok.*;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.ZonedDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AddUserForm {

    @NotEmpty
    @Size(min = 2, max = 30)
    private String firstname;

    @NotEmpty
    @Size(min = 2, max = 30)
    private String lastname;

    @NotEmpty
    @Email
    private String email;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate birthdate;

    @NotEmpty
    private String password;
}
