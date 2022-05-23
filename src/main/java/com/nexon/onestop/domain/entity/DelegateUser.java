package com.nexon.onestop.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DelegateUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delegateUser_id")
    private Long id;

    @Column(nullable = false)
    private String username;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "delegate_id")
    private Delegate delegate;

    @Builder
    private DelegateUser(String username, Delegate delegate) {
        this.username = username;

        if (delegate != null) {
            changeDelegate(delegate);
        }
    }

    public void changeDelegate(Delegate delegate) {
        this.delegate = delegate;
        delegate.getDelegateUsers().add(this);
    }
}
