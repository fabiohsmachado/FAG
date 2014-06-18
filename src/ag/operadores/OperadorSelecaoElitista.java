package ag.operadores;

import ag.representacao.Individuo;
import ag.representacao.Populacao;
import java.util.Collections;
import java.util.List;

public class OperadorSelecaoElitista implements IOperadorSelecao
{
 @Override
 public List<Individuo> seleciona(Populacao populacaoIntermediaria, int qtde)
 {
  Collections.sort(populacaoIntermediaria.getIndividuos());
  return populacaoIntermediaria.getIndividuos().subList(0, qtde - 1);
 } 
}