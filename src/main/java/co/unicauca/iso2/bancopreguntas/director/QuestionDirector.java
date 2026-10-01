package co.unicauca.iso2.bancopreguntas.director;
import co.unicauca.iso2.bancopreguntas.builder.QuestionBuilder;
import co.unicauca.iso2.bancopreguntas.domain.DifficultyLevel;
public class QuestionDirector {
    private QuestionBuilder builder;
    public void changeBuilder(QuestionBuilder b) { this.builder = b; }
    public void makeSimpleQuestion(String s, String c, String a) {
        builder.reset(); builder.buildType(); builder.buildStatement(s);
        builder.buildDifficulty(DifficultyLevel.INTERMEDIO); builder.buildCategory(c);
        builder.buildAuthor(a); builder.buildOptionsAndAnswers();
    }
    public void makeComplexQuestion(String s, String c, String a, String j, String src) {
        builder.reset(); builder.buildType(); builder.buildStatement(s);
        builder.buildDifficulty(DifficultyLevel.ALTO); builder.buildCategory(c);
        builder.buildAuthor(a); builder.buildJustification(j); builder.buildSource(src);
        builder.buildOptionsAndAnswers();
    }
}
