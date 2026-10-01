package co.unicauca.iso2.bancopreguntas.test;

import co.unicauca.iso2.bancopreguntas.builder.*;
import co.unicauca.iso2.bancopreguntas.director.QuestionDirector;
import co.unicauca.iso2.bancopreguntas.domain.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MultipleChoiceQuestionBuilderTest {
   private QuestionDirector director;
   private MultipleChoiceQuestionBuilder mcBuilder;
   private TrueFalseQuestionBuilder tfBuilder;
   private OpenQuestionBuilder openBuilder;

   @BeforeEach
   void setUp() {
      director = new QuestionDirector();
      mcBuilder = new MultipleChoiceQuestionBuilder();
      tfBuilder = new TrueFalseQuestionBuilder();
      openBuilder = new OpenQuestionBuilder();
   }

   // --- PRUEBAS DE CONSTRUCCIÓN CORRECTA (REQ 1) ---
   @Test
   void test01ConstruccionCorrectaMultipleChoice() {
      director.changeBuilder(mcBuilder);
      director.makeSimpleQuestion("¿Capital de Cauca?", "Geografía", "Prof. Hurtado");
      Question q = mcBuilder.build();
      Assertions.assertNotNull(q);
      Assertions.assertEquals(QuestionType.MULTIPLE_CHOICE, q.getType());
   }

   @Test
   void test02ConstruccionCorrectaTrueFalse() {
      director.changeBuilder(tfBuilder);
      director.makeSimpleQuestion("¿Java es un lenguaje?", "Sistemas", "Prof. Pantoja");
      Question q = tfBuilder.build();
      Assertions.assertNotNull(q);
      Assertions.assertEquals(QuestionType.TRUE_FALSE, q.getType());
   }

   // --- PRUEBAS DE VALIDACIÓN DE CAMPOS OBLIGATORIOS (REQ 2) ---
   @Test
   void test03ValidacionEnunciadoObligatorioNoPermiteNulo() {
      director.changeBuilder(mcBuilder);
      director.makeSimpleQuestion(null, "Estructuras", "Anonimo");
      Assertions.assertThrows(IllegalStateException.class, () -> mcBuilder.build());
   }

   @Test
   void test04ValidacionEnunciadoObligatorioNoPermiteVacio() {
      director.changeBuilder(mcBuilder);
      director.makeSimpleQuestion("", "Estructuras", "Anonimo");
      Assertions.assertThrows(IllegalStateException.class, () -> mcBuilder.build());
   }

   // --- PRUEBAS ESPECÍFICAS POR TIPO (REQ 3) ---
   @Test
   void test05MultipleChoiceDebeTenerOpciones() {
      mcBuilder.reset();
      mcBuilder.buildType();
      mcBuilder.buildStatement("Pregunta sin opciones");
      Assertions.assertThrows(IllegalStateException.class, () -> mcBuilder.build());
   }

   @Test
   void test06TrueFalseDebeTenerExactamenteDosOpciones() {
      director.changeBuilder(tfBuilder);
      director.makeSimpleQuestion("¿El patrón es creacional?", "Patrones", "Docente");
      Question q = tfBuilder.build();
      Assertions.assertEquals(2, q.getOptions().size());
   }

   @Test
   void test07OpenQuestionNoDebeTenerOpciones() {
      director.changeBuilder(openBuilder);
      director.makeSimpleQuestion("Escriba un ensayo.", "Líneas", "Autor");
      Question q = openBuilder.build();
      Assertions.assertTrue(q.getOptions().isEmpty());
   }

   // --- PRUEBAS DE RESPUESTAS VÁLIDAS (REQ 4) ---
   @Test
   void test08RespuestaCorrectaAsignadaMultipleChoice() {
      director.changeBuilder(mcBuilder);
      director.makeSimpleQuestion("¿Enunciado?", "Categoria", "Autor");
      Question q = mcBuilder.build();
      Assertions.assertNotNull(q.getOptions());
      Assertions.assertFalse(q.getOptions().stream()
              .filter(o -> o.getClave().equals("B")).findFirst().isEmpty());
   }

   // --- CONSTRUCCIÓN DE DIFERENTES PRODUCTOS (REQ 5) ---
   @Test
   void test09MismoDirectorFabricaProductosDiferentes() {
      director.changeBuilder(mcBuilder);
      director.makeSimpleQuestion("Q1", "Cat", "Aut");
      Question q1 = mcBuilder.build();

      director.changeBuilder(tfBuilder);
      director.makeSimpleQuestion("Q2", "Cat", "Aut");
      Question q2 = tfBuilder.build();

      Assertions.assertNotEquals(q1.getType(), q2.getType());
   }

   @Test
   void test10ValidacionPreguntaComplejaAsignaCamposOpcionales() {
      director.changeBuilder(mcBuilder);
      director.makeComplexQuestion("Enunciado", "Cat", "Autor", "Porque si", "Libro SW");
      Question q = mcBuilder.build();
      Assertions.assertEquals(DifficultyLevel.ALTO, q.getDifficulty());
   }
}
