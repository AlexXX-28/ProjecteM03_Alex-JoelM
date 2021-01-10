# Projecte UF1 - Alex & Joel M

## Esquema principal del projecte
### Petit Resum
El nostre projecte comença amb un menu, creat amb un switch, que mostra les diferents opcions que tenim, son 7 cases, ja que l'ultim serveix per "Sortir".
A continuació tenim en cada case del switch, que s'entra segons l'opció que escollim (1-7).
Despres simplement tenim un codi diferent per al que es demana en les diferents opcions.
Però gairebé tot el codi esta format per "for" que fa que ens puguem moure per els arrays, i poder modificar les dades que es demanen.
Una vegada s'acaba el case que em seleccionat ens demana si volem tornar a utilitzar aquella opció, si diem que si es tornara a executar el mateix codi, pero si diem que no, ens mostrara el menu per a que escollim una nova opció. Això acabarà si escollim l'ultima opció que es la 7 "Sortir".
### Explicació detallada
1. Impressió del menu que es va repetin fins que el bucle trobi el resultat del menu, del cual seria "si no es igual a 7 (case 7 = sortir) continua imprimin fins que retorni un 7 del qual el programa acabaria.
2. Un if per saber si el resultat (s.nextInt) del menu si es correcte...
   1. Si la llargada del resultat del menu (s.nextInt) es diferent a 1 doncs que imprimeixi el resultat de error.
   2. Si la llargada del resultat es correcte entra al switch, on per cada case correspon amb el resultat del menu, es a dir, 7 cases + el default en cas de que no hi ha cap resposta bona, que torni una altra cop a demanar (ja que esta contingut dintre del bucle). 
3. En el cas de la resposta sigui correcte entrem automaticament en el switch i comprobem el resultat per als cases, (per els case del 2 al 6 comença amb un if que serveix per determina si existeix el array a partir d'un boolean, que comença per defecte a false, aixo fa que nomes el primer cop es obligatori fer el primer case).
   1. Case 1: creacio del taulell.
      1. Impressio de les diferents opcions (taulell buit i taulell amb malalts).
      2. Variable que conte l'opció demanada en el anterior punt.
      3. impressió de les quantitats de files i columnes que vol el usuari.
      4. Variable que conte l'opció demanada en el anterior punt.
      5. Creacio de la taula numerica (on aquesta servira per la agafar la informacio demanada).
      6. Creacio de la taula String (que servira per agafar la informacio de la taula numerica i pasarla a string per fer joc amb les X de les cel·les).
      7. Un if per fer les accions corresponents a partir de les varibles anterior de taulell buit i taulell amb malalts.
         1. Si en el cas de que el resultat de la primera impressio es 1, doncs s'ha crea un taulell buit a partir de un bucle per a que cada cel·la contingui el valor 0.
         2. Si no es el cas anterior doncs creara el taulell amb malalts a partir de un bucle del cual servira per fer que cada cel·la s'ompli amb un valor numeric aleatori (Math.random) de un maxim de 10.
      8. Es crea un varible on conte un calcul que declara que la quantitat de cel·les bloquejades sigui el total de cel·les de la taula / 4 (Per a que no hi hagi ni poques ni masses).
      9. A partir de aquesta varible es crean les dos arrays que faran relacio a la posicio de la columna i fila del taulell real creat anteriorment per saber on estaran les X.
      10. Un for per agregar les X que tindran com a valor 0, a l'hora de imprimir el resutat (case 6) com s'imprimeix el taulell string es fara de la relacio de les dos arrays que s'han creat anteriorment per saber les posicions de les X.
   2. Case 2: afegir malalts.
      1. Un while amb un varible iniciada a 1 , la condicio del while sera mentre sigui diferent a 2.
      2. Impressió de introduir nummero de files i columnes amb les sabes variables respectivament.
      3. Impressió de intorduir el numero de malalts a partir de la fila i la columna demanada.
      4. inserció del valor que vols solapar a la cel·la amb les varibles (coordenades fila i columna) demanades anteriorment.
      5. Impressió preguntat si vols tornar a afegir malalts [(1) Si (2) No].
      6. afegir el valor de la impressio anteriror per a la varible utilizada per el while per determinar si vol repetir un altre cop o no.
   3. Case 3: transmissió del virus.
      1. Impressió preguntan la taxa de transmissió del virus (tant si es enter o decimal).
      2. Un for dintre de un altre for per recorre el taulell numeric per introduir a cada cel·la el calcul de la taxa de la transmissió del virus.
      3. Dintre dels for el calcul que es desde la poscicio de la cel·la actualitzada per la transmissio del virus, tot aquest calcul amb un floor per arrodonir cap a baix.
   4. Case 4: curar malalts.
   5. Case 5: desplaçar malalts.
   6. Case 6: mostrar informacio.
   7. Case 7: sortir.
## Decisions de Disseny preses
Alhora de decidir com voliem el disseny, tots dos estavem d'acord en que voliem un menu (switch) que tingues una apariencia distintiva a la resta del codi per a que tot siguès més legible. Per això mateix vam fer diferents canvis que estaran millor explicats a l'apartat de "Propostes de millora", com canviar el color de les "X" a vermell, el color dels errors a vermell, el contorn del menu...
També cal dir que alhora de fer qualsevol opció del menu, sortien diferents subopcions, com per exemple el tipus de càlcul del menu, o si es volia aplicar a tot el taulell.
Per a solucionar aquests "problemes" vam decidir que podiem printar diferents opcions com per exemple:
### Carregar taulell
- '1)' Taullel buit
- '2)' Taullel amb malalts
Com es pot veure alhora de crear un taulell havien dos opcions crear-lo de manera que tot estiguès buit, o amb diferents malalts de manera "random", per a escollir entre aquestes dues opcions vam decidir de fer una variable que agafes la resposta de si era "1" o "2" i així doncs executar el seu "if" corresponent.

En l'apartat de "Desplaçar malalts", voliem que s'entengues de la millor manera posible la diferent utilització de les tecles "Q" "W" "E" "A" "D" "Z" "X" "C", ja que totes representen la posició al voltant de la tecla "S", per tant vam fer que alhora de printar-ho es veies totes en el mateix ordre i posició que tenen al teclat.
>System.out.printf("%s\n%s\n%s\n%s\n", //Diferents opcions mostrades d'una manera gràfica per a la millor comprensió posible
>                                           "Instruccions per a desplaçar: ",  
>                                           "| Q (dalt esquerra) |   W (dalt mig)    | E (dalt dreta) |",  
>                                           "| A (esquerra mig)  |  (Posicio actual) | D (dreta mig)  |",  
>                                           "| Z (baix esquerra) |   X (baix mig)    | C (baix dreta) |");  
>                                   System.out.print("Introdueix el valor: ");  

En l'apartat de "Mostrar informació" no sabiem molt bé quina era la manera de representar el taulell, per tant vam utilitzar un printf per a afegir espaiat i que haguès simetria entre les diferents columnes i files, a part de que com hem esmentat anteriorment les "X" que representaven les cel·les bloquejades es printaven en vermell per a poder diferenciar-les de les cel·les comunes amb una major facilitat.
S'ha d'aclarir que per a poder representar aquesta "X" alhora de mostrar el taulell, no teniem clar com poder mostrar "X" ja que el nostre array havia de ser una matriu numérica, així doncs vam decidir fer un altre "String array" que copies en el moment de escollir la opció "Mostrar informació" el taulell inicial amb les dades numériques, i que reemplacés les cel·les bloquejades per una "X".

## Repartiment de les tasques
Alhora de repartirn-nos les tasques, ja que com nomes erem 2 persones, vam preferir treballar conjuntament així mentre's un feia el codi l'altre podia tant revisar, com donar suport i proposar noves idees per al projecte.
Bàsicament vam quedar 3 dies per a finalitzar el programa i un 4 per a finalitzar la memòria.
La manera que vam tenir de treballar era quedar per "Discord" i un dia compartia un la pantalla mentre's feia el codi i l'altre el miraba i pensava en maneres de poder millorar, i el següent dia a l'inversa.

## Joc de proves
Fent proves de que el nostre codi funcionava correctament vam tenir alguns errors, però els que van ser més "greus" podriem dir que van ser els següents:
-En l'apartat de "Mostrar informació" quan vam voler que les "X" es mostresin de vermell, no sabiem que amb el que posavem a continuació tot seria vermell en comptes de nomes les "X".
![Tot el codi a continuació de les "X" es vermell](/Images/Captura.PNG)

-En l'apartat de "Desplaçar Malalts" quan s'havien d'utilitzar les diferents tecles per a desplaçar a X posició, vam tenir problemes alhora de que es desplaçessin a les posicions correctes, i per exemple si es clicaba la Q per a que es desplaçes a dalt a l'esquerra, es desplaçaba a baix a la dreta.
![Es desplaçen a on no s'hauria de desplaçar](/Images/Captura1.1.PNG)
![Es desplaçen a on no s'hauria de desplaçar](/Images/Captura1.2.PNG)

El requadre groc es la posició actual, el cercle es a on s'hauria de desplaçar i el triangle es a on es desplaça.

-En l'apartat de "Desplaçar Malalts" haviem de guardar quants malalts anaven desplaçant-se en una variable per a mostrar-ho en una altre opció, per tant la variable guarda el numero de malalts que es volien desplaçar en el mateix moment que es demanava, pero si a continuació es veia que la cel·la era una bloquejada o que no es podia perquè donava error per alguna altre cosa ja s'havia sumat a aquella variable tot i que finalment no s'havia desplaçat.
![L'error es va solucionar restant el que haviem sumat previament en el cas que hi hagues l'error](/Images/Captura2.PNG)

## Propostes de millora
Tot i que nomes es requeria una proposta de millora, hi havien força coses que ens molestaven o no acababen d'agradar-nos.

Per exemple que alhora de printar en la consola tant menu, com errors, com diferents opcions, quedava tot amb el mateix color i feia que la lectura fos ilegible, i per tant vam decidir que podiem afegir colors per a que tot es diferencies i es pogues llegir d'una manera correcta.
Vam canviar el menu per a que tingues uns contorns amb "asteriscs" de color blau, els errors els vam printar de color vermell, a l'igual que les "X".

De la següent cosa que ens vam adonar va ser que era poc optim haver de sortir-se de les opcions del menú cada vegada que feies 1 canvi, per tant vam donar la opció que despres d'utilitzar cada opció del menu sortis un missatge que et preguntes si volies seguir utilitzant aquella opció.

També vam pensar que no tenia sentit poder seleccionar opcions del menú que editaven el taulell, sense haver creat un previament, per tant vam haver de fer un validador que s'actives quan es feia la 1a opció "Carregar taulell".
Bàsicament si no has creat el taulell i intentes per exemple "Curar malalts" et sortira un missatge d'error dient-te "El taullel no s'ha creat".

Un altre problema que ens resultaba molest, era que si t'equivoques en algun apartat que et demana alguna dada i tu has posat per exemple, més de lo posible, o simplement alguna dada erronea, doncs em fet que ho detecti i que surti un missatge d'error descriptiu, i que et permeti torna a introduir la dada.
