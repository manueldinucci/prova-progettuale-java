---


---

<p>ReadME<br>
Manuel Di Nucci (1082266)</p>
<p>Il <a href="http://bit.ly/dataset-1082266">dataset</a> assegnatomi riguarda i dati relativi al numero di ricette, suddivise per specialità diagnostica, erogate negli ambulatori lombardi ai soli residenti nel comune di Milano dal 2006 al 2012 (fonte Regione Lombardia - ASL Milano)<br>
<br>
<br>
Tutte le classi del programma sono contenute nella sottocartella:<br>
<em>src\main\java</em></p>
<p>Il main del programma è contenuto nella classe<br>
<strong>ManuelDiNucciApplication</strong>.</p>
<p><br>
Il programma effettua all’avvio il download del file .csv trovato dall’url di partenza.<br>
Questo procedimento è ottenuto utilizzando i metodi della classe CsvFinder.</p>
<h2 id="csvfinder"><strong><code>CsvFinder</code></strong></h2>
<blockquote>
<p>La classe CsvFinder, tramite il metodo <strong><code>analizzaUrl</code></strong>, analizza il json della pagina web presa in ingresso ed effettua il download del file .csv con il nome <em>“dataset_ricette.csv”</em>.</p>
<p>Il metodo <strong><code>analizzaUrl</code></strong> si avvale di due metodi:</p>
<blockquote>
<ul>
<li><strong><code>copiaDati</code></strong> : <em>copia i dati contenuti nella pagina web e li inserisce in un’unica stringa</em>;</li>
<li><strong><code>download</code></strong> : <em>effettua il download del file .csv con il nome assegnatogli dal metodo chiamante.</em></li>
</ul>
</blockquote>
</blockquote>
<p><br>
<br>
La classe CsvParser effettua il parsing dei dati creando delle strutture dati opportune, ma offre anche altri metodi importanti.</p>
<h2 id="csvparser"><strong><code>CsvParser</code></strong></h2>
<blockquote>
<p>La classe CsvParser, tramite il metodo <strong><code>parseCsv</code></strong>, analizza il file passatogli (nel nostro caso sarà <em>“dataset_ricette.csv”</em>) ed organizza i dati in una opportuna classe chiamata <em><strong>Ricetta</strong></em>.</p>
<p>Altri metodi della classe  <strong><code>CsvParser</code></strong> sono quelli che producono statistiche relativamente al data-set:</p>
<blockquote>
<ul>
<li><strong><code>getPrimaRiga</code></strong> : <em>restituisce la prima riga del data-set la quale contiene i metadati</em>;</li>
<li><strong><code>popMetadata</code></strong> : <em>prende la prima riga del data-set e la organizza in una opportuna classe chiamata <em><strong>Metadata</strong></em></em>;</li>
<li><strong><code>numElem</code></strong> : <em>restituisce il numero di righe di dati per ogni anno</em>;</li>
<li><strong><code>totale</code></strong> : <em>restituisce il totale delle Ricette emesse in un dato anno;</em></li>
<li><strong><code>media</code></strong> : <em>restituisce la media delle Ricette emesse in un dato anno;</em></li>
<li><strong><code>max</code></strong> : <em>restituisce il massimo delle Ricette emesse in un dato anno in una singola branca specialistica;</em></li>
<li><strong><code>min</code></strong> : <em>restituisce il minimo delle Ricette emesse in un dato anno in una singola branca specialistica;</em></li>
<li><strong><code>devStd</code></strong> : <em>restituisce la deviazione standard delle Ricette emesse in un dato anno;</em></li>
</ul>
</blockquote>
</blockquote>
<p><br>
Quindi, i dati sono organizzati in un ArrayList di “Ricetta”:</p>
<h2 id="ricetta"><strong><code>Ricetta</code></strong></h2>
<blockquote>
<p>È la classe con la quale sono organizzati i dati del data-set:</p>
<blockquote>
<ul>
<li><strong><code>anno</code></strong> : <em>Rappresenta l’anno dal quale provengono i dati</em>;</li>
<li><strong><code>branca</code></strong> : <em>Rappresenta la Branca Specialistica;</em></li>
<li><strong><code>qty</code></strong> : <em>Rappresenta la quantità di Ricette emesse nel dato anno nella data Branca Specialistica;</em></li>
</ul>
</blockquote>
</blockquote>
<p><br>
<br>
Ed i metadati sono organizzati in una classe <em><strong>Metadata</strong></em>:</p>
<h2 id="metadata"><strong><code>Metadata</code></strong></h2>
<blockquote>
<p>È la classe con la quale sono organizzati i dati del data-set:</p>
<blockquote>
<ul>
<li><strong><code>sourceField</code></strong> : <em>Nome del campo</em>;</li>
<li><strong><code>type</code></strong> : <em>Tipo di dato del campo (i campi Anno e Quantità sono interpretati come String)</em>;</li>
</ul>
</blockquote>
</blockquote>
<p><br>
<br>
Le statistiche invece saranno organizzate nella classe <em><strong>Stats</strong></em>:</p>
<h2 id="stats"><strong><code>Stats</code></strong></h2>
<blockquote>
<p>È la classe con la quale sono organizzate le statistiche:</p>
<blockquote>
<ul>
<li><strong><code>field</code></strong> : <em>Nome del campo</em>;</li>
<li><strong><code>total</code></strong> : <em>Totale</em>;</li>
<li><strong><code>avg</code></strong> : <em>Media</em>;</li>
<li><strong><code>max</code></strong> : <em>Massimo</em>;</li>
<li><strong><code>min</code></strong> : <em>Minimo</em>;</li>
<li><strong><code>devStd</code></strong> : <em>Deviazione standard</em>;</li>
</ul>
</blockquote>
</blockquote>
<p><br>
<br>
Per poter effettuare le richieste API REST GET sono state create delle apposite classi:<br>
<br>
<br>
<strong>Per restituire i metadati:</strong></p>
<h2 id="metadataserviceimpl"><strong><code>MetadataServiceImpl</code></strong></h2>
<blockquote>
<p>È la classe Service nella quale viene implementata la funzione che permette di restituire i metadati:</p>
<blockquote>
<ul>
<li><strong><code>stampa</code></strong> : <em>Attraverso questo metodo vengono restituiti i metadati in un ArrayList</em>;</li>
</ul>
</blockquote>
</blockquote>
<h2 id="metadatacontroller"><strong><code>MetadataController</code></strong></h2>
<blockquote>
<p>È la classe Controller nella quale viene chiamato il metodo del Service.<br>
Su richiesta, all’indirizzo localhost:8080/metadata, restituisce i metadati del dataset.</p>
</blockquote>
<p><br>
<br>
<strong>Per restituire i dati:</strong></p>
<h2 id="ricettaserviceimpl"><strong><code>RicettaServiceImpl</code></strong></h2>
<blockquote>
<p>È la classe Service nella quale viene implementata la funzione che permette di restituire i dati:</p>
<blockquote>
<ul>
<li><strong><code>stampa</code></strong> : <em>Attraverso questo metodo vengono restituiti i dati in un ArrayList</em>;</li>
</ul>
</blockquote>
</blockquote>
<h2 id="datacontroller"><strong><code>DataController</code></strong></h2>
<blockquote>
<p>È la classe Controller nella quale viene chiamato il metodo del Service.<br>
Su richiesta, all’indirizzo localhost:8080/data, restituisce i dati del dataset.</p>
</blockquote>
<p><br>
<strong>Per restituire le statistiche:</strong></p>
<h2 id="ricettaserviceimpl-1"><strong><code>RicettaServiceImpl</code></strong></h2>
<blockquote>
<p>È la classe Service nella quale viene implementata la funzione che permette di restituire le statistiche:</p>
<blockquote>
<ul>
<li><strong><code>paginaAiuto</code></strong> : <em>Attraverso questo metodo viene restituita una Stringa contenente la descrizione della pagina delle statistiche</em>;</li>
<li><strong><code>stats</code></strong> : <em>Attraverso questo metodo vengono restituite le statistiche relative ad un dato anno</em>;</li>
</ul>
</blockquote>
</blockquote>
<h2 id="statscontroller"><strong><code>StatsController</code></strong></h2>
<blockquote>
<p>È la classe Controller nella quale vengono chiamati i metodi del Service.<br>
Su richiesta, all’indirizzo localhost:8080/stats, restituisce una descrizione della pagina delle statistiche ed illustra le possibili opzioni.</p>
</blockquote>

