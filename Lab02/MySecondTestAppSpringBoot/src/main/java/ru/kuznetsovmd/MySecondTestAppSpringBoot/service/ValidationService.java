package ru.kuznetsovmd.MySecondTestAppSpringBoot.service;

import org.springframework.validation.BindingResult;
import ru.kuznetsovmd.MySecondTestAppSpringBoot.exception.UnsupportedCodeException;
import ru.kuznetsovmd.MySecondTestAppSpringBoot.exception.ValidationFailedException;

public interface ValidationService  {
    void isValid(BindingResult bindingResult) throws ValidationFailedException;
    void isValidUid(String uid) throws UnsupportedCodeException;
}
