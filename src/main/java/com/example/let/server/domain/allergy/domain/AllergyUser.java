package com.example.let.server.domain.allergy.domain;

import com.example.let.server.domain.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AllergyUser {
    private Long allergyUserId;
    private User user;
    private Allergy allergy;
}
