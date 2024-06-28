package com.ssaldarriaga.sprintpulse.email;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
public enum EmailTemplateName {
    ACTIVATE_ACCOUNT("activate_account");

    private final String templateName;

    EmailTemplateName(String templateName) {
        this.templateName = templateName;
    }
}
