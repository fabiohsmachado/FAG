package ag.configuracoes;

import java.util.Random;

public class GeradorElementoAleatorioInteger implements IGeradorElementoAleatorio
{
 Random gerador;

 public GeradorElementoAleatorioInteger()
 {
  gerador = new Random();
 }

 @Override
 public Integer novoAlelo()
 {
  return gerador.nextInt();
 }
}
