package hello.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HelloLombok { // 게터 세터 자동으로 어노테이션 프로세스로 만들어준거. getter setter 따로 안만들어도 해준다!!!!!!!!
    
    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("asdf");

        System.out.println("helloLombok = " + helloLombok);
    }
}
