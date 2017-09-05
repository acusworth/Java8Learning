package hello;


import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.util.Arrays;

@Documented // Makes annotations show up in Javadocs
@interface ClassPreamble {
    String author();
    String createdOn();
    int currentRevision() default 1;
    String lastModified() default "N/A";
    String lastModifiedBy() default "N/A";
}

@Repeatable(Authorizations.class)
@interface Authorize {
    String role();
    String[] permissions();
}
@Retention(RetentionPolicy.RUNTIME)
@interface Authorizations{
    Authorize[] value();
}


@ClassPreamble(
        author = "Alex",
        createdOn = "08/08/2017",
        currentRevision = 2,
        lastModified = "24/08/2017",
        lastModifiedBy = "Bob"
)
@Authorize(
        role = "Admin",
        permissions = {"create","read","update","delete"}
)
@Authorize(
        role = "Guest",
        permissions = {"read"}
)
public class Annotations{
    // Code will go here
    public Annotations(){
        System.out.println("-------Authorized Users-------");
        Authorizations authorizations = Annotations.class.getAnnotation(Authorizations.class);
        for(Authorize authorize: authorizations.value()){
            System.out.println("User " + authorize.role() + " can " + Arrays.toString(authorize.permissions()));
        }
    }

}