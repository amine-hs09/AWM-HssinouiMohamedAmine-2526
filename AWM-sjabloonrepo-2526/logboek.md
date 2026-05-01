# logboek hssinoui mohamed amine 

## Week 1 : xx uur
07/02/2026  Installatie Android Studio & Kotlin theorie (variabelen/datatypes). 3.0
08/02/2026  Praktijk in Kotlin Playground (basisoefeningen & functies). 3.0

## Week 2 : 8.5 uur
09/02/2026  Eerste Compose app (Greeting Card) & Android Studio crashes opgelost. 2.5
10/02/2026  Happy Birthday app afgewerkt (Images toevoegen, Box, Column, Modifiers). 2.0
11/02/2026  Compose Practice Problems (Article, Task Manager, Quadrants). 2.0
12/02/2026  Business Card app ontworpen en Unit 1 afgerond (Quiz). 2.0
het begrijpen van float en alpa voor de opacity 

mijn quisen zijn gemaakt met mhssinoui@gmail.com 
de eerste heb ik een 9/10
de tweede heb ik een 6/10
de derdde heb ik een 9/10
de meeste punten verlies ik bij merkeuzevragen.



## Week 3 :
25/02  ik ben met unit 2.1 bezig de theorie is veel en heb nog moeite met het begrijpen 2u
26/02/2026  Unit 2.1 : Theorie & Oefeningen (6.0 uur)
            - Grondige studie van Object-Oriented Programming (OOP).
            - Oefeningen afgewerkt: Internet Profile, Foldable Phone, Special Auction.
            - Focus op Null Safety: Safe Calls (?.), Elvis Operator (?:), en Inversion (!).
            - Begrip van Inheritance: Superclasses (open) vs Subclasses (override).
            - Syntax van Lambda's en Higher-order functions in de praktijk gebracht.

27/02/2026  Unit 2.2: Interactieve Dice Roller App (6.0 uur)
            - State Management: Gebruik van 'remember' en 'mutableStateOf' om de waarde van de dobbelsteen te bewaren.
            - Recomposition: Begrip van hoe Compose de UI hertekent wanneer de state verandert.
            - Event Handling: Klik-actie toegevoegd via een onClick Lambda op de Button.
            - UI Design: Gebruik van Column, Image (painterResource) en Button.
            - Imports: 'getValue' en 'setValue' toegevoegd voor de property delegate (by).
            
            - Complex State: Meerdere states beheerd met 'remember' en 'mutableIntStateOf' om de voortgang van de gebruiker bij te houden.
            - Business Logic: Willekeurige logica toegevoegd met '.random()' om het aantal benodigde kliks (squeezes) te bepalen.
            - UI Architecture: Gebruik van 'Scaffold' en 'TopAppBar' voor een professionele Material 3 lay-out.
            - Reusability: Een herbruikbare Composable 'LemonTextAndImage' gemaakt om code-duplicatie te voorkomen.
28/02/2026  Unit 2.3: Theorie State & Recomposition 3.5
            - Grondige herhaling van de theorie: Compositie, Initiële compositie en Hersamenstelling.
            - Diepgaand begrip van Stateful (met interne state) vs Stateless composables.
            - Het concept van 'State Hoisting' bestudeerd: state omhoog verplaatsen naar de parent en events via lambda's (`() -> Unit`) naar beneden doorgeven om herbruikbare UI-componenten te maken.

02/03/2026  Unit 2.3: Project Art Space App 6.0
            - Eigen Art Space app gebouwd met een galerij van Audi auto's.
            - Complexe lay-out gemaakt met `Column`, `Row`, `Box` en geneste modifiers.
            - Navigatie toegevoegd (Vorige/Volgende knoppen) met een stateless component en 'State Hoisting'.
            - UI geoptimaliseerd voor zowel landschap- als portretmodus met behulp van `LocalConfiguration.current.orientation`.
            - Voorbereiding mondeling examen: code lijn per lijn geanalyseerd en gekoppeld aan de theorie.

05/03/2026  Unit 3.1: Meer Kotlin fundamentals - Theorie 4.0
            - Generics (`<T>`) bestudeerd voor flexibele datatypes.
            - Leren werken met `enum class` en `data class` (automatische functies zoals copy/toString).
            - Het concept van Singletons (`object` en `companion object`) toegepast.
            - Interfaces (contracten zonder implementatie) en extension properties/methodes bestudeerd.
            06/03/2026  Unit 3.1: Meer Kotlin fundamentals - Praktijk & Collections
- Praktische oefeningen gemaakt met enum class (strikte keuzemenu's) en data class (modellen).
- Werken met Collections: verschil tussen read-only (List) en aanpasbaar (MutableList).
- Data getransformeerd en gecategoriseerd (van List naar Map) met Higher-order functies.
- Diepgaand gebruik van functies zoals .filter { ... }, .groupBy { ... }, .last() en het gebruik van de impliciete parameter it.
- Extension properties in de praktijk toegepast (bijv. Event.durationOfEvent) met custom get().

07/03/2026  Unit 3.2: Affirmations App - Scrollbare lijsten (LazyColumn)
- Architectuur toegepast: scheiding van data (Model) en gebruikersinterface (UI).
- Lijst met data weergegeven via een LazyColumn voor optimale prestaties (rendert alleen zichtbare items).
- Gebruik gemaakt van de items(lijst) functie met een trailing lambda om over data te itereren en UI-componenten (AffirmationCard) te genereren.
- Beveiliging van resource-ID's gegarandeerd door middel van @StringRes en @DrawableRes annotaties.
- Code leesbaarder gemaakt door gebruik van benoemde parameters (named arguments, bv. affirmation = affirmation).

08/03/2026  Unit 3.2: Course Grid App - Geavanceerde Grids & Indexering
- Project 'Course Grid' gebouwd met een LazyVerticalGrid om data in een raster weer te geven.
- Kolommen vastgezet via columns = GridCells.Fixed(2).
- Het Singleton-patroon (object DataSource) geïmplementeerd voor geheugenoptimalisatie van de datalijst.
- Een alternatieve iteratiemethode toegepast: items(size) { index -> ... } waarbij de data handmatig uit de lijst wordt gehaald via de [index].
- Mondeling examen voorbereid: het verschil uitgelegd tussen itereren via het object zelf vs. itereren via de index.

14/03/2026  Unit 3.3: Superheroes App & Woof App - Material Design 3 Theming (5.0 uur)
            - Superheroes App gebouwd: een lijst van superhelden weergeven met LazyColumn en Card-composables.
            - Material Design 3 volledig toegepast: kleurenschema's (light/dark), typografie en vormgeving (Shape).
            - CenterAlignedTopAppBar gebruikt voor een professionele navigatiebalk.
            - Data class Hero aangemaakt met @StringRes en @DrawableRes annotaties voor type-safe resources.
            - HeroesRepository als Singleton (object) geïmplementeerd voor centraal databeheer.
            - Woof App: een lijst van honden met uitklapbare kaarten (expandable cards).
            - Animatie toegepast met `animateContentSize()` voor vloeiende expand/collapse-effecten.
            - Begrip van `@OptIn(ExperimentalMaterial3Api::class)` voor experimentele Material 3 componenten.

15/03/2026  Unit 3.3: 30 Days App - Eigen Project met Theming (5.0 uur)
            - Eigen '30 Days' app ontworpen en gebouwd als eindproject van Unit 3.
            - Volledig eigen thema gecreëerd met aangepaste kleuren, typografie en vormen.
            - Hergebruik van het geleerde patroon: data class, Repository (Singleton), LazyColumn en Card.
            - Light en Dark theme ondersteund via Material 3 `isSystemInDarkTheme()`.
            - Edge-to-edge UI geïmplementeerd met transparante status- en navigatiebalk.
            - Preview-functies toegevoegd voor zowel light als dark mode met `@Preview` annotaties.

--- PAUZE: Oogoperatie van 15/03 tot 13/04 - geen activiteit mogelijk 

13/04/2026  Unit 4.1: Dessert Clicker - Activity Lifecycle & State Persistence (5.0 uur)
            - Alle Activity Lifecycle callbacks bestudeerd en geïmplementeerd: onCreate, onStart, onResume, onRestart, onPause, onStop, onDestroy.
            - Logging toegevoegd met `Log.d(TAG, ...)` om de levenscyclus in Logcat te volgen.
            - State Persistence: `rememberSaveable` gebruikt om revenue en dessertsSold te bewaren bij configuratiewijzigingen (bijv. schermrotatie).
            - Dynamische dessert-wissel logica geïmplementeerd: het getoonde dessert verandert automatisch op basis van het aantal verkopen.
            - Intent-gebaseerde deelfunctionaliteit gebouwd met `ACTION_SEND` om verkoopresultaten te delen via andere apps.
            - Verschil begrepen tussen `remember` (verliest state bij recomposition door configuratiewijziging) en `rememberSaveable` (bewaart state).

14/04/2026  Unit 4.1: Unscramble - ViewModel & StateFlow (5.5 uur)
            - MVVM-architectuur (Model-View-ViewModel) voor het eerst toegepast in een volledig project.
            - GameViewModel aangemaakt met `StateFlow<GameUiState>` voor reactief state management.
            - Verschil begrepen tussen `MutableStateFlow` (intern in ViewModel) en `StateFlow` (exposed naar UI via `.asStateFlow()`).
            - Woorden-scramble logica geschreven: willekeurig schudden met `.toCharArray()`, `.shuffle()` en `.concatToString()`.
            - Game flow beheerd: score bijhouden, gebruikte woorden tracken in een `MutableSet`, en game-over conditie na 10 woorden.
            - UI gebouwd met `collectAsState()` om de StateFlow in Compose te observeren.
            - Keyboard actions geïmplementeerd: `ImeAction.Done` op het tekstveld met `KeyboardActions` voor betere UX.

15/04/2026  Unit 4.2: Cupcake App - Navigation met Jetpack Navigation Compose (5.0 uur)
            - Jetpack Navigation Compose voor het eerst gebruikt: `NavHost`, `NavHostController` en `composable()` routes.
            - Navigatie tussen 4 schermen opgezet: Start → Flavor → Pickup → Summary.
            - Enum class `CupcakeScreen` gebruikt als type-safe route-definitie voor elke navigatiebestemming.
            - Shared ViewModel: één `OrderViewModel` gedeeld over alle schermen via `viewModel()` in de NavHost.
            - Terugnavigatie geïmplementeerd met `popBackStack()` en een aangepaste CupcakeAppBar met back-knop.
            - Prijsberekening: basisprijs per cupcake ($2.00) + toeslag voor same-day pickup ($3.00).
            - Datumopties dynamisch gegenereerd met `Calendar` en `SimpleDateFormat` voor de komende 4 dagen.
            - Bestelling delen via `Intent.ACTION_SEND` met een geformatteerde samenvatting van de order.

16/04/2026  Unit 4.2: Lunch Tray App - Geavanceerde Navigation & Sealed Classes (5.5 uur)
            - Sealed class `MenuItem` geïmplementeerd met drie subtypes: `EntreeItem`, `SideDishItem`, `AccompanimentItem`.
            - Voordeel van sealed classes begrepen: de compiler garandeert dat alle subtypes worden afgehandeld in `when`-expressies.
            - 5-stappen navigatieflow gebouwd: Start → Entree → Side Dish → Accompaniment → Checkout.
            - Herbruikbare `BaseMenuScreen` composable ontworpen die door alle menuschermen wordt gedeeld (DRY-principe).
            - Belastingberekening (8% tax) geïmplementeerd in de ViewModel met een `formatPrice()` extension function.
            - Cancel-functionaliteit: bij annulering wordt de hele bestelling gereset en navigeert de app terug naar Start.
            - `getFormattedPrice()` methode in de sealed class gebruikt voor consistente prijsweergave met NumberFormat.


22/04/2026  vergeten om mijn logboek in te vullen en mijn oefeningens te pushen op github 
23/04/2026 Documentatie van mijn Ionic Rent-a-Car versie bekeken om te zien wat ik moet reproduceren in Kotlin. 1.5

24/04/2026 Backend op Combell getest, alles werkt nog. Plan gemaakt om 6 schermen te reproduceren. 1.0

26/04/2026 Unit 5.1 herhaald (Retrofit, kotlinx.serialization, suspend functions, viewModelScope). 2.0

27/04/2026 Stack voor mijn project gekozen: Compose BOM 2026, Retrofit 3.0, Firebase voor Google Sign-In, OSMDroid voor de kaart. 1.5


## Week 12 :


29/04/2026 Architectuur uitgewerkt op papier: lagenmodel uit Unit 4.1 (UI Layer met Composables + ViewModels, Data Layer met ApiService). 2.0

30/04/2026 Examenvragen voor mezelf voorbereid in NL: lifecycle, ViewModel, navigation, Retrofit. 2.0

01/05/2026 Package structuur uitgetekend: model/, network/, auth/, data/, ui/{theme,home,login,locations,booking,rentals,profile,components}/. 1.0
