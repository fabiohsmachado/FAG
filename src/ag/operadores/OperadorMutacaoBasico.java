package ag.operadores;

import ag.configuracoes.ConfiguracoesIndividuo;
import ag.representacao.CromossomoEstatico;
import ag.representacao.Individuo;

public class OperadorMutacaoBasico extends AOperadorMutacao
{
 private ConfiguracoesIndividuo parametros;

 public OperadorMutacaoBasico(ConfiguracoesIndividuo parametros)
 {
  this.parametros = parametros;
 }

 @Override
 public void muta(Individuo I)
 {
  if(I.getCromossomo().getTamanho() > 0)
  {
   for(int i = 0; i < ((CromossomoEstatico) I.getCromossomo()).getGenes().length; i++)
    if(Math.random() < getTaxaMutacao())
     ((CromossomoEstatico) I.getCromossomo()).getGenes()[i].setAlelo(parametros.getParametrosCromossomo().getGerador().novoAlelo());
  }
 }
}
