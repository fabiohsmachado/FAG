package ag.configuracoes;

import ag.operadores.*;
import ag.representacao.Individuo;
import ag.representacao.ObjetoAplicacao;
import ag.representacao.Populacao;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Collections;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ambiente
{
 private long maxGeracoes;
 private double taxaCrossover;
 private double taxaMutacao;
 private ConfiguracoesPopulacao parametrosPopulacao;
 private IOperadorInicializacao operadorInicializacao;
 private IOperadorSelecao operadorSelecao;
 private IOperadorCrossover operadorCrossover;
 private AOperadorMutacao operadorMutacao;
 private IFuncaoFitness funcaoFitness;
 private Populacao populacao = null;
 
 boolean escreve = false;
 String caminho;
 private PrintStream saida;

 public Ambiente()
 {
  
 }

 public Ambiente (String caminho)
 {
  escreve = true;
  try
  {
   saida = new PrintStream(new FileOutputStream(caminho));
  }
  catch (IOException ex)
  {
   Logger.getLogger(Ambiente.class.getName()).log(Level.SEVERE, null, ex);
  }
 }

 public void fechaArquivo()
 {
  saida.close();
  escreve = false;
 }

 public void gravaGeracao()
 {
  saida.println(populacao.getIdade() + "\t" +
                populacao.getFitnessMinimo() + "\t" +
                populacao.getMediaFitness() + "\t" +
                populacao.getFitnessMaximo());
 }

 public void evolui()
 {
  if(populacao == null) inicializaPopulacao();
  for(int i = 0; i < maxGeracoes; i++)
   evoluiUmaGeracao();
 }

 public void evoluiUmaGeracao()
 {
  Populacao populacaoIntermediaria = cruzaPopulacao();
  mutaPopulacao(populacaoIntermediaria);
  avaliaPopulacao(populacaoIntermediaria);
  populacaoIntermediaria.getIndividuos().addAll(populacao.getIndividuos());
  populacao.setIndividuos(new Vector<Individuo>(operadorSelecao.seleciona(populacaoIntermediaria, parametrosPopulacao.getTamanho())));
  populacao.envelhece();
  Collections.sort(populacao.getIndividuos());
  if(escreve) gravaGeracao();
  System.gc();
 }

 public void inicializaPopulacao()
 {
  Individuo I;
  populacao = new Populacao(parametrosPopulacao.getTamanho());

  for(int i = 0; i < parametrosPopulacao.getTamanho(); i++)
  {
   I = operadorInicializacao.inicializa(parametrosPopulacao.getParametrosIndividuo());
   populacao.getIndividuos().add(I);
  }
  avaliaPopulacao(populacao);
  if(escreve) gravaGeracao();
 }

 public Populacao cruzaPopulacao()
 {
  Individuo I;
  Populacao populacaoIntermediaria = new Populacao(populacao.getTamanho());

  for(int i = 0; i < populacao.getTamanho() * taxaCrossover; i++)
  {
   I = new Individuo(operadorCrossover.cruza(operadorCrossover.selecionaPai(populacao).getCromossomo(), operadorCrossover.selecionaMae(populacao).getCromossomo()));
   for(ObjetoAplicacao O : parametrosPopulacao.getParametrosIndividuo().getObjetos())
    I.getObjetos().add(O);

   populacaoIntermediaria.getIndividuos().add(I);
  }
  return populacaoIntermediaria;
 }

 public void mutaPopulacao(Populacao populacaoIntermerdiaria)
 {
  for(Individuo I : populacaoIntermerdiaria.getIndividuos())
   operadorMutacao.muta(I);
 }

 public void avaliaPopulacao(Populacao populacao)
 {
  for(Individuo I : populacao.getIndividuos())
   I.setFitness(funcaoFitness.avalia(I));
 }
 
 // <editor-fold defaultstate="collapsed" desc="Getters and Setters">
 public long getMaxGeracoes()
 {
  return maxGeracoes;
 }

 public void setMaxGeracoes(int maxGeracoes)
 {
  this.maxGeracoes = maxGeracoes;
 }

 public double getTaxaCrossover()
 {
  return taxaCrossover;
 }

 public void setTaxaCrossover(float taxaCrossover)
 {
  this.taxaCrossover = taxaCrossover;
 }

 public double getTaxaMutacao()
 {
  return taxaMutacao;
 }

 public void setTaxaMutacao(float taxaMutacao)
 {
  this.taxaMutacao = taxaMutacao;
  if(operadorMutacao != null) operadorMutacao.setTaxaMutacao(taxaMutacao);
 }

 public ConfiguracoesPopulacao getParametrosPopulacao()
 {
  return parametrosPopulacao;
 }

 public void setParametrosPopulacao(ConfiguracoesPopulacao parametrosPopulacao)
 {
  this.parametrosPopulacao = parametrosPopulacao;
 }

 public IOperadorCrossover getOperadorCrossover()
 {
  return operadorCrossover;
 }

 public void setOperadorCrossover(IOperadorCrossover operadorCrossover)
 {
  this.operadorCrossover = operadorCrossover;
 }

 public AOperadorMutacao getOperadorMutacao()
 {
  return operadorMutacao;
 }

 public void setOperadorMutacao(AOperadorMutacao operadorMutacao)
 {
  this.operadorMutacao = operadorMutacao;
 }

 public IOperadorSelecao getOperadorSelecao()
 {
  return operadorSelecao;
 }

 public void setOperadorSelecao(IOperadorSelecao operadorSelecao)
 {
  this.operadorSelecao = operadorSelecao;
 }

 public Populacao getPopulacao()
 {
  return populacao;
 }

 public IOperadorInicializacao getOperadorInicializacao()
 {
  return operadorInicializacao;
 }

 public void setOperadorInicializacao(IOperadorInicializacao operadorInicializacao)
 {
  this.operadorInicializacao = operadorInicializacao;
 }

 public IFuncaoFitness getFuncaoFitness()
 {
  return funcaoFitness;
 }

 public void setFuncaoFitness(IFuncaoFitness funcaoFitness)
 {
  this.funcaoFitness = funcaoFitness;
 }// </editor-fold>
}