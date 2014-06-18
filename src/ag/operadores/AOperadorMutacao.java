package ag.operadores;

import ag.representacao.Individuo;

public abstract class AOperadorMutacao
{
 private float taxaMutacao;
 
 public abstract void muta (Individuo I);

 public float getTaxaMutacao()
 {
  return taxaMutacao;
 }

 public void setTaxaMutacao(float taxaMutacaoF)
 {
  this.taxaMutacao = taxaMutacaoF;
 }
}
