package com.example.realboard;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BoardRepository  extends JpaRepository<Board, Long> {
    Board findByUser(User user);
}
