package com.example.api;

import com.example.enums.SecurityStatus;

/**
 * @author David.Shahbazyan
 * @since Mar 09, 2017
 */
public interface SecurityService {
    SecurityStatus check();
}
