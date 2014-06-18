package ag.operadores;

import ag.representacao.CromossomoEstatico;
import ag.representacao.Gene;
import ag.representacao.ICromossomo;
import ag.representacao.Individuo;
import ag.representacao.Populacao;
import java.util.Random;

public class OperadorCrossover1Ponto implements IOperadorCrossover
{
 Random random;

 public OperadorCrossover1Ponto()
 {
  random = new Random();
 }

 @Override
 public ICromossomo cruza(ICromossomo pai, ICromossomo mae)
 {
  CromossomoEstatico cromossomoMaior, cromossomoMenor;
  Gene[] genesFilho;
  int pontoDeCorte;

  if(((CromossomoEstatico) pai).getGenes().length > ((CromossomoEstatico) mae).getGenes().length)
  {
   cromossomoMaior = (CromossomoEstatico) pai;
   cromossomoMenor = (CromossomoEstatico) mae;
  }
  else
  {
   cromossomoMaior = (CromossomoEstatico) mae;
   cromossomoMenor = (CromossomoEstatico) pai;
  }

  if(random.nextBoolean())
   genesFilho = new Gene[cromossomoMenor.getGenes().length];
  else
  {
   genesFilho = new Gene[cromossomoMaior.getGenes().length];
   for(int i = cromossomoMenor.getGenes().length; i < cromossomoMaior.getGenes().length; i++)
    genesFilho[i] = new Gene(cromossomoMaior.getGenes()[i].getAlelo());
  }

  if(cromossomoMenor.getGenes().length > 0)
  {
   pontoDeCorte = Math.abs(random.nextInt(cromossomoMenor.getGenes().length));
   for (int i = 0; i < pontoDeCorte; i++)
    genesFilho[i] = new Gene(cromossomoMaior.getGenes()[i].getAlelo());

   for (int i = pontoDeCorte; i < cromossomoMenor.getGenes().length; i++)
    genesFilho[i] = new Gene(cromossomoMenor.getGenes()[i].getAlelo());
  }

  return new CromossomoEstatico(genesFilho);
 }

 @Override
 public Individuo selecionaPai(Populacao populacao)
 {
  return populacao.getIndividuos().get(random.nextInt(populacao.getTamanho()));
 }

 @Override
 public Individuo selecionaMae(Populacao populacao)
 {
  return populacao.getIndividuos().get(random.nextInt(populacao.getTamanho()));
 }
}