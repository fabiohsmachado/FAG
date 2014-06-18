package ag.configuracoes;

public class ConfiguracoesPopulacao
{
 private int tamanho;
 private ConfiguracoesIndividuo parametrosIndividuo;

 public ConfiguracoesPopulacao()
 {
  
 }

 public ConfiguracoesPopulacao(int tamanhoPopulacao, ConfiguracoesIndividuo parametrosIndividuo)
 {
  this.tamanho = tamanhoPopulacao;
  this.parametrosIndividuo = parametrosIndividuo;
 }

 public int getTamanho()
 {
  return tamanho;
 }

 public void setTamanho(int tamanhoPopulacao)
 {
  this.tamanho = tamanhoPopulacao;
 }

 public ConfiguracoesIndividuo getParametrosIndividuo()
 {
  return parametrosIndividuo;
 }

 public void setParametrosIndividuo(ConfiguracoesIndividuo parametrosIndividuo)
 {
  this.parametrosIndividuo = parametrosIndividuo;
 }
}
