package operadoresBeta;

public class VerificadorRestricoesLimites<T extends Comparable> implements VerificadorRestricoes<T>
{
 private T limiteInferior, limiteSuperior;

 public VerificadorRestricoesLimites(T limiteInferior , T limiteSuperior)
 {
  this.limiteInferior = limiteInferior;
  this.limiteSuperior = limiteSuperior;
 }

 public T getLimiteInferior()
 {
  return limiteInferior;
 }

 public void setLimiteInferior(T limiteInferior)
 {
  this.limiteInferior = limiteInferior;
 }

 public T getLimiteSuperior()
 {
  return limiteSuperior;
 }

 public void setLimiteSuperior(T limiteSuperior)
 {
  this.limiteSuperior = limiteSuperior;
 }

 @Override
 public boolean eFactivel (T elemento)
 {
  return (elemento.compareTo(limiteInferior) >= 0 && elemento.compareTo(limiteSuperior) < 0);
 }
}