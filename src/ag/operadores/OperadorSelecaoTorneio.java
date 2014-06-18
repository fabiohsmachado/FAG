package ag.operadores;

import ag.representacao.Individuo;
import ag.representacao.Populacao;
import java.util.List;
import java.util.Vector;

public class OperadorSelecaoTorneio implements IOperadorSelecao
{
 private boolean elitismo;

 public OperadorSelecaoTorneio()
 {
  elitismo = true;
 }

 public OperadorSelecaoTorneio(boolean elitismo)
 {
  this.elitismo = elitismo;
 }

 @Override
 public List<Individuo> seleciona(Populacao populacaoIntermediaria, int qtde)
 {
  int tamanho = populacaoIntermediaria.getTamanho();
  Vector<Individuo> lista = new Vector<Individuo>();
  int i = 0;

  if(elitismo)
  {
   Individuo I = populacaoIntermediaria.getMelhorIndividuo(true);
   if(I != null)
   {
    lista.add(I);
    i++;
    tamanho--;
   }
  }

  for(; i < qtde; i++)
  {
   Individuo I1 = populacaoIntermediaria.getIndividuos().remove((int) (Math.random() * tamanho--));
   Individuo I2 = populacaoIntermediaria.getIndividuos().remove((int) (Math.random() * tamanho));

   if(I1.getFitness() > I2.getFitness())
   {
    lista.add(I1);
    populacaoIntermediaria.getIndividuos().add(I2);
   }
   else
   {
    lista.add(I2);
    populacaoIntermediaria.getIndividuos().add(I1);
   }
  }
  return lista;
 }

 public boolean isElitismo()
 {
  return elitismo;
 }

 public void setElitismo(boolean elitismo)
 {
  this.elitismo = elitismo;
 }
}