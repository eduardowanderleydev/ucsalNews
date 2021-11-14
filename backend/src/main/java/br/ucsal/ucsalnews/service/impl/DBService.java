package br.ucsal.ucsalnews.service.impl;

import br.ucsal.ucsalnews.security.SecurityConfig;
import br.ucsal.ucsalnews.entity.Category;
import br.ucsal.ucsalnews.entity.Comment;
import br.ucsal.ucsalnews.entity.New;
import br.ucsal.ucsalnews.entity.User;
import br.ucsal.ucsalnews.enums.Role;
import br.ucsal.ucsalnews.repository.CategoryRepository;
import br.ucsal.ucsalnews.repository.CommentRepository;
import br.ucsal.ucsalnews.repository.NewRepository;
import br.ucsal.ucsalnews.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;


@Service
public class DBService {


    @Autowired
    CommentRepository commentRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    NewRepository newRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    SecurityConfig encoder;


    public void instantiateTestDatabase() {

        User user = new User(null, "nome", "userName", "nome@email.com", "senha", Role.CLIENTE);
        User user2 = new User(null, "nome2", "userName2", "nome2@email.com", "senha2", Role.ADMIN);

        user.setPassword(encoder.getPasswordEncoder().encode(user.getPassword()));
        user2.setPassword(encoder.getPasswordEncoder().encode(user2.getPassword()));

        New news = new New(null, "title", "Conteúdo", "image", user2);
        New news2 = new New(null, "title2", "Conteúdo2", "image2", user);

        Comment comment = new Comment(null, "Conteúdo", user2, news2);
        Comment comment2 = new Comment(null, "Conteúdo2", user, news);
        Comment comment3 = new Comment(null, "Conteúdo3", user, news2);


        Category category = new Category(null, "categoria");
        Category category2 = new Category(null, "categoria2");
        Category category3 = new Category(null, "categoria3");


        news.getComments().addAll(Arrays.asList(comment2));
        news2.getComments().addAll(Arrays.asList(comment, comment3));

        newRepository.saveAll(Arrays.asList(news, news2));
        categoryRepository.saveAll(Arrays.asList(category, category2, category3));

        news.getCategories().addAll(Arrays.asList(category2, category3));
        news2.getCategories().addAll(Arrays.asList(category));

        newRepository.saveAll(Arrays.asList(news, news2));

        userRepository.saveAll(Arrays.asList(user, user2));

    }


}
