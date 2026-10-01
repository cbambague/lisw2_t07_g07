package co.unicauca.iso2.bancopreguntas.builder;
import co.unicauca.iso2.bancopreguntas.domain.*;
public class MultipleChoiceQuestionBuilder extends QuestionBuilder {
    @Override public void buildType() { question.setType(QuestionType.MULTIPLE_CHOICE); }
    @Override public void buildOptionsAndAnswers() {
        question.addOption(new Option("A", "Cali"));
        question.addOption(new Option("B", "Bogota"));
        question.setCorrectAnswer("B");
    }
    @Override public Question build() {
        Question q = super.build();
        if (q.getOptions().isEmpty()) { throw new IllegalStateException("Opción múltiple debe tener opciones."); }
        return q;
    }
}
