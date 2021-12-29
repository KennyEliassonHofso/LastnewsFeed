package com.newsFeed;

import com.fasterxml.jackson.core.JsonProcessingException;
import express.utils.Utils;

import java.sql.*;
import java.util.List;

public class Database {

    private Connection conn;

    public Database() {
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:news.db");
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM news");
            ResultSet rs = stmt.executeQuery();
            System.out.println(rs.next());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Article> getNews() {
        List<Article> articles = null;

        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM articles ");
            ResultSet rs = stmt.executeQuery();
            Article[] newsFromRS = (Article[]) Utils.readResultSetToObject(rs, Article[].class);

            articles = List.of(newsFromRS);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return articles;
    }

    public boolean createArticle (Article article) {
        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO news (title, content, imageURL1, imageURL2(?, ?, ?, ?)");
            stmt.setString(1,article.getTitle());
            stmt.setString(2,article.getContent());
            stmt.setString(3,article.getImageURL1());
            stmt.setString(4,article.getImageURL2());
            ResultSet rs = stmt.executeQuery();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return true;
    }

    public boolean updateArticle(Article article) {
        try {
            PreparedStatement stmt = conn.prepareStatement("UPDATE news SET content = ? , title = ?, imageURL1 = ?, imageURL2 = ? WHERE id = ?");
            stmt.setString(1,article.getTitle());
            stmt.setString(2,article.getContent());
            stmt.setString(3,article.getImageURL1());
            stmt.setString(4,article.getImageURL2());
            stmt.setInt(5,article.getId());
            stmt.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteArticle(Article article) {
        try {
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM news WHERE id = ?");
            stmt.setInt(1, article.getId());
            stmt.executeUpdate();
            return true;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        }
    }
}

