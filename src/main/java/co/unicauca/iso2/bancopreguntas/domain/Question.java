package co.unicauca.iso2.bancopreguntas.domain;
import java.util.ArrayList;
import java.util.List;
public class Question {
    private String statement;
    private DifficultyLevel difficulty;
    private String category;
    private String author;
    private String justification;
    private String source;
    private QuestionType type;
    private List<Option> options = new ArrayList<>();
    private String correctAnswer;
    public void setStatement(String s) { this.statement = s; }
    public String getStatement() { return statement; }
    public void setDifficulty(DifficultyLevel d) { this.difficulty = d; }
    public DifficultyLevel getDifficulty() { return difficulty; }
    public void setCategory(String c) { this.category = c; }
    public void setAuthor(String a) { this.author = a; }
    public void setJustification(String j) { this.justification = j; }
    public void setSource(String s) { this.source = s; }
    public void setType(QuestionType t) { this.type = t; }
    public QuestionType getType() { return type; }
    public List<Option> getOptions() { return options; }
    public void addOption(Option o) { this.options.add(o); }
    public void setCorrectAnswer(String c) { this.correctAnswer = c; }
       @Override
    public String toString() { 
        return "Pregunta (" + type + ") - Enunciado: " + statement + " | Dificultad: " + difficulty + " | Opciones: " + options.size(); 
    }

    public String getCategory() { return category; }
    public String getAuthor() { return author; }
    public String getJustification() { return justification; }
    public String getSource() { return source; }
    public String getCorrectAnswer() { return correctAnswer; }
}


