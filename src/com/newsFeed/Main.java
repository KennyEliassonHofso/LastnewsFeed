package com.newsFeed;


import express.Express;
import express.middleware.Middleware;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Express app = new Express();
        Database db = new Database();


        app.post("/article", (request, response) -> {
            Article article = (Article) request.getBody(Article.class);
            response.json(db.createArticle(article));
        });

        app.put("/articles", (request, response) -> {
            Article articles = (Article) request.getBody(Article.class);
            response.json(db.updateArticle(articles));

        });

        app.delete("/articles", (request, response) -> {
            Article articles = (Article) request.getBody(Article.class);
            response.json(db.deleteArticle(articles));

        });

        app.get("/articles", (request, response) -> {
            List<Article> news = db.getNews();

            response.json(news);
        });

        try {
            app.use(Middleware.statics(Paths.get("src/www").toString()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        app.listen(5000);

    }
}
