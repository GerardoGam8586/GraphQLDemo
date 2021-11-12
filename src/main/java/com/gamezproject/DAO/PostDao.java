package com.gamezproject.DAO;

import com.gamezproject.entity.Post;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PostDao {
    private List<Post> posts;

    public PostDao(List<Post> posts) {
        this.posts = posts;
    }

    public List<Post> getRecentPosts(int count, int offset) {
        return posts.stream().skip(offset).limit(count).collect(Collectors.toList());
    }

    public List<Post> getAllPosts() {
        return posts;
    }

    public List<Post> getAuthorPosts(String author) {
        return posts.stream().filter(post -> author.equals(post.getAuthorId())).collect(Collectors.toList());
    }

    public Optional<Post> getPostByID(String postid){
        return posts.stream().filter(post -> postid.equals(post.getId())).findFirst();
    }

    public void savePost(Post post) {

        posts.add(0, post);
    }
}
