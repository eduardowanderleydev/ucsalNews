package builder;

import br.ucsal.ucsalnews.entity.Category;
import br.ucsal.ucsalnews.entity.New;
import br.ucsal.ucsalnews.enums.Role;

import java.util.Arrays;

public class NewBuilder {

    private static final String TITLE_DEAFULT = "Some title";
    private static final String CONTENT_DEFAULT = "Some content only to test";

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
        obj.setTitle(this.title);
        obj.setContent(this.content);
        obj.setAuthor(UserBuilder.OneUser().withRole(Role.ADMIN).build());
        obj.setCategories(Arrays.asList(new Category(null, "Tech")));

        return obj;
    }

}
