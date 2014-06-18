package operadoresBeta;

import java.util.ArrayList;

public class VerificadorRestricoesLista<T> implements VerificadorRestricoes<T>
{
 private ArrayList<T> valoresPossiveis;

 public VerificadorRestricoesLista()
 {
 }

 public VerificadorRestricoesLista(ArrayList<T> valoresPossiveis)
 {
  setValoresPossiveis(valoresPossiveis);
 }

 public ArrayList<T> getValoresPossiveis()
 {
  return valoresPossiveis;
 }

 public void setValoresPossiveis(ArrayList<T> valoresPossiveis)
 {
  this.valoresPossiveis = valoresPossiveis;
 }

 @Override
 public boolean eFactivel(T elemento)
 {
  return(valoresPossiveis.contains(elemento));
 }
}