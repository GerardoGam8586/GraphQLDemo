package com.gamezproject.graphql.posts;

import java.util.Optional;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.gamezproject.DAO.AuthorDao;
import com.gamezproject.entity.Author;
import com.gamezproject.entity.Post;

public class PostResolver implements GraphQLResolver<Post> {
    private AuthorDao authorDao;

    public PostResolver(AuthorDao authorDao) {

        this.authorDao = authorDao;
    }

    public Optional<Author> getAuthor(Post post) {

        return authorDao.getAuthor(post.getAuthorId());
    }
}
