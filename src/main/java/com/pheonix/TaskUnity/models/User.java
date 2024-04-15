package com.pheonix.TaskUnity.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "unityuser",schema = "core")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int unity_user_id;
    private String username;
    private String email;
    private String password;

    @Transient
    private String message;
}
