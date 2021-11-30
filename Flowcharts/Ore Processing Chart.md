graph TD
    a(Raw Ore)

    a -->|Ore Chunks| 4x[Ball Mill]
    4x -->|Milled Grit 4x| 4xG[Grinder]
    4xG -->|Grit 4x| 4xC[Crusher]
    4xC -->|Dust 4x| 4xS[Smelter]
    4xS --> 4xI(4 Ingots)

    a -->|Ore Chunks| 3x[Grinder]
    3x -->|Grit 3x| 3xC[Crusher]
    3xC -->|Dust 3x| 3xS[Smelter]
    3xS --> 3xI(3 Ingots)

    a -->|Ore Chunks| 2x[Crusher]
    2x -->|Dust 2x| 2xS[Smelter]
    2xS --> 2xI(2 Ingots)
