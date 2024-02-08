package com.bachtx.authenticationservice.dto.request;

import com.bachtx.authenticationservice.validators.FieldsMatch;
import com.bachtx.authenticationservice.validators.ValidPassword;
import jakarta.validation.constraints.Email;
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
    @Email(message = "Invalid email format. Please enter a valid email address")
    private String email;
    @ValidPassword(message = "Password must be at least 8 characters long and contain a combination of letters, numbers, and special characters")
    private String password;
    private String confirmationPassword;
}
