package io.kielbo.todoapp.model;

import java.time.LocalDateTime;

import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@MappedSuperclass
public abstract class BaseAuditableEntity {
	private LocalDateTime createdOn;
	private LocalDateTime updatedOn;

	@PrePersist
	void prePersist() {
		createdOn = LocalDateTime.now();
	}

	@PreUpdate
	void preUpdate() {
		updatedOn = LocalDateTime.now();
	}

}
