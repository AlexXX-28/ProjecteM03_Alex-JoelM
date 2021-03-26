# Projecte UF1-UF2 - Alex S & Joel M

## Presentació del projecte 
El tema principal del projecte es la pandemia del "Coronavirus"
El projecte tracta de crear un taulell on el puguem gestionar per a fer estadistiques i càlculs dels infectats amb "Coronavirus", es a dir tant el total de malalts, com  el de persones curades entre altres.
Els diferents apartats del programa els veureu a continuació juntament amb els extres que hem afegit personalment.

# UF1
## Esquema principal del projecte
### Petit Resum
El nostre programa demana una opció del menu següent:
- Carregar Taulell
- Introduir malalts
- Transmitir Virus
- Curar malats
- Desplaçar malalts
- Mostrar informació
- Configuració
- Seleccionar taulell
- Sortir
### Explicació detallada
1. Impressió del menu que es va repetin fins que el bucle trobi el resultat del menu, del cual seria "si no es igual a 7 (case 7 = sortir) continua imprimin fins que retorni un 7 del qual el programa acabaria.
2. Un if per saber si el resultat (s.nextInt) del menu si es correcte...
   1. Si la llargada del resultat del menu (s.nextInt) es diferent a 1 doncs que imprimeixi el resultat de error.
   2. Si la llargada del resultat es correcte entra al switch, on per cada case correspon amb el resultat del menu, es a dir, 7 cases + el default en cas de que no hi ha cap resposta bona, que torni una altra cop a demanar (ja que esta contingut dintre del bucle). 
3. En el cas de la resposta sigui correcte entrem automaticament en el switch i comprobem el resultat per als cases, (per els case del 2 al 6 comença amb un if que serveix per determina si existeix el array a partir d'un boolean, que comença per defecte a false, aixo fa que nomes el primer cop es obligatori fer el primer case).
   1. Case 1: creacio del taulell.
      1. Inicialitzem les variables corresponents.
      2. Impressio de les diferents opcions (taulell buit i taulell amb malalts).
      3. Variable que conte l'opció demanada en el anterior punt.
      4. impressió de les quantitats de files i columnes que vol el usuari.
      5. Variable que conte l'opció demanada en el anterior punt.
      6. Creacio de la taula numerica (on aquesta servira per la agafar la informacio demanada).
      7. Creacio de la taula String (que servira per agafar la informacio de la taula numerica i pasarla a string per fer joc amb les X de les cel·les).
      8. Un if per fer les accions corresponents a partir de les varibles anterior de taulell buit i taulell amb malalts.
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
      1. Inicialitzem la variable totalHealCompare a 0, que ens permet comparar les persones malaltes despres d'haver-les curat.
      2. Inicialitzem  la varialbe totalSick a 0, que ens permet saber quantes persones malaltes hi ha abans de curarles.
      3. Impressió de curar tota la taula i curar per posició concreta.
      4. Varible que guardara la respota anterior (amb valor numeric: 1 o 2).
      5. Impressió de curar amb percentatge o amb valor numeric.
      6. Varible que guardara la respota anterior (amb valor numeric: 1 o 2).
      7. Un if en el cas de que la primera varible fos com a resultat un 1 fara el apartat "curar tota la taula", sino automaticament sera la segona opció "curar per posició concreta".
         1. Apartat de curar tota la taula
            1. un if per saber si es fara amb percentatge o amb valor numeric.
               1. Apartat per percentatge.
                  1. Inicialitzem les variables corresponents.
                  2. Un while per a que el percentatge sigui entre 0 - 100 el while es fara infinitament fins que s'entri un valor valid.
                  3. Impressió de el valor del percentatge entre 0 i 100.
                  4. Variable que guardara la resposta anterior del percentatge.
                  5. Un if comparan si el percentatge esta entre 0 i 100.
                  6. Un for que ens permet curar a les persones, a la par que enregistrem quantes persones han sigut curades.
                  7. Calcul final que es el total de persones curades es = al numero de persones malaltes - el numero de persones malaltes despres de curarles.
               2. Apartat per valor numeric.
                  1. Inicialitzem les variables corresponents.
                  2. Impressió de el numero de malats a curar.
                  3. Variable que guardara la resposta anterior del numero de malalts.
                  4. Un for que ens permet curar a les persones, a la par que enregistrem quantes persones han sigut curades i dintre de aquest un if que ens permet cambiar valors negatius a 0.
         2. Apartat curar per posicio concreta.
            1. Impressió de introduiex el numero i fila i columna, amb la seva variable corresponen.
            1. un if per saber si es fara amb percentatge o amb valor numeric.
               1. Apartat per percentatge.
                  1. Inicialitzem les variables corresponents.
                  2. Un while per a que el percentatge sigui entre 0 - 100 el while es fara infinitament fins que s'entri un valor valid.
                  3. Impressió de el valor del percentatge entre 0 i 100.
                  4. Variable que guardara la resposta anterior del percentatge.
                  5. Un if comparan si el percentatge esta entre 0 i 100.
                  6. La variable del percentantge per la cel·la especificada que es guardad en relació a les coordenades donades anteriorment.
               2. Apartat per valor numeric.
                  1. Inicialitzem les variables corresponents.
                  2. Un while que conte dintre un if que validara si el numero de malalts a curar no sigui superior al numero de malalts que i conte en la cel·la.
                  3. El calcul del cual a partir de la posicio demanada menys el numero de malalts a curar.
   5. Case 5: desplaçar malalts.
      1. Inicialitzem les variables corresponents.
      2. Un while que agrupa tot el codi del case 5, es infinit fins que ja no volguis desplaçar-te mes.
         1. Un while que serveix per validar el seguent codi a partir de una variable de tipus bolea.
         2. Impressió de introduiex la fila i la columna amb la seva variable corresponent.
         3. Un if que serveix per validar si no hi ha cap X en la cel·la especificada, en el cas de que que si torna a fer el while.
      3. Impressió de els malalats que hi han en aquella cel·la especificada.
      4. Un while que serveix per validar el seguent codi a partir de una variable de tipus bolea.
         1. Impressió de quant malalts vols desplaçar amb la seva variable corresponent.
         2. Un if que indica si el numero de malalts a desplaçar es major al que te en la cel·la que imprimeixi un missatge de error i tornaria a demanar-lo, en cas que sigui correte el bucle es para.
      5. Un while que ens permet validar si em introduit una tecla correcte (q-w-e-a-d-z-x-c).
         1. Impressió del menu d'opcions.
         2. Un switch del qual cada case sera les lletres corresponents amb un default en el cas de que no trobi la lletra que donara un missatge de error.
         3. Per a cada case de cada lletra compara si la cel·la seleccionada no es moura a una cantonada del taulell, en el cas de que si, es restara pero no es moura res ja que no exisiteix aquella cel·la, en el cas de que que no esta a la vora, es te un altre if del qual compara si no hi ha cap X continguda, si hi ha donara un missatge de error i si no hi ha es fara el calcul per moure, que seria restan les posicions per aixi moure per el taulell.
   6. Case 6: mostrar informacio.
      1. Conte tres for del cual el primer es guardara un array de tipus string que copia el array base tipus int, el segon una vegada copiada la informació a l'array TableShow(taulell de tipus string) em de remplaçar les cel·les bloquejades amb "X" i per ultim el tercer for que imprimeix tot el taulell amb les X de color vermell.
      2. Impressió de el total de malalts.
      3. Impressió de totes les persones curades.
      4. Impressió de el percentatge que no a complit el confinament.
   7. Case 7: sortir.
      1. Impressió de la sortida al programa amb el missatge "Fins despres" amb un emoji de color groc.
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

# UF2
## Distribució del programa en Funcions
En aquesta UF2 hem reprogramat tot el programa previ per a optimitzar-lo i en definitiva fer-ho més correcte, al tenir-ho dividit en funcions.
Tenim el fitxer principal que crida a totes les funcions, i després tenim les funcions dividides entre 4 classes que segons el tipus de funció estarà en un d'aquests fitxers:
   - GestorTaulell
   - Interficie
   - Utils
   - Taulell

### GestorTaulell
En la classe "GestorTaulell" tenim definides les funcions que ens permeten modificar el taulell, tant crear-ne un, com buidar-lo, com afegir malalts o curar-los...

### Interficie
En la classe "Interficie" tenim definides les funcions que es mostren per pantalla, com simples frases, amb o sense color, diferents opcions del menú entre altres.

### Utils
En la classe "Utils" tenim definides les funcions de validació, per exemple que validem si el numero que s'entra es un "Int" i també si esta dins d'un rang

### Taulell
En la classe "Taulell" tenim definides les funcions que ens permeten disposar del taulell, i de més taulells ja que ho explicarem en les millores de prova pero hem fet que es puguin tenir més d'un taullel.

## Joc de Proves
![Si necessitem un enter semmpre validem que ho sigui i que estigui dins d'un rang](/Images/UF2/Captura.PNG)
![Alhora de desplaçar malalts comprovem que no sigui una cel·la bloquejada](/Images/UF2/Captura2.PNG)
![Alhora de desplaçar malalts comprovem que no es desplaçin a una cel·la bloquejada](/Images/UF2/Captura3.PNG)
![Alhora de desplaçar malalts si surten dels limits de la taula mostrem un missatge que ho indica](/Images/UF2/Captura4.PNG)
![Alhora de desplaçar malalts quan indiquem cap a on validem que sigui de tipus "String"](/Images/UF2/Captura5.PNG)
![Tenim opcions de testeig que ens validen que les frases que printem amb un color es facin correctament:](/Images/UF2/Captura6.PNG)



## Javadoc

## Propostes de millora
Tot i que nomes es requeria una proposta de millora, hi havien força coses que ens molestaven o no acababen d'agradar-nos.

Per exemple que alhora de printar en la consola tant menu, com errors, com diferents opcions, quedava tot amb el mateix color i feia que la lectura fos ilegible, i per tant vam decidir que podiem afegir colors per a que tot es diferencies i es pogues llegir d'una manera correcta.
Vam canviar el menu per a que tingues uns contorns amb "asteriscs" de color blau, els errors els vam printar de color vermell, a l'igual que les "X".

De la següent cosa que ens vam adonar va ser que era poc optim haver de sortir-se de les opcions del menú cada vegada que feies 1 canvi, per tant vam donar la opció que despres d'utilitzar cada opció del menu sortis un missatge que et preguntes si volies seguir utilitzant aquella opció.

També vam pensar que no tenia sentit poder seleccionar opcions del menú que editaven el taulell, sense haver creat un previament, per tant vam haver de fer un validador que s'actives quan es feia la 1a opció "Carregar taulell".
Bàsicament si no has creat el taulell i intentes per exemple "Curar malalts" et sortira un missatge d'error dient-te "El taullel no s'ha creat".

Un altre problema que ens resultaba molest, era que si t'equivoques en algun apartat que et demana alguna dada i tu has posat per exemple, més de lo posible, o simplement alguna dada erronea, doncs em fet que ho detecti i que surti un missatge d'error descriptiu, i que et permeti tornar a introduir la dada. Tot això mitjançant una funció que ens valida si el numero es "Int" i si esta dins d'un rang.

Ens va semblar que tenir un unic taulell era una mica ineficient i ens quedavem curts, així doncs vam fer que es puguin crear més d'un taulell i per tant seleccionar quin es el que vols, i també vam afegir una opció per a poder buidar el taulell seleccionat.
