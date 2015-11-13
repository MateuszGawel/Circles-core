Jak uzywac API

1. Musimy nadpisac klase MessageHandler a w niej metode handleMessages() do obslugi messagy oraz trzymac sobie kolekcje entity
2. Musimy napisac klase Message bo to definiuje co wysylamy. W niej znajduje sie builder ktory takze trzeba nadpisac wg potrzeb.
3. messageHandler w petli powinien wykonywac dwie rzeczy: sendBufferedMessage - wysle obiekt message jak uplynie ustawiony interwal. Listen() - bedzie odbierac wiadomosci
4. Potrzebujemy messageBuilder zdefiniowany w klasie message. Musimy go podac do konstruktora MessageHandler i on juz sobie zadba o wyslanie wiadomosci w odpowiednim czasie
5. connect() wywolany na messageHandler ustanowi polaczenie.

Przy uzyciu connect gracz wysle odpowiedni message do wszystkich innych graczy, a kazdy z nich doda go sobie do listy obslugiwanych playerow
Jak nowy gracz przychodzi do pokoju to kazdy mu sie przedstawia