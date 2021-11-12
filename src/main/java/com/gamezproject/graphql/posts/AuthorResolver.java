package com.gamezproject.graphql.posts;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.gamezproject.DAO.PostDao;
import com.gamezproject.entity.Author;
import com.gamezproject.entity.Post;
import java.util.List;

public class AuthorResolver implements GraphQLResolver<Author> {
    private PostDao postDao;

    public AuthorResolver(PostDao postDao) {

        this.postDao = postDao;
    }

    public List<Post> getPosts(Author author) {

        return postDao.getAuthorPosts(author.getId());
    }
}
