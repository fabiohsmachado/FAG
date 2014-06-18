package ag.configuracoes;

import ag.representacao.ObjetoAplicacao;
import java.util.ArrayList;

public class ConfiguracoesIndividuo
{
 private ConfiguracoesCromossomo parametrosCromossomo;
 private ArrayList<ObjetoAplicacao> objetos;

 public ConfiguracoesIndividuo()
 {
  objetos = new ArrayList<ObjetoAplicacao>();
 }

 public ArrayList<ObjetoAplicacao> getObjetos()
 {
  return objetos;
 }

 public void setObjetos(ArrayList<ObjetoAplicacao> objetos)
 {
  this.objetos = objetos;
 }

 public ConfiguracoesCromossomo getParametrosCromossomo()
 {
  return parametrosCromossomo;
 }

 public void setParametrosCromossomo(ConfiguracoesCromossomo parametrosCromossomo)
 {
  this.parametrosCromossomo = parametrosCromossomo;
 }
}
