package com.atlas.Mo_on_Life.repository;

import com.atlas.Mo_on_Life.entity.Post;
import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    Optional<Post> findByCreatedAtAndSlug(LocalDate createdAt, String slug);

    List<Post> findTop10ByTags_NameOrderByViewCountDesc(String name);
}
