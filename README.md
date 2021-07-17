# Feladat

A feladatok megoldásához az IDEA fejlesztőeszközt használd!
Bármely régebbi osztályt megnyithatsz.

Új repository-ba dolgozz!
Ezen könyvtár tartalmát nyugodtan át lehet másolni (`pom.xml`, tesztek).
Projekt, könyvtár, repository neve legyen: `sv2021-jvjbf-reszvizsga-potpot`.
GroupId: `training360`, artifactId: `sv2021-jvjbf-reszvizsga-potpot`. Csomagnév: `lineorders`.

Ha ezzel kész vagy, azonnal commitolj!

Először másold át magadhoz a teszteseteket, majd commitolj azonnal!

A feladatra 3 órád van összesen!

Ha letelik az idő mindenképp commitolj, akkor is
ha nem vagy kész!

**Érdemes közben is commitolni, mert az időn túl leadott megoldásokat nem tudjuk értékelni!**

**Az alkalmazásnak le kell fordulnia, ami le sem fordul, azt nem tudjuk értékelni!**

## Feladatleírás

A mai feladatban egy rendelést és szállítást rendszerező alkalmazást kell megvalósítanod.

Az alap entitás a `Order`, azaz a rendelés. A rendelésnek van egy azonosítója, tartalmazza a megrendelt termék cikkszámát, a rendelés időpontját, a szállítási költséget és a kiszállítás dátumát.

Az `OrderService` osztály tárolja egy listában a rendeléseket. Kezdetben a lista üres. Ez az osztály felelős az egyedi azonosítók kiosztásáért is.

Az `OrderController` osztály a `api/orders` URL-n keresztül várja a kéréseket és a következő funkciókat valósítja meg:

* Lehessen lekérdezni a rendeléseket, ekkor minden egyes rendelésnél az id-n kívül minden adatot adjunk vissza. Amikor lekérdezzük a rendeléseket lehessen szűrni hónapra. Ekkor csak az abban a hónapban rendelt termékeket adjuk vissza
* Lehessen lekérdezni egy rendelést id alpaján
* Lehessen létrehozni új rendelést. Ekkor csak a cikkszámot adjuk meg. A rendelési dátumot az aktuális napra állítjuk.
* Lehessen frissíteni egy rendelést, amikor az készen áll a szállításra. Ekkor megkapjuk a szállítás díját ezt és a szállítás dátumát kell frissíteni az adott rendelésnél. Figyeljünk arra, hogy az egész frissítés csak akkor történjen meg, ha a szállítás dátum nem volt állítva korábban.
* Lehessen lekérdezni a szállítmányozó cég eddigi összbevételét. `/shippingIncome` URL-n keresztül adjunk vissza egy egész számot, ami az eddigi összes szállítási ár összege.
* Lehessen törölni az összes rendelést
* A következő szempontokat vegyük még figyelembe:
    * Új rendelésnél a termék száma nem lehet üres
    * Amikor frissítjük a terméket az átadott szállítási árnak pozitívnak kell lennie
    * Ha a megfelelő id-n keresztül nem található a rendelés akkor 404-es státuszkóddal térjünk vissza.
	