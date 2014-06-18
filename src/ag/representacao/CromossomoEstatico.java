package ag.representacao;

public class CromossomoEstatico implements ICromossomo
{
 Gene[] genes;

 public CromossomoEstatico(int tamanho)
 {
  genes = new Gene[tamanho];
 }

 public CromossomoEstatico(Gene[] genes)
 {
  this.genes = genes;
 }

 public Gene[] getGenes()
 {
  return genes;
 }

 public void setGenes(Gene[] genes)
 {
  this.genes = genes;
 }

 @Override
 public int getTamanho()
 {
  return genes.length;
 }
}