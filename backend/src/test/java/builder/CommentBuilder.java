package builder;

import br.ucsal.ucsalnews.entity.Comment;
import br.ucsal.ucsalnews.enums.Role;

public class CommentBuilder {

    private static final String CONTENT_DEFAULT = "Some content";

    private String content = CONTENT_DEFAULT;

    public CommentBuilder(){

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
