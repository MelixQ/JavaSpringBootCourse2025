package ru.kuznetsovmd.MySecondTestAppSpringBoot.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import ru.kuznetsovmd.MySecondTestAppSpringBoot.exception.UnsupportedCodeException;
import ru.kuznetsovmd.MySecondTestAppSpringBoot.exception.ValidationFailedException;

@Service
public class RequestValidationService implements ValidationService {
    @Override
    public void isValid(BindingResult bindingResult) throws ValidationFailedException {
        if (bindingResult.hasErrors()) {
            throw new
                    ValidationFailedException("Validation failed: " + bindingResult.getFieldError().getDefaultMessage());
        }
    }

    @Override
    public void isValidUid(String uid) throws UnsupportedCodeException {
        if (uid.equals("123")) {
            throw new UnsupportedCodeException("Unsupported UID value posted!");
        }
    }
}