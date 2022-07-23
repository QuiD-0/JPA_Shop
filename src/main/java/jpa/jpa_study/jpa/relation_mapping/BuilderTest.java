package jpa.jpa_study.jpa.relation_mapping;

public class BuilderTest {

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        Member member = Member.builder().name("이름").team(new Team()).build();
        System.out.println(member);
    }

}
