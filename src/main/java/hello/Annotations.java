package hello;

import java.lang.annotation.Repeatable;

@interface Hints {
    Hint [] value();
}

@Repeatable(Hints.class)
@interface Hint {
    String value();
}

@Hint("hint1")
@Hint("hint2")
class Annotations {

    public Annotations() {
        Hint hint = Annotations.class.getAnnotation(Hint.class);
        System.out.println(hint);
    }

    public void getAnnotationByLength(){
        Hints hints1 = Annotations.class.getAnnotation(Hints.class);
        System.out.println(hints1.value().length);
    }

    public void getAnnotationsByTypes(){
        Hint[] hints2 = Annotations.class.getAnnotationsByType(Hint.class);
        System.out.println("Number of hints by array of types: " + hints2.length);

    }

}
