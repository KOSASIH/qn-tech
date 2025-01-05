package com.qntech.interoperability;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/interop")
public class InteropController {

    @Autowired
    private InteropService interopService;

    @PostMapping("/transfer")
    public ResponseEntity<String> initiateTransfer(@RequestBody TransferRequest request) {
        String transactionId = interopService.initiateTransfer(request);
        return ResponseEntity.ok("Transfer initiated with transaction ID: " + transactionId);
    }

    @GetMapping("/status/{transactionId}")
    public ResponseEntity<TransferStatus> getTransferStatus(@PathVariable String transactionId) {
        TransferStatus status = interopService.getTransferStatus(transactionId);
        return ResponseEntity.ok(status);
    }
}
