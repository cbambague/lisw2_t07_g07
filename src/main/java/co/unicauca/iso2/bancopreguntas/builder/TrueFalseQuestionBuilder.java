package co.unicauca.iso2.bancopreguntas.builder;
import co.unicauca.iso2.bancopreguntas.domain.*;
public class TrueFalseQuestionBuilder extends QuestionBuilder {
    @Override public void buildType() { question.setType(QuestionType.TRUE_FALSE); }
    @Override public void buildOptionsAndAnswers() {
        question.addOption(new Option("V", "Verdadero"));
        question.addOption(new Option("F", "Falso"));
        question.setCorrectAnswer("V");
    }
}
