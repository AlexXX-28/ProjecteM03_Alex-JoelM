# Projecte UF1 - Alex & Joel M
## Esquema principal del projecte
## Decisions de Disseny preses
Alhora de decidir com voliem el disseny, tots dos estavem d'acord en que voliem un menu (switch) que tingues una apariencia distintiva a la resta del codi per a que tot siguès més legible. Per això mateix vam fer diferents canvis que estaran millor explicats a l'apartat de "Propostes de millora", com canviar el color de les "X" a vermell, el color dels errors a vermell, el contorn del menu...
També cal dir que alhora de fer qualsevol opció del menu, sortien diferents subopcions, com per exemple el tipus de càlcul del menu, o si es volia aplicar a tot el taulell.
Per a solucionar aquests "problemes" vam decidir que podiem printar diferents opcions com per exemple:
### Carregar taulell
- '1)' Taullel buit
- '2)' Taullel amb malalts
Com es pot veure alhora de crear un taulell havien dos opcions crear-lo de manera que tot estiguès buit, o amb diferents malalts de manera "random", per a escollir entre aquestes dues opcions vam decidir de fer una variable que agafes la resposta de si era "1" o "2" i així doncs executar el seu "if" corresponent.

En l'apartat de "Desplaçar malalts", voliem que s'entengues de la millor manera posible la diferent utilització de les tecles "Q" "W" "E" "A" "D" "Z" "X" "C", ja que totes representen la posició al voltant de la tecla "S", per tant vam fer que alhora de printar-ho es veies totes en el mateix ordre i posició que tenen al teclat.
- System.out.printf("%s\n%s\n%s\n%s\n", //Diferents opcions mostrades d'una manera gràfica per a la millor comprensió posible
                                            "Instruccions per a desplaçar: ",
                                            "| Q (dalt esquerra) |   W (dalt mig)    | E (dalt dreta) |",
                                            "| A (esquerra mig)  |  (Posicio actual) | D (dreta mig)  |",
                                            "| Z (baix esquerra) |   X (baix mig)    | C (baix dreta) |");
                                    System.out.print("Introdueix el valor: ");

En l'apartat de "Mostrar informació" no sabiem molt bé quina era la manera de representar el taulell, per tant vam utilitzar un printf per a afegir espaiat i que haguès simetria entre les diferents columnes i files, a part de que com hem esmentat anteriorment les "X" que representaven les cel·les bloquejades es printaven en vermell per a poder diferenciar-les de les cel·les comunes amb una major facilitat.
S'ha d'aclarir que per a poder representar aquesta "X" alhora de mostrar el taulell, no teniem clar com poder mostrar "X" ja que el nostre array havia de ser una matriu numérica, així doncs vam decidir fer un altre "String array" que copies en el moment de escollir la opció "Mostrar informació" el taulell inicial amb les dades numériques, i que reemplacés les cel·les bloquejades per una "X".

## Repartiment de les tasques
## Joc de proves
## Propostes de millora
