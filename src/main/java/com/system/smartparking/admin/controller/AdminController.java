package com.system.smartparking.admin.controller;
import com.system.smartparking.admin.service.AdminService;
import com.system.smartparking.user.dto.RegisterUserRequest;
import com.system.smartparking.user.dto.UserResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RequiredArgsConstructor
@RestController
public class AdminController {

    private final AdminService adminService;

    @PostMapping
    public ResponseEntity<UserResponse> createManager(
            @Valid @RequestBody RegisterUserRequest request) {

        UserResponse response = adminService.createManager(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PatchMapping("/{id}/deactivate-user")
    public ResponseEntity<Void> deactivateUser(@PathVariable Long id) {
        adminService.deactivateUser(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/activate-user")
    public ResponseEntity<Void> activateUser(@PathVariable Long id) {
        adminService.activateUser(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/activate-manager")
    public ResponseEntity<Void> activateManager(@PathVariable Long id) {
        adminService.activateManager(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/deactivate-manager")
    public ResponseEntity<Void> deactivateManager(@PathVariable Long id) {
        adminService.deactivateManager(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/block-user")
    public ResponseEntity<Void> blockUser(@PathVariable Long id) {
        adminService.blockUser(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/block-manager")
    public ResponseEntity<Void> blockManager(@PathVariable Long id) {
        adminService.blockManager(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllManagers() {
        List<UserResponse> responseList = adminService.getAllManagers();
        return ResponseEntity.ok(responseList);
    }
}