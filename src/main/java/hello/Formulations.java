package hello;

public class Formulations implements Formula {

    @Override
    public double calculate(int a){
        return sqrt(a * 100);
    }
}
