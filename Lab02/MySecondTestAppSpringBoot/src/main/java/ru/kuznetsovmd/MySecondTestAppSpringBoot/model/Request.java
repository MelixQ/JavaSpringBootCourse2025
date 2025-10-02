package ru.kuznetsovmd.MySecondTestAppSpringBoot.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Request {
    @NotBlank(message = "UID is required")
    @Size(max = 32, message = "Max length of UID is 32 characters")
    private String uid;

    @NotBlank(message = "Operation UID is required")
    @Size(max = 32, message = "Max length of Operation UID is 32 characters")
    private String operationUid;

    private String systemName;

    @NotBlank(message = "System Time is required")
    private String systemTime;

    private String source;

    @Min(value = 1, message = "Communication Id must be at least 1")
    @Max(value = 100000, message = "Communication Id must be at most 100000")
    private int communicationId;

    private int templateId;
    private int productCode;
    private int smsCode;
}
