package com.qntech.identity;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class IdentityService {

    private Map<String, Identity> identityStore = new HashMap<>();

    public String createIdentity(IdentityRequest request) {
        Identity identity = new Identity(request.getUser Id(), request.getPublicKey());
        identityStore.put(identity.getId(), identity);
        return identity.getId();
    }

    public boolean verifyIdentity(IdentityVerificationRequest request) {
        Identity identity = identityStore.get(request.getIdentityId());
        return identity != null && identity.getPublicKey().equals(request.getPublicKey());
    }
}
