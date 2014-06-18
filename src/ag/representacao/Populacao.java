package ag.representacao;

import java.util.Collections;
import java.util.Vector;

public class Populacao
{
 private Vector<Individuo> individuos;
 private int idade;

 public Populacao(int tamanho)
 {
  individuos = new Vector<Individuo>(tamanho, 1);
  idade = 0;
 }

 public void envelhece()
 {
  idade++;
  for(Individuo individuo : individuos)
   individuo.envelhece();
 }

 public Individuo getMelhorIndividuo(boolean factivel)
 {
  Collections.sort(individuos);
  if(factivel)
   return (individuos.lastElement().isFactivel() ? individuos.remove(getTamanho() - 1) : null);
  return individuos.get(getTamanho() - 1);
 }

 public double getFitnessMinimo()
 {
  int i = 0;
  while(i < getTamanho() && !individuos.get(i).isFactivel()) i++;

  if(i == getTamanho()) return Double.NEGATIVE_INFINITY;
  return individuos.get(i).getFitness();
 }

 public double getFitnessMaximo()
 {
  int i = getTamanho() - 1;
  while(i >= 0 && !individuos.get(i).isFactivel()) i--;

  if(i < 0) return Double.NEGATIVE_INFINITY;
  return individuos.get(i).getFitness();
 }

 public double getMediaFitness()
 {
  double media = 0;
  int i = 0;

  for(Individuo I : individuos)
   if(I.isFactivel())
   {
    media += I.getFitness();
    i++;
   }
 
  media /= i;
  
  return media;
 }

 public int getIdade()
 {
  return idade;
 }

 public void setIdade(int idade)
 {
  this.idade = idade;
 }

 public Vector<Individuo> getIndividuos()
 {
  return individuos;
 }

 public void setIndividuos(Vector<Individuo> individuos)
 {
  this.individuos = individuos;
 }

 public int getTamanho()
 {
  return individuos.size();
 }
}
