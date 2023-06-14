package com.cls.domain.ports.commons.utilities;

import org.springframework.stereotype.Component;
import java.util.Date;

@Component
public class Utilities {
    public Date getDate() {
        return new Date();
    }
}
