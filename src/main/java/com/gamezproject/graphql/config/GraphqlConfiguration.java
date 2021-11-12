package com.gamezproject.graphql.config;

import java.util.ArrayList;
import java.util.List;

import com.gamezproject.DAO.AuthorDao;
import com.gamezproject.DAO.PostDao;
import com.gamezproject.entity.Author;
import com.gamezproject.entity.Post;
import com.gamezproject.graphql.posts.AuthorResolver;
import com.gamezproject.graphql.posts.MutationPost;
import com.gamezproject.graphql.posts.PostResolver;
import com.gamezproject.graphql.posts.QueryPost;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphqlConfiguration {
    @Bean
    public PostDao postDao() {
        List<Post> posts = new ArrayList<>();
        for (int postId = 0; postId < 10; ++postId) {
            for (int authorId = 0; authorId < 10; ++authorId) {
                Post post = new Post();
                post.setId("Post" + authorId + postId);
                post.setTitle("Post " + authorId + ":" + postId);
                post.setText("Post " + postId + " + by author " + authorId);
                post.setAuthorId("Author" + authorId);
                posts.add(post);
            }
        }
        return new PostDao(posts);
    }

    @Bean
    public AuthorDao authorDao() {
        List<Author> authors = new ArrayList<>();
        for (int authorId = 0; authorId < 10; ++authorId) {
            Author author = new Author();
            author.setId("Author" + authorId);
            author.setName("Author " + authorId);
            author.setThumbnail("http://example.com/authors/" + authorId);
            authors.add(author);
        }
        return new AuthorDao(authors);
    }

    @Bean
    public PostResolver postResolver(AuthorDao authorDao) {
        return new PostResolver(authorDao);
    }

    @Bean
    public AuthorResolver authorResolver(PostDao postDao) {
        return new AuthorResolver(postDao);
    }

    @Bean
    public QueryPost queryPost(PostDao postDao) {
        return new QueryPost(postDao);
    }

    @Bean
    public MutationPost mutationPost(PostDao postDao) {
        return new MutationPost(postDao);
    }



}
