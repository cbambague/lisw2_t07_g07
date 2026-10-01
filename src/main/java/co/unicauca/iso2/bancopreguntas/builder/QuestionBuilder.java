// builder/QuestionBuilder.java
package co.unicauca.iso2.bancopreguntas.builder;

import co.unicauca.iso2.bancopreguntas.domain.Question;
import co.unicauca.iso2.bancopreguntas.domain.DifficultyLevel;

public abstract class QuestionBuilder {
    protected Question question;

    public void reset() {
        this.question = new Question();
    }

    public void buildStatement(String statement) { question.setStatement(statement); }
    public void buildDifficulty(DifficultyLevel difficulty) { question.setDifficulty(difficulty); }
    public void buildCategory(String category) { question.setCategory(category); }
    public void buildAuthor(String author) { question.setAuthor(author); }
    public void buildJustification(String justification) { question.setJustification(justification); }
    public void buildSource(String source) { question.setSource(source); }

    // Métodos abstractos para que cada builder maneje sus reglas de negocio de forma obligatoria
    public abstract void buildType();
    public abstract void buildOptionsAndAnswers();
    
    // Método que valida las reglas de negocio antes de entregar el producto final
    public Question build() {
        if (question.getStatement() == null || question.getStatement().isEmpty()) {
            throw new IllegalStateException("Regla de Negocio: El enunciado es obligatorio.");
        }
        return this.question;
    }
}
