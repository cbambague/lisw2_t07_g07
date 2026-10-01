package co.unicauca.iso2.bancopreguntas.builder;
public class OpenQuestionBuilder extends QuestionBuilder {
    @Override public void buildType() { question.setType(co.unicauca.iso2.bancopreguntas.domain.QuestionType.OPEN); }
    @Override public void buildOptionsAndAnswers() { question.setCorrectAnswer("Respuesta abierta."); }
}
