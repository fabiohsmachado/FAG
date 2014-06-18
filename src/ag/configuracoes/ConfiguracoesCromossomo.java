package ag.configuracoes;

public class ConfiguracoesCromossomo
{
 private IGeradorElementoAleatorio gerador;
 private int tamanho;

 public ConfiguracoesCromossomo()
 {
 }

 public ConfiguracoesCromossomo(int tamanho)
 {
  this.tamanho = tamanho;
 }

 public int getTamanho()
 {
  return tamanho;
 }

 public void setTamanho(int Tamanho)
 {
  this.tamanho = Tamanho;
 }

 public IGeradorElementoAleatorio getGerador()
 {
  return gerador;
 }

 public void setGerador(IGeradorElementoAleatorio gerador)
 {
  this.gerador = gerador;
 }
}
