package ag.operadores;

import ag.representacao.ICromossomo;
import ag.representacao.Individuo;
import ag.representacao.Populacao;

public interface IOperadorCrossover
{
 public ICromossomo cruza (ICromossomo pai, ICromossomo mae);
 public Individuo selecionaPai (Populacao populacao);
 public Individuo selecionaMae (Populacao populacao);
}
