package builder;

import br.ucsal.ucsalnews.entity.Category;
import br.ucsal.ucsalnews.entity.Comment;
import br.ucsal.ucsalnews.entity.New;
import br.ucsal.ucsalnews.enums.Role;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class NewBuilder {

    private static final String TITLE_DEAFULT = "Some title";
    private static final String CONTENT_DEFAULT = "Some content only to test";
    private static final long ID_DEFAULT = 1L;
    private static List<Category> CATEGORIES_DEFAULT = createCategories();
    private static List<Comment> COMMENTS_DEFAULT = createComments();


    private List<Comment> comments = COMMENTS_DEFAULT;
    private List<Category> categories = CATEGORIES_DEFAULT;
    private long id = ID_DEFAULT;
    private String title = TITLE_DEAFULT;
    private String content = CONTENT_DEFAULT;

    private NewBuilder() {
    }

    public static NewBuilder oneNew() {
        return new NewBuilder();
    }

    public NewBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public NewBuilder withContent(String content) {
        this.content = content;
        return this;
    }

    public New build() {
        New obj = new New();
        obj.setId(this.id);
        obj.setTitle(this.title);
        obj.setContent(this.content);
        obj.setAuthor(UserBuilder.OneUser().withRole(Role.ADMIN).build());
        obj.setCategories(this.categories);
        obj.setComments(this.comments);
        return obj;
    }

    private static List<Category> createCategories() {
        Category category1 = new Category();
        category1.setId(1l);
        category1.setName("Tech");

        Category category2 = new Category();
        category2.setId(2l);
        category2.setName("Tech");

        return Arrays.asList(category1, category2);
    }

    private static List<Comment> createComments() {
        Comment comment1 = new Comment();
        comment1.setId(1l);
        comment1.setContent("comment 1");
        comment1.setDate(LocalDateTime.now());

        Comment comment2 = new Comment();
        comment2.setId(2l);
        comment2.setContent("comment 2");
        comment2.setDate(LocalDateTime.now());

        return Arrays.asList(comment1, comment2);
    }

}
