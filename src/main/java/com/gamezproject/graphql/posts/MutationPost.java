package com.gamezproject.graphql.posts;

import java.util.UUID;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.gamezproject.DAO.PostDao;
import com.gamezproject.entity.Post;
import org.springframework.stereotype.Component;

@Component
public class MutationPost implements GraphQLMutationResolver {
    private PostDao postDao;

    public MutationPost(PostDao postDao) {
        this.postDao = postDao;
    }

    public Post writePost(String title, String text, String category, String author) {
        Post post = new Post();
        post.setId(UUID.randomUUID().toString());
        post.setTitle(title);
        post.setText(text);
        post.setCategory(category);
        post.setAuthorId(author);
        postDao.savePost(post);

        return post;
    }


}
