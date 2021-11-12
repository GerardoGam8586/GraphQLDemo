package com.gamezproject.graphql.posts;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.gamezproject.DAO.PostDao;
import com.gamezproject.entity.Post;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class QueryPost implements GraphQLQueryResolver {
    private PostDao postDao;

    public QueryPost(PostDao postDao) {
        this.postDao = postDao;
    }

    public List<Post> getRecentPosts(int count, int offset) {

        return postDao.getRecentPosts(count, offset);
    }

    public List<Post> getAllPosts() {

        return postDao.getAllPosts();
    }

    public Optional<Post> getPostByID(String postid){
        return postDao.getPostByID(postid);
    }



}
