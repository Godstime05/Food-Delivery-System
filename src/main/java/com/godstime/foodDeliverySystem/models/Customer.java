package com.godstime.foodDeliverySystem.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "customers")
public class Customer {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_id")
    @SequenceGenerator(sequenceName = "seq_id", allocationSize = 1, name = "seq_id")
    private Integer customerId;

    @NotBlank(message = "please enter your full name")
    @Column(name = "customer_name", length = 25)
    private String name;

    private String address;

    @Column(length = 25)
    @NotNull(message = "please type your email address")
    @Email(message = "please provide correct email id")
    private String email;

    @NotNull
    private String password;

    private long phoneNo;

    private String gender;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "customers")
    @JsonIgnoreProperties("customers")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Cart> listItem = new ArrayList<>();
}