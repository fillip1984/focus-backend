package org.home.productivity.focus.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public abstract class AbstractEntity {

    @Id
    @GeneratedValue
    private Long id;

    @CreatedDate
    @NotNull
    // @JsonView(Views.Audit.class)
    private LocalDateTime created;

    @CreatedBy
    @Size(max = 20)
    // @JsonView(Views.Audit.class)
    private String createdBy;

    @LastModifiedDate
    @NotNull
    // @JsonView(Views.Audit.class)
    private LocalDateTime updated;

    @LastModifiedBy
    @Size(max = 20)
    // @JsonView(Views.Audit.class)
    private String updatedBy;

}
