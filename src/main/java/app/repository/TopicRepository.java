package app.repository;

import app.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TopicRepository extends JpaRepository<Topic, Long> {

    @Query("SELECT topic FROM Topic AS topic WHERE topic.name = :name")
    Topic findByName(@Param("name") String name);

    @Query("SELECT topic FROM Topic AS topic WHERE topic.theme = :theme")
    List<Topic> findAllByTheme(@Param("theme") String theme);
}
