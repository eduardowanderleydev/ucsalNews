package br.ucsal.ucsalnews.service.impl;

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


    public void instantiateTestDatabase(){

        Comment comment = new Comment(null, "Conteúdo");
        Comment comment2 = new Comment(null, "Conteúdo2");
        Comment comment3 = new Comment(null, "Conteúdo3");


        Category category = new Category(null,"categoria");
        Category category2 = new Category(null,"categoria2");
        Category category3 = new Category(null,"categoria3");


        User user = new User(null,"nome","userName","nome@email.com","senha", Role.USER);
        User user2 = new User(null,"nome2","userName2","nome2@email.com","senha2", Role.ADMIN);

        New news = new New(null,"title","Conteúdo","image");
        New news2 = new New(null,"title2","Conteúdo2","image2");


        commentRepository.save(comment);
        commentRepository.save(comment2);
        commentRepository.save(comment3);

        categoryRepository.save(category);
        categoryRepository.save(category2);
        categoryRepository.save(category3);

        newRepository.save(news);
        newRepository.save(news2);

        userRepository.save(user);
        userRepository.save(user2);

    }


}
