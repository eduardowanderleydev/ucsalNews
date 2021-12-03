package builder;

import br.ucsal.ucsalnews.entity.Comment;
import br.ucsal.ucsalnews.enums.Role;

public class CommentBuilder {

    private static final String CONTENT_DEFAULT = "Lorem Ipsum is simply dummy text of the printing and typesetting industry." +
            " Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley " +
            "of type and scrambled it to make a type specimen book. ";

    private String content = CONTENT_DEFAULT;

    private CommentBuilder(){

    }

    public CommentBuilder oneComment(){
        return new CommentBuilder();
    }

    public CommentBuilder withContent(String content){
        this.content = content;
        return this;
    }

    public Comment build(){
        Comment obj = new Comment();
        obj.setContent(this.content);
        obj.setUser(UserBuilder.OneUser().withRole(Role.ADMIN).build());
        obj.setNews(NewBuilder.oneNew().build());
        return obj;
    }

}
