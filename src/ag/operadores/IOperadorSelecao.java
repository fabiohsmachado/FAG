package ag.operadores;

import ag.representacao.Individuo;
import ag.representacao.Populacao;
import java.util.List;

public interface IOperadorSelecao
{
 public List<Individuo> seleciona(Populacao populacaoIntermediaria, int qtde);
}
