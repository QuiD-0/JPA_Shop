package jpa.jpa_study.playGround.streamGround;

import lombok.AllArgsConstructor;

@AllArgsConstructor
class Outer {

    Nested nested;


    @AllArgsConstructor
    static class Nested {

        Inner inner;

        @AllArgsConstructor
        static
        class Inner {

            String foo;
        }
    }


}
