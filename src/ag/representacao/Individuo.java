package ag.representacao;

import java.util.ArrayList;

public class Individuo implements Comparable<Individuo>
{
 private ICromossomo cromossomo;
 private ArrayList<ObjetoAplicacao> objetos;
 private double fitness;
 private boolean factivel;
 private int idade;

 public Individuo()
 {
  objetos = new ArrayList<ObjetoAplicacao>();
  idade = 0;
 }

 public Individuo(ICromossomo cromossomo)
 {
  this.cromossomo = cromossomo;
  objetos = new ArrayList<ObjetoAplicacao>();
 }
 
 public ObjetoAplicacao getObjetoPeloNome(String nome)
 {
  for (int i = 0; i < objetos.size(); i++)
  {
   if(objetos.get(i).getNome().equals(nome))
    return objetos.get(i);
  }
  return null;
 }

 void envelhece()
 {
  idade++;
 }

 @Override
 public int compareTo(Individuo o)
 {
  if(o.isFactivel() == isFactivel())
   return (int) ((getFitness() - o.getFitness()) * 10000);

  if(o.isFactivel())
   return -1;
  else
   return 1;
 }

 public ICromossomo getCromossomo()
 {
  return cromossomo;
 }

 public void setCromossomo(ICromossomo cromossomo)
 {
  this.cromossomo = cromossomo;
 }

 public ArrayList<ObjetoAplicacao> getObjetos()
 {
  return objetos;
 }

 public void setObjetos(ArrayList<ObjetoAplicacao> objetos)
 {
  this.objetos = objetos;
 }

 public double getFitness()
 {
  return fitness;
 }

 public void setFitness(double fitness)
 {
  this.fitness = fitness;
 }

 public int getIdade()
 {
  return idade;
 }

 public void setIdade(int idade)
 {
  this.idade = idade;
 }

 public boolean isFactivel()
 {
  return factivel;
 }

 public void setFactivel(boolean factivel)
 {
  this.factivel = factivel;
 }
}