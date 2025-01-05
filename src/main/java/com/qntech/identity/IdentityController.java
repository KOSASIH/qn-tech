package com.qntech.identity;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/identity")
public class IdentityController {

    @Autowired
    private IdentityService identityService;

    @PostMapping("/create")
    public ResponseEntity<String> createIdentity(@RequestBody IdentityRequest request) {
        String identityId = identityService.createIdentity(request);
        return ResponseEntity.ok("Identity created with ID: " + identityId);
    }

    @PostMapping("/verify")
    public ResponseEntity<String> verifyIdentity(@RequestBody IdentityVerificationRequest request) {
        boolean isVerified = identityService.verifyIdentity(request);
        return ResponseEntity.ok("Identity verification status: " + (isVerified ? "Verified" : "Not Verified"));
    }
}
