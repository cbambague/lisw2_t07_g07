package co.unicauca.iso2.bancopreguntas;

import co.unicauca.iso2.bancopreguntas.builder.*;
import co.unicauca.iso2.bancopreguntas.director.QuestionDirector;
import co.unicauca.iso2.bancopreguntas.domain.Question;

public class ApplicationMain {
    public static void main(String[] args) {
        QuestionDirector director = new QuestionDirector();
        QuestionBuilder mcBuilder = new MultipleChoiceQuestionBuilder();
        director.changeBuilder(mcBuilder);
        director.makeSimpleQuestion("Cual es la capital de Colombia?", "Geografia", "Prof. Hurtado");
        System.out.println(mcBuilder.build());
        QuestionBuilder tfBuilder = new TrueFalseQuestionBuilder();
        director.changeBuilder(tfBuilder);
        director.makeComplexQuestion("El patron Builder es estructural?", "Ing. Software", "Prof. Pantoja", "Es creacional", "Refactoring Guru");
        System.out.println(tfBuilder.build());
    }
}
