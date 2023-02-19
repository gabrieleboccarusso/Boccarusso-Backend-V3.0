package boccarusso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import boccarusso.entity.Article;

public interface ArticleRepository extends JpaRepository<Article, String> {
 Iterable<Article> findByTitleContaining(String title);

 Iterable<Article> findByTagSlug(String tag_slug);
}
