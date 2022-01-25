package io.kielbo.todoapp.model;

import java.time.LocalDateTime;

import javax.persistence.Embeddable;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Embeddable
public class Audit {
	private LocalDateTime createdOn;
	private LocalDateTime updatedOn;

	@PrePersist
	void prePersist() {
		createdOn = LocalDateTime.now();
	}

	@PreUpdate
	void preMerge() {
		updatedOn = LocalDateTime.now();
	}

}
