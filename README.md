class PagesRangeTest < Test::Unit::TestCase
  def test_below_max_pages
    assert_equal(1..10, PagesRange.with_total_pages(11).at_page(1))
    assert_equal(1..10, PagesRange.with_total_pages(11).at_page(6))
  end

  def test_overtake_max_pages
    assert_equal(1..1, PagesRange.with_total_pages(1).at_page(1))
    assert_equal(2..11, PagesRange.with_total_pages(11).at_page(7))
    assert_equal(2..11, PagesRange.with_total_pages(11).at_page(8))
    assert_equal(11..20, PagesRange.with_total_pages(20).at_page(20))
    assert_equal(9..18, PagesRange.with_total_pages(200).at_page(14))
  end

  def test_links_to_show_are_less_than_max
    assert_equal(1..3, PagesRange.with_total_pages(3).at_page(2))
  end
end
# kata-bowling
Una partita di bowling è composta da 10 frame (frazioni) per ognuna delle quali si hanno a disposizione 2 tiri per cercare di abbattere tutti i birilli. Il punteggio viene annotato in una apposita scheda con 10 caselle principali, una per ogni turno di gioco e normalmente si possono incontrare queste situazioni:
se non vengono abbattuti tutti i birilli nei due tiri a disposizione, si procede semplicemente alla somma aritmetica dei birilli abbattuti nei due turni del frame e si continua.
se si sono abbattuti tutti e 10 i birilli al secondo tiro, si è fatto uno spare. In questo caso il punteggio del frame è di 10 punti più il numero dei birilli abbattuti con il tiro successivo (cioè il primo del frame seguente).
se si sono abbattuti tutti i birilli al primo tiro, si è fatto uno strike. Lo strike vale 10 punti più il numero di birilli abbattuti con i due tiri successivi. In questo caso non viene effettuato il secondo tiro (di riserva).
Il punteggio massimo ottenibile con uno strike è quindi 30, nel caso vengano abbattuti 10 birilli anche nei 2 tiri successivi (cioè si siano fatti 3 strike di fila, il cosiddetto "turkey").
Se nell'ultimo frame della partita viene effettuato uno spare o uno strike, si effettuano uno o due tiri addizionali per permettere il calcolo del punteggio del frame, dato che, come si è visto, il punteggio in questi casi deve tener conto dei tiri successivi. Nel caso si sia fatto strike, i tiri addizionali saranno due, mentre per lo spare si effettuerà solo un altro tiro.
Test di accettazione

Data la sequenza di tiri: 1, 4, 4, 5, 6, 4, 5, 5, 10, 0, 1, 7, 3, 6, 4, 10, 2, 8, 6
Verificare che il punteggio totalizzato sia: 133
