package ag.operadores;

import ag.configuracoes.ConfiguracoesIndividuo;
import ag.representacao.CromossomoEstatico;
import ag.representacao.Gene;
import ag.representacao.Individuo;
import ag.representacao.ObjetoAplicacao;

public class OperadorInicializacaoIndividuoBasico implements IOperadorInicializacao
{
 private boolean tamanhoFixo;

 public OperadorInicializacaoIndividuoBasico(boolean tamanhoFixo)
 {
  this.tamanhoFixo = tamanhoFixo;
 }

 @Override
 public Individuo inicializa (ConfiguracoesIndividuo parametros)
 {
  Individuo novoIndividuo;
  CromossomoEstatico cromossomo;
  int tamanho;

  tamanho = parametros.getParametrosCromossomo().getTamanho();
  if(!tamanhoFixo) tamanho = (int) (Math.random() * tamanho);

  cromossomo = new CromossomoEstatico(tamanho);
  for(int i = 0; i < tamanho; i++)
   cromossomo.getGenes()[i] = new Gene(parametros.getParametrosCromossomo().getGerador().novoAlelo());

  novoIndividuo = new Individuo();
  for(ObjetoAplicacao O : parametros.getObjetos())
   novoIndividuo.getObjetos().add(O);
  novoIndividuo.setCromossomo(cromossomo);

  return novoIndividuo;
 }
}