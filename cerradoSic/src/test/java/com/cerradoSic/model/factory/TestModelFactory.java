package com.cerradoSic.model.factory;


import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import com.cerradoSic.model.enumerators.Genero;
import com.cerradoSic.model.valueObjects.Aluno;
import com.cerradoSic.model.valueObjects.Especialidade;
import com.cerradoSic.model.valueObjects.Matricula;
import com.cerradoSic.model.valueObjects.Mensalidade;
import com.cerradoSic.model.valueObjects.Modalidade;
import com.cerradoSic.model.valueObjects.Professor;


public class TestModelFactory {
  private static TestModelFactory factory;

  private TestModelFactory() {
  }

  public static TestModelFactory getInstace() {
    return factory == null? new TestModelFactory(): factory;
  }

  public Mensalidade createMensalidade() {
    Mensalidade mensalidade = new Mensalidade();
    mensalidade.setNome("Mensalidade Comum");
    mensalidade.setValor(100f);
    return mensalidade;
  }

  public Matricula createMatricula() {
    Matricula matricula = new Matricula();
    matricula.setMensalidade(createMensalidade());
    Calendar cal = Calendar.getInstance(); // locale-specific
    cal.setTime(new Date());
    cal.set(Calendar.HOUR_OF_DAY, 0);
    cal.set(Calendar.MINUTE, 0);
    cal.set(Calendar.SECOND, 0);
    cal.set(Calendar.MILLISECOND, 0);
    matricula.setDataMatricula(new Date(cal.getTimeInMillis()));
    matricula.setPago(false);
    matricula.setValorDesconto(0);
    return matricula;
  }

  public Matricula createMatriculaComAluno(Aluno aluno) {
    return createMatriculaComAlunoComMensalidade(aluno, null);
  }

  public Matricula createMatriculaComAlunoComMensalidade() {
    return createMatriculaComAlunoComMensalidade(null, null);
  }

  public Matricula createMatriculaComAlunoComMensalidade(Aluno aluno,
                                                         Mensalidade mensalidade) {
    Matricula matricula = createMatricula();
    matricula.setMensalidade(mensalidade == null? createMensalidade()
      : mensalidade);
    joinMatriculaAluno(matricula, aluno == null? createAluno(): aluno);
    return matricula;
  }

  public Aluno createAluno() {
    Aluno aluno = new Aluno();
    aluno.setNome("Aluno Teste");
    aluno.setGenero(Genero.MASCULINO);
    aluno.setObservacao("Aluno Teste Automático");
    aluno.setCpf(Long.toString((new Date()).getTime()).substring(0, 11));
    return aluno;
  }

  public Aluno createAlunoComMatricula() {
    Aluno aluno = createAluno();
    joinMatriculaAluno(createMatriculaComAluno(aluno), aluno);
    return aluno;
  }

  public Aluno createAlunoComMatricula(Matricula matricula) {
    Aluno aluno = createAluno();
    joinMatriculaAluno(matricula, aluno);
    return aluno;
  }

  public void joinMatriculaAluno(Matricula matricula, Aluno aluno) {
    if (matricula != null || aluno != null) {
      matricula.setAluno(aluno);
      aluno.addMatricula(matricula);
    }
  }

  public Especialidade createEspecialidade() {
    Especialidade especialidade = new Especialidade();
    especialidade.setNome("Educação Física");
    especialidade.setDescricao("Formação em Educação Física");
    return especialidade;
  }

  public Modalidade createModalidade() {
    Modalidade modalidade = new Modalidade();
    modalidade.setNome("Treino Funcional");
    modalidade.setDescricao("Treino com foco funcional");
    return modalidade;
  }

  public Professor createProfessor() {
    Random r = new Random();
    Professor professor = new Professor();
    professor.setCref(Long.toString(new Date().getTime()).substring(0, 6)+"-"+generateUpperRandomString(1)+"/"+generateUpperRandomString(2));
    professor.setNome("Lucas Veppo");
    professor.setGenero(Genero.MASCULINO);
    professor.setDescricao("Professor Teste");
    return professor;
  }

  
  static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
  static final String UPPER_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
  static final String LOWER_ALPHABET = "abcdefghijklmnopqrstuvwxyz";
  
  static private String generateLowerRandomString(int stringSize){
    return generateRandomString(stringSize,LOWER_ALPHABET);
  }
  
  static private String generateUpperRandomString(int stringSize){
    return generateRandomString(stringSize,UPPER_ALPHABET);
  }
  
  static private String generateRandomString(int stringSize){
    return generateRandomString(stringSize,ALPHABET);
  }
  
  static private String generateRandomString(int stringSize, String alphabet){
    Random r = new Random();
    StringBuilder s = new StringBuilder();
    for(int i =0; i < stringSize;i++){
      s.append(alphabet.charAt(r.nextInt(alphabet.length())));
    }
    return s.toString();
  }

  public Professor createProfessorComEspecialidadeComModalidade() {
    return createProfessorComEspecialidadeComModalidade(null, null);
  }

  public Professor createProfessorComEspecialidade() {
    return createProfessorComEspecialidade(null);
  }

  public Professor createProfessorComEspecialidade(Especialidade especialidade) {
    Professor professor = createProfessor();
    joinProfessorEspecialidade(professor,
                               especialidade != null? especialidade
                                 : createEspecialidade());
    return professor;
  }

  public Professor createProfessorComModalidade() {
    return createProfessorComModalidade(null);
  }

  public Professor createProfessorComModalidade(Modalidade modalidade) {
    Professor professor = createProfessor();
    joinProfessorModalidade(professor,
                            modalidade != null? modalidade
                              : createModalidade());
    return professor;
  }

  public Professor createProfessorComEspecialidadeComModalidade(Especialidade especialidade,
                                                                Modalidade modalidade) {
    Professor professor = createProfessor();
    joinProfessorEspecialidade(professor,
                               especialidade != null? especialidade
                                 : createEspecialidade());
    joinProfessorModalidade(professor,
                            modalidade != null? modalidade
                              : createModalidade());
    return professor;
  }

  public void joinProfessorEspecialidade(Professor professor,
                                         Especialidade especialidade) {
    if (!professor.getEspecialidades().contains(especialidade)) {
      professor.addEspecialidade(especialidade);
    }
    if (!especialidade.getProfessores().contains(professor)) {
      especialidade.addProfessor(professor);
    }
  }

  public void joinProfessorModalidade(Professor professor,
                                      Modalidade modalidade) {
    if (!professor.getModalidades().contains(modalidade)) {
      professor.addModalidade(modalidade);
    }
    if (!modalidade.getProfessores().contains(professor)) {
      modalidade.addProfessor(professor);
    }
  }
}
