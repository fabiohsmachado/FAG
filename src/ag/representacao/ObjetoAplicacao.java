package ag.representacao;

public class ObjetoAplicacao
{
 private String Nome;
 private Object valor;

 public ObjetoAplicacao(String Nome, Object valor)
 {
  this.Nome = Nome;
  this.valor = valor;
 }

 public String getNome()
 {
  return Nome;
 }

 public void setNome(String Nome)
 {
  this.Nome = Nome;
 }

 public Object getValor()
 {
  return valor;
 }

 public void setValor(Object valor)
 {
  this.valor = valor;
 }
}