package com.bachtx.authenticationservice.dto.request;

import com.bachtx.authenticationservice.validators.FieldsMatch;
import com.bachtx.authenticationservice.validators.ValidPassword;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.validation.annotation.Validated;

@AllArgsConstructor
@Getter
@Setter
@Validated
@FieldsMatch(
        field = "password",
        fieldMatch = "confirmationPassword"
)
@ToString
public class RegisterRequest {
    private String email;
    @ValidPassword
    private String password;
    private String confirmationPassword;
}
